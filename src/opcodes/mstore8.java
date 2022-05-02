//Author Gera Jahja
package src.opcodes;
/*  write a single byte to memory
    Stack no.53
    Last update: 04/03,05/03
    5C-5F are invalid
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class mstore8 implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public mstore8()
    {
        this.opcode=0x53;
        this.name = "MSTORE8";
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
