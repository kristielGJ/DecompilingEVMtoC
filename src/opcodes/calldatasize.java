//Author Gera Jahja
package src.opcodes;
/*  length of msg data, in bytes
    Stack no.36
    Last update: 03/03,05/03
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class calldatasize implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public calldatasize()
    {
        this.opcode=0x36;
        this.name = "CALLDATASIZE";
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

