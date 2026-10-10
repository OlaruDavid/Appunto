package com.appunto.notes.get.getone;

import com.appunto.notes.Note;
import java.time.Instant;

public record GetOneNoteResponse(Long id, String title, String content,
                                 Instant createdAt, Instant updatedAt) {

    public static GetOneNoteResponse from(Note note) {
        return new GetOneNoteResponse(note.getId(), note.getTitle(), note.getContent(),
                note.getCreatedAt(), note.getUpdatedAt());
    }
}