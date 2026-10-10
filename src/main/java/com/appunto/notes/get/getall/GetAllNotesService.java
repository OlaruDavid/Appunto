package com.appunto.notes.get.getall;

import com.appunto.notes.NoteRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import com.appunto.security.CurrentUser;
import org.springframework.stereotype.Service;

@Service
public class GetAllNotesService {

    private static final int MAX_SIZE = 50;

    private final NoteRepository repository;

    public GetAllNotesService(NoteRepository repository) {
        this.repository = repository;
    }

    public GetAllNotesResponse getAll(int page, int size) {
        Long userId = CurrentUser.id();

        int safePage = Math.max(page, 0);
        int safeSize = Math.min(Math.max(size, 1), MAX_SIZE);

        var pageable = PageRequest.of(safePage, safeSize, Sort.by(Sort.Direction.DESC, "updatedAt"));
        return GetAllNotesResponse.from(repository.findByUserId(userId, pageable));
    }
}