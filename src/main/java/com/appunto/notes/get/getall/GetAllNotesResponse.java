package com.appunto.notes.get.getall;

import com.appunto.notes.Note;
import org.springframework.data.domain.Page;

import java.time.Instant;
import java.util.List;

public record GetAllNotesResponse(List<Item> notes, int page, boolean hasNext) {

    public record Item(Long id, String title, String content,
                       Instant createdAt, Instant updatedAt) {
        static Item from(Note note) {
            return new Item(note.getId(), note.getTitle(), note.getContent(),
                    note.getCreatedAt(), note.getUpdatedAt());
        }
    }

    public static GetAllNotesResponse from(Page<Note> page) {
        return new GetAllNotesResponse(
                page.getContent().stream().map(Item::from).toList(),
                page.getNumber(),
                page.hasNext());
    }
}