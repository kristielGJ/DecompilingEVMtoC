//Author Gera Jahja
package src.opcodes;
/*  gas price of tx, in wei per unit gas **
    Stack no.3A
    Last update: 03/03,05/03,01/05
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class gasprice implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public gasprice()
    {
        this.opcode=0x3A;
        this.name = "GASPRICE";
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
