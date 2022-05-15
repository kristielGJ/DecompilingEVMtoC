//Author Gera Jahja
package src.opcodes;
import src.interfaces.*;
/*  Last update: 24/04,01/05
    A0 =  LOG0 (LOG0(memory[ost:ost+len]))
    A1 =  LOG1 (LOG1(memory[ost:ost+len], topic0))
    ...etc
    
    A0	LOG0 (LOG0(memory[ost:ost+len]))
    A1	LOG1 (LOG1(memory[ost:ost+len], topic0))
    A2	LOG2 (LOG1(memory[ost:ost+len], topic0, topic1))
    A3	LOG3 (LOG1(memory[ost:ost+len], topic0, topic1, topic2))
    A4	LOG4 (LOG1(memory[ost:ost+len], topic0, topic1, topic2, topic3))
    A5-EF are invalid
*/
public class log implements GetInstructionsFromOpcode {

    private int opcode;
    private String opcodeHex;
    private String name;
    private int opnumber;
    public log(int opcodenumber)
    {
        this.opnumber=opcodenumber;
        this.opcodeHex="a"+Integer.toHexString(opcodenumber);
        this.opcode=Integer.parseInt(opcodeHex,16);
        this.name = "LOG"+String.valueOf(opcodenumber);
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
    public int getOpcodeNo() 
    {
        return opnumber;
    }
   
    public String getName()
    {
        return this.name;
    }
   
    @Override
    public String accept(Dissasemble visitor,int orderNo) 
    {
        return visitor.visit(this,orderNo);
    }
}
