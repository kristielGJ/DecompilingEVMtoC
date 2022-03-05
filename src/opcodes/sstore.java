//Author Gera Jahja
package src.opcodes;
import src.interfaces.*;
/*  write word from storage
    Stack no.55
    Last update: 04/03, 05/03
    Test: Passed Dissasembly test! 05/03
    5C-5F are invalid
*/
public class sstore implements GetInstructionsFromOpcode 
{
    private String opcode;
    private String name;
   
    public sstore(String opcode)
    {
        this.opcode=opcode;
        this.name = "SSTORE";
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
