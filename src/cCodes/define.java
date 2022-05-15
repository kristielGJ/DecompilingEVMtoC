//Author Gera Jahja, last update 15/05
package src.cCodes;

public class define {
    String defineStackHeight;
    String defineGasLimit;
    
    public define(int StackHeight, int GasLimit) {
        this.defineStackHeight = "#define STACKHEIGHT "+StackHeight+"\n";//stack height is 1024
        this.defineGasLimit = "#define GASLIMIT "+GasLimit+"\n";
    }

    public String getDefineStackHeight() {
        return defineStackHeight;
    }

    public String getDefineGasLimit() {
        return defineGasLimit;
    }

}
