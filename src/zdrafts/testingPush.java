package src.zdrafts;
//import java.io.*;
//import java.util.Arrays;
//import java.util.List;
//import java.util.concurrent.TimeUnit;

public class testingPush {

/*    public static void main(String[] args) throws IOException, InterruptedException {
        // Creating BufferedReader Object
        BufferedReader bfn = new BufferedReader(new InputStreamReader(System.in));
        // Asking for input from user
        System.out.println("Enter your Ethereum contract bytecode (e.g 68001...) : ");

        // String reading internally
        String evmContract = (bfn.readLine()).toUpperCase();

        // outputs for readibility
        System.out.println("Processing...");
        TimeUnit.SECONDS.sleep(1);

        // outputs the input from the user
        System.out.println("EVM BYTECODE: " + evmContract + "\n");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Dissasebly: ");

        // possible log hexadecimals:
        String[] LogVariations = { "AO", "A1", "A2", "A3", "A4" };
        List LogVariationsList = Arrays.asList(LogVariations);

        // split into an array of two character op codes (for PUSH make sure to send
        // over the next element also)
        String[] evmByteCode = evmContract.split("(?<=\\G.{2})");

        for (String opcode : evmByteCode) {
            // push starts with 6 and 7
            if (opcode.startsWith("6") || opcode.startsWith("7")) {
                System.out.println("Push opcode:" + opcode);// test
                System.out.println("Push Memory location:" + opcode);// test

            }
            // dup starts 8
            if (opcode.startsWith("8")) {
                System.out.println("Dup opcode:" + opcode);// test
            }
            // swap starts with 9
            if (opcode.startsWith("9")) {
                System.out.println("Swap opcode:" + opcode);// test
            }
            // log starts with A (0,1,2,3,4)
            if (opcode.startsWith("A") && LogVariationsList.contains(opcode)) {
                System.out.println("Log opcode:" + opcode);// test

            }
        }

        // Testing
        // all hex values:
        // 000102030405060708090A0B101112131415161718191A1B1C1D20303132333435363738393A3B3C3D3E3F404142434445464748505152535455565758595A5B606162636465666768696A6B6C6D6E6F707172737475767778797A7B7C7D7E7F808182838485868788898A8B8C8D8E8F909192939495969798999A9B9C9D9E9FA0A1A2A3A4F0F1F2F3F4F5FAFDFEFF0C0D0E0F1E1F2122232425262728292A2B2C2D2E2F494A4B4C4D4E4F5C5D5E5FA5A6A7A8A9AAABACADAEAFB0B1B2B3B4B5B6B7B8B9BABBBCBDBEBFC0C1C2C3C4C5C6C7C8C9CACBCCCDCECFD0D1D2D3D4D5D6D7D8D9DADBDCDDDEDFE0E1E2E3E4E5E6E7E8E9EAEBECEDEEEFF6F7F8F9FBFC

        // Should print opcodes:
        // 000102030405060708090A0B101112131415161718191A1B1C1D20303132333435363738393A3B3C3D3E3F404142434445464748505152535455565758595A5B606162636465666768696A6B6C6D6E6F707172737475767778797A7B7C7D7E7F808182838485868788898A8B8C8D8E8F909192939495969798999A9B9C9D9E9FA0A1A2A3A4F0F1F2F3F4F5FAFDFEFF

        // Should all be invalid:
        // 0C0D0E0F1E1F2122232425262728292A2B2C2D2E2F494A4B4C4D4E4F5C5D5E5FA5A6A7A8A9AAABACADAEAFB0B1B2B3B4B5B6B7B8B9BABBBCBDBEBFC0C1C2C3C4C5C6C7C8C9CACBCCCDCECFD0D1D2D3D4D5D6D7D8D9DADBDCDDDEDFE0E1E2E3E4E5E6E7E8E9EAEBECEDEEEFF6F7F8F9FBFC

      
            // callVisitorFunctions(opcode); // displays opcodes

            // 10/03 :while loop for imidiates (such as push1 commands)
            // 10/03 review: code tidy up : create an array with 256 entries , create a
            // "invalid" op code for numbers that arent cool, look up in the array and then
            // create
            // make the HEX into integers!!! less if statements
            // for each op code, add a build method, gets passed the array of bytes ,
            // consumes the appropriate number (via looking up in the table, byilds the
            // object of the apropriate type)
    }*/

}
