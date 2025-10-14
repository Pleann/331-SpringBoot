package se321.lab.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import se321.lab.dao.EventDao;
import se321.lab.dao.OrganizerDao;
import se321.lab.entity.Event;
import  se321.lab.entity.Organizer;

import java.util.List;

@Service
@RequiredArgsConstructor

public class EventServiceImpl implements EventService{
    final EventDao eventDao;
    final OrganizerDao organizerDao;

    @Override
    public Integer getEventSize() {
        return eventDao.getEventSize();
    }

    @Override
    public Page<Event> getEvents(Integer pageSize, Integer page) {
        return eventDao.getEvents(pageSize,page);
    }

    @Override
    public Event getEvent(Long id) {
        return eventDao.getEvent(id);
    }

    @Override
    @Transactional
    public Event save(Event event) {
        Organizer organizer = organizerDao.findById(event.getOrganizer().getId()).orElse(null);
        event.setOrganizer(organizer);
        organizer.getOwnEvents().add(event);
        return eventDao.save(event);
    }
}