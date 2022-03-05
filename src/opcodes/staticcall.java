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
    private String opcode;
    private String name;
   
    public staticcall(String opcode)
    {
        this.opcode=opcode;
        this.name = "STATICCALL";
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

