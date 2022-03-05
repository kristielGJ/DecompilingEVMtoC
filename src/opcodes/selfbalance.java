//Author Gera Jahja
package src.opcodes;
/*  balance of executing contract, in wei
    Stack no.47
    Last update: 04/03,05/03
    49-4F are invalid
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class selfbalance implements GetInstructionsFromOpcode 
{
    private String opcode;
    private String name;
   
    public selfbalance(String opcode)
    {
        this.opcode=opcode;
        this.name = "SELFBALANCE";
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