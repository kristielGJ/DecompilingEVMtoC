//Author Gera Jahja
package src.opcodes;
/*  copy executing contract's bytecode
    mem[dstOst:dstOst+len] := this.code[ost:ost+len]
    Stack no. 39
    Last update: 03/03,05/03
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class codecopy implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public codecopy()
    {
        this.opcode=0x39;
        this.name = "CODECOPY";
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
