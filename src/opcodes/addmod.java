//Author Gera Jahja
package src.opcodes;
/*  (u)int256 addition modulo N
    Stack no.08
    Last update: 28/02,05/03
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class addmod implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public addmod()
    {
        this.opcode=0x08;
        this.name = "ADDMOD";
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