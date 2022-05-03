//Author Gera Jahja
package src.opcodes;
/*  int256 less-than
    Stack no.12
    Last update: 03/03,05/03
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class slt implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public slt()
    {
        this.opcode=0x12;
        this.name = "SLT";
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