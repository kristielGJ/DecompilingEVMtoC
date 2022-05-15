//Author Gera Jahja, last update 15/05
package src.cCodes;

public class include {
    String includeAssert;
    String includeExit;

    public include() {
        this.includeExit ="#include <stdlib.h>\n#include <stdio.h>\n#include <math.h>\n#include <stdint.h>\n";
        this.includeAssert = "#include <assert.h>\n"+includeExit;
    }

    public String getIncludeAssert() {
        return includeAssert;
    }
    
}
