//Author Gera Jahja
package src.opcodes;
/*  mem[retOst:retOst+retLen] := returndata
    Stack no.F1
    Last update: 04/03,05/03
    F6-F9 and FB-FC are invalid
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class call implements GetInstructionsFromOpcode 
{
    private String opcode;
    private String name;
   
    public call(String opcode)
    {
        this.opcode=opcode;
        this.name = "CALL";
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