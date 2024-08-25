package poo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias("person")
public class Person {
    private String firstname;
    private String lastname;
    
    
    //Pour ne pas apparaitre dans la sérialization :-)
    @XStreamOmitField
    private char gender;

    public Person(String firstname, String lastname, char gender) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
    }

    // Getters and setters
    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getLastname() { return lastname; }
    public void setLastname(String lastname) { this.lastname = lastname; }

    public char getGender() { return gender; }
    public void setGender(char gender) { this.gender = gender; }

    @Override
    public String toString() {
        return firstname + " " + lastname + " (" + gender + ")";
    }
}
