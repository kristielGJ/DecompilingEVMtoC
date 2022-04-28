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
    private int opcode;
    private String name;
   
    public create()
    {
        this.opcode=0xF0;
        this.name = "CREATE";
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