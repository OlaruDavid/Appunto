package com.appunto.users.delete.account;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class DeleteAccountController {

    private final DeleteAccountService service;

    public DeleteAccountController(DeleteAccountService service) {
        this.service = service;
    }

    @DeleteMapping("/me")
    public ResponseEntity<Void> deleteAccount() {
        service.deleteAccount();
        return ResponseEntity.noContent().build();
    }
}