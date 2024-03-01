package com.example.dinemaster.service;

import com.example.dinemaster.model.*;
import com.example.dinemaster.repository.*;
import java.util.*;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Service
public class RestaurantJpaService implements RestaurantRepository {
    @Autowired
    public RestaurantJpaRepository restaurantJpaRepository;

    @Override
    public ArrayList<Restaurant> getRestaurants() {
        List<Restaurant> restaurantsList = restaurantJpaRepository.findAll();
        ArrayList<Restaurant> restaurants = new ArrayList<>(restaurantsList);
        return restaurants;
    }

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        restaurantJpaRepository.save(restaurant);
        return restaurant;
    }

    public Restaurant getRestaurantById(int restaurantId) {
        try {
            Restaurant restaurant = restaurantJpaRepository.findById(restaurantId).get();
            return restaurant;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public Restaurant updateRestaurant(int restaurantId, Restaurant restaurant) {
        try {
            Restaurant newRestaurant = restaurantJpaRepository.findById(restaurantId).get();
            if (restaurant.getName() != null) {
                newRestaurant.setName(restaurant.getName());
            }
            if (restaurant.getAddress() != null) {
                newRestaurant.setAddress(restaurant.getAddress());
            }
            if (restaurant.getCuisineType() != null) {
                newRestaurant.setCuisineType(restaurant.getCuisineType());
            }
            if (restaurant.getRating() > 0) {
                newRestaurant.setRating(restaurant.getRating());
            }
            restaurantJpaRepository.save(newRestaurant);
            return newRestaurant;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public void deleteRestaurant(int restaurantId) {
        try {
            restaurantJpaRepository.deleteById(restaurantId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }
}