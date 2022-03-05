//Author Gera Jahja
package src.opcodes;
/*  int256 modulus
    Stack no.07
    Last update: 28/02,05/03
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class smod implements GetInstructionsFromOpcode 
{
    private String opcode;
    private String name;
   
    public smod(String opcode)
    {
        this.opcode=opcode;
        this.name = "SMOD";
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