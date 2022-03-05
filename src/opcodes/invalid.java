//Author Gera Jahja
package src.opcodes;
/*  designated invalid opcode - EIP-141
    Stack no.FE
    Last update: 04/03,05/03
    F6-F9 and FB-FC are invalid
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class invalid implements GetInstructionsFromOpcode 
{
    private String opcode;
    private String name;
   
    public invalid(String opcode)
    {
        this.opcode=opcode;
        this.name = "INVALID";
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
