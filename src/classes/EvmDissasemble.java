package src.classes;
import java.io.*;
import java.util.concurrent.TimeUnit;
import src.interfaces.*;
import src.opcodes.*;

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