package org.example.auth_spring_app.service;

import org.example.auth_spring_app.domain.model.Videogame;
import org.example.auth_spring_app.repository.VideogameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideogameService {
    private VideogameRepository videogameRepository;

    @Autowired
    public VideogameService(VideogameRepository videogameRepository) {
        this.videogameRepository = videogameRepository;
    }

    public List<Videogame> findAll() {
        return videogameRepository.findAll();
    }

    public Optional<Videogame> findById(Long id) {
        return videogameRepository.findById(id);
    }

    public Videogame saveOne(Videogame videogame) {
        return videogameRepository.save(videogame);
    }

    public void deleteOne(Long id) {
        videogameRepository.deleteById(id);
    }

    public Videogame updateOne(Long id, Videogame videogame) {
        videogame.setId(id);
        return videogameRepository.save(videogame);
    }

    public boolean isExists(Long id) {
        return videogameRepository.existsById(id);
    }
}
