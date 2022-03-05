//Author Gera Jahja
package src.opcodes;
/*  balance, in wei
    Stack no. 31
    Last update: 03/03,05/03
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class balance implements GetInstructionsFromOpcode 
{
    private String opcode;
    private String name;
   
    public balance(String opcode)
    {
        this.opcode=opcode;
        this.name = "BALANCE";
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

