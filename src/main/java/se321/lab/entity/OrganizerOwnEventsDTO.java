package se321.lab.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrganizerOwnEventsDTO {
    Long id;
    String category;
    String title;
    String description;
    String location;
    String date;
    String time;
    Boolean petAllowed;
    List<Participant> participants;
}
