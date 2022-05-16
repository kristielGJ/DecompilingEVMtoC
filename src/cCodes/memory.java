//Author Gera Jahja, last update 15/05
package src.cCodes;

public class memory {
    String mLoad;
    String mStore;
    public memory(){
        this.mLoad="\tint i;\n\tfor (i = 0; i <= memPoint; i++)\n\t{\n\t\tif (memory[i].location == stack[top-1])\n\t\t{\n\t\t\tstack[top]= memory[i].value;\n\t\t\ttop++;\n\t\t}\n\t}\n";
        this.mStore="\tmemory[memPoint] = (struct pair){stack[top-1],stack[top-2] };\n\ttop-=2;\n\tmemPoint++;\n";
    }
    public String getmLoad() {
        return mLoad;
    }
    
    public String getmStore() {
        return mStore;
    }
    
}
