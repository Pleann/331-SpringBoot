package se321.lab.dao;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import se321.lab.entity.Event;
import se321.lab.entity.Organizer;
import se321.lab.repository.OrganizerRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Primary
@Profile("manuel")
public class OrganizerDaoImpl implements OrganizerDao {
    List<Organizer> organizerList;

    @PostConstruct
    public void init() {
        organizerList = new ArrayList<>();
        organizerList.add(Organizer.builder().id(1L).organizationName("Meow Town Shelter").address("123 Cat St, Meow Town").build());
        organizerList.add(Organizer.builder().id(2L).organizationName("Flora City Community").address("456 Garden Ave, Flora City").build());
        organizerList.add(Organizer.builder().id(3L).organizationName("Playa Cleanup Crew").address("789 Beach Rd, Playa Del Carmen").build());
        organizerList.add(Organizer.builder().id(4L).organizationName("Woof Town Rescue").address("12 Doggo Blvd, Woof Town").build());
        organizerList.add(Organizer.builder().id(5L).organizationName("Tin City Food Bank").address("34 Can Dr, Tin City").build());
        organizerList.add(Organizer.builder().id(6L).organizationName("Highway 50 Volunteers").address("50 Highway 50, Mile 10").build());
        organizerList.add(Organizer.builder().id(7L).organizationName("Innovation Hub").address("77 Future Ln, Innovation City").build());
        organizerList.add(Organizer.builder().id(8L).organizationName("Dance Studio Crew").address("88 Rhythm Rd, Dance City").build());
    }

    @Override
    public Integer getOrganizerSize() {
        return organizerList.size();
    }

    @Override
    public Page<Organizer> getOrganizers(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? organizerList.size() : pageSize;
        page = page == null ? 1 : page;
        int firstIndex = (page - 1) * pageSize;
        return new PageImpl<Organizer>(organizerList.subList(firstIndex, firstIndex + pageSize), PageRequest.of(page,pageSize),organizerList.size());
    }

    @Override
    public Organizer getOrganizer(Long id) {
        return organizerList.stream().filter(o -> o.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Organizer save(Organizer organizer) {
        organizer.setId(organizerList.get(organizerList.size() - 1).getId() + 1);
        organizerList.add(organizer);
        return organizer;
    }
}
