//Author Gera Jahja
package src.opcodes;
/*  int256 greater-than
    Stack no.13 
    Last update: 03/03,05/03
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class sgt implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public sgt()
    {
        this.opcode=0x13;
        this.name = "SGT";
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
