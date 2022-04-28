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
    private int opcode;
    private String name;
   
    public exp ()
    {
        this.opcode=0x0A;
        this.name = "EXP";
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
