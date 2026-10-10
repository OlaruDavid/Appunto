package com.appunto.users.delete.account;

import com.appunto.notes.NoteRepository;
import com.appunto.security.CurrentUser;
import com.appunto.users.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class DeleteAccountService {

    private final UserRepository userRepository;
    private final NoteRepository noteRepository;

    public DeleteAccountService(UserRepository userRepository, NoteRepository noteRepository) {
        this.userRepository = userRepository;
        this.noteRepository = noteRepository;
    }

    @Transactional
    public void deleteAccount() {
        Long userId = CurrentUser.id();

        if (!userRepository.existsById(userId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }

        noteRepository.deleteByUserId(userId);
        userRepository.deleteById(userId);
    }
}