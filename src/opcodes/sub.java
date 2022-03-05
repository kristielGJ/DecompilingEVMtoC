//Author Gera Jahja
package src.opcodes;
import src.interfaces.*;
/*  (u)int256 addition modulo 2**256
    Stack no.03
    Last update: 28/02, 05/03
    Test: Passed Dissasembly test! 05/03
*/
public class sub implements GetInstructionsFromOpcode 
{
    private String opcode;
    private String name;
   
    public sub(String opcode)
    {
        this.opcode=opcode;
        this.name = "SUB";
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
