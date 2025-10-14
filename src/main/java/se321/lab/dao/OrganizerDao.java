package se321.lab.dao;

import se321.lab.entity.Organizer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrganizerDao {
    Page<Organizer> getOrganizer(Pageable pageRequest);
}
