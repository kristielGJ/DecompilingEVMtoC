//Author Gera Jahja
package src.opcodes;
/*  shift left
    Stack no.1B
    Last update: 03/03,05/03
    Stack no 1E-1F are invalid!
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class shl implements GetInstructionsFromOpcode 
{
    private String opcode;
    private String name;
   
    public shl(String opcode)
    {
        this.opcode=opcode;
        this.name = "SHL";
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