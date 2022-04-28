//Author Gera Jahja
package src.opcodes;
/*  size of returned data from last external call, in bytes
    Stack no.3D
    Last update: 04/03,05/03
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class returndatasize implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public returndatasize()
    {
        this.opcode=0x3D;
        this.name = "RETURNDATASIZE";
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