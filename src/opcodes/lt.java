//Author Gera Jahja
package src.opcodes;
/*  uint256 greater-than
    Stack no.10
    Last update: 03/03,05/03
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class lt implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public lt()
    {
        this.opcode=0x10;
        this.name = "LT";
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