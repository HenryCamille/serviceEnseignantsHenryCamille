package champollion;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class ChampollionJUnitTest {
	Enseignant untel;
	UE uml, java;
        Salle salle1;
        
		
	@BeforeEach
	public void setUp() {
		untel = new Enseignant("untel", "untel@gmail.com");
		uml = new UE("UML");
		java = new UE("Programmation en java"); 
	}
	

	@Test
	public void testNouvelEnseignantSansService() {
		assertEquals(0, untel.heuresPrevues(),
                        "Un nouvel enseignant doit avoir 0 heures prévues");
	}
	
	@Test
	public void testAjouteHeures() {
                // 10h TD pour UML
		untel.ajouteEnseignement(uml, 0, 10, 0);
                untel.ajouteEnseignement(java, 0, 5, 0);

		assertEquals(10, untel.heuresPrevuesPourUE(uml),
                        "L'enseignant doit maintenant avoir 10 heures prévues pour l'UE 'uml'");
                assertEquals(15, untel.heuresPrevues(),
                        "L'enseignant doit maintenant avoir 15 heures prévues");

                // 20h TD pour UML
                untel.ajouteEnseignement(uml, 0, 20, 0);
                untel.ajouteEnseignement(java, 0, 3, 0);
                
		assertEquals(10 + 20, untel.heuresPrevuesPourUE(uml),
                         "L'enseignant doit maintenant avoir 30 heures prévues pour l'UE 'uml'");
                assertEquals(10 + 20 + 5 + 3, untel.heuresPrevues(),
                         "L'enseignant doit maintenant avoir 38 heures prévues");
		
	}
        
        @Test
        public void testAjouteIntervention(){
            Date date = new Date();
            Intervention intervention = new Intervention(untel, salle1, uml, 2, date);
            untel.ajouteIntervention(intervention);
            assertFalse(untel.getIntervention().isEmpty());
        }
	
        
        @Test
        public void testEnSousService(){
            Date date = new Date();
            Intervention intervention = new Intervention(untel, salle1, uml, 2, date);
            untel.ajouteIntervention(intervention);
            Intervention intervention2 = new Intervention(untel, salle1, uml, 3, date);
            Intervention intervention3 = new Intervention(untel, salle1, java, 2, date);
            intervention.setTypeIntervention(TypeIntervention.TP);
            intervention2.setTypeIntervention(TypeIntervention.TD);
            intervention3.setTypeIntervention(TypeIntervention.CM);
            untel.ajouteIntervention(intervention2);
            untel.ajouteIntervention(intervention3);
            untel.ajouteEnseignement(uml, 0, 10, 0);
            assertTrue(untel.enSousService(), "L'enseignant est en sous service");
            
          
        }
}
