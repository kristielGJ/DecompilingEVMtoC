//Author Gera Jahja
package src.opcodes;
/*  address of executing contract
    Stack no. 30
    Last update: 03/03 ,05/03
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class address implements GetInstructionsFromOpcode 
{
    private String opcode;
    private String name;
   
    public address(String opcode)
    {
        this.opcode=opcode;
        this.name = "ADDRESS";
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

