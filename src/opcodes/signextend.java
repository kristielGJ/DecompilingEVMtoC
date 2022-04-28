//Author Gera Jahja
package src.opcodes;
/*  sign extend x from (b+1) bytes to 32 bytes
    Stack no.0B
    0C-0F are invalid
    Last update: 28/02,05/03
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class signextend implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public signextend()
    {
        this.opcode=0x0B;
        this.name = "SIGNEXTEND";
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

