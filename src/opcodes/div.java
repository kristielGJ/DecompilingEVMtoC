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
    private String opcode;
    private String name;
   
    public div(String opcode)
    {
        this.opcode=opcode;
        this.name = "DIV";
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