//Author Gera Jahja
package src.opcodes;
/*  gasRemaining
    Stack no.5A
    Last update: 04/03,05/03
    5C-5F are invalid
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class gas implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public gas()
    {
        this.opcode=0x5A;
        this.name = "GAS";
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
