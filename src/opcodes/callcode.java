//Author Gera Jahja
package src.opcodes;
/*  same as DELEGATECALL (delegatecall.java), but does not propagate original msg.sender and msg.value
    mem[retOst:retOst+retLen] = returndata
    Stack no.F2
    Last update: 04/03,05/03
    F6-F9 and FB-FC are invalid
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class callcode implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public callcode()
    {
        this.opcode=0xF2;
        this.name = "CALLCODE";
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
