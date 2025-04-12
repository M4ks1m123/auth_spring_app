package org.example.auth_spring_app.controller;

import lombok.RequiredArgsConstructor;
import org.example.auth_spring_app.domain.model.Videogame;
import org.example.auth_spring_app.repository.VideogameRepository;
import org.example.auth_spring_app.service.VideogameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/videogame")
public class VideogameController {

    private VideogameService videogameService;

    @Autowired
    public VideogameController(VideogameService videogameService) {
        this.videogameService = videogameService;
    }

    @GetMapping()
    public List<Videogame> getAllVideogame(){
//        return Arrays.asList(
//                new Videogame(1L,
//                "1",
//                "1",
//                "1",
//                "1",
//                1L),
//                new Videogame(1L,
//                "1",
//                "1",
//                "1",
//                "1",
//                1L),
//                new Videogame(1L,
//                "1",
//                "1",
//                "1",
//                "1",
//                1L));
        return videogameService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Videogame> getVideogame(@PathVariable("id") Long id){
       Optional<Videogame> foundVideogame = videogameService.findById(id);
        return foundVideogame.map(videogame -> new ResponseEntity<>(videogame, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public ResponseEntity<Videogame> createVideogame(@RequestBody Videogame videogame){
        Videogame createdVideogame = videogameService.saveOne(videogame);
        return new ResponseEntity<>(createdVideogame, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Videogame> updateVideogame(@PathVariable("id") Long id, @RequestBody Videogame videogame){
        if(!videogameService.isExists(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        videogame.setId(id);
        Videogame updatedVideogame = videogameService.updateOne(id, videogame);
        return new ResponseEntity<>(updatedVideogame, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVideogame(@PathVariable("id") Long id){
        videogameService.deleteOne(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
