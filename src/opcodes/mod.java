//Author Gera Jahja
package src.opcodes;
/*  uint256 modulus
    Stack no.06
    Last update: 28/02,05/03
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class mod implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public mod()
    {
        this.opcode=0x06;
        this.name = "MOD";
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
