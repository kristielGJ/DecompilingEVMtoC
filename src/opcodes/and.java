//Author Gera Jahja
package src.opcodes;
/*  bitwise AND
    Stack no. 16
    Last update: 03/03,05/03
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class and implements GetInstructionsFromOpcode 
{
    private String opcode;
    private String name;
   
    public and(String opcode)
    {
        this.opcode=opcode;
        this.name = "AND";
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
