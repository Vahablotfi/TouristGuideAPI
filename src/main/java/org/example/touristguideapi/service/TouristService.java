package org.example.touristguideapi.service;

import org.example.touristguideapi.model.TouristAttraction;
import org.example.touristguideapi.repository.TouristRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TouristService {
    private final TouristRepository touristRepository;

    public TouristService(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }

    public ArrayList<TouristAttraction> getAllTouristAttractions() {
        return touristRepository.getAttractions();
    }

    public ArrayList<TouristAttraction> addTouristAttraction(TouristAttraction touristAttraction) {
        touristRepository.addAttractions( touristAttraction);
        return touristRepository.getAttractions();
    }

    public TouristAttraction updateTouristAttraction(TouristAttraction touristAttraction) {
        return touristRepository.updateAttraction(touristAttraction);
    }

    public ArrayList<TouristAttraction> removeTouristAttraction(String touristAttraction) {
        touristRepository.removeAttraction(touristAttraction);
        return touristRepository.getAttractions();
    }

    public TouristAttraction getTouristAttractionByName(String name) {
        return touristRepository.findAttraction(name);
    }
}
