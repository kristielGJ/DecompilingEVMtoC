//Author Gera Jahja
package src.opcodes;
/*  shift left
    Stack no.1B
    Last update: 03/03,05/03
    Stack no 1E-1F are invalid!
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class shl implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public shl()
    {
        this.opcode=0x1B;
        this.name = "SHL";
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