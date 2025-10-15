package se321.lab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se321.lab.repository.ParticipantRepository;
import se321.lab.entity.Participant;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParticipantServiceImpl implements ParticipantService {
    private final ParticipantRepository participantRepository;

    @Override
    public List<Participant> getAll() {
        return participantRepository.findAll();
    }

    @Override
    public Page<Participant> getPage(Pageable pageable) {
        return participantRepository.findAll(pageable);
    }
}
