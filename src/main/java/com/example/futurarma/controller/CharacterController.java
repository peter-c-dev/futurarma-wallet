package com.example.futurarma.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.futurarma.entity.CharacterEntity;
import com.example.futurarma.service.CharacterService;

@RestController
@RequestMapping("/characters")
@RequiredArgsConstructor
public class CharacterController {

    private final CharacterService service;

    @PostMapping
    public CharacterEntity create(
            @RequestBody CharacterEntity character) {

        return service.create(character);
    }

    @GetMapping
    public List<CharacterEntity> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public CharacterEntity getById(
            @PathVariable Long id) {

        return service.find(id);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id) {
        service.delete(id);
    }
}