//Author Gera Jahja
package src.opcodes;
/*  uint256 greater-than
    Stack no.11
    Last update: 03/03,05/03
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class gt implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public gt()
    {
        this.opcode=0x11;
        this.name = "GT";
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
