//Author Gera Jahja
package src.opcodes;
/*  int256 modulus
    Stack no.07
    Last update: 28/02,05/03,01/05
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class smod implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public smod()
    {
        this.opcode=0x07;
        this.name = "SMOD";
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