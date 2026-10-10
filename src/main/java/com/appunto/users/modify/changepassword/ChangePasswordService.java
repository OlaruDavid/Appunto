package com.appunto.users.modify.changepassword;

import com.appunto.users.User;
import com.appunto.users.UserRepository;
import org.springframework.http.HttpStatus;
import com.appunto.security.CurrentUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ChangePasswordService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public ChangePasswordService(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public void changePassword(ChangePasswordRequest request) {
        if (!request.newPassword().equals(request.confirmNewPassword())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Passwords do not match");
        }

        Long userId = CurrentUser.id();

        User user = repository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        if (!passwordEncoder.matches(request.oldPassword(), user.getPasswordHash())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials");
        }

        user.setPasswordHash(passwordEncoder.encode(request.newPassword()));
        repository.save(user);
    }
}