//Author Gera Jahja
package src.opcodes;
/*  uint256 modulus
    Stack no.06
    Last update: 28/02,05/03
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class mod implements GetInstructionsFromOpcode 
{
    private String opcode;
    private String name;
   
    public mod(String opcode)
    {
        this.opcode=opcode;
        this.name = "MOD";
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
