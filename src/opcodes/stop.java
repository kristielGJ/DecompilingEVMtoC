//Author Gera Jahja
package src.opcodes;
import src.interfaces.*;
/*  This command halts the execution
    Stack no.00 
    Last update: 28/02, 05/03
    Test: Passed Dissasembly test! 05/03
*/
public class stop implements GetInstructionsFromOpcode 
{
    private String opcode;
    private String name;
   
    public stop(String opcode)
    {
        this.opcode=opcode;
        this.name = "STOP";
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
