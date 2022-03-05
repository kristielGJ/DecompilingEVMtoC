//Author Gera Jahja
package src.opcodes;
/*  ith byte of (u)int256 x, from the left
    Stack no. 1A
    Last update: 03/03,05/03
    Stack no 1E-1F are invalid!
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class bytee implements GetInstructionsFromOpcode 
{
    private String opcode;
    private String name;
   
    public bytee(String opcode)
    {
        this.opcode=opcode;
        this.name = "BYTE";
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