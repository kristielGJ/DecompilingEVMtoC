//Author Gera Jahja
package src.opcodes;
import src.interfaces.*;
/*  hexadecimal conversion code https://stackoverflow.com/questions/12005424/java-converting-int-to-hex-and-back-again
    Last update: 24/04
    60 = PUSH1 (push 1-byte value onto stack)
    61 = PUSH2 (push 2-byte value onto stack)
    ...etc
    60  PUSH1     61	PUSH2     62	PUSH3     63	PUSH4     64	PUSH5     65	PUSH6    
    66	PUSH7     67	PUSH8     68	PUSH9     69	PUSH10    6A	PUSH11    6B	PUSH12    
    6C	PUSH13    6D	PUSH14    6E	PUSH15    6F	PUSH16    70	PUSH17    71	PUSH18    
    72	PUSH19    73	PUSH20    74	PUSH21    75	PUSH22    76	PUSH23    77	PUSH24    
    78	PUSH25    79	PUSH26    7A	PUSH27    7B	PUSH28    7C	PUSH29    7D	PUSH30    
    7E	PUSH31    7F	PUSH32
*/
public class push implements GetInstructionsFromOpcode {

    private int opcode;
    private String opcodeHex;
    private String name;
   
    public push(String memoryadd,String opcodenumber,int byteNo)
    {
        this.opcodeHex=opcodenumber;
        this.opcode=Integer.parseInt(opcodeHex,16);
        this.name = "PUSH"+String.valueOf(byteNo)+" 0x"+memoryadd;
    }
   
    public int getOpcode() 
    {
        return opcode;
    }
    private String cCode;
    public String getC()
    {
        return this.cCode;
    }
    public void setC(String cCode) {
        this.cCode = cCode;
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
