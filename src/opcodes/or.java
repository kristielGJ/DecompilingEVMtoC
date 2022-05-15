//Author Gera Jahja
package src.opcodes;
/*  bitwise OR
    Stack no. 17
    Last update: 03/03,05/03,01/05
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class or implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public or()
    {
        this.opcode=0x17;
        this.name = "OR";
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