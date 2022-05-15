//Author Gera Jahja
package src.opcodes;
import src.interfaces.*;
/*  bitwise XOR
    Stack no. 18
    Last update: 03/03, 05/03,01/05
    Test: Passed Dissasembly test! 05/03
*/
 
public class xor implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public xor( )
    {
        this.opcode=0x18;
        this.name = "XOR";
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
