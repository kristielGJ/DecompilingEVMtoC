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
    private String opcode;
    private String name;
   
    public returndatasize(String opcode)
    {
        this.opcode=opcode;
        this.name = "RETURNDATASIZE";
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