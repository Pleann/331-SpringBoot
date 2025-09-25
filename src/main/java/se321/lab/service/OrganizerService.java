package se321.lab.service;

import org.springframework.data.domain.Page;
import se321.lab.entity.Organizer;

import java.util.List;

public interface OrganizerService {
    Integer getOrganizerSize();
    Page<Organizer> getOrganizers(int page, int size);
    Organizer getOrganizer(Long id);
    Organizer save(Organizer organizer);
}
