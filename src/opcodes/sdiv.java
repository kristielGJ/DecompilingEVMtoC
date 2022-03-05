//Author Gera Jahja
package src.opcodes;
/*  int256 division
    Stack no.00 
    Last update: 28/02,05/03
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class sdiv implements GetInstructionsFromOpcode 
{
    private String opcode;
    private String name;
   
    public sdiv(String opcode)
    {
        this.opcode=opcode;
        this.name = "SDIV";
    }
   
    public String getOpcode() 
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