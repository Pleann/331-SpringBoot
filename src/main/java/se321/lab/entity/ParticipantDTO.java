package se321.lab.entity;

import lombok.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParticipantDTO {
    private Long id;
    private String name;
    private String telNo;

    // Each participant has attended multiple events
    private List<ParticipantEventDTO> eventHistory;
}
