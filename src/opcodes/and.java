//Author Gera Jahja
package src.opcodes;
/*  bitwise AND
    Stack no. 16
    Last update: 03/03,05/03
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class and implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;   
    private String cCode;

    public and()
    {
        this.opcode=0x16;
        this.name = "AND";
    }
   
    public int getOpcode() 
    {
        return opcode;
    }
   
    public String getName()
    {
        return this.name;
    }

    public String getC()
    {
        return this.cCode;
    }
    public void setC(String cCode) {
        this.cCode = cCode;
    }
   
    @Override
    public String accept(Dissasemble visitor,int orderNo) 
    {
        return visitor.visit(this,orderNo);
    }
}
