package com.appunto.notes.create;

import com.appunto.notes.Note;
import com.appunto.notes.NoteRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CreateNoteService {

    private final NoteRepository repository;

    public CreateNoteService(NoteRepository repository) {
        this.repository = repository;
    }

    public CreateNoteResponse create(CreateNoteRequest request) {
        Long userId = (Long) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();

        Note note = new Note();
        note.setUserId(userId);
        note.setTitle(request.title());
        note.setContent(request.content());
        return CreateNoteResponse.from(repository.save(note));
    }
}