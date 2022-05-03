//Author Gera Jahja
package src.opcodes;
/*  destroy contract and sends all funds to addr
    Stack no.FF
    Last update: 04/03,05/03
    F6-F9 and FB-FC are invalid
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class selfdestruct implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public selfdestruct()
    {
        this.opcode=0xFF;
        this.name = "SELFDESTRUCT";
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
