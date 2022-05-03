package src.cCodes;

public class label {
    String labelName;
    String labelEnd;

    public label(int order) {
        this.labelName="\n label_"+order+" :\n {\n";
        this.labelEnd="\n }";
        //add gass model,etc

    }
    public String getLabelName() {
        return labelName;

    }public String getLabelEnd() {
        return labelEnd;
    }
}
