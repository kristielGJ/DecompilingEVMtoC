//Author Gera Jahja
package src.opcodes;
/*  gas limit of current block
    Stack no.45
    Last update: 04/03,05/03
    49-4F are invalid
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class gaslimit implements GetInstructionsFromOpcode 
{
    private String opcode;
    private String name;
   
    public gaslimit(String opcode)
    {
        this.opcode=opcode;
        this.name = "GASLIMIT";
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
