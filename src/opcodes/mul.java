//Author Gera Jahja
package src.opcodes;
import src.interfaces.*;

/*  (u)int256 multiplication modulo 2**256
    Stack no. 02
    Last update: 28/02, 05/03
    Test: Passed Dissasembly test! 05/03
*/
public class mul implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public mul()
    {
        this.opcode=0x02;
        this.name = "MUL";
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