//Author Gera Jahja
package src.opcodes;
/*  read word from msg data at index idx
    Stack no.35
    Last update: 03/03,05/03
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class calldataload implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public calldataload()
    {
        this.opcode=0x35;
        this.name = "CALLDATALOAD";
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
