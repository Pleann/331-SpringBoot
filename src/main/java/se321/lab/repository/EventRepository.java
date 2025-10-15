package se321.lab.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import se321.lab.entity.Event;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findAll();
    Page<Event> findByTitle(String title, Pageable pageRequest);
    Page<Event> findByTitleContaining(String title, Pageable pageRequest);
    Page<Event> findByTitleContainingOrDescriptionContaining(String title, String description, Pageable pageRequest);
    Page<Event> findByTitleContainingAndDescriptionContaining(String title, String description, Pageable pageRequest);
    Page<Event> findByTitleContainingOrDescriptionContainingOrOrganizer_NameContaining(String title, String description, String organizerName, Pageable pageRequest
    );
}