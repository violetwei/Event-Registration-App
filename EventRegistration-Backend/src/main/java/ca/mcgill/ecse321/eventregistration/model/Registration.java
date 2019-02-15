package ca.mcgill.ecse321.eventregistration.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Registration{
private int id;
   
   public void setId(int value) {
this.id = value;
    }
@Id
public int getId() {
return this.id;
    }
private Person person;

@ManyToOne(optional=false)
public Person getPerson() {
   return this.person;
}

public void setPerson(Person person) {
   this.person = person;
}

private Event event;

@ManyToOne(optional=false)
public Event getEvent() {
   return this.event;
}

public void setEvent(Event event) {
   this.event = event;
}

}
