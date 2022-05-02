//Author Gera Jahja
package src.opcodes;
/*  copy code from addr
    Stack no.3C
    Last update: 03/03,05/03
*/  
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class extcodecopy implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public extcodecopy()
    {
        this.opcode=0x3C;
        this.name = "EXTCODECOPY";
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