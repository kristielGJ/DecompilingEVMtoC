//Author Gera Jahja
package src.opcodes;
/*  base fee of current block
    Stack no.48
    Last update: 04/03,05/03,01/05
    49-4F are invalid
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class basefee implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public basefee()
    {
        this.opcode=0x48;
        this.name = "BASEFEE";
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
