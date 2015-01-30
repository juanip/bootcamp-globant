package meetings.data;

import java.util.List;

import meetings.entities.Meeting;
import meetings.entities.Room;
import meetings.entities.TimeSlot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Long> {
	public List<Meeting> findByRoom(Room room);

	public List<Meeting> findByTimeSlot(TimeSlot timeSlot);

	public Meeting findByRoomAndTimeSlot(Room room, TimeSlot timeSlot);

	public Meeting findById(Long id);
}
