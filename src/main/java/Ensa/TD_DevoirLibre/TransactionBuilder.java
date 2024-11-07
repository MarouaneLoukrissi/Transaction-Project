package Ensa.TD_DevoirLibre;

import java.util.Date;
import java.util.List;

public class TransactionBuilder {

	private Type type;
    private Date timeStump;
    private String reference;
    private List<Compte> comptes;
    
    public TransactionBuilder type(Type type){
        this.type =  type;
        return this;
    }

    public TransactionBuilder timestump(Date timeStump){
        this.timeStump = timeStump;
        return this;
    }

    public TransactionBuilder reference(String reference){
        this.reference = reference;
        return this;
    }

    public TransactionBuilder comptes(List<Compte> comptes){
        this.comptes = comptes;
        return this;
    }

    public Transaction build(){
        return null;
    }
}
