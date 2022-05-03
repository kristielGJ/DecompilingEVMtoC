package src.cCodes;

public class include {
    String includeAssert;
    String includeExit;

    public include() {
        this.includeExit ="#include <stdlib.h>\n#include <stdio.h>\n";
        this.includeAssert = "#include <assert.h>\n"+includeExit;
    }

    public String getIncludeAssert() {
        return includeAssert;
    }
    
}
