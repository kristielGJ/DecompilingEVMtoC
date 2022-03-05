//Author Gera Jahja
package src.opcodes;
/*  mem[retOst:retOst+retLen] := returndata
    Stack no.F4
    Last update: 04/03,05/03
    F6-F9 and FB-FC are invalid
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class delegatecall implements GetInstructionsFromOpcode 
{
    private String opcode;
    private String name;
   
    public delegatecall(String opcode)
    {
        this.opcode=opcode;
        this.name = "DELEGATECALL";
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