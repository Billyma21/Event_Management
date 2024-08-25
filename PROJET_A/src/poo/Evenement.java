package poo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import java.util.ArrayList;
import java.util.List;

@XStreamAlias("Event")
public class Evenement implements Registrable {

    @XStreamAsAttribute
    private String title;

    @XStreamAsAttribute
    private String date;

    @XStreamAsAttribute
    private double price;

    private List<Member> members;

    public Evenement(String title, String date, double price) {
        this.title = title;
        this.date = date;
        this.price = price;
        this.members = new ArrayList<>();
    }

    public Evenement(String title, String date) {
        this(title, date, 0.0);
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public List<Member> getMembers() { return members; }
    public void setMembers(List<Member> members) { this.members = members; }

    @Override
    public void register(Person p) {
        if (p instanceof Member) {
            Member member = (Member) p;
            if (member.getMoney() >= price) {
                members.add(member);
                member.getEvents().add(this);
            } else {
                throw new InsufficientBalanceException("Balance insuffisante pour participer à cet événement.");
            }
        }
    }

    @Override
    public String toString() {
        return "Event: " + title + " on " + date + " Price: " + price + " Members: " + members;
    }
}
