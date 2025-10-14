package se321.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import  se321.lab.entity.Organizer;

public interface OrganizerRepository extends JpaRepository<Organizer, Long> {
}
