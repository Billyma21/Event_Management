package poo;

import java.util.ArrayList;
import java.util.List;

//Classe Journal
class Journal {
 private List<Evenement> events;

 public Journal() {
     events = new ArrayList<>();
 }

 public void addEvent(Evenement e) {
     events.add(e);
 }

 public List<Evenement> getEvents() {
	return events;
}

public void setEvents(List<Evenement> events) {
	this.events = events;
}

@Override
 public String toString() {
     return "Journal: " + events;
 }
}

