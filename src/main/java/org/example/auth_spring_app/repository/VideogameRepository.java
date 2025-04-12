package org.example.auth_spring_app.repository;

import org.example.auth_spring_app.domain.model.Videogame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideogameRepository extends JpaRepository<Videogame, Long> {
}
