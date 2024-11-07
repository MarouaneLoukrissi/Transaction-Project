package Ensa.TD_DevoirLibre;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.ArrayList;
import  com.google.gson.Gson;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
	private int numClient;
	private String nom;
	private String prenom;
	private String adresse;
	private String phone;
	private String email;
	private List<Compte> comptes;
	
	public Client(int numClient, String nom,String prenom, String adresse, String phone, String email){
        this.numClient = numClient;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.phone = phone;
        this.email = email;
        this.comptes = new ArrayList<>();
    }
	public void addCompte(Compte compte){
        comptes.add(compte);
    }
	@Override
    public String toString() {
        return "Client{" +
                "numClient=" + numClient +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
	public String toJson(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
	public static Client fromJson(String json) {
	    Gson gson = new Gson();
	    return gson.fromJson(json, Client.class);
	}
}