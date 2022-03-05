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
    private String opcode;
    private String name;
   
    public sgt(String opcode)
    {
        this.opcode=opcode;
        this.name = "SGT";
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
