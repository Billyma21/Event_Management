package poo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class EvenementTest {

    @Test
    public void testRegisterMember() {
        // Crée un membre avec un solde suffisant
        Member member = new Member("Bob", "Sull", 'h', "bob");
        member.setMoney(100.0);

        // Crée un événement avec un prix de 30.0
        Evenement event = new Evenement("Concert", "2023-04-24T18:30", 30.0);

        // Inscrit le membre à l'événement
        event.register(member);

        // Vérifie que le membre est bien enregistré dans l'événement
        assertTrue(event.getMembers().contains(member));
        
        // Vérifie que l'événement est bien ajouté à la liste des événements du membre
        assertTrue(member.getEvents().contains(event));

        // Affiche les informations pour vérification
        System.out.println("Membre enregistré: " + member);
        System.out.println("Événements du membre: " + member.getEvents());
        System.out.println("Membres inscrits à l'événement: " + event.getMembers());
    }

    @Test
    public void testInsufficientBalance() {
        // Crée un membre avec un solde insuffisant
        Member member = new Member("Bob", "Sull", 'h', "bob");
        member.setMoney(10.0);

        // Crée un événement avec un prix supérieur au solde du membre
        Evenement event = new Evenement("Concert", "2023-04-24T18:30", 30.0);

        // Vérifie que l'inscription lance l'exception attendue
        assertThrows(InsufficientBalanceException.class, () -> {
            event.register(member);
        });

        // Affiche un message pour indiquer que l'exception a été levée
        System.out.println("Exception InsufficientBalanceException levée comme prévu pour le membre: " + member);
    }
}
