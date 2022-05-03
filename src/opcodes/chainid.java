//Author Gera Jahja
package src.opcodes;
/*  push current chain id onto stack
    Stack no.46
    Last update: 04/03,05/03
    49-4F are invalid
*/ 
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class chainid implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public chainid()
    {
        this.opcode=0x46;
        this.name = "CHAINID";
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
