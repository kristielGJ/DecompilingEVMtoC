//Author Gera Jahja
package src.opcodes;
/*  destroy contract and sends all funds to addr
    Stack no.FF
    Last update: 04/03,05/03
    F6-F9 and FB-FC are invalid
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class selfdestruct implements GetInstructionsFromOpcode 
{
    private String opcode;
    private String name;
   
    public selfdestruct(String opcode)
    {
        this.opcode=opcode;
        this.name = "SELFDESTRUCT";
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
