package src.decompile;

import java.util.Arrays;
import java.util.List;
import src.interfaces.*;
import src.opcodes.*;

public class EvmDisassemble {
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
    public static String callVisitorFunctions(String opcode, List<String> invalidHexList,GetInstructionsFromOpcode[] instructions_no,int number,Dissasemble visitor,int orderNo) {
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
                        return instructions_no[opcodeNumber].accept(visitor,orderNo);

                    } else if ((opcodeNumber > 20) && (opcodeNumber < 60)) {
                        if (opcodeNumber > 49) {
                            return instructions_no[opcodeNumber - 10].accept(visitor,orderNo);
                        } else {
                            return instructions_no[opcodeNumber - 9].accept(visitor,orderNo);
                        }
                    }
                }
                else if (checkLetter==true){
                    // evm with letters
                    if (opcode.contains("FF")) { new selfdestruct().accept(visitor,orderNo);} // SELFDESTRUCT passed test
                    else if (opcode.contains("0A")) { return new exp().accept(visitor,orderNo);} // EXP passed test
                    else if (opcode.contains("0B")) { return new signextend().accept(visitor,orderNo);} // SIGNEXTEND passed test
                    else if (opcode.contains("1A")) { return new bytee().accept(visitor,orderNo);} // BYTE passed test
                    else if (opcode.contains("1B")) { return new shl().accept(visitor,orderNo);} // SHL passed test
                    else if (opcode.contains("1C")) { return new shr().accept(visitor,orderNo);} // SHR passed test
                    else if (opcode.contains("3A")) { return new gasprice().accept(visitor,orderNo);} // GASPRICE passed test
                    else if (opcode.contains("3B")) { return new extcodesize().accept(visitor,orderNo);} // EXTCODESIZE passed test
                    else if (opcode.contains("3C")) { return new extcodecopy().accept(visitor,orderNo);} // EXTCODECOPY passed test
                    else if (opcode.contains("3E")) { return new returndatacopy().accept(visitor,orderNo);} // RETURNDATACOPY passed test
                    else if (opcode.contains("5A")) { return new gas().accept(visitor,orderNo);} // GAS passed test
                    else if (opcode.contains("5B")) { return new jumpdest().accept(visitor,orderNo);} // JUMPDEST passed test
                    else if (opcode.contains("F0")) { return new create().accept(visitor,orderNo);} // CREATE passed test
                    else if (opcode.contains("F1")) { return new call().accept(visitor,orderNo);} // CALL passed test                        
                    else if (opcode.contains("F2")) { return new callcode().accept(visitor,orderNo);} // CALLCODE passed test
                    else if (opcode.contains("F3")) { return new return_().accept(visitor,orderNo);} // RETURN passed test
                    else if (opcode.contains("F4")) { return new delegatecall().accept(visitor,orderNo);} // DELEGATECALL passed test
                    else if (opcode.contains("F5")) { return new create2().accept(visitor,orderNo);} // CREATE2 passed test
                    else if (opcode.contains("FA")) { return new staticcall().accept(visitor,orderNo);} // STATICCALL passed test
                    else if (opcode.contains("FD")) { return new revert().accept(visitor,orderNo);} // REVERT passed test
                    else if (opcode.contains("FE")) { return new invalid().accept(visitor,orderNo);} // INVALID passed test
                    else if ((opcode.startsWith("A") && LogVariationsList.contains(opcode))|| (opcode.startsWith("A") && opcode.endsWith("0"))) {
                        new log(number).accept(visitor,orderNo);
                    }
                }
            } 
        }catch (Exception e) {
            if (opcode.contains("1D")) {return new sar().accept(visitor,orderNo);} // SAR passed test
            else if (opcode.contains("3F")) { return new extcodehash().accept(visitor,orderNo);} // EXTCODEHASH passed test
            else if (opcode.contains("3D")) { return new returndatasize().accept(visitor,orderNo);} // RETURNDATASIZE passed test
            else{
                System.out.println("---- Valid Opcode has not been Implemented Yet---- ");
                // if a valid opcode isnt handeled in the try section it will show this message
            }
        }
        return "";
    }

    /*
    Looks at second number and calulates number for log, dup,swap and push
    , i.e for 63 (push4), it returns 3+1 = 4 (to display the number for push "4")
    also gets Lable00_ number for decompiled C code
    */
    public static int getNumber(String opcode) { 
        
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
    
}
