//Author Gera Jahja
package src.opcodes;
/*  blockHash(blockNum)
    Stack no.40
    Last update: 04/03,05/03
    49-4F are invalid
*/
import src.interfaces.*;
/* 
    Test: Passed Dissasembly test! 05/03
*/
public class blockhash implements GetInstructionsFromOpcode 
{
    private String opcode;
    private String name;
   
    public blockhash(String opcode)
    {
        this.opcode=opcode;
        this.name = "BLOCKHASH";
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
