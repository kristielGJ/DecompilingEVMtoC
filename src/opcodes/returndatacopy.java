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
    private String opcode;
    private String name;
   
    public returndatacopy(String opcode)
    {
        this.opcode=opcode;
        this.name = "RETURNDATACCOPY";
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