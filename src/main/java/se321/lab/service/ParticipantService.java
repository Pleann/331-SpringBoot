package se321.lab.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se321.lab.entity.Participant;
import java.util.List;

public interface ParticipantService {
    List<Participant> getAll();
    Page<Participant> getPage(Pageable pageable);
}
