package Ensa.TD_DevoirLibre;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import  com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Banque {
	private String id;
	private String pays;
	private List<Compte> comptes;
	
	public Banque(String id, String pays) {
        this.id = id;
        this.pays = pays;
        this.comptes = new ArrayList<>();
    }
	public void addCompte(Compte compte){
        comptes.add(compte);
    }
	@Override
    public String toString() {
        return "Banque{" +
                "id=" + id +
                ", pays='" + pays + '\'' +
                '}';
    }
	
	public String toJson(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
	public static Banque fromJson(String json) {
	    Gson gson = new Gson();
	    return gson.fromJson(json, Banque.class);
	}
}
