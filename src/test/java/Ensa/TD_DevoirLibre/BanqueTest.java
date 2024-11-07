package Ensa.TD_DevoirLibre;

import  com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class BanqueTest {
	
	Banque banque = new Banque("121","USA") ;

  @Test
  public void testConstructeur(){

      assertEquals("121",banque.getId());
      assertEquals("USA",banque.getPays());
      assertTrue(banque.getComptes().isEmpty());
      assertNotNull(banque.getComptes());
      
  }

  @Test
  public void testSetId(){
      banque.setId("212");
      assertEquals("212",banque.getId());
  }

  @Test
  public void testSetPays(){
      banque.setPays("USA");
      assertEquals("USA",banque.getPays());
  }

  @Test
  public void testToStrig(){
      String excepted = "Banque{id=911, pays='USA'}";
      assertEquals(excepted,banque.toString());
  }

  @Test
  public void testToJson(){
      Gson gson = new Gson();
      String excepted = gson.toJson(banque);
      assertEquals(excepted,banque.toJson());
  }
  
}
