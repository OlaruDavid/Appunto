package com.appunto.notes.modify.updatenote;

import com.appunto.notes.Note;
import java.time.Instant;

public record UpdateNoteResponse(Long id, String title, String content,
                                 Instant createdAt, Instant updatedAt) {

    public static UpdateNoteResponse from(Note note) {
        return new UpdateNoteResponse(note.getId(), note.getTitle(), note.getContent(),
                note.getCreatedAt(), note.getUpdatedAt());
    }
}