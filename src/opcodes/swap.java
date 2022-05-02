//Author Gera Jahja
package src.opcodes;
import src.interfaces.*;
/*  Last update: 24/04
    90 =  SWAP1 ( a, b -> becomes -> b, a )
    91 =  SWAP2 ( a, _, b -> becomes -> b, _, a )
    ...etc
    
    90	SWAP1 
    91	SWAP2
    92	SWAP3
    93	SWAP4
    94	SWAP5
    95	SWAP6
    96	SWAP7
    97	SWAP8
    98	SWAP9
    99	SWAP10
    9A	SWAP11
    9B	SWAP12
    9C	SWAP13
    9D	SWAP14
    9E	SWAP15
    9F	SWAP16
*/
public class swap implements GetInstructionsFromOpcode {

    private int opcode;
    private String opcodeHex;
    private String name;
   
    public swap(int opcodenumber)
    {
        this.opcodeHex="9"+Integer.toHexString(opcodenumber-1);
        this.opcode=Integer.parseInt(opcodeHex,16);
        this.name = "SWAP"+String.valueOf(opcodenumber);
    }
    private String cCode;
    public String getC()
    {
        return this.cCode;
    }
    public void setC(String cCode) {
        this.cCode = cCode;
    }
    public int getOpcode() 
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
