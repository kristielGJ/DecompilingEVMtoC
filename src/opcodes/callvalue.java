//Author Gera Jahja
package src.opcodes;
/*  msg value, in wei
    Stack no.34
    Last update: 03/03,05/03
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class callvalue implements GetInstructionsFromOpcode 
{
    private String opcode;
    private String name;
   
    public callvalue(String opcode)
    {
        this.opcode=opcode;
        this.name = "CALLVALUE";
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
