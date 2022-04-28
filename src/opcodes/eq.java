//Author Gera Jahja
package src.opcodes;
/*  (u)int256 equality
    Stack no.14
    Last update: 03/03,05/03
*/
    
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class eq implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public eq()
    {
        this.opcode=0x14;
        this.name = "EQ";
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

