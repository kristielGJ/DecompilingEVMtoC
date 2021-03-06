//Author Gera Jahja, last update 15/05
package src.cCodes;

public class variable {
   
    String variableName;
    String variableNameDef;
    String variableValue;
    String variableDefValue;
    String variable;
    String variableDef;
    String intvariable;
    String variableType;
    String variableType2;
    String noTypeVariable;

    //create a tmp (or customised name "variableDef") variable definition
    public variable(int tmpNo,String varName,String value,String unsigned) {
        this.variableName="tmp"+tmpNo;
        this.variableNameDef=varName;
        this.variableValue=" = "+value;
        this.variable="\t"+unsigned+"var "+variableName+variableValue+";\n";
        this.variableDef="var "+variableNameDef+";\n";
        this.variableDefValue="var "+variableNameDef+variableValue+";\n";
        this.intvariable="\tint "+variableName+variableValue+";\n";
        this.noTypeVariable="\t"+varName+variableValue+";\n";
    }

    //create a var type definition
    public variable(String type, String varextention) {
        this.variableType="typedef "+ type +" "+varextention+";\n";
        this.variableType2=type +" "+varextention+";\n";
    }
    

    public String getVariableName() {
        return variableName;
    } 
    public String getNoTypeVariable() {
        return noTypeVariable;
    }

    public String getVariableValue() {
        return variableValue;
    }

    public String getVariable() {
        return variable;
        
    } 
    public String getVariableDef() {
        return variableDef;
        
    }
    public String getVariableDefValue() {
        return variableDefValue;
        
    }

    public String getVariableType() {
        return variableType;

    }
    
    public String getVariableType2() {
        return variableType2;
    }
}
