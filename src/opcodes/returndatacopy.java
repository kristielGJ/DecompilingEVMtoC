//Author Gera Jahja
package src.opcodes;
/*  copy returned data from last external call
    Stack no.3E
    Last update: 04/03,05/03
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class returndatacopy implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public returndatacopy()
    {
        this.opcode=0x3E;
        this.name = "RETURNDATACCOPY";
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