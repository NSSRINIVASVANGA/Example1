package com.example.dinemaster.repository;

import com.example.dinemaster.model.*;

import java.util.*;

public interface RestaurantRepository {
    ArrayList<Restaurant> getRestaurants();

    Restaurant addRestaurant(Restaurant restaurant);

    Restaurant getRestaurantById(int restaurantId);

    Restaurant updateRestaurant(int restaurantId, Restaurant restaurant);

    void deleteRestaurant(int restaurantId);
}