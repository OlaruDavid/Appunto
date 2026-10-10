package com.appunto.users.delete.account;

import com.appunto.users.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class DeleteAccountService {

    private final UserRepository repository;

    public DeleteAccountService(UserRepository repository) {
        this.repository = repository;
    }

    public void deleteAccount() {
        Long userId = (Long) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();

        if (!repository.existsById(userId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        repository.deleteById(userId);
    }
}