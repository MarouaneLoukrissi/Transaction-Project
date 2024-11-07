package Ensa.TD_DevoirLibre;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.ArrayList;
import  com.google.gson.Gson;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Transaction {
	private Type type;
	private Date timeStump;
	private String reference;
	private List<Compte> comptes;
	
	public Transaction(List<Compte> comptes) {
        this.timeStump = new Date();
        this.reference = generateReference();
        this.comptes = new ArrayList<>();
        addComptes(comptes);
        typeTransaction();
    }
	private String generateReference(){
        return UUID.randomUUID().toString();
    }

    public void addCompte(Compte compte){
        this.comptes.add(compte);
    }
    public void addComptes( List<Compte> comptes){
        for (Compte compte : comptes) {
            addCompte(compte);
        }
    }
    @Override
    public String toString() {
        return "Transaction{" +
                "type=" + type +
                ", timestump=" + timeStump +
                ", reference='" + reference + '\'' +
                '}';
    }
    public String toJson(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
    public static Transaction fromJson(String json) {
	    Gson gson = new Gson();
	    return gson.fromJson(json, Transaction.class);
	}
    public void typeTransaction(){
        if (this.comptes.size() == 2) {

            for (int i = 0; i < this.comptes.size() - 1 ; i++) {
                if (this.comptes.get(i).getBanque().getId().equals(this.comptes.get(i+1).getBanque().getId()))
                {
                	
                    this.type = Type.VIRINI;
                    
                } else if (this.comptes.get(i).getBanque().getPays().equals(this.comptes.get(i+1).getBanque().getPays()))
                {
                	
                    this.type = Type.VIREST;

                } else if ((!this.comptes.get(i).getBanque().getId().equals(this.comptes.get(i+1).getBanque().getId()))
                        && (!this.comptes.get(i).getBanque().getPays().equals(this.comptes.get(i+1).getBanque().getPays()))
                ) {

                    this.type = Type.VIRCHAC;

                }
                else{
                	
                    this.type = null;
                    
                }
            }
        }else if (this.comptes.size() > 2 ){

            this.type = Type.VIRMULTA;

        }else{
        	
            this.type = null;
            
        }
    }
    public TransactionBuilder build(){
    	
        return new TransactionBuilder();
        
    }
}
