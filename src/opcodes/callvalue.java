//Author Gera Jahja
package src.opcodes;
/*  msg value, in wei
    Stack no.34
    Last update: 03/03,05/03
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class callvalue implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public callvalue()
    {
        this.opcode=0x34;
        this.name = "CALLVALUE";
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
