package Ensa.TD_DevoirLibre;

import java.util.ArrayList;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
    	
        Banque bank1 = new Banque("1","Marrakech");
        Banque bank2 = new Banque("2","Marrakech");

        Client client1 = new Client(1,"name1","surname1","address1","phone1","email1");
        Client client2 = new Client(2,"name2","surname2","address2","phone2","email2");
        Client client3 = new Client(3,"name3","surname3","address3","phone3","email3");
        
        Compte account1 = new Compte(1,500,client1,bank1);
        Compte account2 = new Compte(2,1000,client2,bank2);
//        Compte account3 = new Compte(3,1500,client3,bank2);
        
        List<Compte> accounts = new ArrayList<>();
        
        accounts.add(account1);
        accounts.add(account2);
//        accounts.add(account3);
       
        Transaction transaction = new Transaction(accounts);
        
        System.out.println(transaction.getType());
        System.out.println(client1);
        System.out.println(client1.toJson());
        System.out.println(client1.fromJson(client1.toJson()));

    }
}
