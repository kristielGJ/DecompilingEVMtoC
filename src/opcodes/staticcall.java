//Author Gera Jahja
package src.opcodes;
import src.interfaces.*;
/*  mem[retOst:retOst+retLen] := returndata
    Stack no.FA
    Last update: 04/03, 05/03
    Test: Passed Dissasembly test! 05/03
    F6-F9 and FB-FC are invalid
*/
public class staticcall implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public staticcall()
    {
        this.opcode=0xFA;
        this.name = "STATICCALL";
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

