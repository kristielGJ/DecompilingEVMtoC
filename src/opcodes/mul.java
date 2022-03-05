//Author Gera Jahja
package src.opcodes;
import src.interfaces.*;

/*  (u)int256 multiplication modulo 2**256
    Stack no. 02
    Last update: 28/02, 05/03
    Test: Passed Dissasembly test! 05/03
*/
public class mul implements GetInstructionsFromOpcode 
{
    private String opcode;
    private String name;
   
    public mul(String opcode)
    {
        this.opcode=opcode;
        this.name = "MUL";
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