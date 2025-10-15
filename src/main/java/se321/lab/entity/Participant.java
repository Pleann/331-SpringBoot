package se321.lab.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private Long id;

    private String name;
    private String telNo;

    // Many events can include this participant
    @ManyToMany(mappedBy = "participants")
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<Event> eventHistory = new ArrayList<>();

}