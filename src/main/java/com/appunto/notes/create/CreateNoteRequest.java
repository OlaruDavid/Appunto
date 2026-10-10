package com.appunto.notes.create;

import jakarta.validation.constraints.NotBlank;

public record CreateNoteRequest(@NotBlank String title, String content) {
}