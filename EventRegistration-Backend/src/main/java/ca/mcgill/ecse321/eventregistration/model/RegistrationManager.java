package ca.mcgill.ecse321.eventregistration.model;

import javax.persistence.Entity;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.persistence.Id;

@Entity
public class RegistrationManager{
private Set<Person> persons;

@OneToMany(cascade={CascadeType.ALL})
public Set<Person> getPersons() {
   return this.persons;
}

public void setPersons(Set<Person> personss) {
   this.persons = personss;
}

private Set<Registration> registrations;

@OneToMany(cascade={CascadeType.ALL})
public Set<Registration> getRegistrations() {
   return this.registrations;
}

public void setRegistrations(Set<Registration> registrationss) {
   this.registrations = registrationss;
}

private Set<Event> events;

@OneToMany(cascade={CascadeType.ALL})
public Set<Event> getEvents() {
   return this.events;
}

public void setEvents(Set<Event> eventss) {
   this.events = eventss;
}

private int id;

public void setId(int value) {
this.id = value;
    }
@Id
public int getId() {
return this.id;
       }
   }
