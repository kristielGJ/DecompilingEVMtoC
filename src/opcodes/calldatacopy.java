//Author Gera Jahja
package src.opcodes;
/*  copy msg data
    Stack no.37
    Last update: 03/03,05/03
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class calldatacopy implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public calldatacopy()
    {
        this.opcode=0x37;
        this.name = "CALLDATACOPY";
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