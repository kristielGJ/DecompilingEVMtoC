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

    public stack(String valstr,int val, String operator) {
        //before int main
        this.height="var stack[STACKHEIGHT];";//see define.java for STACKHEIGHT
        this.initialiseTop="int top;";

        //stack manipulation in main c function
        this.stackPopTop="--top;";
        this.stackElement="stack[top]";
        this.stackPushTop="++top;";
        this.assertStackHeight="top != STACKHEIGHT";
        this.assertStackNotEmpty="top >=0";
        this.stackOp="stack[top "+operator+" "+val+"]";
        this.stackVariable="stack[top] = "+valstr+";";
        this.incVal=valstr+"++;";
        
    }
   
    public String getHeight() {
        return height;
    }
    public void setHeight(String height) {
        this.height = height;
    }
    public String getStackPopTop() {
        return stackPopTop;
    }
    public void setStackPopTop(String stackPopTop) {
        this.stackPopTop = stackPopTop;
    }
    public String getStackElement() {
        return stackElement;
    }
    public void setStackElement(String stackElement) {
        this.stackElement = stackElement;
    }
    public String getStackPushTop() {
        return stackPushTop;
    }
    public void setStackPushTop(String stackPushTop) {
        this.stackPushTop = stackPushTop;
    }
    public String getInitialiseTop() {
        return initialiseTop;
    }
    public void setInitialiseTop(String initialiseTop) {
        this.initialiseTop = initialiseTop;
    }
    public String getStackVariable() {
        return stackVariable;
    }
    public void setStackVariable(String stackVariable) {
        this.stackVariable = stackVariable;
    }
    public String getAssertStackHeight() {
        return assertStackHeight;
    }
    public void setAssertStackHeight(String assertStackHeight) {
        this.assertStackHeight = assertStackHeight;
    }
    public String getAssertStackNotEmpty() {
        return assertStackNotEmpty;
    }
    public void setAssertStackNotEmpty(String assertStackNotEmpty) {
        this.assertStackNotEmpty = assertStackNotEmpty;
    }
    public String getStackOp() {
        return stackOp;
    }
    public void setStackOp(String stackOp) {
        this.stackOp = stackOp;
    }
    
}
