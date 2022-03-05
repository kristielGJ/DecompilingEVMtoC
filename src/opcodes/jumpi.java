//Author Gera Jahja
package src.opcodes;
/*  $pc := condition ? dst : $pc + 1
    Stack no.57
    Last update: 04/03,05/03
    5C-5F are invalid
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class jumpi implements GetInstructionsFromOpcode 
{
    private String opcode;
    private String name;
   
    public jumpi(String opcode)
    {
        this.opcode=opcode;
        this.name = "JUMPI";
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
