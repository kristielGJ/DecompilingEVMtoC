//Author Gera Jahja
package src.opcodes;
/*  base fee of current block
    Stack no.48
    Last update: 04/03,05/03
    49-4F are invalid
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class basefee implements GetInstructionsFromOpcode 
{
    private String opcode;
    private String name;
   
    public basefee(String opcode)
    {
        this.opcode=opcode;
        this.name = "BASEFEE";
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
