//Author Gera Jahja
package src.opcodes;
/*  length of executing contract's code, in bytes
    Stack no. 38
    Last update: 03/03,05/03
*/    
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class codesize implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public codesize()
    {
        this.opcode=0x38;
        this.name = "CODESIZE";
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