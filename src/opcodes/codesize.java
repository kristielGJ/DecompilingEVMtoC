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
    private String opcode;
    private String name;
   
    public codesize(String opcode)
    {
        this.opcode=opcode;
        this.name = "CODESIZE";
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