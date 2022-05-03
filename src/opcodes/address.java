//Author Gera Jahja
package src.opcodes;
/*  address of executing contract
    Stack no. 30
    Last update: 03/03 ,05/03
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class address implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
    private String cCode;

    public address()
    {
        this.opcode=0x30;
        this.name = "ADDRESS";
    }
   
    public int getOpcode() 
    {
        return opcode;
    }
   
    public String getName()
    {
        return this.name;
    }

    public String getC()
    {
        return this.cCode;
    }
    public void setC(String cCode) {
        this.cCode = cCode;
    }
    @Override
    public String accept(Dissasemble visitor,int orderNo) 
    {
        return visitor.visit(this,orderNo);
    }
}

