package ca.mcgill.ecse321.eventregistration.dto;

public class RegistrationDto {

	private PersonDto person;
	private EventDto event;
	
	public RegistrationDto() {
	}

	public RegistrationDto(PersonDto person, EventDto event) {
		this.person = person;
		this.event = event;
	}
	
	public PersonDto getperson() {
		return person;
	}
	
	public void setperson(PersonDto person) {
		this.person = person;
	}

	public EventDto getEvent() {
		return event;
	}

	public void setEvent(EventDto event) {
		this.event = event;
	}
}
