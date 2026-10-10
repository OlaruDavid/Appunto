package com.appunto.notes.get.getall;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notes")
@CrossOrigin
public class GetAllNotesController {

    private final GetAllNotesService service;

    public GetAllNotesController(GetAllNotesService service) {
        this.service = service;
    }

    @GetMapping
    public GetAllNotesResponse getAll(@RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "10") int size) {
        return service.getAll(page, size);
    }
}