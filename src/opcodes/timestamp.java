//Author Gera Jahja
package src.opcodes;
import src.interfaces.*;
/*  timestamp of current block
    Stack no.42
    Last update: 04/03,05/03,01/05
    Test: Passed Dissasembly test! 05/03
    49-4F are invalid
*/

public class timestamp implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public timestamp()
    {
        this.opcode=0x42;
        this.name = "TIMESTAMP";
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
