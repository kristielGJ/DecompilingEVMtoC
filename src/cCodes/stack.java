package src.cCodes;

public class stack {
    String height;
    String stackPopTop;
    String stackElement;
    String stackPushTop;
    String initialiseTop;
    String stackVariable;
    String assertStackHeight;
    String assertStackNotEmpty;
    String stackOp;
    String incVal;
    String operationPop;

    public stack(String valstr,int val, String operator) {
        //before int main
        this.height="var stack[STACKHEIGHT];";//see define.java for STACKHEIGHT
        this.initialiseTop="int top;";

        //stack manipulation in main c function
        this.stackPopTop="--top;\n";
        this.stackElement="stack[top]";
        this.stackPushTop="++top;\n";
        this.assertStackHeight="top != STACKHEIGHT";
        this.assertStackNotEmpty="top >=0";
        this.stackOp="stack[top "+operator+" "+val+"]";
        this.stackVariable="stack[top] = "+valstr+";";
        this.incVal=valstr+"++;";
        this.operationPop="top-=2;\n";
    }
    public String getOperationPop() {
        return operationPop;
    }
    public String getHeight() {
        return height;
    }
    
    public String getStackPopTop() {
        return stackPopTop;
    }
    
    public String getStackElement() {
        return stackElement;
    }
    
    public String getStackPushTop() {
        return stackPushTop;
    }
    
    public String getInitialiseTop() {
        return initialiseTop;
    }
    
    public String getStackVariable() {
        return stackVariable;
    }
    
    public String getAssertStackHeight() {
        return assertStackHeight;
    }
    
    public String getAssertStackNotEmpty() {
        return assertStackNotEmpty;
    }
    
    public String getStackOp() {
        return stackOp;
    }
    
    
}
