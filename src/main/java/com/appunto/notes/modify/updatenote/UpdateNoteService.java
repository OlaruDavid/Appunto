package com.appunto.notes.modify.updatenote;

import com.appunto.notes.Note;
import com.appunto.notes.NoteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;

@Service
public class UpdateNoteService {

    private final NoteRepository repository;

    public UpdateNoteService(NoteRepository repository) {
        this.repository = repository;
    }

    public UpdateNoteResponse update(Long id, UpdateNoteRequest request) {
        Long userId = (Long) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();

        Note note = repository.findByIdAndUserId(id, userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Note not found"));

        note.setTitle(request.title());
        note.setContent(request.content());
        note.setUpdatedAt(Instant.now());
        return UpdateNoteResponse.from(repository.save(note));
    }
}