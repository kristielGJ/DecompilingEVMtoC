//Author Gera Jahja
package src.opcodes;
/*  uint256 division
    Stack no. 04
    Last update: 28/02,05/03
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class div implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public div()
    {
        this.opcode=0x04;
        this.name = "DIV";
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