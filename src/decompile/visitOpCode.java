//Author Gera Jahja
package src.decompile;
import src.interfaces.*;
import src.opcodes.*;
import src.cCodes.*;

//Uses interfaces to visit the opcode java classes
//Last update: 24/04
class visitOpCode implements Dissasemble
{ 
    //C code that is  used for more than one opcode:
    public String getCheck(stack st,String assertFor){
        assertVal stackCheck =new assertVal("");
        if (assertFor=="not empty"){
            stackCheck = new assertVal(st.getAssertStackNotEmpty());
        }else if (assertFor=="stack height"){
            stackCheck = new assertVal(st.getAssertStackHeight());
        }
        assertVal gasCheck = new assertVal("gasUsed < gasLimit");
        return "\t"+stackCheck.getAssertCall()+"\n\t"+"gasUsed ++;"+"\n\t"+gasCheck.getAssertCall();
    }


    public String arithmeticCodeGenerator(int lableno,int no,String operator){
        //decompilation
        stack stackval1 = new stack("",2,"-");
        stack stackval2 = new stack("",1,"-");
        //NUM SHOULD BE A PARMETER
        variable var1 = new variable(no+1,"",stackval1.getStackOp());//no need for varName as these are tmp variables
        variable var2 = new variable(no+2,"",stackval2.getStackOp());
        variable var3 = new variable(no+3,"",var1.getVariableName()+operator+var2.getVariableName());

        stack stackval = new stack(var3.getVariableName(),2,"-");

        label label_ =new label(lableno);//ORDER SHOULD BE A PARAMETER

        String variables =var1.getVariable()+var2.getVariable()+var3.getVariable();

        String stackvals ="\t"+stackval.getStackVariable()+"\n\t"+stackval.getStackPushTop()+"\n";
        
        String asserts= getCheck(stackval,"stack height");
        return label_.getLabelName()+variables+stackvals+asserts+label_.getLabelEnd();
    }
   

    //Visitors
   
    @Override
    public String  visit(push Push,int orderNo)
    {
        System.out.println(Integer.toHexString(Push.getOpcode()).toUpperCase() + "  "+ Push.getName());//output the instruction(Disassembly), used for decompilation
        label label_ =new label(orderNo);
        variable var =new variable(0, "stack[top]" , Push.getMemoryAdd());
        stack stackval = new stack("",0,"");

        String variables =var.getNoTypeVariable();
        String stackvals ="\t"+stackval.getStackPushTop();
        String asserts= getCheck(stackval,"stack height");
        String PushValues= label_.getLabelName()+variables+stackvals+asserts+label_.getLabelEnd();

        Push.setC(PushValues);
        return Push.getC();
    }
  

    @Override
    public String visit(log Log,int orderNo)
    {
        System.out.println(Integer.toHexString(Log.getOpcode()).toUpperCase() + "  "+ Log.getName());//output the instruction(Disassembly), used for decompilation
        return Log.getName();
    }@Override
    public String visit(dup Dup,int orderNo)
        {
        System.out.println(Integer.toHexString(Dup.getOpcode()).toUpperCase() + "  "+ Dup.getName());//output the instruction(Disassembly), used for decompilation
        return Dup.getName();
    }@Override
    public String visit(swap Swap,int orderNo)
    {
        System.out.println(Integer.toHexString(Swap.getOpcode()).toUpperCase() + "  "+ Swap.getName());//output the instruction(Disassembly), used for decompilation
        return Swap.getName();
    }
    //addition
    @Override
    public String visit(add Add,int orderNo) 
    {
        //dissasembly
        System.out.println("0"+Integer.toHexString(Add.getOpcode()).toUpperCase() + "  "+ Add.getName());//output the instruction(Disassembly), used for decompilation
        Add.setC(arithmeticCodeGenerator(orderNo,orderNo," + "));//C Code 
        return Add.getC();
    }
    
    //multiplication
    @Override
    public String visit(mul Mul,int orderNo) 
    {
        System.out.println("0"+Integer.toHexString(Mul.getOpcode()).toUpperCase() + "  "+ Mul.getName());//output the instruction(Disassembly), used for decompilation
        Mul.setC(arithmeticCodeGenerator(orderNo,orderNo," * "));//C Code 
        return Mul.getC();
    }
    //subtraction
    @Override
    public String visit(sub Sub,int orderNo) 
    {
        System.out.println("0"+Integer.toHexString(Sub.getOpcode()).toUpperCase() + "  "+ Sub.getName());//output the instruction(Disassembly), used for decompilation
        Sub.setC(arithmeticCodeGenerator(orderNo,orderNo," - "));//C Code 
        return Sub.getC();
    }
    //unsigned division
    @Override
    public String visit(div Div,int orderNo){
        System.out.println("0"+Integer.toHexString(Div.getOpcode()).toUpperCase() + "  "+ Div.getName());//output the instruction(Disassembly), used for decompilation
        Div.setC(arithmeticCodeGenerator(orderNo,orderNo," / "));//C Code 
        return Div.getC();
    }
    //signed division
    @Override
    public String visit(sdiv Sdiv,int orderNo){
        System.out.println("0"+Integer.toHexString(Sdiv.getOpcode()).toUpperCase() + "  "+ Sdiv.getName());//output the instruction(Disassembly), used for decompilation
        Sdiv.setC(arithmeticCodeGenerator(orderNo,orderNo," / "));//C Code 
        return Sdiv.getC();
    }
    @Override
    //modulo
    public String visit(mod Mod,int orderNo){
        System.out.println("0"+Integer.toHexString(Mod.getOpcode()).toUpperCase() + "  "+ Mod.getName());//output the instruction(Disassembly), used for decompilation
        Mod.setC(arithmeticCodeGenerator(orderNo,orderNo," % "));//C Code 
        return Mod.getC();
    }
    //signed Modulo
    @Override
    public String visit(smod Smod,int orderNo){
        System.out.println("0"+Integer.toHexString(Smod.getOpcode()).toUpperCase() + "  "+ Smod.getName());//output the instruction(Disassembly), used for decompilation
        Smod.setC(arithmeticCodeGenerator(orderNo,orderNo," % "));//C Code 
        return Smod.getC();
    }
    //no code generation?
    @Override
    public String visit(addmod Addmod,int orderNo){
        System.out.println("0"+Integer.toHexString(Addmod.getOpcode()).toUpperCase() + "  "+ Addmod.getName());//output the instruction(Disassembly), used for decompilation
        return "\n//"+Addmod.getName()+"\n";
    }
    //no code generation?
    @Override
    public String visit(mulmod Mulmod,int orderNo){
        System.out.println("0"+Integer.toHexString(Mulmod.getOpcode()).toUpperCase() + "  "+ Mulmod.getName());//output the instruction(Disassembly), used for decompilation
        return "\n//"+Mulmod.getName()+"\n";
    }
    //#include <math.h> and pow(x, y)
    @Override
    public String visit(exp Exp,int orderNo){
        System.out.println("0"+Integer.toHexString(Exp.getOpcode()).toUpperCase() + "  "+ Exp.getName());//output the instruction(Disassembly), used for decompilation
        return Exp.getName();
    }
    //sign extend x from (b+1) bytes to 32 bytes (in solidity this is a function call to SIGNEXTEND(x, b) , x and b being the last two values on the stack)
    @Override
    public String visit(signextend Signextend,int orderNo){
        System.out.println("0"+Integer.toHexString(Signextend.getOpcode()).toUpperCase() + "  "+ Signextend.getName());//output the instruction(Disassembly), used for decompilation
        Signextend.setC(arithmeticCodeGenerator(orderNo,orderNo," ~ "));//C Code 
        return Signextend.getC();
    }
    //lower than
    @Override
    public String visit(lt Lt,int orderNo){
        System.out.println(Integer.toHexString(Lt.getOpcode()).toUpperCase() + "  "+ Lt.getName());//output the instruction(Disassembly), used for decompilation
        Lt.setC(arithmeticCodeGenerator(1,0," < "));//C Code 
        return Lt.getC();
    }
    //greater than
    @Override
    public String visit(gt GT,int orderNo){
        System.out.println(Integer.toHexString(GT.getOpcode()).toUpperCase() + "  "+ GT.getName());//output the instruction(Disassembly), used for decompilation
        GT.setC(arithmeticCodeGenerator(orderNo,orderNo," > "));//C Code 
        return GT.getC();
    }
    //signed lower than
    @Override
    public String visit(slt Slt,int orderNo){
        System.out.println(Integer.toHexString(Slt.getOpcode()).toUpperCase() + "  "+ Slt.getName());//output the instruction(Disassembly), used for decompilation
        Slt.setC(arithmeticCodeGenerator(orderNo,orderNo," < "));//C Code 
        return Slt.getC();
    }
    //signed greater than
    @Override
    public String visit(sgt Sgt,int orderNo){
        System.out.println(Integer.toHexString(Sgt.getOpcode()).toUpperCase() + "  "+ Sgt.getName());//output the instruction(Disassembly), used for decompilation
        Sgt.setC(arithmeticCodeGenerator(orderNo,orderNo," > "));//C Code 
        return Sgt.getC();    }
    //equal to operator
    @Override
    public String visit(eq Eq,int orderNo){
        System.out.println(Integer.toHexString(Eq.getOpcode()).toUpperCase()+ "  "+ Eq.getName());//output the instruction(Disassembly), used for decompilation
        Eq.setC(arithmeticCodeGenerator(orderNo,orderNo," == "));//C Code 
        return Eq.getC();
    }
    //not operator
    @Override
    public String visit(iszero Iszero,int orderNo){
        System.out.println(Integer.toHexString(Iszero.getOpcode()).toUpperCase() + "  "+ Iszero.getName());//output the instruction(Disassembly), used for decompilation
        return Iszero.getName();
    }
    //bitwise AND
    @Override
    public String visit(and And,int orderNo){
        System.out.println(Integer.toHexString(And.getOpcode()).toUpperCase() + "  "+ And.getName());//output the instruction(Disassembly), used for decompilation
        And.setC(arithmeticCodeGenerator(orderNo,orderNo," & "));//C Code 
        return And.getC();
    }
    //bitwise OR
    @Override
    public String visit(or Or,int orderNo){
        System.out.println(Integer.toHexString(Or.getOpcode()).toUpperCase() + "  "+ Or.getName());//output the instruction(Disassembly), used for decompilation
        Or.setC(arithmeticCodeGenerator(orderNo,orderNo," | "));//C Code 
        return Or.getC();
    }
    //bitwise XOR
    @Override
    public String visit(xor Xor,int orderNo){
        System.out.println(Integer.toHexString(Xor.getOpcode()).toUpperCase() + "  "+ Xor.getName());//output the instruction(Disassembly), used for decompilation
        Xor.setC(arithmeticCodeGenerator(orderNo,orderNo," ^ "));//C Code 
        return Xor.getC();    }

    //bitwise NOT, i.e !(last value of stack) in c
    @Override
    public String visit(not Not,int orderNo){
        System.out.println(Integer.toHexString(Not.getOpcode()).toUpperCase() + "  "+ Not.getName());//output the instruction(Disassembly), used for decompilation
        //Or.setC(arithmeticCodeGenerator(orderNo,orderNo," | "));//C Code 
        //return Not.getC();
        return Not.getName();

    }
    @Override
    public String visit(bytee Bytee,int orderNo){
        System.out.println(Integer.toHexString(Bytee.getOpcode()).toUpperCase() + "  "+ Bytee.getName());//output the instruction(Disassembly), used for decompilation
        return Bytee.getName();
    }
    //shift left
    @Override
    public String visit(shl Shl,int orderNo){
        System.out.println(Integer.toHexString(Shl.getOpcode()).toUpperCase() + "  "+ Shl.getName());//output the instruction(Disassembly), used for decompilation
        Shl.setC(arithmeticCodeGenerator(orderNo,orderNo," << "));//C Code 
        return Shl.getC();
    }
    //logical shift right
    @Override
    public String visit(shr Shr,int orderNo){
        System.out.println(Integer.toHexString(Shr.getOpcode()).toUpperCase() + "  "+ Shr.getName());//output the instruction(Disassembly), used for decompilation
        Shr.setC(arithmeticCodeGenerator(orderNo,orderNo," >> "));//C Code 
        return Shr.getC();
    }
    //arithmetic shift right, C and C++ have only arithmetic shifting
    @Override
    public String visit(sar Sar,int orderNo){
        System.out.println(Integer.toHexString(Sar.getOpcode()).toUpperCase() + "  "+ Sar.getName());//output the instruction(Disassembly), used for decompilation
        Sar.setC(arithmeticCodeGenerator(orderNo,orderNo," >> "));//C Code 
        return Sar.getC();
    }
    @Override
    public String visit(address Address,int orderNo){
        System.out.println(Integer.toHexString(Address.getOpcode()).toUpperCase() + "  "+ Address.getName());//output the instruction(Disassembly), used for decompilation
        return Address.getName();
    }
    @Override
    public String visit(balance Balance,int orderNo){
        System.out.println(Integer.toHexString(Balance.getOpcode()).toUpperCase() + "  "+ Balance.getName());//output the instruction(Disassembly), used for decompilation
        return Balance.getName();
    }
    @Override
    public String visit(origin Origin,int orderNo){
        System.out.println(Integer.toHexString(Origin.getOpcode()).toUpperCase() + "  "+ Origin.getName());//output the instruction(Disassembly), used for decompilation
        return Origin.getName();
    }
    @Override
    public String visit(caller Caller,int orderNo){
        System.out.println(Integer.toHexString(Caller.getOpcode()).toUpperCase() + "  "+ Caller.getName());//output the instruction(Disassembly), used for decompilation
        return Caller.getName();
    }
    @Override
    public String visit(callvalue Callvalue,int orderNo){
        System.out.println(Integer.toHexString(Callvalue.getOpcode()).toUpperCase() + "  "+ Callvalue.getName());//output the instruction(Disassembly), used for decompilation
        return Callvalue.getName();
    }
    @Override
    public String visit(calldataload Calldataload,int orderNo){
        System.out.println(Integer.toHexString(Calldataload.getOpcode()).toUpperCase() + "  "+ Calldataload.getName());//output the instruction(Disassembly), used for decompilation
        return Calldataload.getName();
    }
    @Override
    public String visit(calldatasize Calldatasize,int orderNo){
        System.out.println(Integer.toHexString(Calldatasize.getOpcode()).toUpperCase() + "  "+ Calldatasize.getName());//output the instruction(Disassembly), used for decompilation
        return Calldatasize.getName();
    }
    @Override
    public String visit(calldatacopy Calldatacopy,int orderNo){
        System.out.println(Integer.toHexString(Calldatacopy.getOpcode()).toUpperCase() + "  "+ Calldatacopy.getName());//output the instruction(Disassembly), used for decompilation
        return Calldatacopy.getName();
    }
    @Override
    public  String visit(codesize Codesize,int orderNo){
        System.out.println(Integer.toHexString(Codesize.getOpcode()).toUpperCase() + "  "+ Codesize.getName());//output the instruction(Disassembly), used for decompilation
        return Codesize.getName();
    }
    @Override
    public String visit(codecopy Codecopy,int orderNo){
        System.out.println(Integer.toHexString(Codecopy.getOpcode()).toUpperCase() + "  "+ Codecopy.getName());//output the instruction(Disassembly), used for decompilation
        return Codecopy.getName();
    }
    @Override
    public String visit(gasprice Gasprice,int orderNo){
        System.out.println(Integer.toHexString(Gasprice.getOpcode()).toUpperCase() + "  "+ Gasprice.getName());//output the instruction(Disassembly), used for decompilation
        return Gasprice.getName();
    }
    @Override
    public String visit(extcodesize Extcodesize,int orderNo){
        System.out.println(Integer.toHexString(Extcodesize.getOpcode()).toUpperCase() + "  "+ Extcodesize.getName());//output the instruction(Disassembly), used for decompilation
        return Extcodesize.getName();
    }
    @Override
    public String visit(extcodecopy Extcodecopy,int orderNo){
        System.out.println(Integer.toHexString(Extcodecopy.getOpcode()).toUpperCase() + "  "+ Extcodecopy.getName());//output the instruction(Disassembly), used for decompilation
        return Extcodecopy.getName();
    }
    @Override
    public String visit(returndatasize Returndatasize,int orderNo){
        System.out.println(Integer.toHexString(Returndatasize.getOpcode()).toUpperCase() + "  "+ Returndatasize.getName());//output the instruction(Disassembly), used for decompilation
        return Returndatasize.getName();
    }
    @Override
    public String visit(returndatacopy Returndatacopy,int orderNo){
        System.out.println(Integer.toHexString(Returndatacopy.getOpcode()).toUpperCase() + "  "+ Returndatacopy.getName());//output the instruction(Disassembly), used for decompilation
        return Returndatacopy.getName();
    }
    @Override
    public String visit(extcodehash Extcodehash,int orderNo){
        System.out.println(Integer.toHexString(Extcodehash.getOpcode()).toUpperCase() + "  "+ Extcodehash.getName());//output the instruction(Disassembly), used for decompilation
        return Extcodehash.getName();
    }
    @Override
    public String visit(blockhash Blockhash,int orderNo){
        System.out.println(Integer.toHexString(Blockhash.getOpcode()).toUpperCase() + "  "+ Blockhash.getName());//output the instruction(Disassembly), used for decompilation
        return Blockhash.getName();
    }
    @Override
    public String visit(coinbase Coinbase,int orderNo){
        System.out.println(Integer.toHexString(Coinbase.getOpcode()).toUpperCase() + "  "+ Coinbase.getName());//output the instruction(Disassembly), used for decompilation
        return Coinbase.getName();
    }
    @Override
    public String visit(timestamp Timestamp,int orderNo){
        System.out.println(Integer.toHexString(Timestamp.getOpcode()).toUpperCase() + "  "+ Timestamp.getName());//output the instruction(Disassembly), used for decompilation
        return Timestamp.getName();
    }
    @Override
    public String visit(number Number,int orderNo){
        System.out.println(Integer.toHexString(Number.getOpcode()).toUpperCase() + "  "+ Number.getName());//output the instruction(Disassembly), used for decompilation
        return Number.getName();
    }
    @Override
    public String visit(difficulty Difficulty,int orderNo){
        System.out.println(Integer.toHexString(Difficulty.getOpcode()).toUpperCase() + "  "+ Difficulty.getName());//output the instruction(Disassembly), used for decompilation
        return Difficulty.getName();
    }
    @Override
    public String visit(gaslimit Gaslimit,int orderNo){
        System.out.println(Integer.toHexString(Gaslimit.getOpcode()).toUpperCase() + "  "+ Gaslimit.getName());//output the instruction(Disassembly), used for decompilation
        return Gaslimit.getName();
    }
    @Override
    public String visit(chainid Chainid,int orderNo){
        System.out.println(Integer.toHexString(Chainid.getOpcode()).toUpperCase() + "  "+ Chainid.getName());//output the instruction(Disassembly), used for decompilation
        return Chainid.getName();
    }
    @Override
    public String visit(selfbalance Selfbalance,int orderNo){
        System.out.println(Integer.toHexString(Selfbalance.getOpcode()).toUpperCase() + "  "+ Selfbalance.getName());//output the instruction(Disassembly), used for decompilation
        return Selfbalance.getName();
    }
    @Override
    public String visit(basefee Basefee,int orderNo){
        System.out.println(Integer.toHexString(Basefee.getOpcode()).toUpperCase() + "  "+ Basefee.getName());//output the instruction(Disassembly), used for decompilation
        return Basefee.getName();
    }
    //pop value off the top of the stack
    @Override
    public String visit(pop Pop,int orderNo){
        System.out.println(Integer.toHexString(Pop.getOpcode()).toUpperCase() + "  "+ Pop.getName());//output the instruction(Disassembly), used for decompilation
        label label_ =new label(orderNo);//ORDER SHOULD BE A PARAMETER
        stack stackval = new stack("",0,"");
        
        String asserts= getCheck(stackval,"not empty");

        String stackvals ="\t"+stackval.getStackPopTop();
        String PopValues= label_.getLabelName()+stackvals+asserts+label_.getLabelEnd();
        Pop.setC(PopValues);
        return Pop.getC();
    }
    @Override
    public String visit(mload Mload,int orderNo){
        System.out.println(Integer.toHexString(Mload.getOpcode()).toUpperCase() + "  "+ Mload.getName());//output the instruction(Disassembly), used for decompilation
        return Mload.getName();
    }
    @Override
    public String visit(mstore Mstore,int orderNo){
        System.out.println(Integer.toHexString(Mstore.getOpcode()).toUpperCase() + "  "+ Mstore.getName());//output the instruction(Disassembly), used for decompilation
        return Mstore.getName();
    }
    @Override
    public String visit(mstore8 Mstore8,int orderNo){
        System.out.println(Integer.toHexString(Mstore8.getOpcode()).toUpperCase() + "  "+ Mstore8.getName());//output the instruction(Disassembly), used for decompilation
        return Mstore8.getName();
    }
    @Override
    public String visit(sload Sload,int orderNo){
        System.out.println(Integer.toHexString(Sload.getOpcode()).toUpperCase() + "  "+ Sload.getName());//output the instruction(Disassembly), used for decompilation
        return Sload.getName();
    }
    @Override
    public String visit(sstore Sstore,int orderNo){
        System.out.println(Integer.toHexString(Sstore.getOpcode()).toUpperCase() + "  "+ Sstore.getName());//output the instruction(Disassembly), used for decompilation
        return Sstore.getName();
    }
    @Override
    public String visit(jump Jump,int orderNo){
        System.out.println(Integer.toHexString(Jump.getOpcode()).toUpperCase() + "  "+ Jump.getName());//output the instruction(Disassembly), used for decompilation
        return Jump.getName();
    }
    @Override
    public String visit(jumpi Jumpi,int orderNo){
        System.out.println(Integer.toHexString(Jumpi.getOpcode()).toUpperCase() + "  "+ Jumpi.getName());//output the instruction(Disassembly), used for decompilation
        return Jumpi.getName();
    }
    @Override
    public String visit(pc Pc,int orderNo){
        System.out.println(Integer.toHexString(Pc.getOpcode()).toUpperCase() + "  "+ Pc.getName());//output the instruction(Disassembly), used for decompilation
        return Pc.getName();
    }
    @Override
    public String visit(msize Msize,int orderNo){
        System.out.println(Integer.toHexString(Msize.getOpcode()).toUpperCase() + "  "+ Msize.getName());//output the instruction(Disassembly), used for decompilation
        return Msize.getName();
    }
    @Override
    public String visit(gas Gas,int orderNo){
        System.out.println(Integer.toHexString(Gas.getOpcode()).toUpperCase() + "  "+ Gas.getName());//output the instruction(Disassembly), used for decompilation
        return Gas.getName();
    }
    @Override
    public String visit(jumpdest Jumpdest,int orderNo){
        System.out.println(Integer.toHexString(Jumpdest.getOpcode()).toUpperCase() + "  "+ Jumpdest.getName());//output the instruction(Disassembly), used for decompilation
        return Jumpdest.getName();
    }
    
    @Override
    public String visit(create Create,int orderNo){
        System.out.println(Integer.toHexString(Create.getOpcode()).toUpperCase() + "  "+ Create.getName());//output the instruction(Disassembly), used for decompilation
        return Create.getName();
    }
    @Override
    public String visit(call Call,int orderNo){
        System.out.println(Integer.toHexString(Call.getOpcode()).toUpperCase() + "  "+ Call.getName());//output the instruction(Disassembly), used for decompilation
        return Call.getName();
    }
    @Override
    public String visit(callcode Callcode,int orderNo){
        System.out.println(Integer.toHexString(Callcode.getOpcode()).toUpperCase() + "  "+ Callcode.getName());//output the instruction(Disassembly), used for decompilation
        return Callcode.getName();
    }
    @Override
    public String visit(return_ Return_,int orderNo){
        System.out.println(Integer.toHexString(Return_.getOpcode()).toUpperCase() + "  "+ Return_.getName());//output the instruction(Disassembly), used for decompilation
        return Return_.getName();
    }
    @Override
    public String visit(delegatecall Delegatecall,int orderNo){
        System.out.println(Integer.toHexString(Delegatecall.getOpcode()).toUpperCase() + "  "+ Delegatecall.getName());//output the instruction(Disassembly), used for decompilation
        return Delegatecall.getName();
    }
    @Override
    public String visit(create2 Create2,int orderNo){
        System.out.println(Integer.toHexString(Create2.getOpcode()).toUpperCase() + "  "+ Create2.getName());//output the instruction(Disassembly), used for decompilation
        return Create2.getName();
    }
    @Override
    public String visit(staticcall Staticcall,int orderNo){
        System.out.println(Integer.toHexString(Staticcall.getOpcode()).toUpperCase() + "  "+ Staticcall.getName());//output the instruction(Disassembly), used for decompilation
        return Staticcall.getName();
    }
    @Override
    public String visit(revert Revert,int orderNo){
        System.out.println(Integer.toHexString(Revert.getOpcode()).toUpperCase() + "  "+ Revert.getName());//output the instruction(Disassembly), used for decompilation
        return Revert.getName();
    }
    @Override
    public String visit(invalid Invalid,int orderNo){
        System.out.println(Integer.toHexString(Invalid.getOpcode()).toUpperCase() + "  "+ Invalid.getName());//output the instruction(Disassembly), used for decompilation
        return Invalid.getName();
    }
    @Override
    public String visit(selfdestruct Selfdestruct,int orderNo){
        System.out.println(Integer.toHexString(Selfdestruct.getOpcode()).toUpperCase() + "  "+ Selfdestruct.getName());//output the instruction(Disassembly), used for decompilation
        return Selfdestruct.getName();
    }

    @Override
    public String visit(sh3 Sh3,int orderNo) 
    {
        System.out.println(Integer.toHexString(Sh3.getOpcode()).toUpperCase() + "  "+ Sh3.getName());//output the instruction(Disassembly), used for decompilation
        return Sh3.getName();
    }
    //halts execution,exits program
    @Override
    public String visit(stop Stop,int orderNo) 
    {
        System.out.println("0"+Integer.toHexString(Stop.getOpcode()).toUpperCase() + "  "+ Stop.getName());//output the instruction(Disassembly), used for decompilation
        returnVal exit = new returnVal(0);
        return exit.getExitStatement();
    }
}

