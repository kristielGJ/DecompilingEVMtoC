//Author Gera Jahja
package src.opcodes;
/*  size of memory in current execution context, in bytes
    Stack no.59
    Last update: 04/03,05/03
    5C-5F are invalid
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class msize implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public msize()
    {
        this.opcode=0x59;
        this.name = "MSIZE";
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