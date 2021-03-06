//Author Gera Jahja
package src.opcodes;
/*  keccak256(mem[ost:ost+len])
    Stack no.20
    Last update: 03/03,05/03,01/05
    21-2F are invalid!
*/
import src.interfaces.*;

// Test: Passed Dissasembly test! 05/03

public class sh3 implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public sh3()
    {
        this.opcode=0x20;
        this.name = "SHA3";
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
