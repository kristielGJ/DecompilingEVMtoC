//Author Gera Jahja, last update 15/05
package src.cCodes;

public class storage {
    String sLoad;
    String sStore;
    public storage(){
        this.sLoad="\tint i;\n\tfor (i = 0; i <= storePoint; i++)\n\t{\n\t\tif (storage[i].location == stack[top-1])\n\t\t{\n\t\t\tstack[top]= storage[i].value;\n\t\t\ttop++;\n\t\t}\n\t}\n";
        this.sStore="\tstorage[storePoint] = (struct pair){stack[top-1],stack[top-2] };\n\ttop-=2;\n\tstorePoint++;\n";
    }
    public String getsLoad() {
        return sLoad;
    }
    
    public String getsStore() {
        return sStore;
    }
}
