//Author Gera Jahja
package src.opcodes;
/*  ith byte of (u)int256 x, from the left
    Stack no. 1A
    Last update: 03/03,05/03
    Stack no 1E-1F are invalid!
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class bytee implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public bytee()
    {
        this.opcode=0x1A;
        this.name = "BYTE";
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