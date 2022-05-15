//Author Gera Jahja
package src.opcodes;
/*  return mem[ost:ost+len]
    Stack no.F3
    Last update: 04/03,05/03,01/05
    F6-F9 and FB-FC are invalid
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class return_ implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public return_()
    {
        this.opcode=0xF3;
        this.name = "RETURN";
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
