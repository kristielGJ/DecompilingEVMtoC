//Author Gera Jahja
package src.opcodes;
/*  write a single byte to memory
    Stack no.53
    Last update: 04/03,05/03
    5C-5F are invalid
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class mstore8 implements GetInstructionsFromOpcode 
{
    private String opcode;
    private String name;
   
    public mstore8(String opcode)
    {
        this.opcode=opcode;
        this.name = "MSTORE8";
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
