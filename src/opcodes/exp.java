//Author Gera Jahja
package src.opcodes;
/*  uint256 exponentiation modulo 2**256
    Stack no.0A
    Last update: 28/02,05/03
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class exp implements GetInstructionsFromOpcode 
{
    private String opcode;
    private String name;
   
    public exp(String opcode)
    {
        this.opcode=opcode;
        this.name = "EXP";
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
