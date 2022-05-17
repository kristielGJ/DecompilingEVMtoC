package src.cCodes;

public class account {
    String createAccount;
    String structPairs;
    String defAccounts;

    public account(){
        this.createAccount="\taccounts[accountNo] = (struct numpair){accountNo, 0.0};\n\taccountNo++;";
    }

    public String getCreateAccount() {
        return createAccount;
    }


    public String getStructPairs() {
        return structPairs;
    }

  
    public String getDefAccounts() {
        return defAccounts;
    }

}