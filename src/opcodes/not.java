//Author Gera Jahja
package src.opcodes;
/*  bitwise NOT
    Stack no. 19
    Last update: 03/03,05/03
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class not implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public not()
    {
        this.opcode=0x19;
        this.name = "NOT";
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
