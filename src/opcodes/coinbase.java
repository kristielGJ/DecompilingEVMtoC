//Author Gera Jahja
package src.opcodes;
/*  address of miner of current block
    Stack no.41
    Last update: 04/03,05/03
    49-4F are invalid
*/ 
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class coinbase implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public coinbase()
    {
        this.opcode=0x41;
        this.name = "COINBASE";
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