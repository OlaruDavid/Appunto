package com.appunto.notes.get.getone;

import com.appunto.notes.NoteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class GetOneNoteService {

    private final NoteRepository repository;

    public GetOneNoteService(NoteRepository repository) {
        this.repository = repository;
    }

    public GetOneNoteResponse getOne(Long id) {
        Long userId = (Long) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();

        return repository.findByIdAndUserId(id, userId)
                .map(GetOneNoteResponse::from)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Note not found"));
    }
}