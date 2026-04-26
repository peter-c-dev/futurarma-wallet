package com.example.futurarma.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.example.futurarma.entity.CharacterEntity;
import com.example.futurarma.repository.CharacterRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class CharacterService {

    private final CharacterRepository repository;

    public CharacterEntity create(CharacterEntity character) {
        return repository.save(character);
    }

    public List<CharacterEntity> getAll() {
        return repository.findAll();
    }

    public CharacterEntity find(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Character not found"));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}