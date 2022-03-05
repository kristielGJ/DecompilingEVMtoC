//Author Gera Jahja
package src.opcodes;
/*  (u)int256 iszero
    Stack no.15
    Last update: 03/03,05/03
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class iszero implements GetInstructionsFromOpcode 
{
    private String opcode;
    private String name;
   
    public iszero(String opcode)
    {
        this.opcode=opcode;
        this.name = "ISZERO";
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
