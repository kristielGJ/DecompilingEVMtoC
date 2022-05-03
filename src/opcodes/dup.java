//Author Gera Jahja
package src.opcodes;
import src.interfaces.*;
/*  Last update: 24/04
    80 =  DUP1 clone 1st value on stack
    81 =  DUP2 clone 1nd value on stack
    ...etc
    80	DUP1
    81	DUP2
    82	DUP3
    83	DUP4
    84	DUP5
    85	DUP6
    86	DUP7
    87	DUP8
    88	DUP9
    89	DUP10
    8A	DUP11
    8B	DUP12
    8C	DUP13
    8D	DUP14
    8E	DUP15
    8F	DUP16
*/
public class dup implements GetInstructionsFromOpcode {
 
    private int opcode;
    private String opcodeHex;
    private String name;
 

    public dup(int opcodenumber)
    {
        this.opcodeHex="8"+Integer.toHexString(opcodenumber-1);
        this.opcode=Integer.parseInt(opcodeHex,16);
        this.name = "DUP"+String.valueOf(opcodenumber);
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
    public String accept(Dissasemble visitor,int orderNo) 
    {
        return visitor.visit(this,orderNo);
    }
}
