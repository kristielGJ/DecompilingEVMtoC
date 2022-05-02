//Author Gera Jahja
package src.opcodes;
/*  int256 division
    Stack no.05
    Last update: 28/02,05/03
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class sdiv implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public sdiv()
    {
        this.opcode=0x05;
        this.name = "SDIV";
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