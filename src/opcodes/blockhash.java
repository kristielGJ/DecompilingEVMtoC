//Author Gera Jahja
package src.opcodes;
/*  blockHash(blockNum)
    Stack no.40
    Last update: 04/03,05/03
    49-4F are invalid
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class blockhash implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public blockhash()
    {
        this.opcode=0x40;
        this.name = "BLOCKHASH";
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
    public String accept(Dissasemble visitor) 
    {
        return visitor.visit(this);
    }
}
