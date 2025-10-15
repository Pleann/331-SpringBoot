package se321.lab.config;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se321.lab.entity.Event;
import se321.lab.entity.Organizer;
import se321.lab.entity.Participant;
import se321.lab.repository.EventRepository;
import se321.lab.repository.OrganizerRepository;
import se321.lab.repository.ParticipantRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final EventRepository eventRepository;
    final OrganizerRepository organizerRepository;
    final ParticipantRepository participantRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Organizer org1, org2, org3;
        org1 = organizerRepository.save(Organizer.builder()
                .name("CAMT")
                .build());
        org2 = organizerRepository.save(Organizer.builder()
                .name("CMU")
                .build());
        org3 = organizerRepository.save(Organizer.builder()
                .name("ChiangMai")
                .build());
        Event tempEvent;

        Event e1 = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Midterm Exam")
                .description("A time for taking the exam")
                .location("CAMT Building")
                .date("3rd Sept")
                .time("3.00–4.00 pm.")
                .petAllowed(false)
                .build());
        e1.setOrganizer(org1);
        org1.getOwnEvents().add(e1);

        Event e2 = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Commencement Day")
                .description("A time for celebration")
                .location("CMU Convention hall")
                .date("21th Jan")
                .time("8.00am–4.00 pm.")
                .petAllowed(false)
                .build());
        e2.setOrganizer(org1);
        org1.getOwnEvents().add(e2);

        Event e3 = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Loy Krathong")
                .description("A time for Krathong")
                .location("Ping River")
                .date("21th Nov")
                .time("8.00–10.00 pm.")
                .petAllowed(false)
                .build());
        e3.setOrganizer(org2);
        org2.getOwnEvents().add(e3);

        Event e4 = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Songkran")
                .description("Let's Play Water")
                .location("Chiang Mai Moat")
                .date("13th April")
                .time("10.00am – 6.00 pm.")
                .petAllowed(true)
                .build());
        e4.setOrganizer(org3);
        org3.getOwnEvents().add(e4);

        Participant p1 = participantRepository.save(Participant.builder()
                .name("Alice")
                .telNo("081-111-1111")
                .build());
        Participant p2 = participantRepository.save(Participant.builder()
                .name("Bob")
                .telNo("082-222-2222")
                .build());
        Participant p3 = participantRepository.save(Participant.builder()
                .name("Charlie")
                .telNo("083-333-3333")
                .build());
        Participant p4 = participantRepository.save(Participant.builder()
                .name("Dana")
                .telNo("084-444-4444")
                .build());
        Participant p5 = participantRepository.save(Participant.builder()
                .name("Eve")
                .telNo("085-555-5555")
                .build());

        e1.getParticipants().addAll(List.of(p1, p2, p3));
        e2.getParticipants().addAll(List.of(p1, p2, p3));
        e3.getParticipants().addAll(List.of(p1, p2, p3));
        e4.getParticipants().addAll(List.of(p3, p4, p5));

        p1.getEventHistory().addAll(List.of(e1, e2, e3));
        p2.getEventHistory().addAll(List.of(e1, e2, e3));
        p3.getEventHistory().addAll(List.of(e1, e2, e3, e4));
        p4.getEventHistory().add(e4);
        p5.getEventHistory().add(e4);

        eventRepository.saveAll(List.of(e1, e2, e3, e4));
        participantRepository.saveAll(List.of(p1, p2, p3, p4, p5));
    }
}
