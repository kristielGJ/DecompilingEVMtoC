//Author Gera Jahja, last update 15/05

package src.cCodes;

public class assertVal {
    String assertCall;
    
    public assertVal(String assertThis){
        this.assertCall="assert("+assertThis+");";
    }

    public String getAssertCall() {
        return assertCall;
    }

    
}
