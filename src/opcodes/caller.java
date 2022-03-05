//Author Gera Jahja
package src.opcodes;
/*  address of msg sender
    Stack no.33
    Last update: 03/03,05/03
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class caller implements GetInstructionsFromOpcode 
{
    private String opcode;
    private String name;
   
    public caller(String opcode)
    {
        this.opcode=opcode;
        this.name = "CALLER";
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
