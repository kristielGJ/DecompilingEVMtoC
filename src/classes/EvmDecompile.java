//Author Gera Jahja, last update 24/04
package src.classes;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import src.interfaces.*;
import src.opcodes.*;
import src.cCodes.*;
// Testing Examples:

// 605f7000606061008090A1A2A3A4A0 for push, dup, swap and log

// Should print opcodes:
//000102030405060708090A0B101112131415161718191A1B1C1D20303132333435363738393A3B3C3D3E3F404142434445464748505152535455565758595A5B60006100006200000063000000006400000000006500000000000066000000000000006700000000000000006800000000000000000069000000000000000000006A00000000000000000000006B0000000000000000000000006C000000000000000000000000006D00000000000000000000000000006E0000000000000000000000000000006F000000000000000000000000000000007000000000000000000000000000000000007100000000000000000000000000000000000072000000000000000000000000000000000000007300000000000000000000000000000000000000007400000000000000000000000000000000000000000075000000000000000000000000000000000000000000007600000000000000000000000000000000000000000000007700000000000000000000000000000000000000000000000078000000000000000000000000000000000000000000000000007900000000000000000000000000000000000000000000000000007A0000000000000000000000000000000000000000000000000000007B000000000000000000000000000000000000000000000000000000007C00000000000000000000000000000000000000000000000000000000007D0000000000000000000000000000000000000000000000000000000000007E000000000000000000000000000000000000000000000000000000000000007F0000000000000000000000000000000000000000000000000000000000000000808182838485868788898A8B8C8D8E8F909192939495969798999A9B9C9D9E9FA0A1A2A3A4F0F1F2F3F4F5FAFDFEFF

// Should all be invalid:
// 0C0D0E0F1E1F2122232425262728292A2B2C2D2E2F494A4B4C4D4E4F5C5D5E5FA5A6A7A8A9AAABACADAEAFB0B1B2B3B4B5B6B7B8B9BABBBCBDBEBFC0C1C2C3C4C5C6C7C8C9CACBCCCDCECFD0D1D2D3D4D5D6D7D8D9DADBDCDDDEDFE0E1E2E3E4E5E6E7E8E9EAEBECEDEEEFF6F7F8F9FBFC


class EvmDecompile {
    // possible log hexadecimals:
    public static String[] LogVariations = { "AO", "A1", "A2", "A3", "A4" };
    public static List<String> LogVariationsList = Arrays.asList(LogVariations);

    /*check is a string is a number , from :https://www.baeldung.com/java-check-string-number */
    public static boolean isNumeric(String strNum) {//check is a string is a number https://www.baeldung.com/java-check-string-number
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    /* Prints out readable opcodes from EVM bytecode */
    private static String callVisitorFunctions(String opcode, List<String> invalidHexList,GetInstructionsFromOpcode[] instructions_no,int number,Dissasemble visitor) {
        boolean checkNumber = isNumeric(opcode);
        boolean checkLetter = opcode.contains("A")||opcode.contains("B")||opcode.contains("C")||opcode.contains("D")||opcode.contains("E")||opcode.contains("F");
        
        // Display opcode, from EVMBytecode
        try {
            if (invalidHexList.contains(opcode)) {
                System.out.println("---- INVALID BYTE CODE! ---- ");
            } 
            else {
                if (checkNumber == true) {
                    int opcodeNumber = Integer.parseInt(opcode);
                    if (opcodeNumber < 21) {
                        return instructions_no[opcodeNumber].accept(visitor);

                    } else if ((opcodeNumber > 20) && (opcodeNumber < 60)) {
                        if (opcodeNumber > 49) {
                            return instructions_no[opcodeNumber - 10].accept(visitor);
                        } else {
                            return instructions_no[opcodeNumber - 9].accept(visitor);
                        }
                    }
                }
                else if (checkLetter==true){
                    // evm with letters
                    if (opcode.contains("FF")) { new selfdestruct().accept(visitor);} // SELFDESTRUCT passed test
                    else if (opcode.contains("0A")) { return new exp().accept(visitor);} // EXP passed test
                    else if (opcode.contains("0B")) { return new signextend().accept(visitor);} // SIGNEXTEND passed test
                    else if (opcode.contains("1A")) { return new bytee().accept(visitor);} // BYTE passed test
                    else if (opcode.contains("1B")) { return new shl().accept(visitor);} // SHL passed test
                    else if (opcode.contains("1C")) { return new shr().accept(visitor);} // SHR passed test
                    else if (opcode.contains("3A")) { return new gasprice().accept(visitor);} // GASPRICE passed test
                    else if (opcode.contains("3B")) { return new extcodesize().accept(visitor);} // EXTCODESIZE passed test
                    else if (opcode.contains("3C")) { return new extcodecopy().accept(visitor);} // EXTCODECOPY passed test
                    else if (opcode.contains("3E")) { return new returndatacopy().accept(visitor);} // RETURNDATACOPY passed test
                    else if (opcode.contains("5A")) { return new gas().accept(visitor);} // GAS passed test
                    else if (opcode.contains("5B")) { return new jumpdest().accept(visitor);} // JUMPDEST passed test
                    else if (opcode.contains("F0")) { return new create().accept(visitor);} // CREATE passed test
                    else if (opcode.contains("F1")) { return new call().accept(visitor);} // CALL passed test                        
                    else if (opcode.contains("F2")) { return new callcode().accept(visitor);} // CALLCODE passed test
                    else if (opcode.contains("F3")) { return new return_().accept(visitor);} // RETURN passed test
                    else if (opcode.contains("F4")) { return new delegatecall().accept(visitor);} // DELEGATECALL passed test
                    else if (opcode.contains("F5")) { return new create2().accept(visitor);} // CREATE2 passed test
                    else if (opcode.contains("FA")) { return new staticcall().accept(visitor);} // STATICCALL passed test
                    else if (opcode.contains("FD")) { return new revert().accept(visitor);} // REVERT passed test
                    else if (opcode.contains("FE")) { return new invalid().accept(visitor);} // INVALID passed test
                    else if ((opcode.startsWith("A") && LogVariationsList.contains(opcode))|| (opcode.startsWith("A") && opcode.endsWith("0"))) {
                        new log(number).accept(visitor);
                    }
                }
            } 
        }catch (Exception e) {
            if (opcode.contains("1D")) {return new sar().accept(visitor);} // SAR passed test
            else if (opcode.contains("3F")) { return new extcodehash().accept(visitor);} // EXTCODEHASH passed test
            else if (opcode.contains("3D")) { return new returndatasize().accept(visitor);} // RETURNDATASIZE passed test
            else{
                System.out.println("---- Valid Opcode has not been Implemented Yet---- ");
                // if a valid opcode isnt handeled in the try section it will show this message
            }
        }
        return "invalid";
    }

    /*
    Looks at second number and calulates number for log, dup,swap and push
    , i.e for 63 (push4), it returns 3+1 = 4 (to display the number for push "4")
    also gets Lable00_ number for decompiled C code
    */
    private static int getNumber(String opcode) { 
        
        String[] arr = opcode.split("");
        if (isNumeric(arr[1]) == true) {// integer conversion 0-9
            if (opcode.startsWith("7")) {
                return Integer.parseInt(arr[1]) + 17;// returns push 17-26

            } else if (opcode.startsWith("A")) {
                return Integer.parseInt(arr[1]);// returns log 1-4
            } else {
                return Integer.parseInt(arr[1]) + 1;// returns dup/push/swap 1-10
            }
        } else {// hexadecimal conversion for a-f
            if (opcode.startsWith("7")) {
                return Integer.parseInt(arr[1], 16) + 17;// returns push 26-32
            } else {
                return Integer.parseInt(arr[1], 16) + 1;// returns dup/push/swap 11-16
            }
        }
    }
    /* saves from a list to a c file
    code based from https://www.w3schools.com/java/java_files_create.asp
    */
    public static void saveFile(List<String> DecompiledC)throws IOException{
        String saveFile="";
        boolean exit = false;
        BufferedReader bfn = new BufferedReader(new InputStreamReader(System.in));
            while (exit==false){
                System.out.println("Save to .c file? (y/n) ");
                saveFile = (bfn.readLine()).toUpperCase();

                if ((saveFile.contains("Y"))&&(saveFile.length()==1)){
                    System.out.println("Enter file name: ");
                    String fileName = bfn.readLine();
                    try {  
                        File cCodeFile = new File(fileName+".c");  
                        if (cCodeFile.createNewFile()) {  
                          System.out.println("File created: " + cCodeFile.getName());  
                        } else {  
                          System.out.println("File already exists");  
                        }  
                        FileWriter myWriter = new FileWriter(fileName+".c");
                        for (String label : DecompiledC) {
                            myWriter.write(label);
                        }
                        myWriter.close();
                        System.out.println("Successfully updated file");
                        System.out.println("File path: " + cCodeFile.getAbsolutePath());
                    
                      } catch (IOException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();  
                      }  
                    exit = true;
                }else if ((saveFile.contains("N"))&&(saveFile.length()==1)){

                    exit = true;
                }
                else{
                    System.out.println("Please Type y/n");
                }
            }
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        // Creating BufferedReader Object
        BufferedReader bfn = new BufferedReader(new InputStreamReader(System.in));
        // all invalid hexadecimals as a string (for convinience)
        String invalidHex = "0C0D0E0F1E1F2122232425262728292A2B2C2D2E2F494A4B4C4D4E4F5C5D5E5FA5A6A7A8A9AAABACADAEAFB0B1B2B3B4B5B6B7B8B9BABBBCBDBEBFC0C1C2C3C4C5C6C7C8C9CACBCCCDCECFD0D1D2D3D4D5D6D7D8D9DADBDCDDDEDFE0E1E2E3E4E5E6E7E8E9EAEBECEDEEEFF6F7F8F9FBFC";
        // then split into an array of charecters (2 charecters per element)
        String[] invalidHexL = invalidHex.split("(?<=\\G.{2})");
        // then converted into a list
        List<String> invalidHexList = Arrays.asList(invalidHexL);
        //push hex values
        // numerical evm for easy calling of visitor functions 
        GetInstructionsFromOpcode[] instructions_no = new GetInstructionsFromOpcode[] {
                new stop(), new add(), new mul(), new sub(), new div(), new sdiv(), new mod(),
                new smod(), new addmod(), new mulmod(), new lt(), new gt(), new slt(), new sgt(),
                new eq(), new iszero(), new and(), new or(), new xor(), new not(), new sh3(),
                new address(), new balance(), new origin(), new caller(), new callvalue(),
                new calldataload(), new calldatasize(), new calldatacopy(), new codesize(),
                new codecopy(), new blockhash(), new coinbase(), new timestamp(), new number(),
                new difficulty(), new gaslimit(), new chainid(), new selfbalance(), new basefee(),
                new pop(), new mload(), new mstore(), new mstore8(), new sload(), new sstore(),
                new jump(), new jumpi(), new pc(), new msize() };

        while (true) {
            try{
                // Asking for input from user
                System.out.println("Enter your Ethereum contract bytecode (e.g 68001...) : ");
                
                String evmContract = bfn.readLine();//1023 chars only?
                evmContract = evmContract.toUpperCase();

                // outputs for readibility
                System.out.println("Processing...");
                TimeUnit.SECONDS.sleep(1);

                // outputs the input from the user
                System.out.println("EVM BYTECODE: " + evmContract + "\n");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Dissasebly: \n");
                
                // split into an array of two character op codes (for PUSH make sure to send
                // over the next element also)
                String[] evmByteCode = evmContract.split("(?<=\\G.{2})");
                List<String> evmByteCodeList = Arrays.asList(evmByteCode);
                ArrayList<String> evmByteCodeArrayList = new ArrayList<String>(evmByteCodeList);

                //list that is used for correctly split bytecode  (i.e valid push comands)
                List<String> evmByteCodeCorrect = new ArrayList<>();
                //list for Code that is returned by the visitor functions 
                List<String> DecompiledC = new ArrayList<>();

                // ensure the elements of the array are split to the right size and stored in evmByteCodeCorrect
                //( push requires more than 2 chars)
                for (int j = 0; j < evmByteCodeArrayList.size(); j++) {

                    String opcode = evmByteCodeArrayList.get(j);
                    // push starts with 6 and 
                    //evmByteCodeArrayList.remove(j);// remove memory adress to prevent it being read as an additional opcode (as list was split into pairs (see variable "String[] evmByteCode"))
                            
                    try{
                        if (opcode.startsWith("6") || opcode.startsWith("7")) {
                            int memsize=getNumber(opcode);
                            String memoryadd = "";
                            //evmByteCodeArrayList.remove(j + 1);// remove memory adress to prevent it being read as an additional opcode (as list was split into pairs (see variable "String[] evmByteCode"))
                            for (int i = 1; i < memsize+1; i++) {
                                    memoryadd = memoryadd+evmByteCodeArrayList.get(j + 1);
                                    evmByteCodeArrayList.remove(j + 1);// remove memory adress to prevent it being read as an additional opcode (as list was split into pairs (see variable "String[] evmByteCode"))
                            }
                            // (push commands are not two chars, e.g 6008, 60 being PUSH1 and 0x08 being thememory adress)
                            evmByteCodeCorrect.add(opcode + memoryadd);
                        } else {
                            evmByteCodeCorrect.add(opcode);
                        }
                    }catch (Exception e){
                        System.out.println("----Not enough code for Push opcode , Invalid Contract---- "); // if user types 60 this is invalid, must be 6000, or 610000, etc
                    }
                }
                
                //create c main function and initialise gas model, stack , etc...
                Decompile(DecompiledC,"start");
                //displays dissasembly and also computes future c code , ready for display
                Dissasemble visitor = new visitOpCode();
                
                // Whole contract dissasembled:
                for (String opcode : evmByteCodeCorrect) {
                    int number = getNumber(opcode);
                    String[] arr = opcode.split("");
                    String opcodeStr = arr[0] + arr[1];

                    if (opcode.startsWith("6")) { DecompiledC.add(new push(opcode.substring(2), opcodeStr, number).accept(visitor));}// push starts with 6 and 7
                    else if (opcode.startsWith("7")) { DecompiledC.add(new push(opcode.substring(2), opcodeStr, number).accept(visitor));}// push starts with 7
                    else if (opcode.startsWith("8")) {DecompiledC.add(new dup(number).accept(visitor));}// dup starts 8
                    else if (opcode.startsWith("9")) {DecompiledC.add(new swap(number).accept(visitor));}// swap starts with 9
                     else{
                        DecompiledC.add(callVisitorFunctions(opcode, invalidHexList, instructions_no,number,visitor)); // displays opcodes 
                    }
                }
                //finalise c code
                Decompile(DecompiledC,"end");
                //display C 
                Decompile(DecompiledC,"display");
                //choice to save generated C code to a file to run through CPROVER tools
                saveFile(DecompiledC);
                
                // Function detection: Basic Blocks from contract: (i.e split on occurunces of jump, jumpi etc), prep for decompilation

        }catch (Exception e){
            System.out.println("----Invalid Contract, Enter valid EVM byte code please---- "); //e.g if there is an irregular number of opcodes
        }
        }

    }

    private static void Decompile(List<String> decompiledC, String s_or_e) throws InterruptedException {
        //initialise C codes  preparing for decompilation
        include includeAssert = new include();
        function mainFunction = new function();
        variable defineVar = new variable("int", "var");
        define gas_stack_definitions = new define(1024, 1000);//get gas limit as user input?
        returnVal return_0 = new returnVal(0);
        
        // Model ethereum stack
        variable stack = new variable(0,"stack[STACKHEIGHT]", ""); 
        variable topOfStack= new variable(0,"top","");

        // Model gas
        variable gasUsed= new variable(0,"gasUsed","");
        variable gasLimit= new variable(0,"gasLimit","GASLIMIT");

        if (s_or_e =="start"){
            TimeUnit.SECONDS.sleep(1);
            decompiledC.add(includeAssert.getIncludeAssert()+"\n"+defineVar.getVariableType()+"\n"+gas_stack_definitions.getDefineGasLimit()+gas_stack_definitions.getDefineStackHeight()+"\n"+stack.getVariableDef()+topOfStack.getVariableDef()+"\n"+gasUsed.getVariableDef()+gasLimit.getVariableDefValue()+"\n"+mainFunction.getMain()+"\n /*** Start of decompiled code ***/ \n");
        }
        else if (s_or_e =="end"){
            TimeUnit.SECONDS.sleep(1);

            decompiledC.add(" /*** End of decompiled code ***/\n"+return_0.getReturnStatement()+mainFunction.getEnd()+"\n");

        }else if (s_or_e=="display"){
            //Print to Generated C code:

            System.out.println("Decompilation to C code: \n");
            TimeUnit.SECONDS.sleep(1);
  
            for (String label : decompiledC) {
                System.out.println(label);
            }
        }
    }

}
