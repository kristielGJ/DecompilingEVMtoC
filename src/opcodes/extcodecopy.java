//Author Gera Jahja
package src.opcodes;
/*  copy code from addr
    Stack no.3C
    Last update: 03/03,05/03
*/  
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class extcodecopy implements GetInstructionsFromOpcode 
{
    private String opcode;
    private String name;
   
    public extcodecopy(String opcode)
    {
        this.opcode=opcode;
        this.name = "EXTCODECOPY";
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