package poo;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Application {

    public static void main(String[] args) {
        // Créer un membre et un événement pour tester la sérialisation
        Member bob = new Member("Bob", "Sull", 'h', "bob");
        bob.setStatus(Status.VIP);

        Evenement concert = new Evenement("Concert", "2023-04-24T18:30:00", 30.0);
        concert.getMembers().add(bob);

        // Sauvegarde de l'événement dans un fichier XML
        String filename = "data/concert.xml";
        MyUtilities.saveEventToFile(concert, filename);

        // Vérification si le fichier a été créé
        Path filePath = Paths.get(filename);
        if (Files.exists(filePath)) {
            System.out.println("Le fichier existe : " + filePath.toAbsolutePath());
        } else {
            System.out.println("Le fichier n'existe pas : " + filePath.toAbsolutePath());
        }

        // Chargement de l'événement depuis le fichier XML
        Evenement loadedConcert = MyUtilities.loadEventFromFile(filename);
        System.out.println("Événement chargé: " + loadedConcert);
    }
}
