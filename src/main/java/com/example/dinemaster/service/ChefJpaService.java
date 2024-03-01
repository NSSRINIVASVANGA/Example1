package com.example.dinemaster.service;

import com.example.dinemaster.repository.ChefJpaRepository;
import com.example.dinemaster.repository.RestaurantJpaRepository;
import com.example.dinemaster.model.*;
import com.example.dinemaster.repository.*;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.*;

@Service
public class ChefJpaService implements ChefRepository {
    @Autowired
    public ChefJpaRepository chefJpaRepository;

    @Autowired
    public RestaurantJpaRepository restaurantJpaRepository;

    @Override
    public ArrayList<Chef> getChefs() {
        List<Chef> chefsList = chefJpaRepository.findAll();
        ArrayList<Chef> chefs = new ArrayList<>(chefsList);
        return chefs;
    }

    @Override
    public Chef addChef(Chef chef) {
        try {
            Restaurant restaurant = chef.getRestaurant();
            int restaurantId = restaurant.getId();
            Restaurant newRestaurant = restaurantJpaRepository.findById(restaurantId).get();
            chef.setRestaurant(newRestaurant);
            chefJpaRepository.save(chef);
            return chef;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public Chef getChefById(int chefId) {
        try {
            Chef chef = chefJpaRepository.findById(chefId).get();
            return chef;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Chef updateChef(int chefId, Chef chef) {
        try {
            Chef newChef = chefJpaRepository.findById(chefId).get();
            if (chef.getFirstName() != null) {
                newChef.setFristName(chef.getFirstName());
            }
            if (chef.getLastName() != null) {
                newChef.setLastName(chef.getLastName());
            }
            if (chef.getExpertise() != null) {
                newChef.setExpertise(chef.getExpertise());
            }
            if (chef.getExperienceYears() >= 0) {
                newChef.setExperienceYears(chef.getExperienceYears());
            }
            if (chef.getRestaurant() != null) {
                Restaurant restaurant = chef.getRestaurant();
                int restaurantId = restaurant.getId();
                Restaurant newRestaurant = restaurantJpaRepository.findById(restaurantId).get();
                newChef.setRestaurant(newRestaurant);
            }
            chefJpaRepository.save(newChef);
            return newChef;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public void deleteChef(int chefId) {
        try {
            chefJpaRepository.deleteById(chefId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

    @Override
    public Restaurant getChefRestaurant(int chefId) {
        try {
            Chef chef = chefJpaRepository.findById(chefId).get();
            return chef.getRestaurant();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }
}