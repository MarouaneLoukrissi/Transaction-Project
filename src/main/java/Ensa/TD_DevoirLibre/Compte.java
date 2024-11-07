package Ensa.TD_DevoirLibre;

import java.util.Date;
import java.util.List;
import com.google.gson.Gson;
import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Compte {
	private int numCompte;
	private Date dateCreation;
	private Date dateUpdate;
	private double devise;
	private Client client;
	private List<Transaction> transactions;
	private Banque banque;
	
    public Compte(int numCompte, double devise, Client client, Banque banque) {
        this.numCompte = numCompte;
        this.dateCreation = new Date();
        this.dateUpdate = new Date();
        this.devise = devise;
        this.client = client;
        this.banque = banque;
        this.transactions = new ArrayList<>();
    }
    @Override
    public String toString() {
        return "Compte{" +
                "numCompte=" + numCompte +
                ", dateCreation=" + dateCreation +
                ", dateUp=" + dateUpdate +
                ", devise=" + devise +
                '}';
    }
    public String toJson(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
    public static Compte fromJson(String json) {
	    Gson gson = new Gson();
	    return gson.fromJson(json, Compte.class);
	}
    
    public void UpdateDate(){
        this.dateUpdate = new Date();
    }
}