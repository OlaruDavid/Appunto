package com.appunto.notes.create;

import com.appunto.notes.Note;
import java.time.Instant;

public record CreateNoteResponse(Long id, String title, String content,
                                 Instant createdAt, Instant updatedAt) {

    public static CreateNoteResponse from(Note note) {
        return new CreateNoteResponse(note.getId(), note.getTitle(), note.getContent(),
                note.getCreatedAt(), note.getUpdatedAt());
    }
}