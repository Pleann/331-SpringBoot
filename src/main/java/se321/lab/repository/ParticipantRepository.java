package se321.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se321.lab.entity.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Long> { }