//Author Gera Jahja
package src.opcodes;
/*  (u)int256 iszero
    Stack no.15
    Last update: 03/03,05/03
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class iszero implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public iszero()
    {
        this.opcode=0x15;
        this.name = "ISZERO";
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
