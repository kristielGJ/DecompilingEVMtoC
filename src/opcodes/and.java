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
    private int opcode;
    private String name;
   
    public and()
    {
        this.opcode=0x16;
        this.name = "AND";
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
