package com.appunto.notes.modify.updatenote;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notes")
@CrossOrigin
public class UpdateNoteController {

    private final UpdateNoteService service;

    public UpdateNoteController(UpdateNoteService service) {
        this.service = service;
    }

    @PutMapping("/{id}")
    public UpdateNoteResponse update(@PathVariable Long id,
                                     @Valid @RequestBody UpdateNoteRequest request) {
        return service.update(id, request);
    }
}