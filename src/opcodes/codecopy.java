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
    private String opcode;
    private String name;
   
    public codecopy(String opcode)
    {
        this.opcode=opcode;
        this.name = "CODECOPY";
    }
   
    public String getOpcode() 
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
