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
    private String opcode;
    private String name;
   
    public mulmod(String opcode)
    {
        this.opcode=opcode;
        this.name = "MULMOD";
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
