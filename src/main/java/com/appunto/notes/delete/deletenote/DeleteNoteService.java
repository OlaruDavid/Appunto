package com.appunto.notes.delete.deletenote;

import com.appunto.notes.NoteRepository;
import org.springframework.http.HttpStatus;
import com.appunto.security.CurrentUser;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class DeleteNoteService {

    private final NoteRepository repository;

    public DeleteNoteService(NoteRepository repository) {
        this.repository = repository;
    }

    public void delete(Long id) {
        Long userId = CurrentUser.id();

        if (!repository.existsByIdAndUserId(id, userId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Note not found");
        }
        repository.deleteById(id);
    }
}