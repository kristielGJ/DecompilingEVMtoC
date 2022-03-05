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
    private String opcode;
    private String name;
   
    public gt(String opcode)
    {
        this.opcode=opcode;
        this.name = "GT";
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
