package meetings;

import meetings.data.AttendeeRepository;
import meetings.data.RoomRepository;
import meetings.entities.Attendee;
import meetings.entities.Room;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MeetingsApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MeetingsApplication.class);
		AttendeeRepository attendeeRepository = context.getBean(AttendeeRepository.class);
		RoomRepository roomRepository = context.getBean(RoomRepository.class);

		for (String name : "Juan Perez,Emilio Rodriguez,Emanuel Fernandez".split(",")) {
			attendeeRepository.save(new Attendee(name));
		}
		for (String name : "Blue room,Red room,Yellow room".split(",")) {
			roomRepository.save(new Room(name));
		}

	}
}
