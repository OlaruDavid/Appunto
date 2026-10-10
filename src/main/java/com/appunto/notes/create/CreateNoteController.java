package com.appunto.notes.create;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notes")
@CrossOrigin
public class CreateNoteController {

    private final CreateNoteService service;

    public CreateNoteController(CreateNoteService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateNoteResponse create(@Valid @RequestBody CreateNoteRequest request) {
        return service.create(request);
    }
}