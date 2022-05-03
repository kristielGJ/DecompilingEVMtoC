//Author Gera Jahja
package src.opcodes;
/*  logical shift right
    Stack no.1C
    Last update: 03/03,05/03
    Stack no 1E-1F are invalid!
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class shr implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public shr()
    {
        this.opcode=0x1C;
        this.name = "SHR";
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

