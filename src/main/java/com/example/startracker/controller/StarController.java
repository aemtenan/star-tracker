package com.example.startracker.controller;

import com.example.startracker.model.Star;
import com.example.startracker.repository.StarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class StarController {

    @Autowired
    StarRepository starRepository;

    @GetMapping("/stars")
    public ResponseEntity<List<Star>> getStars(){

        List<Star> stars = starRepository.findAll();

        if(stars.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(stars, HttpStatus.OK);
    }

    @GetMapping("/stars/{id}")
    public ResponseEntity<Star> getStar(@PathVariable("id") long id){

        Star star = starRepository.findById(id).orElse(null);

        if(star==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(star, HttpStatus.OK);
    }

    @PostMapping("/stars")
    public ResponseEntity<Star> addRStar(@RequestBody Star star){
        Star savedStar = starRepository.save(new Star(star.getName(), star.getConstellation(), star.getDistanceInLightYears(), star.getTemperatureInKelvin()));
        return new ResponseEntity<>(savedStar, HttpStatus.CREATED);
    }

    @PutMapping("/stars/{id}")
    public ResponseEntity<Star> updateStar(@PathVariable("id") long id, @RequestBody Star star){
        Star starToUpdate = starRepository.findById(id).orElse(null);

        if(starToUpdate==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        starToUpdate.setName(star.getName());
        starToUpdate.setConstellation(star.getConstellation());
        starToUpdate.setDistanceInLightYears(star.getDistanceInLightYears());
        starToUpdate.setTemperatureInKelvin(star.getTemperatureInKelvin());
        Star savedStar = starRepository.save(starToUpdate);
        return new ResponseEntity<>(savedStar, HttpStatus.OK);
    }

    @DeleteMapping("/stars/{id}")
    public ResponseEntity<HttpStatus> deleteStar(@PathVariable("id") long id){
        starRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
