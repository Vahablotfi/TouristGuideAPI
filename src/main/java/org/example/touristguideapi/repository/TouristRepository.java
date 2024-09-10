package org.example.touristguideapi.repository;

import org.example.touristguideapi.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository
public class TouristRepository {

    private ArrayList<TouristAttraction> attractions = new ArrayList<>();

    public TouristRepository() {
        crateAttractions();
    }

    //GET
    public ArrayList<TouristAttraction> getAttractions() {
        return attractions;
    }

    //ADD
    public ArrayList<TouristAttraction> addAttractions(TouristAttraction newAttraction) {
        attractions.add(newAttraction);
        return attractions;
    }

    //Update
    public TouristAttraction updateAttraction(TouristAttraction attractionToModify) {
        var foundAttraction = findAttraction(attractionToModify.getName());
       if( foundAttraction != null) {
           foundAttraction.setDescription(attractionToModify.getDescription());
       }
        return null;
    }

    //Delete
    public ArrayList<TouristAttraction> removeAttraction(String attractionToRemove) {
        var foundAttraction = findAttraction(attractionToRemove);
        if( foundAttraction != null) {
            attractions.remove(foundAttraction);
            return attractions;
        }
        return null;
    }

    public void crateAttractions() {
        attractions.add(new TouristAttraction("Tivoli Gardens","Historical amusement garden"));
        attractions.add(new TouristAttraction( "The Round Tower","Historical Observatory with a spiral ramp"));
    }

    //Find an attraction
    public TouristAttraction findAttraction(String attractionName) {
        for (TouristAttraction touristAttraction : attractions) {
            if (touristAttraction.getName().equals(attractionName)) {
                return touristAttraction;
            }
        }
        return null;
    }

}
