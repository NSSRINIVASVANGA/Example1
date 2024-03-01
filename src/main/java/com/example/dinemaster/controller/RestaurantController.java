package com.example.dinemaster.controller;

import com.example.dinemaster.model.*;
import com.example.dinemaster.repository.*;
import com.example.dinemaster.service.*;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

@RestController
public class RestaurantController {
    @Autowired
    public RestaurantJpaService restaurantService;

    @GetMapping("/restaurants")
    public ArrayList<Restaurant> getRestaurants() {
        return restaurantService.getRestaurants();
    }

    @PostMapping("/restaurants")
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.addRestaurant(restaurant);
    }

    @GetMapping("/restaurants/{restaurantId}")
    public Restaurant getRestaurantById(@PathVariable("restaurantId") int restaurantId) {
        return restaurantService.getRestaurantById(restaurantId);
    }

    @PutMapping("/restaurants/{restaurantId}")
    public Restaurant updateRestaurant(@PathVariable("restaurantId") int restaurantId,
            @RequestBody Restaurant restaurant) {
        return restaurantService.updateRestaurant(restaurantId, restaurant);
    }

    @DeleteMapping("/restaurants/{restaurantId}")
    public void deleteRestaurant(@PathVariable("restaurantId") int restaurantId) {
        restaurantService.deleteRestaurant(restaurantId);
    }
}