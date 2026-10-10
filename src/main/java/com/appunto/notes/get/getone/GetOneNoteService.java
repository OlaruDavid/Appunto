package com.appunto.notes.get.getone;

import com.appunto.notes.NoteRepository;
import org.springframework.http.HttpStatus;
import com.appunto.security.CurrentUser;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class GetOneNoteService {

    private final NoteRepository repository;

    public GetOneNoteService(NoteRepository repository) {
        this.repository = repository;
    }

    public GetOneNoteResponse getOne(Long id) {
        Long userId = CurrentUser.id();

        return repository.findByIdAndUserId(id, userId)
                .map(GetOneNoteResponse::from)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Note not found"));
    }
}