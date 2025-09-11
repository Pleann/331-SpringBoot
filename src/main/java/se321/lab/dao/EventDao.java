package se321.lab.dao;

import se321.lab.entity.Event;

import java.util.List;

public interface EventDao {
    Integer getEventSize();
    List<Event> getEvents(Integer pageSize, Integer page);
    Event getEvent(Long id);
}