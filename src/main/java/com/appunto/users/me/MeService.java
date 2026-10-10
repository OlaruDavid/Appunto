package com.appunto.users.me;

import com.appunto.users.User;
import com.appunto.users.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class MeService {

    private final UserRepository repository;

    public MeService(UserRepository repository) {
        this.repository = repository;
    }

    public MeResponse getMe() {
        Long userId = (Long) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();

        User user = repository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        return MeResponse.from(user);
    }
}