package com.appunto.notes.modify.updatenote;

import jakarta.validation.constraints.NotBlank;

public record UpdateNoteRequest(@NotBlank String title, String content) {
}