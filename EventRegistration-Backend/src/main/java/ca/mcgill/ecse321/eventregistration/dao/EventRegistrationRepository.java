package ca.mcgill.ecse321.eventregistration.dao;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.mcgill.ecse321.eventregistration.model.Event;
import ca.mcgill.ecse321.eventregistration.model.Person;

@Repository
public class EventRegistrationRepository {

	@Autowired
	EntityManager entityManager;

	@Transactional
	public Person createPerson(String name) {
		Person p = new Person();
		p.setName(name);
		entityManager.persist(p);
		return p;
	}
	
	@Transactional
	public Person getPerson(String name) {
		Person p = entityManager.find(Person.class, name);
		return p;
	}
	
	@Transactional
	public Event createEvent(String name, Date date, Time startTime, Time endTime) {
		Event e = new Event();
		e.setName(name);
		e.setDate(date);
		e.setStartTime(startTime);
		e.setEndTime(endTime);
		entityManager.persist(e);
		return e;
	}
	
	@Transactional
	public Event getEvent(String name) {
		Event e = entityManager.find(Event.class, name);
		return e;
	}
	
	@Transactional
	public List<Event> getEventsBeforeADeadline(Date deadline) {
		TypedQuery<Event> q = entityManager.createQuery("select e from Event e where e.date < :deadline",Event.class);
		q.setParameter("deadline", deadline);
		List<Event> resultList = q.getResultList();
		return resultList;
	}
	
	
}