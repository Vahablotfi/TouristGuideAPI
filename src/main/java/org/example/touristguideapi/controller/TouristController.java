package org.example.touristguideapi.controller;

import org.example.touristguideapi.model.TouristAttraction;
import org.example.touristguideapi.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("attractions")
public class TouristController {

    private final TouristService touristService;

    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }
    @GetMapping("")
    public ResponseEntity<List<TouristAttraction>> getAllTouristAttractions() {
        List<TouristAttraction> touristAttractions = touristService.getAllTouristAttractions();
        return new ResponseEntity<>(touristAttractions, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<TouristAttraction> getAttractionByName(@PathVariable String name) {
        TouristAttraction touristAttraction = touristService.getTouristAttractionByName(name);
        return new ResponseEntity<>(touristAttraction, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<List<TouristAttraction>> addAttraction(@RequestBody TouristAttraction touristAttraction) {
        ArrayList<TouristAttraction> AttractionToAdd = touristService.addTouristAttraction(touristAttraction);
        return new ResponseEntity<>(touristService.getAllTouristAttractions(), HttpStatus.CREATED);
    }

    @PostMapping({"/update/{name}"})
    public ResponseEntity<TouristAttraction> updateAttraction(@PathVariable String name, @RequestBody TouristAttraction touristAttraction) {
        TouristAttraction attractionToUpdate = touristService.updateTouristAttraction(touristAttraction);
        return new ResponseEntity<>(attractionToUpdate, HttpStatus.OK);
    }

    @PostMapping("/delete/{name}")
    public ResponseEntity<HttpStatus> deleteAttraction(@PathVariable String name) {
        touristService.removeTouristAttraction(name);
        return new ResponseEntity<>(HttpStatus.GONE);
    }
}
