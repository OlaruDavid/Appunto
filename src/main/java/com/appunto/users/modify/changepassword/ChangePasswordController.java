package com.appunto.users.modify.changepassword;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users/me")
@CrossOrigin
public class ChangePasswordController {

    private final ChangePasswordService service;

    public ChangePasswordController(ChangePasswordService service) {
        this.service = service;
    }

    @PutMapping("/password")
    public ResponseEntity<Void> changePassword(@Valid @RequestBody ChangePasswordRequest request) {
        service.changePassword(request);
        return ResponseEntity.noContent().build();
    }
}