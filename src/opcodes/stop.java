//Author Gera Jahja
package src.opcodes;
import src.interfaces.*;
/*  This command halts the execution
    Stack no.00 
    Last update: 28/02, 05/03
    Test: Passed Dissasembly test! 05/03
*/
public class stop implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public stop()
    {
        this.opcode=0x00;
        this.name = "STOP";
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
