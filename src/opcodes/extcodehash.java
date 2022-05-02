//Author Gera Jahja
package src.opcodes;
/*  hash = addr.exists ? keccak256(addr.code) : 0
    Stack no.3F
    Last update: 04/03,05/03
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class extcodehash implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public extcodehash()
    {
        this.opcode=0x3F;
        this.name = "EXTCODEHASH";
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

