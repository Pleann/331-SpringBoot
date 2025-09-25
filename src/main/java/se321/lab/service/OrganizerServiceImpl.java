package se321.lab.service;

import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import se321.lab.dao.OrganizerDao;
import se321.lab.entity.Event;
import se321.lab.entity.Organizer;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizerServiceImpl implements OrganizerService {
    final OrganizerDao organizerDao;

    @Override
    public Integer getOrganizerSize() {
        return organizerDao.getOrganizerSize();
    }

    @Override
    public Page<Organizer> getOrganizers(int pageSize, int page) {
        return organizerDao.getOrganizers(pageSize, page);
    }

    @Override
    public Organizer getOrganizer(Long id) {
        return organizerDao.getOrganizer(id);
    }

    @Override
    public Organizer save(Organizer organizer) {
        return organizerDao.save(organizer);
    }
}
