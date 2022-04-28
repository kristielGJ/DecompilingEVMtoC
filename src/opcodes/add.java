//Author Gera Jahja
package src.opcodes;
import src.interfaces.*;
/*  (u)int256 addition modulo 2**256
    Stack no. 01 (op code is 01)
    Last update: 28/02, 05/03 
    Test: Passed Dissasembly test! 05/03
*/
public class add implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public add()
    {
        this.opcode=0x01;
        this.name = "ADD";
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
