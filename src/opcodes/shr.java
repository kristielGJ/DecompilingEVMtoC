//Author Gera Jahja
package src.opcodes;
/*  logical shift right
    Stack no.1C
    Last update: 03/03,05/03
    Stack no 1E-1F are invalid!
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class shr implements GetInstructionsFromOpcode 
{
    private String opcode;
    private String name;
   
    public shr(String opcode)
    {
        this.opcode=opcode;
        this.name = "SHR";
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

