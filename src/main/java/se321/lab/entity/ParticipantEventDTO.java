package se321.lab.entity;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParticipantEventDTO {
    private Long id;
    private String title;
    private String category;
    private String location;
    private String date;
    private String time;
    private Boolean petAllowed;
}