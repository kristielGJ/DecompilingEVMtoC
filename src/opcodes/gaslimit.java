//Author Gera Jahja
package src.opcodes;
/*  gas limit of current block
    Stack no.45
    Last update: 04/03,05/03
    49-4F are invalid
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class gaslimit implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public gaslimit()
    {
        this.opcode=0x45;
        this.name = "GASLIMIT";
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
