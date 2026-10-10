package com.appunto.users.me;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class MeController {

    private final MeService service;

    public MeController(MeService service) {
        this.service = service;
    }

    @GetMapping("/me")
    public MeResponse getMe() {
        return service.getMe();
    }
}