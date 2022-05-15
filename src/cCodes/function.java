//Author Gera Jahja, last update 15/05
package src.cCodes;

public class function {
    String main;
    String end;
    String functioncall;
    public function() {
        this.main="int main (int argc, char **argv) {\n";
        this.end="\n}";
    }
    public function(String goto_) {
        this.functioncall="goto "+goto_+";";
    }
    public String getMain() {
        return main;
    } 
    
    public String getFunctionCall() {
        return functioncall;
    }
 
    public String getEnd() {
        return end;
    }
}
