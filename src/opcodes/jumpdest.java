//Author Gera Jahja
package src.opcodes;
/*  a valid jump destination for example a jump destination not inside the push data
    Stack no.5B
    Last update: 04/03,05/03
    5C-5F are invalid
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class jumpdest implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public jumpdest()
    {
        this.opcode=0x5B;
        this.name = "JUMPDEST";
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
    public String accept(Dissasemble visitor,int orderNo) 
    {
        return visitor.visit(this,orderNo);
    }
   
}