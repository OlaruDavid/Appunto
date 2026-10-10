package com.appunto.notes.delete.deletenote;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notes")
@CrossOrigin
public class DeleteNoteController {

    private final DeleteNoteService service;

    public DeleteNoteController(DeleteNoteService service) {
        this.service = service;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}