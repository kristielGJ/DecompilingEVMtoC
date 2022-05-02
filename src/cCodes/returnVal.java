package src.cCodes;

public class returnVal {
    String returnStatement;
    
    //return string
    public returnVal(String val){
        this.returnStatement= "return"+val+";\n";

    }
    //return integer
    public returnVal(int val){
        this.returnStatement= "return "+val+";\n";

    }
    public String getReturnStatement() {
        return returnStatement;
    }
    
}
