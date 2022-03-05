package src.classes;
import src.interfaces.*;
import src.opcodes.*;

class visitOpCode implements Dissasemble
{
   
    @Override
    public String visit(add Add) 
    {
        System.out.println(Add.getOpcode() + "  "+ Add.getName());//output the instruction(Disassembly), used for decompilation
        return Add.getName();
    }
}
