//Author Gera Jahja
package src.opcodes;
/*  push current chain id onto stack
    Stack no.46
    Last update: 04/03,05/03
    49-4F are invalid
*/ 
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class chainid implements GetInstructionsFromOpcode 
{
    private String opcode;
    private String name;
   
    public chainid(String opcode)
    {
        this.opcode=opcode;
        this.name = "CHAINID";
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
