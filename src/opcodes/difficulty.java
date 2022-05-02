//Author Gera Jahja
package src.opcodes;
/*  difficulty of current block
    Stack no.44
    Last update: 04/03,05/03
    49-4F are invalid
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class difficulty implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
   
    public difficulty()
    {
        this.opcode=0x44;
        this.name = "DIFFICULTY";
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