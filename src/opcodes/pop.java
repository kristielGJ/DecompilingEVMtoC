//Author Gera Jahja
package src.opcodes;
/*  remove item from top of stack and discard it
    Stack no.50
    Last update: 04/03,05/03
    5C-5F are invalid
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class pop implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public pop()
    {
        this.opcode=0x50;
        this.name = "POP";
    }
    private String cCode;
    public String getC()
    {
        return this.cCode;
    }
    public void setC(String cCode) {
        this.cCode = cCode;
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
