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
    private int opcode;
    private String name;
   
    public jumpi()
    {
        this.opcode=0x57;
        this.name = "JUMPI";
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
