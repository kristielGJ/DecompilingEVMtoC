//Author Gera Jahja
package src.opcodes;
import src.interfaces.*;

/*  (u)int256 addition modulo 2**256
    Stack no. 01 (op code is 01)
    Last update: 28/02, 05/03,01/05
    Test: Passed Dissasembly test! 05/03
*/
public class add implements GetInstructionsFromOpcode 
{
    private int opcode;
    private String name;
    private String cCode;
   
    public add()
    {
        this.opcode=0x01;
        this.name = "ADD";
//        this.cCode = "{\n\tvar tmp1 = stack[top - 2];\n\tvar tmp2 = stack[top - 1];\n\t var tmp3 = tmp1 + tmp2;\n\tstack[top] = tmp3;\n\t++top;\n\tassert(top != STACKHEIGHT);\n\tgasUsed++;\n\tassert(gasUsed < gasLimit);\n}";
    }
    public int getOpcode() 
    {
        return opcode;
    }
   
    public String getName()
    {
        return this.name;
    }
    public String getC()
    {
        return this.cCode;
    }
    public void setC(String cCode) {
        this.cCode = cCode;
    }
    @Override
    public String accept(Dissasemble visitor,int orderNo) 
    {
        return visitor.visit(this,orderNo);
    }

    
   
}
