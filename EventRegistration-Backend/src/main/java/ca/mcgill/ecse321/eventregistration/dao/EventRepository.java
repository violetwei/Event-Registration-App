package ca.mcgill.ecse321.eventregistration.dao;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.eventregistration.model.Event;

public interface EventRepository extends CrudRepository<Event, String> {
	
	Event findEventByName(String name);

}
