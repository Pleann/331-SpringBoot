package se321.lab.dao;

import org.springframework.data.domain.Pageable;
import se321.lab.entity.Event;
import org.springframework.data.domain.Page;


public interface EventDao {
    Integer getEventSize();
    Page<Event> getEvents(Integer pageSize, Integer page);
    Event getEvent(Long id);
    Event save (Event event);
    Page<Event> getEvents(String name, Pageable page);
}