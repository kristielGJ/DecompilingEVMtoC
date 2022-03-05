package src.tests;
import java.io.*;
import java.util.concurrent.TimeUnit;

//https://www.geeksforgeeks.org/visitor-design-pattern/
//https://stackoverflow.com/questions/2604169/visitor-patterns-purpose-with-examples
interface GetInstructionsFromOpcode
{
    public String accept(Dissasemble visitor);
}
  
class add implements GetInstructionsFromOpcode 
{
    private String opcode;
    private String name;
   
    public add(String opcode)
    {
        this.opcode=opcode;
        this.name = "ADD";
    }
   
    public String getOpcode() 
    {
        return opcode;
    }
   
    public String getName()
    {
        return this.name;
    }
   
    @Override
    public String accept(Dissasemble visitor) 
    {
        return visitor.visit(this);
    }
   
}

interface Dissasemble 
{
    String visit(add Add);
}

class visitOpCode implements Dissasemble
{
   
    @Override
    public String visit(add Add) 
    {
        System.out.println(Add.getOpcode() + "  "+ Add.getName());//output the instruction(Disassembly), used for decompilation
        return Add.getName();
    }
}
class EvmDissasemble 
{
    public static void main(String[] args) throws IOException, InterruptedException 
    {
        // Creating BufferedReader Object
        BufferedReader bfn = new BufferedReader(new InputStreamReader(System.in));
                        
        // Asking for input from user
        System.out.println("Enter your Ethereum contract bytecode (e.g 608001...) : ");
                      
        // String reading internally 
        String evmContract = bfn.readLine();

        //outputs for readibility
        System.out.println("Processing...");
        TimeUnit.SECONDS.sleep(1);
        //outputs the input from the user
        System.out.println("EVM BYTECODE: "+ evmContract+"\n");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Dissasebly: ");

        //split into an array of two character op codes (for PUSH make sure to send over the next element also)
        String[] evmByteCode=evmContract.split("(?<=\\G.{2})");
        GetInstructionsFromOpcode[] instructions = new GetInstructionsFromOpcode[]{new add("01")};

        for (String opcode : evmByteCode) {
            //System.out.println(opcode);
            if (opcode.contains("01")) {
               // GetInstructionsFromOpcode[] instructions = new GetInstructionsFromOpcode[]{new add("01")};
               Dissasemble visitor = new visitOpCode();
               instructions[0].accept(visitor);
            }
        }
    
    }  
}

