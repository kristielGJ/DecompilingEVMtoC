//Author Gera Jahja
package src.opcodes;
/*  addr = keccak256(0xff ++ address(this) ++ salt ++ keccak256(mem[ost:ost+len]))[12:]
    Stack no.F5
    Last update: 04/03,05/03,01/05
    F6-F9 and FB-FC are invalid
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class create2 implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public create2()
    {
        this.opcode=0xF5;
        this.name = "CREATE2";
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
