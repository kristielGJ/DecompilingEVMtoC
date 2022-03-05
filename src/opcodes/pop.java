//Author Gera Jahja
package src.opcodes;
/*  remove item from top of stack and discard it
    Stack no.50
    Last update: 04/03,05/03
    5C-5F are invalid
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class pop implements GetInstructionsFromOpcode 
{
    private String opcode;
    private String name;
   
    public pop(String opcode)
    {
        this.opcode=opcode;
        this.name = "POP";
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
