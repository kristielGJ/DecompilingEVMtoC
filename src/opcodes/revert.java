//Author Gera Jahja
package src.opcodes;
/*  revert(mem[ost:ost+len])
    Stack no.FD
    Last update: 04/03,05/03
    F6-F9 and FB-FC are invalid
*/
import src.interfaces.*;
 /* 
     Test: Passed Dissasembly test! 05/03
 */
public class revert implements GetInstructionsFromOpcode 
 {
     private int opcode;
     private String name;
    
     public revert()
     {
         this.opcode=0xFD;
         this.name = "REVERT";
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