package se321.lab.dao;

import se321.lab.entity.Organizer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface OrganizerDao {
    Page<Organizer> getOrganizer(Pageable pageRequest);
    Optional<Organizer> findById(Long id);
}
