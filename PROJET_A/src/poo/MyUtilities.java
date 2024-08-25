package poo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class MyUtilities {

    public static Evenement loadEventFromFile(String filename) {
        Path path = Paths.get(filename);

        if (!Files.exists(path)) {
            throw new RuntimeException("Fichier introuvable : " + path.toAbsolutePath());
        }

        try {
            String content = Files.readString(path, StandardCharsets.UTF_8);
            XStream xStream = new XStream(new DomDriver());
            configureXStream(xStream);
            return (Evenement) xStream.fromXML(content);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Problème de lecture du fichier : " + path.toAbsolutePath());
        }
    }

    public static void saveEventToFile(Evenement e, String filename) {
        Path path = Paths.get(filename);

        XStream xStream = new XStream(new DomDriver());
        configureXStream(xStream);

        String xmlString = xStream.toXML(e);

        try {
            Path directory = path.getParent();
            if (directory != null && !Files.exists(directory)) {
                Files.createDirectories(directory);
            }
            Files.writeString(path, xmlString, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Fichier " + path.toAbsolutePath() + " créé avec succès.");
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Problème d'écriture dans le fichier : " + path.toAbsolutePath());
        }
    }

    private static void configureXStream(XStream xStream) {
        xStream.addPermission(AnyTypePermission.ANY);

        // Configure XStream for Evenement and Member classes
        xStream.processAnnotations(Evenement.class);
        xStream.processAnnotations(Member.class);

        // Set aliases for the elements
        xStream.alias("Event", Evenement.class);
        xStream.alias("member", Member.class);

        // Set attributes for Event
        xStream.useAttributeFor(Evenement.class, "title");
        xStream.useAttributeFor(Evenement.class, "date");
        xStream.useAttributeFor(Evenement.class, "price");

        // Configure member element to exclude non-desired fields
        xStream.omitField(Member.class, "login");
        xStream.omitField(Member.class, "password");
        xStream.omitField(Member.class, "money");
        xStream.omitField(Member.class, "email");
        xStream.omitField(Member.class, "events");

        // Rename 'members' to 'member' if needed
        xStream.aliasField("member", Evenement.class, "members");
    }
}
