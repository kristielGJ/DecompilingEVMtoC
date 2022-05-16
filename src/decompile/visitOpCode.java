//Author Gera Jahja
package src.decompile;
import src.interfaces.*;
import src.opcodes.*;
import src.opcodes.pc;
import src.sha3Hash.main.java.pl.thewalkingcode.sha3.Sha3;
import src.sha3Hash.main.java.pl.thewalkingcode.sha3.Type;
import src.cCodes.*;
import java.math.BigInteger;
import java.util.*;


//Uses interfaces to visit the opcode java classes
//last update 15/05
class visitOpCode implements Dissasemble
{ 
    public Stack< String> java_stack = new Stack<>();  
    public int variableNumber;

    //C code that is  used for more than one opcode
    //-----------------------------------------------------------------------------------------------------------------//

    /*attempt to simulate stack, however it does not work for extremely large numbers ... so only partially workinh*/
    public void getMemoryAddForStack(String operator){
        BigInteger arithmetic = new BigInteger("0");
        try{
            if ((java_stack.isEmpty()==false)&& (((java_stack.peek()).length())<16)){
                BigInteger xi = new BigInteger(java_stack.pop());
                if ((java_stack.isEmpty()==false)&& (((java_stack.peek()).length())<16)){
                    BigInteger yi = new BigInteger(java_stack.pop());
                    int inty =yi.intValue();
                    long longy= yi.longValue();
                    
                    if (operator.contains("+")){ arithmetic= xi.add(yi);
                    }else if (operator.contains("-")){arithmetic= xi.subtract(yi);
                    }else if (operator.contains("*")){arithmetic=xi.multiply(yi);
                    }else if (operator.contains("/")){arithmetic= xi.divide(yi);
                    }else if (operator.contains("%")){arithmetic= xi.mod(yi);
                    }else if (operator.contains("**")){arithmetic= xi.pow(inty);
                    }else if (operator.contains("<")){arithmetic=  xi.min(yi);
                    }else if (operator.contains(">")){arithmetic= xi.max(yi);
                    }else if (operator.contains("==")){arithmetic= BigInteger.valueOf(longy);
                    }else if (operator.contains("!")||operator.contains("~")){
                        arithmetic= xi.not();
                        java_stack.push(yi.toString());  
                    }else if (operator.contains("&&")){arithmetic= xi.and(yi);
                    }else if (operator.contains("||")){arithmetic= xi.or(yi);
                    }else if (operator.contains("^")){arithmetic= xi.xor(yi);
                    }else if (operator.contains("<<")){arithmetic= xi.shiftLeft(inty);
                    }else if (operator.contains(">>")&&operator.length()==2){arithmetic= xi.shiftRight(inty);
                    }else if (operator.contains(">>>")&&operator.length()==3){arithmetic= xi.shiftRight(inty);
                    }
                    java_stack.push(arithmetic.toString());
                }else{
                    java_stack.push(xi.toString());
                }
            }
        }catch(Exception e) {
            //  Block of code to handle errors
            System.out.println("Large number used, sha3 hashes may be affected"); // error!
        }
    }

    public String getCheck(stack st,String assertFor,int gasno){
        assertVal stackCheck =new assertVal("");
        if (assertFor=="not empty"){
            stackCheck = new assertVal(st.getAssertStackNotEmpty());
        }else if (assertFor=="stack height"){
            stackCheck = new assertVal(st.getAssertStackHeight());
        }
        String gasCheck = getGasNoCheck(gasno);
        return "\t"+stackCheck.getAssertCall()+"\n\t"+gasCheck;
    }

    //ensure the gas used is never  more than the gas used
    public String getGasNoCheck(int gasno){
        assertVal gasCheck = new assertVal("gasUsed < gasLimit");
        return "gasUsed +="+gasno+";\n\t"+gasCheck.getAssertCall();
    }

    public String arithmeticCodeGenerator(int lableno,int no,String operator,int gasno,boolean unsigned){
        //decompilation
        stack stackval1 = new stack("",2,"-");
        stack stackval2 = new stack("",1,"-");
        String unsignedstr ="u";

        if (unsigned==true){
            unsignedstr ="u";
        }else{
            unsignedstr ="";
        }
        variable var1 = new variable(no+1,"",stackval1.getStackOp(),unsignedstr);//no need for varName as these are tmp variables
        variable var2 = new variable(no+2,"",stackval2.getStackOp(),unsignedstr);
        variable var3 = new variable(no+3,"",var1.getVariableName()+operator+var2.getVariableName(),unsignedstr);
        setVariableNumber(variableNumber+3);
        stack stackval = new stack(var3.getVariableName(),2,"-");

        label label_ =new label(lableno);

        String variables =var1.getVariable()+var2.getVariable()+var3.getVariable();

        String stackvals ="\t"+stackval.getOperationPop()+"\t"+stackval.getStackVariable()+"\n\t"+stackval.getStackPushTop()+"\n";
        
        String asserts= getCheck(stackval,"stack height",gasno);
        return label_.getLabelName()+variables+stackvals+asserts+label_.getLabelEnd();
    }
   
    //-----------------------------------------------------------------------------------------------------------------//

    //Visitors

    //Place n byte item on stack. 0 < n <= 32
    @Override
    public String  visit(push Push,int orderNo)
    {
        System.out.println(Integer.toHexString(Push.getOpcode()).toUpperCase() + "  "+ Push.getName());//output the instruction(Disassembly), used for decompilation
        label label_ =new label(orderNo);
        variable var =new variable(0, "stack[top]" , Push.getMemoryAdd(),"");
        stack stackval = new stack("",0,"");

        String variables =var.getNoTypeVariable();
        String stackvals ="\t"+stackval.getStackPushTop();
        String asserts= getCheck(stackval,"stack height",3);
        String PushValues= label_.getLabelName()+variables+stackvals+asserts+label_.getLabelEnd();
        
        //add to internal stack for memory acess
        java_stack.push(Push.getMemoryAdd());
       // System.out.println("\nElements in Stack: " + java_stack +"\n");  

        Push.setC(PushValues);
        return Push.getC();
    }
  
    //Append log record with 0-4 topics.
    @Override
    public String visit(log Log,int orderNo)
    {
        System.out.println(Integer.toHexString(Log.getOpcode()).toUpperCase() + "  "+ Log.getName());//output the instruction(Disassembly), used for decompilation
        
        assertVal logCheck =new assertVal("0");
        label label_ =new label(orderNo);
        String gasNoCheck ="";

           
        if (Log.getOpcodeNo()==0){
            gasNoCheck = getGasNoCheck(375);//log0 , gas= 375
        }else if (Log.getOpcodeNo()==1){
            gasNoCheck = getGasNoCheck(750);// log1 gas= 750
        }else if (Log.getOpcodeNo()==2){
            gasNoCheck = getGasNoCheck(1125);//log2 gas =1125
        }else if (Log.getOpcodeNo()==3){
            gasNoCheck = getGasNoCheck(1500);//log 3 gas =1500
        }else if (Log.getOpcodeNo()==4){
            gasNoCheck = getGasNoCheck(1875);//log 4 gas= 1875
        }else {
            gasNoCheck = getGasNoCheck(0);
        }
        Log.setC(label_.getLabelName()+"\n\t"+logCheck.getAssertCall()+"\n\t"+gasNoCheck+"\n\t"+label_.getLabelEnd());
        return Log.getC(); }

    //Duplicate nth stack item. 0 < n <= 16
    @Override
    public String visit(dup Dup,int orderNo)
    {
        System.out.println(Integer.toHexString(Dup.getOpcode()).toUpperCase() + "  "+ Dup.getName());//output the instruction(Disassembly), used for decompilation
        
        stack stackval2 = new stack("",Dup.getOpcodeNo(),"-");
        variable var1 = new variable(getVariableNumber()+1,"",stackval2.getStackOp(),"");//no need for varName as these are tmp variables
        setVariableNumber(variableNumber+1);
        stack stackval = new stack(var1.getVariableName(),2,"-");
        label label_ =new label(orderNo);
        String variables =var1.getVariable();
        String stackvals ="\t"+stackval.getStackVariable()+"\n\t"+stackval.getStackPushTop()+"\n";
        String asserts= getCheck(stackval,"stack height",3);
        Dup.setC(label_.getLabelName()+variables+stackvals+asserts+label_.getLabelEnd());
        return Dup.getC();
    }

    //Exchange 1st and (* + 1)th stack items.
    @Override
    public String visit(swap Swap,int orderNo)
    {
        System.out.println(Integer.toHexString(Swap.getOpcode()).toUpperCase() + "  "+ Swap.getName());//output the instruction(Disassembly), used for decompilation
        int swapPosition = Swap.getOpcodeNo()+1;
        int varno1=getVariableNumber()+1;
        int varno2=getVariableNumber()+2;
        setVariableNumber(variableNumber+2);

        stack stackval1 = new stack("",1,"-");
        stack stackval2 = new stack("",swapPosition,"-");
        variable var1 = new variable(varno1,"",stackval1.getStackOp(),"");
        variable var2 = new variable(varno2,"",stackval2.getStackOp(),"");
        variable var3 = new variable(0,stackval1.getStackOp(),"tmp"+varno2,"");// no need for tmp number as a variable name has been provided
        variable var4 = new variable(0,stackval2.getStackOp(),"tmp"+varno1,"");
        label label_ =new label(orderNo);
        
        String variables =var1.getVariable()+var2.getVariable()+var3.getNoTypeVariable()+var4.getNoTypeVariable();
        String stackvals ="\n";
        String asserts= "\tassert("+swapPosition+"<= top);\n"+getCheck(stackval1,"stack height",3);//ensure the swap position exists in the stack (top is an integer representng the stack pointer )
        
        Swap.setC( label_.getLabelName()+variables+stackvals+asserts+label_.getLabelEnd());
        return Swap.getC();
    }

    //addition
    @Override
    public String visit(add Add,int orderNo) 
    {
        //dissasembly
        System.out.println("0"+Integer.toHexString(Add.getOpcode()).toUpperCase() + "  "+ Add.getName());//output the instruction(Disassembly), used for decompilation
        Add.setC(arithmeticCodeGenerator(orderNo,getVariableNumber()," + ",3,true));//C Code 
        getMemoryAddForStack("+");
        return Add.getC();
    }
    
    //multiplication
    @Override
    public String visit(mul Mul,int orderNo) 
    {
        System.out.println("0"+Integer.toHexString(Mul.getOpcode()).toUpperCase() + "  "+ Mul.getName());//output the instruction(Disassembly), used for decompilation
        Mul.setC(arithmeticCodeGenerator(orderNo,getVariableNumber()," * ",5,true));//C Code 
        getMemoryAddForStack("*");
        return Mul.getC();
    }

    //subtraction
    @Override
    public String visit(sub Sub,int orderNo) 
    {
        System.out.println("0"+Integer.toHexString(Sub.getOpcode()).toUpperCase() + "  "+ Sub.getName());//output the instruction(Disassembly), used for decompilation
        Sub.setC(arithmeticCodeGenerator(orderNo,getVariableNumber()," - ",3,true));//C Code  
        getMemoryAddForStack("-");
        return Sub.getC();
    }

    //unsigned division
    @Override
    public String visit(div Div,int orderNo){
        System.out.println("0"+Integer.toHexString(Div.getOpcode()).toUpperCase() + "  "+ Div.getName());//output the instruction(Disassembly), used for decompilation
        Div.setC(arithmeticCodeGenerator(orderNo,getVariableNumber()," / ",5,true));//C Code  
        getMemoryAddForStack("/");
        return Div.getC();
    }

    //signed division
    @Override
    public String visit(sdiv Sdiv,int orderNo){
        System.out.println("0"+Integer.toHexString(Sdiv.getOpcode()).toUpperCase() + "  "+ Sdiv.getName());//output the instruction(Disassembly), used for decompilation
        Sdiv.setC(arithmeticCodeGenerator(orderNo,getVariableNumber()," / ",5,false));//C Code 
        getMemoryAddForStack("/");
        return Sdiv.getC();
    }

    @Override
    //modulo
    public String visit(mod Mod,int orderNo){
        System.out.println("0"+Integer.toHexString(Mod.getOpcode()).toUpperCase() + "  "+ Mod.getName());//output the instruction(Disassembly), used for decompilation
        Mod.setC(arithmeticCodeGenerator(orderNo,getVariableNumber()," % ",5,true));//C Code 
        getMemoryAddForStack("%");
        return Mod.getC();
    }

    //signed Modulo
    @Override
    public String visit(smod Smod,int orderNo){
        System.out.println("0"+Integer.toHexString(Smod.getOpcode()).toUpperCase() + "  "+ Smod.getName());//output the instruction(Disassembly), used for decompilation
        Smod.setC(arithmeticCodeGenerator(orderNo,getVariableNumber()," % ",5,false));//C Code 
        getMemoryAddForStack("%");
        return Smod.getC();
    }

    //no code generation?
    @Override
    public String visit(addmod Addmod,int orderNo){
        System.out.println("0"+Integer.toHexString(Addmod.getOpcode()).toUpperCase() + "  "+ Addmod.getName());//output the instruction(Disassembly), used for decompilation
        return "\n//"+Addmod.getName()+"\n";//gas =8
    }

    //no code generation?
    @Override
    public String visit(mulmod Mulmod,int orderNo){
        System.out.println("0"+Integer.toHexString(Mulmod.getOpcode()).toUpperCase() + "  "+ Mulmod.getName());//output the instruction(Disassembly), used for decompilation
        return "\n//"+Mulmod.getName()+"\n";//gas=8
    }

    //#include <math.h> and pow(x, y)
    @Override
    public String visit(exp Exp,int orderNo){
        System.out.println("0"+Integer.toHexString(Exp.getOpcode()).toUpperCase() + "  "+ Exp.getName());//output the instruction(Disassembly), used for decompilation
        
        stack stackval1 = new stack("",2,"-");
        stack stackval2 = new stack("",1,"-");
        String unsignedstr ="u";
        variable var1 = new variable(getVariableNumber()+1,"",stackval1.getStackOp(),unsignedstr);//no need for varName as these are tmp variables
        variable var2 = new variable(getVariableNumber()+2,"",stackval2.getStackOp(),unsignedstr);
        variable var3 = new variable(getVariableNumber()+3,"","pow("+var1.getVariableName()+","+var2.getVariableName()+")",unsignedstr);
        setVariableNumber(variableNumber+3);
        stack stackval = new stack(var3.getVariableName(),2,"-");

        label label_ =new label(orderNo);

        String variables =var1.getVariable()+var2.getVariable()+var3.getVariable();

        String stackvals ="\t"+stackval.getOperationPop()+"\t"+stackval.getStackVariable()+"\n\t"+stackval.getStackPushTop()+"\n";
         
        String asserts= getCheck(stackval,"stack height",10);
        Exp.setC(label_.getLabelName()+variables+stackvals+asserts+label_.getLabelEnd());
        getMemoryAddForStack("**");
        return Exp.getC();
    }

    //sign extend x from (b+1) bytes to 32 bytes (in solidity this is a function call to SIGNEXTEND(x, b) , x and b being the last two values on the stack)
    @Override
    public String visit(signextend Signextend,int orderNo){
        System.out.println("0"+Integer.toHexString(Signextend.getOpcode()).toUpperCase() + "  "+ Signextend.getName());//output the instruction(Disassembly), used for decompilation
        Signextend.setC(arithmeticCodeGenerator(orderNo,getVariableNumber()," ~ ",5,false));//C Code 
        getMemoryAddForStack("~");
        return Signextend.getC();
    }

    //lower than
    @Override
    public String visit(lt Lt,int orderNo){
        System.out.println(Integer.toHexString(Lt.getOpcode()).toUpperCase() + "  "+ Lt.getName());//output the instruction(Disassembly), used for decompilation
        Lt.setC(arithmeticCodeGenerator(1,0," < ",3,true));//C Code 
        getMemoryAddForStack("<");
        return Lt.getC();
    }

    //greater than
    @Override
    public String visit(gt GT,int orderNo){
        System.out.println(Integer.toHexString(GT.getOpcode()).toUpperCase() + "  "+ GT.getName());//output the instruction(Disassembly), used for decompilation
        GT.setC(arithmeticCodeGenerator(orderNo,getVariableNumber()," > ",3,true));//C Code 
        getMemoryAddForStack(">");
        return GT.getC();
    }

    //signed lower than
    @Override
    public String visit(slt Slt,int orderNo){
        System.out.println(Integer.toHexString(Slt.getOpcode()).toUpperCase() + "  "+ Slt.getName());//output the instruction(Disassembly), used for decompilation
        Slt.setC(arithmeticCodeGenerator(orderNo,getVariableNumber()," < ",3,false));//C Code 
        getMemoryAddForStack("<");
        return Slt.getC();
    }

    //signed greater than
    @Override
    public String visit(sgt Sgt,int orderNo){
        System.out.println(Integer.toHexString(Sgt.getOpcode()).toUpperCase() + "  "+ Sgt.getName());//output the instruction(Disassembly), used for decompilation
        Sgt.setC(arithmeticCodeGenerator(orderNo,getVariableNumber()," > ",3,false));//C Code 
        getMemoryAddForStack(">");
        return Sgt.getC();   
    }

    //equal to operator
    @Override
    public String visit(eq Eq,int orderNo){
        System.out.println(Integer.toHexString(Eq.getOpcode()).toUpperCase()+ "  "+ Eq.getName());//output the instruction(Disassembly), used for decompilation
        Eq.setC(arithmeticCodeGenerator(orderNo,getVariableNumber()," == ",3,true));//C Code 
        getMemoryAddForStack("==");
        return Eq.getC();
    }

    //simple not operator
    @Override
    public String visit(iszero Iszero,int orderNo){
        System.out.println(Integer.toHexString(Iszero.getOpcode()).toUpperCase() + "  "+ Iszero.getName());//output the instruction(Disassembly), used for decompilation
        stack stackval1 = new stack("",1,"-");
        String unsignedstr ="u";
        variable var1 = new variable(getVariableNumber()+1,"",stackval1.getStackOp(),unsignedstr);//no need for varName as these are tmp variables
        variable var3 = new variable(getVariableNumber()+2,"","!("+var1.getVariableName()+")",unsignedstr);
        setVariableNumber(variableNumber+1);
        stack stackval = new stack(var3.getVariableName(),1,"-");

        label label_ =new label(orderNo);

        String variables =var1.getVariable()+var3.getVariable();

        String stackvals ="\t"+stackval.getStackPopTop()+"\t"+stackval.getStackVariable()+"\n\t"+stackval.getStackPushTop()+"\n";
        
        String asserts= getCheck(stackval,"stack height",3);
        Iszero.setC(label_.getLabelName()+variables+stackvals+asserts+label_.getLabelEnd());
        getMemoryAddForStack("!");
        return Iszero.getC();
    }

    //bitwise AND
    @Override
    public String visit(and And,int orderNo){
        System.out.println(Integer.toHexString(And.getOpcode()).toUpperCase() + "  "+ And.getName());//output the instruction(Disassembly), used for decompilation
        And.setC(arithmeticCodeGenerator(orderNo,getVariableNumber()," & ",3,false));//C Code 
        getMemoryAddForStack("&&");
        return And.getC();
    }

    //bitwise OR
    @Override
    public String visit(or Or,int orderNo){
        System.out.println(Integer.toHexString(Or.getOpcode()).toUpperCase() + "  "+ Or.getName());//output the instruction(Disassembly), used for decompilation
        Or.setC(arithmeticCodeGenerator(orderNo,getVariableNumber()," | ",3,false));//C Code 
        getMemoryAddForStack("||");
        return Or.getC();
    }

    //bitwise XOR
    @Override
    public String visit(xor Xor,int orderNo){
        System.out.println(Integer.toHexString(Xor.getOpcode()).toUpperCase() + "  "+ Xor.getName());//output the instruction(Disassembly), used for decompilation
        Xor.setC(arithmeticCodeGenerator(orderNo,getVariableNumber()," ^ ",3,false));//C Code 
        getMemoryAddForStack("^");
        return Xor.getC();    
    }

    //bitwise NOT, i.e ~(last value of stack) in c
    @Override
    public String visit(not Not,int orderNo){
        System.out.println(Integer.toHexString(Not.getOpcode()).toUpperCase() + "  "+ Not.getName());//output the instruction(Disassembly), used for decompilation
        stack stackval1 = new stack("",1,"-");
        String unsignedstr ="u";
        variable var1 = new variable(getVariableNumber()+1,"",stackval1.getStackOp(),unsignedstr);//no need for varName as these are tmp variables
        variable var3 = new variable(getVariableNumber()+2,"","~("+var1.getVariableName()+")",unsignedstr);
        setVariableNumber(variableNumber+1);
        stack stackval = new stack(var3.getVariableName(),1,"-");

        label label_ =new label(orderNo);

        String variables =var1.getVariable()+var3.getVariable();

        String stackvals ="\t"+stackval.getStackPopTop()+"\t"+stackval.getStackVariable()+"\n\t"+stackval.getStackPushTop()+"\n";
        String asserts= getCheck(stackval,"stack height",3);
        Not.setC(label_.getLabelName()+variables+stackvals+asserts+label_.getLabelEnd());
        getMemoryAddForStack("~");
        return Not.getC();
    }
    
    @Override
    public String visit(bytee Bytee,int orderNo){
        System.out.println(Integer.toHexString(Bytee.getOpcode()).toUpperCase() + "  "+ Bytee.getName());//output the instruction(Disassembly), used for decompilation
        return "\n\t"+getGasNoCheck(3);//gas 3
    }

    //shift left
    @Override
    public String visit(shl Shl,int orderNo){
        System.out.println(Integer.toHexString(Shl.getOpcode()).toUpperCase() + "  "+ Shl.getName());//output the instruction(Disassembly), used for decompilation
        Shl.setC(arithmeticCodeGenerator(orderNo,getVariableNumber()," << ",3,false));//C Code 
        getMemoryAddForStack("<<");
        return Shl.getC();
    }

    //logical shift right
    @Override
    public String visit(shr Shr,int orderNo){
        System.out.println(Integer.toHexString(Shr.getOpcode()).toUpperCase() + "  "+ Shr.getName());//output the instruction(Disassembly), used for decompilation
        Shr.setC(arithmeticCodeGenerator(orderNo,getVariableNumber()," >> ",3,false));//C Code 
        getMemoryAddForStack(">>");
        return Shr.getC();
    }

    //arithmetic shift right, C and C++ have only arithmetic shifting
    @Override
    public String visit(sar Sar,int orderNo){
        System.out.println(Integer.toHexString(Sar.getOpcode()).toUpperCase() + "  "+ Sar.getName());//output the instruction(Disassembly), used for decompilation
        Sar.setC(arithmeticCodeGenerator(orderNo,getVariableNumber()," >> ",3,false));//C Code 
        getMemoryAddForStack(">>>");
        return Sar.getC();
    }

    //accounts model

    //ADDRESS: Get the address of the currently executing account
    /*
        stack[top]=accounts[accountNo-1].address;
        top++;
        gas+=2;
    */
    @Override
    public String visit(address Address,int orderNo){
        System.out.println(Integer.toHexString(Address.getOpcode()).toUpperCase() + "  "+ Address.getName());//output the instruction(Disassembly), used for decompilation
        stack stackval =new stack("accounts[accountNo-1].address",0,"");
        label label_ =new label(orderNo);
        String strVals = label_.getLabelName()+"\t"+stackval.getStackVariable()+"\n\t"+stackval.getStackPushTop()+"\n\t"+getGasNoCheck(2)+label_.getLabelEnd();
        Address.setC(strVals);
        return Address.getC();
    }

    //BALANCE: Get the account balance of any given account
    /*
    stack[top]=accounts[accountNo-1].balance;
    top++;
    gas+=400
    */
    @Override
    public String visit(balance Balance,int orderNo){
        System.out.println(Integer.toHexString(Balance.getOpcode()).toUpperCase() + "  "+ Balance.getName());//output the instruction(Disassembly), used for decompilation
        stack stackval =new stack("accounts[accountNo-1].balance",0,"");
        label label_ =new label(orderNo);
        String strVals = label_.getLabelName()+"\t"+stackval.getStackVariable()+"\n\t"+stackval.getStackPushTop()+"\n\t"+getGasNoCheck(400)+label_.getLabelEnd();
        Balance.setC(strVals);
        return Balance.getC();   
    }

    //GASPRICE: Get the gas price specified by the originating transaction
    /*
    stack[top]=gasUsed;
    top++;
    gas+=2;
    */
    @Override
    public String visit(gasprice Gasprice,int orderNo){
        System.out.println(Integer.toHexString(Gasprice.getOpcode()).toUpperCase() + "  "+ Gasprice.getName());//output the instruction(Disassembly), used for decompilation
        stack stackval =new stack("gasUsed",0,"");
        label label_ =new label(orderNo);
        String strVals = label_.getLabelName()+"\t"+stackval.getStackVariable()+"\n\t"+stackval.getStackPushTop()+"\n\t"+getGasNoCheck(2)+label_.getLabelEnd();
        Gasprice.setC(strVals);
        return Gasprice.getC();
    }

    //pop value off the top of the stack
    @Override
    public String visit(pop Pop,int orderNo){
        System.out.println(Integer.toHexString(Pop.getOpcode()).toUpperCase() + "  "+ Pop.getName());//output the instruction(Disassembly), used for decompilation
        label label_ =new label(orderNo);
        stack stackval = new stack("",0,"");
        String asserts= getCheck(stackval,"not empty",2);
        String stackvals ="\t"+stackval.getStackPopTop();
        String PopValues= label_.getLabelName()+stackvals+asserts+label_.getLabelEnd();
        Pop.setC(PopValues);
        return Pop.getC();
    }
    
    //GAS: Get the amount of available gas (after the reduction for this instruction)
    /*
    gasUsed+=2;
    stack[top]=GASLIMIT- gasUsed;
    top++;
    */
    @Override
    public String visit(gas Gas,int orderNo){
        System.out.println(Integer.toHexString(Gas.getOpcode()).toUpperCase() + "  "+ Gas.getName());//output the instruction(Disassembly), used for decompilation
        stack stackval =new stack("GASLIMIT- gasUsed",0,"");
        label label_ =new label(orderNo);
        String strVals = label_.getLabelName()+"\tgasUsed+=2;\n\t"+stackval.getStackVariable()+"\n\t"+stackval.getStackPushTop()+label_.getLabelEnd();
        Gas.setC(strVals);
        return Gas.getC();
    }
    //Create an account with a balance and address
    /*
    accounts[accountNo] = (struct numpair){accountNo, 2.0};
    accountNo++;
    gas+=32000;
    
    WHERE:
    struct numpair {
        int accNum;
        double balance;
    };
    struct numpair accounts[MEMORYSIZE] = {};   */
    @Override
    public String visit(create Create,int orderNo){
        System.out.println(Integer.toHexString(Create.getOpcode()).toUpperCase() + "  "+ Create.getName());//output the instruction(Disassembly), used for decompilation
        account accountStr = new account();
        label label_ = new label(orderNo);
        String strVals= label_.getLabelName()+accountStr.getCreateAccount()+"\n\t"+getGasNoCheck(32000)+label_.getLabelEnd();
        Create.setC(strVals);
        return Create.getC();
    }
    //unknown gas cost for create 2... so used the same as create 
    @Override
    public String visit(create2 Create2,int orderNo){
        System.out.println(Integer.toHexString(Create2.getOpcode()).toUpperCase() + "  "+ Create2.getName());//output the instruction(Disassembly), used for decompilation
        account accountStr = new account();
        label label_ = new label(orderNo);
        String strVals= label_.getLabelName()+accountStr.getCreateAccount()+"\n\t"+getGasNoCheck(32000)+label_.getLabelEnd();
        Create2.setC(strVals);
        return Create2.getC();
    }

    //RETURN: Halt execution and return output data
    @Override
    public String visit(return_ Return_,int orderNo){
        System.out.println(Integer.toHexString(Return_.getOpcode()).toUpperCase() + "  "+ Return_.getName());//output the instruction(Disassembly), used for decompilation
        returnVal exit = new returnVal(0);
        return exit.getExitStatement();
    }

    //REVERT: Halt execution, reverting state changes but returning data and remaining gas
    @Override
    public String visit(revert Revert,int orderNo){
        System.out.println(Integer.toHexString(Revert.getOpcode()).toUpperCase() + "  "+ Revert.getName());//output the instruction(Disassembly), used for decompilation
        returnVal exit = new returnVal(0);
        return exit.getExitStatement();
    }

    //INVALID: The designated invalid instruction
    @Override
    public String visit(invalid Invalid,int orderNo){
        System.out.println(Integer.toHexString(Invalid.getOpcode()).toUpperCase() + "  "+ Invalid.getName());//output the instruction(Disassembly), used for decompilation
        return "";
    }

    // SELFDESTRUCT: Halt execution and register account for deletion
    @Override
    public String visit(selfdestruct Selfdestruct,int orderNo){
        System.out.println(Integer.toHexString(Selfdestruct.getOpcode()).toUpperCase() + "  "+ Selfdestruct.getName());//output the instruction(Disassembly), used for decompilation
        return"exit(0);" ;
    }

    // hash the last two items of stack,  sha3 algorithm is from https://github.com/mchrapek/sha3-java
    @Override
    public String visit(sh3 Sh3,int orderNo) 
    {
        System.out.println(Integer.toHexString(Sh3.getOpcode()).toUpperCase() + "  "+ Sh3.getName());//output the instruction(Disassembly), used for decompilation

        String x = java_stack.pop();  
        String y = java_stack.pop();  
        // string to byte[]
        byte[] input = (x+y).getBytes();
        Type type = Type.SHA3_256;
        Sha3 sha3 = new Sha3(type);
        byte[] encode = sha3.encode(input);
        String s = Base64.getEncoder().encodeToString(encode);
        java_stack.push(s);

        String gasCheck= getGasNoCheck(30);//C Code;//gas is aproximtely 30, but can vary so not 100% accurate
        label label_ = new label(orderNo);
        Sh3.setC(label_.getLabelName()+"\t"+gasCheck+"\n\t"+"stack[top]='"+s+"';\n"+label_.getLabelEnd());
        return Sh3.getC();
    }

    //halts execution,exits program
    @Override
    public String visit(stop Stop,int orderNo) 
    {
        System.out.println("0"+Integer.toHexString(Stop.getOpcode()).toUpperCase() + "  "+ Stop.getName());//output the instruction(Disassembly), used for decompilation
        returnVal exit = new returnVal(0);
        return exit.getExitStatement();
    }

    //memory model

    //Look through the memory, if the memory location is equal to the top of the stack, store the value in that memory location on the stack
    /*
    int i;
    for (i = 0; i <= memPoint; i++)
    {
        if (memory[i].location == stack[top-1]) 
        {                    
        stack[top]= memory[i].value;
        top++;
        }
    }
    */
    @Override
    public String visit(mload Mload,int orderNo){
      System.out.println(Integer.toHexString(Mload.getOpcode()).toUpperCase() + "  "+ Mload.getName());//output the instruction(Disassembly), used for decompilation
      label label_ =new label(orderNo);
      memory mem = new memory();
      Mload.setC(label_.getLabelName()+mem.getmLoad()+"\t"+getGasNoCheck(3)+label_.getLabelEnd());
      return Mload.getC();
    }
  
    //Top of stack= memory location, top of stack-1 = value
    /*
        memory[memPoint] = (struct pair){stack[top],stack[top-1] };
        top-=2;
        memPoint++;
     */
    @Override
    public String visit(mstore Mstore,int orderNo){
        System.out.println(Integer.toHexString(Mstore.getOpcode()).toUpperCase() + "  "+ Mstore.getName());//output the instruction(Disassembly), used for decompilation
        label label_ =new label(orderNo);
        memory mem = new memory();
        Mstore.setC(label_.getLabelName()+mem.getmStore()+"\t"+getGasNoCheck(3)+label_.getLabelEnd());
        return Mstore.getC();
    }
  
    //Top of stack= memory location, top of stack-1 = value
     /*C code
        memory[memPoint] = (struct pair){stack[top],stack[top-1] };
        top-=2;
        memPoint++;
     */
    @Override
    public String visit(mstore8 Mstore8,int orderNo){
        System.out.println(Integer.toHexString(Mstore8.getOpcode()).toUpperCase() + "  "+ Mstore8.getName());//output the instruction(Disassembly), used for decompilation
        label label_ =new label(orderNo);
        memory mem = new memory();
        Mstore8.setC(label_.getLabelName()+mem.getmStore()+"\t"+getGasNoCheck(3)+label_.getLabelEnd());
        return Mstore8.getC();
    }
  
    // Load the value of a storage location
    /*  C code:
    for (i = 0; i <= storePoint; i++)
    {
        if (storage[i].location == stack[top-1]) 
        {                    
        stack[top]= storage[i].value;
        top++;
        }
    }
    WHERE
    struct pair {
        var location;
        var value;
    };

    struct pair storage[MEMORYSIZE] = {};
    var storePoint;
    */
    @Override
    public String visit(sload Sload,int orderNo){
        System.out.println(Integer.toHexString(Sload.getOpcode()).toUpperCase() + "  "+ Sload.getName());//output the instruction(Disassembly), used for decompilation
        label label_ =new label(orderNo);
        storage store = new storage();
        Sload.setC(label_.getLabelName()+store.getsLoad()+"\t"+getGasNoCheck(800)+label_.getLabelEnd());
        return Sload.getC();
    }
  
    //Top of stack= storage location, top of stack-1 = value, storage[0x80] = 0x40;
     /*
        storage[storePoint] = (struct pair){stack[top],stack[top-1] };
        top-=2;
        storePoint++;
     */
    @Override
    public String visit(sstore Sstore,int orderNo){
        System.out.println(Integer.toHexString(Sstore.getOpcode()).toUpperCase() + "  "+ Sstore.getName());//output the instruction(Disassembly), used for decompilation
        label label_ =new label(orderNo);
        storage store = new storage();
        Sstore.setC(label_.getLabelName()+store.getsStore()+"\t"+getGasNoCheck(20000)+label_.getLabelEnd());
        return Sstore.getC();
    }
    //stack[top]=memPoint;
    //top++;
    //gasUsed+=2;    
    @Override
    public String visit(msize Msize,int orderNo){
        System.out.println(Integer.toHexString(Msize.getOpcode()).toUpperCase() + "  "+ Msize.getName());//output the instruction(Disassembly), used for decompilation
        label label_=new label(orderNo);
        stack stackk = new stack("memPoint",2,"");
        Msize.setC(label_.getLabelName()+"\t"+stackk.getStackVariable()+"\n\t"+stackk.getStackPushTop()+"\t"+getGasNoCheck(2)+label_.getLabelEnd());
        return Msize.getC();
    }
    //Get the value of the program counter prior to the increment corresponding to this instruction.
    //stack[top]=pcCounter;
    //top++;
    //pcCounter++;
    //gasUsed+=2;

    @Override
    public String visit(pc Pc,int orderNo){
        System.out.println(Integer.toHexString(Pc.getOpcode()).toUpperCase() + "  "+ Pc.getName());//output the instruction(Disassembly), used for decompilation
        label label_=new label(orderNo);
        stack stackk = new stack("pcCounter",2,"");
        Pc.setC(label_.getLabelName()+"\t"+stackk.getStackVariable()+"\n\t"+stackk.getStackPushTop()+"\n\tpcCounter++;"+"\t"+getGasNoCheck(2)+label_.getLabelEnd());
        return Pc.getC();
    }

   //
   @Override
   public String visit(jumpdest Jumpdest,int orderNo){
       System.out.println(Integer.toHexString(Jumpdest.getOpcode()).toUpperCase() + "  "+ Jumpdest.getName());//output the instruction(Disassembly), used for decompilation
       return "";
   }
   //
   @Override
   public String visit(jumpi Jumpi,int orderNo){
         System.out.println(Integer.toHexString(Jumpi.getOpcode()).toUpperCase() + "  "+ Jumpi.getName());//output the instruction(Disassembly), used for decompilation
         return "";
   }
   //Alter the program counter, and jump to address ontop of stack
   @Override
   public String visit(jump Jump,int orderNo){
       System.out.println(Integer.toHexString(Jump.getOpcode()).toUpperCase() + "  "+ Jump.getName());//output the instruction(Disassembly), used for decompilation
       function f = new function("label_"+ (orderNo-1)); 
       label label_ = new label(orderNo);
       String getGas = getGasNoCheck(8);
       Jump.setC(label_.getLabelName()+"\t"+getGas+"\n\t"+f.getFunctionCall()+"\n\tpcCounter++;"+label_.getLabelEnd());
       return Jump.getC();
   }
 
    //-----------------------------------------------------------------------------------------------------------------//

    //Dissasembly, and gass calculation
    @Override
    public String visit(staticcall Staticcall,int orderNo){
        System.out.println(Integer.toHexString(Staticcall.getOpcode()).toUpperCase() + "  "+ Staticcall.getName());//output the instruction(Disassembly), used for decompilation
        return "\n\t"+getGasNoCheck(40);
    }
    @Override
    public String visit(call Call,int orderNo){
        System.out.println(Integer.toHexString(Call.getOpcode()).toUpperCase() + "  "+ Call.getName());//output the instruction(Disassembly), used for decompilation
        return "";
    }
    @Override
    public String visit(callcode Callcode,int orderNo){
        System.out.println(Integer.toHexString(Callcode.getOpcode()).toUpperCase() + "  "+ Callcode.getName());//output the instruction(Disassembly), used for decompilation
        return "";
    }
    @Override
    public String visit(delegatecall Delegatecall,int orderNo){
        System.out.println(Integer.toHexString(Delegatecall.getOpcode()).toUpperCase() + "  "+ Delegatecall.getName());//output the instruction(Disassembly), used for decompilation
        return "";
    }
    @Override
    public String visit(origin Origin,int orderNo){
        System.out.println(Integer.toHexString(Origin.getOpcode()).toUpperCase() + "  "+ Origin.getName());//output the instruction(Disassembly), used for decompilation
        return "\n\t"+getGasNoCheck(2);
    }

    @Override
    public String visit(caller Caller,int orderNo){
        System.out.println(Integer.toHexString(Caller.getOpcode()).toUpperCase() + "  "+ Caller.getName());//output the instruction(Disassembly), used for decompilation
        return "\n\t"+getGasNoCheck(2);
    }

    //
    @Override
    public String visit(callvalue Callvalue,int orderNo){
        System.out.println(Integer.toHexString(Callvalue.getOpcode()).toUpperCase() + "  "+ Callvalue.getName());//output the instruction(Disassembly), used for decompilation
        return "\n\t"+getGasNoCheck(2);
    }

    //
    @Override
    public String visit(calldataload Calldataload,int orderNo){
        System.out.println(Integer.toHexString(Calldataload.getOpcode()).toUpperCase() + "  "+ Calldataload.getName());//output the instruction(Disassembly), used for decompilation
        return "\n\t"+getGasNoCheck(3);
    }

    //
    @Override
    public String visit(calldatasize Calldatasize,int orderNo){
        System.out.println(Integer.toHexString(Calldatasize.getOpcode()).toUpperCase() + "  "+ Calldatasize.getName());//output the instruction(Disassembly), used for decompilation
        return "\n\t"+getGasNoCheck(2);
    }
   @Override
   public String visit(calldatacopy Calldatacopy,int orderNo){
       System.out.println(Integer.toHexString(Calldatacopy.getOpcode()).toUpperCase() + "  "+ Calldatacopy.getName());//output the instruction(Disassembly), used for decompilation
       return "\n\t"+getGasNoCheck(3);
   }

   @Override
   public  String visit(codesize Codesize,int orderNo){
       System.out.println(Integer.toHexString(Codesize.getOpcode()).toUpperCase() + "  "+ Codesize.getName());//output the instruction(Disassembly), used for decompilation
       return "\n\t"+getGasNoCheck(2);
   }

   @Override
   public String visit(codecopy Codecopy,int orderNo){
       System.out.println(Integer.toHexString(Codecopy.getOpcode()).toUpperCase() + "  "+ Codecopy.getName());//output the instruction(Disassembly), used for decompilation
       return "\n\t"+getGasNoCheck(3);
   }

   @Override
   public String visit(extcodesize Extcodesize,int orderNo){
       System.out.println(Integer.toHexString(Extcodesize.getOpcode()).toUpperCase() + "  "+ Extcodesize.getName());//output the instruction(Disassembly), used for decompilation
       return "\n\t"+getGasNoCheck(700);
   }

   @Override
   public String visit(extcodecopy Extcodecopy,int orderNo){
       System.out.println(Integer.toHexString(Extcodecopy.getOpcode()).toUpperCase() + "  "+ Extcodecopy.getName());//output the instruction(Disassembly), used for decompilation
       return "\n\t"+getGasNoCheck(700);
   }

   @Override
   public String visit(returndatasize Returndatasize,int orderNo){
       System.out.println(Integer.toHexString(Returndatasize.getOpcode()).toUpperCase() + "  "+ Returndatasize.getName());//output the instruction(Disassembly), used for decompilation
       return "\n\t"+getGasNoCheck(2);
   }

   @Override
   public String visit(returndatacopy Returndatacopy,int orderNo){
       System.out.println(Integer.toHexString(Returndatacopy.getOpcode()).toUpperCase() + "  "+ Returndatacopy.getName());//output the instruction(Disassembly), used for decompilation
       return "\n\t"+getGasNoCheck(3);
   }

   @Override
   public String visit(extcodehash Extcodehash,int orderNo){
       System.out.println(Integer.toHexString(Extcodehash.getOpcode()).toUpperCase() + "  "+ Extcodehash.getName());//output the instruction(Disassembly), used for decompilation
       return "\n\t"+getGasNoCheck(700);
   }

   @Override
   public String visit(blockhash Blockhash,int orderNo){
       System.out.println(Integer.toHexString(Blockhash.getOpcode()).toUpperCase() + "  "+ Blockhash.getName());//output the instruction(Disassembly), used for decompilation
       return "\n\t"+getGasNoCheck(20);
   }

   @Override
   public String visit(coinbase Coinbase,int orderNo){
       System.out.println(Integer.toHexString(Coinbase.getOpcode()).toUpperCase() + "  "+ Coinbase.getName());//output the instruction(Disassembly), used for decompilation
       return "\n\t"+getGasNoCheck(2);
   }

   @Override
   public String visit(timestamp Timestamp,int orderNo){
       System.out.println(Integer.toHexString(Timestamp.getOpcode()).toUpperCase() + "  "+ Timestamp.getName());//output the instruction(Disassembly), used for decompilation
       return "\n\t"+getGasNoCheck(2);
   }

   @Override
   public String visit(number Number,int orderNo){
       System.out.println(Integer.toHexString(Number.getOpcode()).toUpperCase() + "  "+ Number.getName());//output the instruction(Disassembly), used for decompilation
       return "\n\t"+getGasNoCheck(2);
   }

   @Override
   public String visit(difficulty Difficulty,int orderNo){
       System.out.println(Integer.toHexString(Difficulty.getOpcode()).toUpperCase() + "  "+ Difficulty.getName());//output the instruction(Disassembly), used for decompilation
       return "\n\t"+getGasNoCheck(2);
   }

   @Override
   public String visit(gaslimit Gaslimit,int orderNo){
       System.out.println(Integer.toHexString(Gaslimit.getOpcode()).toUpperCase() + "  "+ Gaslimit.getName());//output the instruction(Disassembly), used for decompilation
       return "\n\t"+getGasNoCheck(2);
   }
   @Override
   public String visit(chainid Chainid,int orderNo){
       System.out.println(Integer.toHexString(Chainid.getOpcode()).toUpperCase() + "  "+ Chainid.getName());//output the instruction(Disassembly), used for decompilation
       return "\n\t"+getGasNoCheck(2);
   }
   @Override
   public String visit(selfbalance Selfbalance,int orderNo){
       System.out.println(Integer.toHexString(Selfbalance.getOpcode()).toUpperCase() + "  "+ Selfbalance.getName());//output the instruction(Disassembly), used for decompilation
       return "";
   }

   @Override
   public String visit(basefee Basefee,int orderNo){
       System.out.println(Integer.toHexString(Basefee.getOpcode()).toUpperCase() + "  "+ Basefee.getName());//output the instruction(Disassembly), used for decompilation
       return "\n\t"+getGasNoCheck(2);
    }

    //-----------------------------------------------------------------------------------------------------------------//
    //ensures there are never two of the same variable names in thr c generated code, goes in order from first call 
    public int getVariableNumber() {
        return variableNumber;
    }

    public void setVariableNumber(int variableNumber) {
        this.variableNumber = variableNumber;
    }
    //-----------------------------------------------------------------------------------------------------------------//

}

