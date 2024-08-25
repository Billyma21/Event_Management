package poo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import java.util.ArrayList;
import java.util.List;

@XStreamAlias("member")
public class Member extends Person {

    @XStreamOmitField
    private String login;

    @XStreamOmitField
    private String password;

    @XStreamOmitField
    private double money;

    @XStreamOmitField
    private String email;

    @XStreamAlias("status")
    private Status status;

    @XStreamOmitField
    private List<Evenement> events;

    public Member(String firstname, String lastname, char gender, String login) {
        super(firstname, lastname, gender);
        this.login = login;
        this.password = "";
        this.money = 0.0;
        this.email = "";
        this.status = Status.MEMBER;
        this.events = new ArrayList<>();
    }

    // Getters and setters
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public double getMoney() { return money; }
    public void setMoney(double money) { this.money = money; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public List<Evenement> getEvents() { return events; }
    public void setEvents(List<Evenement> events) { this.events = events; }
}
