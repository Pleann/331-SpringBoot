package se321.lab.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se321.lab.entity.Event;
import se321.lab.entity.Organizer;
import se321.lab.repository.EventRepository;
import se321.lab.repository.OrganizerRepository;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final EventRepository eventRepository;
    final OrganizerRepository organizerRepository;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        eventRepository.save(Event.builder()
                .category("Academic")
                .title("Midterm Exam")
                .description("A time for taking the exam")
                .location("CAMT Building")
                .date("3rd Sept")
                .time("3.00–4.00 pm.")
                .petAllowed(false)
                .organizer("CAMT").build());

        eventRepository.save(Event.builder()
                .category("Academic")
                .title("Commencement Day")
                .description("A time for celebration")
                .location("CMU Convention hall")
                .date("21th Jan")
                .time("8.00am–4.00 pm.")
                .petAllowed(false)
                .organizer("CMU").build());

        eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Loy Krathong")
                .description("A time for Krathong")
                .location("Ping River")
                .date("21th Nov")
                .time("8.00–10.00 pm.")
                .petAllowed(false)
                .organizer("Chiang Mai").build());

        eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Songkran")
                .description("Let's Play Water")
                .location("Chiang Mai Moat")
                .date("13th April")
                .time("10.00am – 6.00 pm.")
                .petAllowed(true)
                .organizer("Chiang Mai Municipality").build());

        organizerRepository.save(Organizer.builder()
                .organizationName("Meow Town Shelter")
                .address("123 Cat St, Meow Town")
                .build());
        organizerRepository.save(Organizer.builder()
                .organizationName("Flora City Community")
                .address("456 Garden Ave, Flora City")
                .build());
        organizerRepository.save(Organizer.builder()
                .organizationName("Playa Cleanup Crew")
                .address("789 Beach Rd, Playa Del Carmen")
                .build());
        organizerRepository.save(Organizer.builder()
                .organizationName("Woof Town Rescue")
                .address("12 Doggo Blvd, Woof Town")
                .build());
        organizerRepository.save(Organizer.builder()
                .organizationName("Tin City Food Bank")
                .address("34 Can Dr, Tin City")
                .build());
        organizerRepository.save(Organizer.builder()
                .organizationName("Highway 50 Volunteers")
                .address("50 Highway 50, Mile 10")
                .build());
    }
}
