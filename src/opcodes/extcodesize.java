//Author Gera Jahja
package src.opcodes;
/*  size of code at addr, in bytes
    Stack no.3B
    Last update: 03/03,05/03
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class extcodesize implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public extcodesize()
    {
        this.opcode=0x3B;
        this.name = "EXTCODESIZE";
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
