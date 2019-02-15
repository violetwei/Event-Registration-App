package ca.mcgill.ecse321.eventregistration;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.mcgill.ecse321.eventregistration.dao.EventRegistrationRepository;
import ca.mcgill.ecse321.eventregistration.model.Event;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EventRegistrationApplicationTests {

	@Test
	public void contextLoads() {
		
	}

}

