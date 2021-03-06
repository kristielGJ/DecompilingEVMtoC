//Author Gera Jahja
package src.opcodes;
/*  balance of executing contract, in wei
    Stack no.47
    Last update: 04/03,05/03,01/05
    49-4F are invalid
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class selfbalance implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public selfbalance()
    {
        this.opcode=0x47;
        this.name = "SELFBALANCE";
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