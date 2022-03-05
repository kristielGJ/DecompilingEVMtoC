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
    private String opcode;
    private String name;
   
    public gas(String opcode)
    {
        this.opcode=opcode;
        this.name = "GAS";
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
