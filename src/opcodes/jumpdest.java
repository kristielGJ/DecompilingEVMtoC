//Author Gera Jahja
package src.opcodes;
/*  a valid jump destination for example a jump destination not inside the push data
    Stack no.5B
    Last update: 04/03,05/03
    5C-5F are invalid
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class jumpdest implements GetInstructionsFromOpcode 
{
    private String opcode;
    private String name;
   
    public jumpdest(String opcode)
    {
        this.opcode=opcode;
        this.name = "JUMPDEST";
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