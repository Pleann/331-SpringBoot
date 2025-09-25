package se321.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se321.lab.entity.Event;
import se321.lab.entity.Organizer;

import java.util.List;

public interface OrganizerRepository extends JpaRepository<Organizer, Long> {
    List<Organizer> findAll();
}