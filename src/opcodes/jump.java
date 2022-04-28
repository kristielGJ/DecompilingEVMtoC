//Author Gera Jahja
package src.opcodes;
/*  $pc := dst mark that pc is only assigned if dst is a valid jumpdest
    Stack no.56
    Last update: 04/03,05/03
    5C-5F are invalid
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class jump implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public jump()
    {
        this.opcode=0x56;
        this.name = "JUMP";
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
