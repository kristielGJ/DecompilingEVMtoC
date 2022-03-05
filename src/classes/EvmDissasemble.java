//Author Gera Jahja, last update 05/03
package src.classes;
import java.io.*;
import java.util.concurrent.TimeUnit;
import src.interfaces.*;
import src.opcodes.*;
class EvmDissasemble 
{
    public static boolean isNumeric(String strNum) {
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
        
        //numerical evm
        GetInstructionsFromOpcode[] instructions_no = new GetInstructionsFromOpcode[]{
            new stop("00"),new add("01"),new mul("02"),new sub("03"),new div("04"),new sdiv("05"),new mod("06"),
            new smod("07"),new addmod("08"),new mulmod("09"),new lt("10"),new gt("11"),new slt("12"),new sgt("13"),
            new eq("14"),new iszero("15"),new and("16"),new or("17"),new xor("18"),new not("19"),new address("30"),
            new balance("31"),new origin("32"),new caller("33"),new callvalue("34"),new calldataload("35"),
            new calldatasize("36"),new calldatacopy("37"),new codesize("38"),new codecopy("39"),new blockhash("40"),
            new coinbase("41"),new timestamp("42"),new number("43"),new dificulty("44"),new gaslimit("45"),
            new chainid("46"),new selfbalance("47"),new basefee("48"),new pop("50"),new mload("51"),new mstore("52"),
            new mstore8("53"),new sload("54"),new sstore("55"),new jump("56"),new jumpi("57"),new pc("58"),new msize("59")};
        //evm with letters
        GetInstructionsFromOpcode[] instructions = new GetInstructionsFromOpcode[]{
            new selfdestruct("FF"), new exp("0A"),new signextend("0B"),bytee("1A"),new shl("1B"),new shr("1C"),
            new sar("1D"),new gasprice("3A"),new extcodesize("3B"),new extcodecopy("3C") ,new returndatasize("3D"),
            new returndatacopy("3E"),new extcodehash("3F"), new gas("5A"), new jumpdest("5B"), new create ("F0") ,
            new call("F1"), new callcode("F2"), new return_("F3"),new delegatecall("F4"),new create2("F5"),
            new staticcall("FA"),new revert("FD"),new invalid ("FE")
        };
        
            //test using:
            //FF0A0B1A1B1C1D3A3B3C3D3E3F5A5BF0F1F2F3F4F5FAFDFE
            //00010203040506070809101112131415161718193031323334353637383940414243444546474850515253545556575859 
        for (String opcode : evmByteCode) {
            Dissasemble visitor = new visitOpCode();
            boolean checkNumber = isNumeric(opcode);
           // System.out.println(opcode);
           if (checkNumber==true){
                int opcodeNumber =Integer.parseInt(opcode);
                if (opcodeNumber<20)
                {   
                    instructions_no[opcodeNumber].accept(visitor);
                }
                else if (opcodeNumber==49||opcodeNumber==20)
                {   
                    System.out.println("----  INVALID BYTE CODE! ---- ");
                }
                else if (opcodeNumber>19 && opcodeNumber<50)
                {   
                    instructions_no[opcodeNumber-10].accept(visitor);
                }
                else if (opcodeNumber>49)
                {   
                    instructions_no[opcodeNumber-11].accept(visitor);
                }
            }
            //for non numerical hexadecimals, fix 1A , 1D, 3D, 3F
            //FF0A0B1B1C3A3B3C3E5A5BF0F1F2F3F4F5FAFDFE input passed test 
            else if (checkNumber==false){
                if (opcode.contains("0A")) {//EXP passed test
                    instructions[1].accept(visitor);
                }
                else if (opcode.contains("0B")) {//SIGNEXTEND passed test
                    instructions[2].accept(visitor);
                }
                else if (opcode.contains("1A")) {//BYTE not working
                    instructions[3].accept(visitor);
                }
                else if (opcode.contains("1B")) {//SHL passed test
                    instructions[4].accept(visitor);
                }
                else if (opcode.contains("1C")) {//SHR passed test
                    instructions[5].accept(visitor);
                }
                else if (opcode.contains("1D")) {//SAR not working
                    instructions[6].accept(visitor);
                }
                else if (opcode.contains("3A")) {//GASPRICE  passed test
                    instructions[7].accept(visitor);
                }
                else if (opcode.contains("3B")) {//EXTCODESIZE passed test
                    instructions[8].accept(visitor);
                }
                else if (opcode.contains("3C")) {//EXTCODECOPY passed test
                    instructions[9].accept(visitor);
                }
                else if (opcode.contains("3D")) {//RETURNDATASIZE not working
                    instructions[10].accept(visitor);
                }
                else if (opcode.contains("3E")) {//RETURNDATACOPY  passed test
                    instructions[11].accept(visitor);
                }
                else if (opcode.contains("3F")) {//EXTCODEHASH not working
                    instructions[12].accept(visitor);
                }
                else if (opcode.contains("5A")) {//GAS passed test
                    instructions[13].accept(visitor);
                }
                else if (opcode.contains("5B")) {//JUMPDEST passed test
                    instructions[14].accept(visitor);
                }
                else if (opcode.contains("F0")) {//CREATE passed test
                    instructions[15].accept(visitor);
                }
                else if (opcode.contains("F1")) {//CALL passed test
                    instructions[16].accept(visitor);
                }
                else if (opcode.contains("F2")) {//CALLCODE  passed test
                    instructions[17].accept(visitor);
                }
                else if (opcode.contains("F3")) {//RETURN  passed test
                    instructions[18].accept(visitor);
                } 
                else if (opcode.contains("F4")) {//DELEGATECALL passed test
                    instructions[19].accept(visitor);
                }
                else if (opcode.contains("F5")) {//CREATE2 passed test
                    instructions[20].accept(visitor);
                }
                else if (opcode.contains("FA")) {//STATICCALL passed test
                    instructions[21].accept(visitor);
                }
                else if (opcode.contains("FD")) {//REVERT passed test
                    instructions[22].accept(visitor);
                }
                else if (opcode.contains("FE")) {//INVALID passed test
                    instructions[23].accept(visitor);
                }
                else if (opcode.contains("FF")) {//SELFDESTRUCT passed test
                    instructions[00].accept(visitor);
                }
        }
        }
            /*
            }
            //--------||||||-------------|||||-------------

            else if (opcode.contains("6A")) {//PUSH11
                Dissasemble visitor = new visitOpCode();
                instructions[].accept(visitor);
            }
            else if (opcode.contains("6B")) {//PUSH12
                Dissasemble visitor = new visitOpCode();
                instructions[]].accept(visitor);
            }
            else if (opcode.contains("6C")) {//PUSH13
                Dissasemble visitor = new visitOpCode();
                instructions[].accept(visitor);
            }
            else if (opcode.contains("6D")) {//PUSH14
                Dissasemble visitor = new visitOpCode();
                instructions[].accept(visitor);
            }
            else if (opcode.contains("6E")) {//PUSH15
                Dissasemble visitor = new visitOpCode();
                instructions[].accept(visitor);
            }
            else if (opcode.contains("6F")) {//PUSH16
                Dissasemble visitor = new visitOpCode();
                instructions[].accept(visitor);
            }
            else if (opcode.contains("7A")) {//PUSH27
                Dissasemble visitor = new visitOpCode();
                instructions[].accept(visitor);
            }
            else if (opcode.contains("7B")) {//PUSH28
                Dissasemble visitor = new visitOpCode();
                instructions[].accept(visitor);
            }
            else if (opcode.contains("7C")) {//PUSH29
                Dissasemble visitor = new visitOpCode();
                instructions[].accept(visitor);
            }
            else if (opcode.contains("7D")) {//PUSH30
                Dissasemble visitor = new visitOpCode();
                instructions[].accept(visitor);
            }
            else if (opcode.contains("7E")) {//PUSH32
                Dissasemble visitor = new visitOpCode();
                instructions[].accept(visitor);
            }
            else if (opcode.contains("7F")) {//PUSH32
                Dissasemble visitor = new visitOpCode();
                instructions[].accept(visitor);
            }
            else if (opcode.contains("8A")) {//DUP11
                Dissasemble visitor = new visitOpCode();
                instructions[].accept(visitor);
            }
            else if (opcode.contains("8B")) {//DUP12
                Dissasemble visitor = new visitOpCode();
                instructions[].accept(visitor);
            }
            else if (opcode.contains("8C")) {//DUP13
                Dissasemble visitor = new visitOpCode();
                instructions[].accept(visitor);
            }
            else if (opcode.contains("8D")) {//DUP14
                Dissasemble visitor = new visitOpCode();
                instructions[].accept(visitor);
            }
            else if (opcode.contains("8E")) {//DUP15
                Dissasemble visitor = new visitOpCode();
                instructions[].accept(visitor);
            }
            else if (opcode.contains("8F")) {//DUP16
                Dissasemble visitor = new visitOpCode();
                instructions[].accept(visitor);
            }
            else if (opcode.contains("9A")) {//SWAP11
                Dissasemble visitor = new visitOpCode();
                instructions[].accept(visitor);
            }
            else if (opcode.contains("9B")) {//SWAP12
                Dissasemble visitor = new visitOpCode();
                instructions[].accept(visitor);
            }
            else if (opcode.contains("9C")) {//SWAP13
                Dissasemble visitor = new visitOpCode();
                instructions[].accept(visitor);
            }
            else if (opcode.contains("9D")) {//SWAP14
                Dissasemble visitor = new visitOpCode();
                instructions[].accept(visitor);
            }
            else if (opcode.contains("9E")) {//SWAP15
                Dissasemble visitor = new visitOpCode();
                instructions[4].accept(visitor);
            }
            else if (opcode.contains("9F")) {//SWAP16
                Dissasemble visitor = new visitOpCode();
                instructions[4].accept(visitor);
            }

             else if (opcode.contains("A0")) {//DUP14
                Dissasemble visitor = new visitOpCode();
                instructions[4].accept(visitor);
            }
            else if (opcode.contains("A1")) {//LOG1
                Dissasemble visitor = new visitOpCode();
                instructions[4].accept(visitor);
            }
            else if (opcode.contains("A2")) {//LOG2
                Dissasemble visitor = new visitOpCode();
                instructions[4].accept(visitor);
            }
            else if (opcode.contains("A3")) {//LOG3
                Dissasemble visitor = new visitOpCode();
                instructions[4].accept(visitor);
            }
            else if (opcode.contains("A4")) {//LOG4
                Dissasemble visitor = new visitOpCode();
                instructions[4].accept(visitor);
            }
        
            */
    
    } 
    private static GetInstructionsFromOpcode bytee(String string) {
        return null;
    } 
}

    