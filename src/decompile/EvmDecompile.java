//Author Gera Jahja, last update 15/04
package src.decompile;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import src.interfaces.*;
import src.opcodes.*;
import src.cCodes.*;

//To run the program, please run the main program found in this class.

class EvmDecompile {

    private static void Decompile(List<String> decompiledC, String s_or_e) throws InterruptedException, IOException {
        //initialise C codes  preparing for decompilation
        include includeAssert = new include();
        function mainFunction = new function();
        boolean runProgram=true;
        BufferedReader bfn = new BufferedReader(new InputStreamReader(System.in));
        variable defineVar = new variable("int64_t", "var");//there are no 256 bit numbers in c 
        variable defineUVar = new variable("uint64_t", "uvar");//unsigned 64bit integer ... for compilation
       
       returnVal return_0 = new returnVal(0);
        
        // Model ethereum stack
        variable stack = new variable(0,"stack[STACKHEIGHT]", "",""); 
        variable topOfStack= new variable(0,"top","","");

        // Model gas
        variable gasUsed= new variable(0,"gasUsed","","");
        variable gasLimit= new variable(0,"gasLimit","GASLIMIT","");

        if (s_or_e =="start"){
            while (runProgram) {
                // Asking for input from user
                System.out.println("\n __________________________");
                System.out.println("|     C Code Decompiler    |");
                System.out.println("| Options:                 |");
                System.out.println("|        1. Executable C   |");
                System.out.println("|        2. Analysable C   |");
                System.out.println("|__________________________|\n");

                System.out.println("Choose an option from the menu above: ");
                String evmContract = bfn.readLine();//1023 chars only?
                
                if (evmContract.contains("1")&&evmContract.length()==1){
                    defineVar = new variable("int64_t", "var");//there are no 256 bit numbers in c 
                    defineUVar = new variable("uint64_t", "uvar");//unsigned 64bit integer ... for compilation
                    runProgram=false;
                }else if (evmContract.contains("2")&&evmContract.length()==1){
                    runProgram=false;
                    defineVar = new variable("int128_t", "var");//analysable in cprover
                    defineUVar = new variable("int128_t", "uvar");//cannot be run without c prover        
                }else{
                    System.out.println("Please enter 1 or 2");
                }
            }
            
            define gas_stack_definitions = new define(1024, 10000,10000);
            //model memory, storage and accounts
            structs mod =  new structs();

            String structs= mod.getPair()+mod.getNumpair()+mod.getMemory()+mod.getStorage()+mod.getAccounts()+"\n\n";

            TimeUnit.SECONDS.sleep(1);
            System.out.println("\n __________________");
            System.out.println("|     Dissasebly:  |");
            System.out.println("|__________________|\n");
            decompiledC.add(includeAssert.getIncludeAssert()+"\n"+defineVar.getVariableType()+"\n"+defineUVar.getVariableType()+"\n"+gas_stack_definitions.getDefineGasLimit()+gas_stack_definitions.getDefineStackHeight()+gas_stack_definitions.getdefineMemLimit()+"\n"+structs+stack.getVariableDef()+topOfStack.getVariableDef()+"\nvar memPoint;\nvar storePoint;\nvar accountNo;\nvar pcCounter;\n"+gasUsed.getVariableDef()+gasLimit.getVariableDefValue()+"\n"+mainFunction.getMain()+"\n /*** Start of decompiled code ***/ \n");
        }
        else if (s_or_e =="end"){
            TimeUnit.SECONDS.sleep(1);

            decompiledC.add(" /*** End of decompiled code ***/\n"+return_0.getReturnStatement()+mainFunction.getEnd()+"\n");

        }else if (s_or_e=="display"){
            //Print to Generated C code:
            System.out.println("\n _______________________________");
            System.out.println("|     Decompilation to C code:  |");
            System.out.println("|_______________________________|\n");
            TimeUnit.SECONDS.sleep(1);
  
            for (String label : decompiledC) {
                System.out.println(label);
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
                System.out.println("\n _____________________________________________");
                System.out.println("|     Save to file                            |");
                System.out.println("| Options:                                    |");
                System.out.println("|        1. Save decompilation to a .c file   |");
                System.out.println("|        2. Decompile a new contract          |");
                System.out.println("|_____________________________________________|\n");
                System.out.println("Please choose an option from above: ");
             
                saveFile = (bfn.readLine()).toUpperCase();

                if ((saveFile.contains("1"))&&(saveFile.length()==1)){
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
                }else if ((saveFile.contains("2"))&&(saveFile.length()==1)){

                    exit = true;
                }
                else{
                    System.out.println("Please Type a number from the menu");
                }
            }
    }
    //read txt file
    public static String readFile(String evmContract)throws IOException{
        BufferedReader bfn = new BufferedReader(new InputStreamReader(System.in));
        boolean getfile = true;
        while(getfile){
            try {
                System.out.println("Enter name of .txt file: \n");
                String filename = bfn.readLine();//1023 chars only?
                File myObj = new File(filename+".txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    System.out.println(data);
                    evmContract=data;
                }
                myReader.close();
                getfile=false;
            } catch (FileNotFoundException e) {
                System.out.println("There is a problem with your file");
            }                    
        }
        return evmContract;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        // possible log hexadecimals:
        String[] LogVariations = { "AO", "A1", "A2", "A3", "A4" };
        List<String> LogVariationsList = Arrays.asList(LogVariations);
        boolean runProgram = true;
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

        while (runProgram) {
            // Asking for input from user
            System.out.println("\n ___________________________________________________________________");
            System.out.println("|     EVM BYTE CODE -> C DECOMILER                                  |");
            System.out.println("|                                                                   |");                System.out.println("|        Type 'EXIT' to quit  the program                           |");
            System.out.println("|        Type 'FILE' to read a txt file containing your byte code   |");
            System.out.println("|        or enter your Ethereum contract bytecode (e.g 60806040...) |");
            System.out.println("|___________________________________________________________________|\n");
                
            String evmContract = bfn.readLine();//1023 chars only?
            evmContract = evmContract.toUpperCase();
            
            if (evmContract.contains("EXIT")&&evmContract.length()==4){
                runProgram=false;
            }else{
                try{
                    if (evmContract.contains("FILE")&&evmContract.length()==4){
                        evmContract= readFile(evmContract);
                    }
                    // outputs for readibility
                    System.out.println("Processing...");
                    TimeUnit.SECONDS.sleep(1);

                    // outputs the input from the user
                    System.out.println("EVM BYTECODE: " + evmContract + "\n");
                    TimeUnit.SECONDS.sleep(1);
                    
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
                                int memsize=EvmDisassemble.getNumber(opcode);
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
                    
                    HashMap<String,Integer> cCodeLabelOrder = new HashMap<String, Integer>();
                    int order =0;
                    //create c main function and initialise gas model, stack , etc...
                    Decompile(DecompiledC,"start");

                    //displays dissasembly and also computes future c code , ready for display
                    Dissasemble visitor = new visitOpCode();
                    
                    // Whole contract dissasembled:
                    for (String opcode : evmByteCodeCorrect) {
                        int number = EvmDisassemble.getNumber(opcode);
                        String[] arr = opcode.split("");
                        String opcodeStr = arr[0] + arr[1];
                        cCodeLabelOrder.put(opcode, order);
                        order++;
                        if (opcode.startsWith("6")) { DecompiledC.add(new push(opcode.substring(2), opcodeStr, number).accept(visitor,cCodeLabelOrder.get(opcode)));}// push starts with 6 and 7
                        else if (opcode.startsWith("7")) { DecompiledC.add(new push(opcode.substring(2), opcodeStr, number).accept(visitor,cCodeLabelOrder.get(opcode)));}// push starts with 7
                        else if (opcode.startsWith("8")) {DecompiledC.add(new dup(number).accept(visitor,cCodeLabelOrder.get(opcode)));}// dup starts 8
                        else if (opcode.startsWith("9")) {DecompiledC.add(new swap(number).accept(visitor,cCodeLabelOrder.get(opcode)));}// swap starts with 9
                        else if ((opcode.startsWith("A") && LogVariationsList.contains(opcode))|| (opcode.startsWith("A") && opcode.endsWith("0"))) {
                            DecompiledC.add(new log(number).accept(visitor,cCodeLabelOrder.get(opcode)));
                        }
                        else{
                            DecompiledC.add(EvmDisassemble.callVisitorFunctions(opcode, invalidHexList, instructions_no,number,visitor,cCodeLabelOrder.get(opcode))); // displays opcodes 
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

    }


}
