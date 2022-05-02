//Author Gera Jahja
package src.opcodes;
import src.interfaces.*;
/*  write word from storage
    Stack no.55
    Last update: 04/03, 05/03
    Test: Passed Dissasembly test! 05/03
    5C-5F are invalid
*/
public class sstore implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public sstore()
    {
        this.opcode=0x55;
        this.name = "SSTORE";
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
