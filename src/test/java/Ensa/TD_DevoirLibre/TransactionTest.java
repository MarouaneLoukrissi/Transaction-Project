package Ensa.TD_DevoirLibre;

import com.google.gson.Gson;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TransactionTest {

    List<Compte> comptes = new ArrayList<>();
    Transaction transaction = new Transaction(comptes);

    @Test
    public void testGenererReference() {
        String reference = transaction.getReference();
        assertNotNull(reference);
        assertFalse(reference.isEmpty());
    }

    @Test
    public void addCompte(){
        Banque banque1 = new Banque("1","Morocco");
        Client client1 = new Client(1,"nom1","prenom1","addresse1","phone1","email1");
        Compte compte = new Compte(1,1000,client1,banque1);
        transaction.addCompte(compte);
        assertEquals(1,transaction.getComptes().size());
        assertTrue(transaction.getComptes().contains(compte));
    }

    @Test
    public void testTransactionVIRINI(){
        Banque banque1 = new Banque("1","Morocco");
        Banque banque2 = new Banque("1","France");
        Client client1 = new Client(1,"nom1","prenom1","addresse1","phone1","email1");
        Client client2 = new Client(2,"nom2","prenom2","addresse2","phone2","email2");
        Compte compte1 = new Compte(1,1000,client1,banque1);
        Compte compte2 = new Compte(2,1500,client2,banque2);
        transaction.addCompte(compte1);
        transaction.addCompte(compte2);
        transaction.typeTransaction();
        assertEquals(Type.VIRINI,transaction.getType());
    }

    @Test
    public void testTransactionVIREST(){
        Banque banque1 = new Banque("1","Morocco");
        Banque banque2 = new Banque("2","Morocco");
        Client client1 = new Client(1,"nom1","prenom1","addresse1","phone1","email1");
        Client client2 = new Client(2,"nom2","prenom2","addresse2","phone2","email2");
        Compte compte1 = new Compte(1,1000,client1,banque1);
        Compte compte2 = new Compte(2,1500,client2,banque2);
        transaction.addCompte(compte1);
        transaction.addCompte(compte2);
        transaction.typeTransaction();
        assertEquals(Type.VIREST,transaction.getType());
    }

    @Test
    public void testTransactionVICHAC(){
        Banque banque1 = new Banque("1","Morocco");
        Banque banque2 = new Banque("2","France");
        Client client1 = new Client(1,"nom1","prenom1","addresse1","phone1","email1");
        Client client2 = new Client(2,"nom2","prenom2","addresse2","phone2","email2");
        Compte compte1 = new Compte(1,1000,client1,banque1);
        Compte compte2 = new Compte(2,1500,client2,banque2);
        transaction.addCompte(compte1);
        transaction.addCompte(compte2);
        transaction.typeTransaction();
        assertEquals(Type.VIRCHAC,transaction.getType());
    }
    @Test
    public void testTransactionVIMULTA(){
        Banque banque1 = new Banque("1","Morocco");
        Banque banque2 = new Banque("2","France");
        Client client1 = new Client(1,"nom1","prenom1","addresse1","phone1","email1");
        Client client2 = new Client(2,"nom2","prenom2","addresse2","phone2","email2");
        Client client3 = new Client(3,"nom3","prenom3","addresse3","phone3","email3");
        Compte compte1 = new Compte(1,500,client1,banque1);
        Compte compte2 = new Compte(2,1000,client2,banque1);
        Compte compte3 = new Compte(2,1500,client3,banque2);
        transaction.addCompte(compte1);
        transaction.addCompte(compte2);
        transaction.addCompte(compte3);
        transaction.typeTransaction();
        assertEquals(Type.VIRMULTA,transaction.getType());
    }

    @Test
    public void testtoStrig(){
        String excepted = "Transaction{" +
                "type=" + transaction.getType() +
                ", timestump=" + transaction.getTimeStump() +
                ", reference='" + transaction.getReference() + '\'' +
                '}';
        assertEquals(excepted,transaction.toString());
    }

    @Test
    public void testtoJson(){
        Gson gson = new Gson();
        String excepted = gson.toJson(transaction);
        assertEquals(excepted,transaction.toJson());
    }

}