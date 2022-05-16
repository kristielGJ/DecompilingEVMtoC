package src.cCodes;

public class structs {
/*
\nstruct pair {\n\tvar location;\n\tvar value;\n};
\nstruct numpair {\n\tint address;\n\tdouble balance;\n};

struct pair memory[MEMORYSIZE] = {};
\nstruct pair storage[MEMORYSIZE] = {};
\nstruct numpair accounts[MEMORYSIZE] = {};

*/
    String pair;
    String numpair;
    String memory;
    String storage;
    String accounts;

    public structs() {
        this.pair = "\nstruct pair {\n\tvar location;\n\tvar value;\n};";
        this.numpair = "\nstruct numpair {\n\tint address;\n\tdouble balance;\n};\n";
        this.memory = "\nstruct pair memory[MEMORYSIZE] = {};";
        this.storage = "\nstruct pair storage[MEMORYSIZE] = {};";
        this.accounts = "\nstruct numpair accounts[MEMORYSIZE] = {};";
    }
    
    public String getPair() {
        return pair;
    }
    public String getNumpair() {
        return numpair;
    }
    public String getMemory() {
        return memory;
    }
    public String getStorage() {
        return storage;
    }
    public String getAccounts() {
        return accounts;
    }
  
}
