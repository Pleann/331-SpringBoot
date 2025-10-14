package se321.lab.util;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import se321.lab.entity.Event;
import se321.lab.entity.EventDTO;

import java.util.List;

@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);
    EventDTO getEventDto(Event event);
    List<EventDTO> getEventDto (List<Event> events);
}
