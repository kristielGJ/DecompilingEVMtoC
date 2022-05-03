package src.cCodes;

public class returnVal {
    String returnStatement;
    String exitStatement;
    
    //return string
    public returnVal(String val){
        this.returnStatement= "return"+val+";\n";

    }
    //return integer
    public returnVal(int val){
        this.returnStatement= "return "+val+";\n";
        this.exitStatement = "exit(0);\n";

    }
    public String getReturnStatement() {
        return returnStatement;
    }
    public String getExitStatement() {
        return exitStatement;
    }
    
}
