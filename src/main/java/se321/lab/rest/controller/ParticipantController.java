package se321.lab.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se321.lab.entity.Participant;
import se321.lab.service.ParticipantService;
import se321.lab.util.LabMapper;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ParticipantController {

    private final ParticipantService participantService;

    // 7.3 – list participants and their attended events
    @GetMapping("/participants")
    public ResponseEntity<?> getParticipants() {
        List<Participant> participants = participantService.getAll();
        return ResponseEntity.ok(LabMapper.INSTANCE.getParticipantDTO(participants));
    }


    // optional paged
    @GetMapping("/participants/page")
    public ResponseEntity<?> getParticipantsPaged(@RequestParam int page,
                                                  @RequestParam int size) {
        return ResponseEntity.ok(participantService.getPage(PageRequest.of(page, size)));
    }
}
