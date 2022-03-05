//Author Gera Jahja
package src.opcodes;
/*  return mem[ost:ost+len]
    Stack no.F3
    Last update: 04/03,05/03
    F6-F9 and FB-FC are invalid
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class return_ implements GetInstructionsFromOpcode 
{
    private String opcode;
    private String name;
   
    public return_(String opcode)
    {
        this.opcode=opcode;
        this.name = "RETURN";
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
