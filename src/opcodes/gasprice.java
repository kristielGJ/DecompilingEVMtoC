//Author Gera Jahja
package src.opcodes;
/*  gas price of tx, in wei per unit gas **
    Stack no.3A
    Last update: 03/03,05/03
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class gasprice implements GetInstructionsFromOpcode 
{
    private String opcode;
    private String name;
   
    public gasprice(String opcode)
    {
        this.opcode=opcode;
        this.name = "GASPRICE";
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
