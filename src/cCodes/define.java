//Author Gera Jahja, last update 15/05
package src.cCodes;

public class define {
    String defineStackHeight;
    String defineGasLimit;
    String defineMemLimit;
    
    public define(int StackHeight, int GasLimit,int memLim) {
        this.defineStackHeight = "#define STACKHEIGHT "+StackHeight+"\n";//stack height is 1024
        this.defineGasLimit = "#define GASLIMIT "+GasLimit+"\n";
        this.defineMemLimit = "#define MEMORYSIZE "+memLim+"\n";
    }

    public String getDefineStackHeight() {
        return defineStackHeight;
    }

    public String getDefineGasLimit() {
        return defineGasLimit;
    }
    public String getdefineMemLimit() {
        return defineMemLimit;
    }
}
