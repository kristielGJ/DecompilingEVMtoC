//Author Gera Jahja
package src.opcodes;
/*  bitwise OR
    Stack no. 17
    Last update: 03/03,05/03
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class or implements GetInstructionsFromOpcode 
{
    private String opcode;
    private String name;
   
    public or(String opcode)
    {
        this.opcode=opcode;
        this.name = "OR";
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