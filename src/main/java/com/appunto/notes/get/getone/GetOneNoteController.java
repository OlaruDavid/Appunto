package com.appunto.notes.get.getone;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notes")
@CrossOrigin
public class GetOneNoteController {

    private final GetOneNoteService service;

    public GetOneNoteController(GetOneNoteService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public GetOneNoteResponse getOne(@PathVariable Long id) {
        return service.getOne(id);
    }
}