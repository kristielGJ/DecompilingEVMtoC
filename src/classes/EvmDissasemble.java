//Author Gera Jahja, last update 24/04
package src.classes;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import src.interfaces.*;
import src.opcodes.*;
// Testing

// 605f7000606061008090A1A2A3A4A0 for push, dup, swap and log

// Should print opcodes:
// 000102030405060708090A0B101112131415161718191A1B1C1D20303132333435363738393A3B3C3D3E3F404142434445464748505152535455565758595A5B60006100620063006400650066006700680069006A006B006C006D006E006F0070007100720073007400750076007700780079007A007B007C007D007E007F00808182838485868788898A8B8C8D8E8F909192939495969798999A9B9C9D9E9FA0A1A2A3A4F0F1F2F3F4F5FAFDFEFF

// Should all be invalid:
// 0C0D0E0F1E1F2122232425262728292A2B2C2D2E2F494A4B4C4D4E4F5C5D5E5FA5A6A7A8A9AAABACADAEAFB0B1B2B3B4B5B6B7B8B9BABBBCBDBEBFC0C1C2C3C4C5C6C7C8C9CACBCCCDCECFD0D1D2D3D4D5D6D7D8D9DADBDCDDDEDFE0E1E2E3E4E5E6E7E8E9EAEBECEDEEEFF6F7F8F9FBFC

// 10/03 review: code tidy up : create an array with 256 entries , create a
// "invalid" op code for numbers that arent cool, look up in the array and then
// create
// for each op code, add a build method, gets passed the array of bytes ,
// consumes the appropriate number (via looking up in the table, byilds the
// object of the apropriate type)
class EvmDissasemble {
    // possible log hexadecimals:
    public static String[] LogVariations = { "AO", "A1", "A2", "A3", "A4" };
    public static List<String> LogVariationsList = Arrays.asList(LogVariations);

    public static boolean isNumeric(String strNum) {// https://www.baeldung.com/java-check-string-number
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

    /* prints out readable opcodes from EVM bytecode */
    private static void callVisitorFunctions(String opcode, List<String> invalidHexList,GetInstructionsFromOpcode[] instructions_no,int number,Dissasemble visitor) {
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
                        instructions_no[opcodeNumber].accept(visitor);

                    } else if ((opcodeNumber > 20) && (opcodeNumber < 60)) {
                        if (opcodeNumber > 49) {
                            instructions_no[opcodeNumber - 10].accept(visitor);
                        } else {
                            instructions_no[opcodeNumber - 9].accept(visitor);
                        }
                    }
                }
                else if (checkLetter==true){
                    // evm with letters
                    if (opcode.contains("FF")) { new selfdestruct().accept(visitor);} // SELFDESTRUCT passed test
                    else if (opcode.contains("0A")) { new exp().accept(visitor);} // EXP passed test
                    else if (opcode.contains("0B")) { new signextend().accept(visitor);} // SIGNEXTEND passed test
                    else if (opcode.contains("1A")) { new bytee().accept(visitor);} // BYTE passed test
                    else if (opcode.contains("1B")) { new shl().accept(visitor);} // SHL passed test
                    else if (opcode.contains("1C")) { new shr().accept(visitor);} // SHR passed test
                    else if (opcode.contains("3A")) { new gasprice().accept(visitor);} // GASPRICE passed test
                    else if (opcode.contains("3B")) { new extcodesize().accept(visitor);} // EXTCODESIZE passed test
                    else if (opcode.contains("3C")) { new extcodecopy().accept(visitor);} // EXTCODECOPY passed test
                    else if (opcode.contains("3E")) { new returndatacopy().accept(visitor);} // RETURNDATACOPY passed test
                    else if (opcode.contains("5A")) { new gas().accept(visitor);} // GAS passed test
                    else if (opcode.contains("5B")) { new jumpdest().accept(visitor);} // JUMPDEST passed test
                    else if (opcode.contains("F0")) { new create().accept(visitor);} // CREATE passed test
                    else if (opcode.contains("F1")) { new call().accept(visitor);} // CALL passed test                        
                    else if (opcode.contains("F2")) { new callcode().accept(visitor);} // CALLCODE passed test
                    else if (opcode.contains("F3")) { new return_().accept(visitor);} // RETURN passed test
                    else if (opcode.contains("F4")) { new delegatecall().accept(visitor);} // DELEGATECALL passed test
                    else if (opcode.contains("F5")) { new create2().accept(visitor);} // CREATE2 passed test
                    else if (opcode.contains("FA")) { new staticcall().accept(visitor);} // STATICCALL passed test
                    else if (opcode.contains("FD")) { new revert().accept(visitor);} // REVERT passed test
                    else if (opcode.contains("FE")) { new invalid().accept(visitor);} // INVALID passed test
                    else if ((opcode.startsWith("A") && LogVariationsList.contains(opcode))|| (opcode.startsWith("A") && opcode.endsWith("0"))) {
                        new log(number).accept(visitor);
                    }
                }
            } 
        }catch (Exception e) {
            if (opcode.contains("1D")) { new sar().accept(visitor);} // SAR passed test
            else if (opcode.contains("3F")) { new extcodehash().accept(visitor);} // EXTCODEHASH passed test
            else if (opcode.contains("3D")) { new returndatasize().accept(visitor);} // RETURNDATASIZE passed test
            else{
                System.out.println("---- Valid Opcode has not been Implemented Yet---- ");
                // if a valid opcode isnt handeled in the try section it will show this message
            }
        }
    }
    /*looks at second number and calulates number for log, dup,swap and push
    , i.e for 63 (push4), it returns 3+1 = 4 (to display the number for push "4")*/
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
    //60806040526004361061004c576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806341c0e1b514610051578063cfae321714610068575b600080fd5b34801561005d57600080fd5b506100666100f8565b005b34801561007457600080fd5b5061007d610189565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156100bd5780820151818401526020810190506100a2565b50505050905090810190601f1680156100ea5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415610187576000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16ff5b565b606060018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156102215780601f106101f657610100808354040283529160200191610221565b820191906000526020600020905b81548152906001019060200180831161020457829003601f168201915b50505050509050905600a165
        while (true) {
            try{
                // Asking for input from user
                System.out.println("Enter your Ethereum contract bytecode (e.g 68001...) : ");
                String evmContract = (bfn.readLine()).toUpperCase();

                // outputs for readibility
                System.out.println("Processing...");
                TimeUnit.SECONDS.sleep(1);

                // outputs the input from the user
                System.out.println("EVM BYTECODE: " + evmContract + "\n");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Dissasebly: ");
                
                // split into an array of two character op codes (for PUSH make sure to send
                // over the next element also)
                String[] evmByteCode = evmContract.split("(?<=\\G.{2})");
                List<String> evmByteCodeList = Arrays.asList(evmByteCode);
                ArrayList<String> evmByteCodeArrayList = new ArrayList<String>(evmByteCodeList);

                List<String> evmByteCodeCorrect = new ArrayList<>();

                // ensure the elements of the array are split to the right size ( push requires
                // more than 2 chars)
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
                // Whole contract dissasembled:
                for (String opcode : evmByteCodeCorrect) {
                    int number = getNumber(opcode);
                    String[] arr = opcode.split("");
                    String opcodeStr = arr[0] + arr[1];
                    Dissasemble visitor = new visitOpCode();
                                        
                    if (opcode.startsWith("6")) { new push(opcode.substring(2), opcodeStr, number).accept(visitor);}// push starts with 6 and 7
                    else if (opcode.startsWith("7")) { new push(opcode.substring(2), opcodeStr, number).accept(visitor);}// push starts with 7
                    else if (opcode.startsWith("8")) {new dup(number).accept(visitor);}// dup starts 8
                    else if (opcode.startsWith("9")) { new swap(number).accept(visitor);}// swap starts with 9
                     else{
                        callVisitorFunctions(opcode, invalidHexList, instructions_no,number,visitor); // displays opcodes 
                    }
                }
                // Basic Blocks from contract: (i.e split on occurunces of jump, jumpi etc), prep for decompilation

        }catch (Exception e){
            System.out.println("----Invalid Contract, Enter valid EVM byte code please---- "); //e.g if there is an irregular number of opcodes
        }
        }

    }

}
