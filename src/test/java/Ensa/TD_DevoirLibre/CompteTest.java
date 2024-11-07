package Ensa.TD_DevoirLibre;

import com.google.gson.Gson;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CompteTest {
	Client client = new Client();
    Banque banque = new Banque();
    Compte compte = new Compte(3,1500,client,banque);

    @Test
    public void testconstructeur(){
        assertEquals(3,compte.getNumCompte());
        assertEquals(1500,compte.getDevise());
        assertEquals(client,compte.getClient());
        assertEquals(banque,compte.getBanque());
        assertNotNull(compte.getTransactions());
        assertTrue(compte.getTransactions().isEmpty());

    }
    @Test
    public void testsetNumCompte(){
        compte.setNumCompte(1);
        assertEquals(1,compte.getNumCompte());

    }
    @Test
    public void testsetDevice(){
        compte.setDevise(1500);
        assertEquals(1500,compte.getDevise());

    }
    @Test
    public void testsetClient(){
        Client client1 = new Client();
        compte.setClient(client1);
        assertEquals(client1,compte.getClient());

    }
    @Test
    public void testsetBanque(){
        Banque banque1 = new Banque();
        compte.setBanque(banque1);
        assertEquals(banque1,compte.getBanque());

    }

    @Test
    public void testtoStrig(){
        String excepted = "Compte{" +
                "numCompte=" + compte.getNumCompte() +
                ", dateCreation=" + compte.getDateCreation() +
                ", dateUp=" + compte.getDateUpdate() +
                ", devise=" + compte.getDevise() +
                '}';
        assertEquals(excepted,compte.toString());
    }

    @Test
    public void testtoJson(){
        Gson gson = new Gson();
        String excepted = gson.toJson(compte);
        assertEquals(excepted,compte.toJson());
    }
}
