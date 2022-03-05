//Author Gera Jahja
package src.opcodes;
/*  size of memory in current execution context, in bytes
    Stack no.59
    Last update: 04/03,05/03
    5C-5F are invalid
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class msize implements GetInstructionsFromOpcode 
{
    private String opcode;
    private String name;
   
    public msize(String opcode)
    {
        this.opcode=opcode;
        this.name = "MSIZE";
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