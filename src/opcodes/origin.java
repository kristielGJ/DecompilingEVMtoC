//Author Gera Jahja
package src.opcodes;
/*  address that originated the tx
    Stack no. 32
    Last update: 03/03,05/03
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class origin implements GetInstructionsFromOpcode 
{
    private String opcode;
    private String name;
   
    public origin(String opcode)
    {
        this.opcode=opcode;
        this.name = "ORIGIN";
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
