//Author Gera Jahja
package src.opcodes;
/*  addr = keccak256(rlp([address(this), this.nonce]))
    Stack no.F0
    Last update: 04/03,05/03
    F6-F9 and FB-FC are invalid
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class create implements GetInstructionsFromOpcode 
{
    private String opcode;
    private String name;
   
    public create(String opcode)
    {
        this.opcode=opcode;
        this.name = "CREATE";
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