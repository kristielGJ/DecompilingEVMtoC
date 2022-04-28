//Author Gera Jahja
package src.opcodes;
/*  write a word to memory
    Stack no.52
    Last update: 04/03,05/03
    5C-5F are invalid
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class mstore implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public mstore()
    {
        this.opcode=0x52;
        this.name = "MSTORE";
    }
   
    public int getOpcode() 
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
