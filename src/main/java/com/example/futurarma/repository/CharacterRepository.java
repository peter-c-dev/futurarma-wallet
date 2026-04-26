package com.example.futurarma.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.futurarma.entity.CharacterEntity;
public interface CharacterRepository
        extends JpaRepository<CharacterEntity, Long> {
}
