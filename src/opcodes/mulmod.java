//Author Gera Jahja
package src.opcodes;
/*  ((u)int256 multiplication modulo N
    Stack no.09
    Last update: 28/02,05/03
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class mulmod implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public mulmod()
    {
        this.opcode=0x09;
        this.name = "MULMOD";
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
