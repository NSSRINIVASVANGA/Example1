package com.example.dinemaster.repository;

import com.example.dinemaster.model.*;

import java.util.*;

public interface ChefRepository {
    ArrayList<Chef> getChefs();

    Chef addChef(Chef chef);

    Chef getChefById(int chefId);

    Chef updateChef(int chefId, Chef chef);

    void deleteChef(int chefId);

    Restaurant getChefRestaurant(int chefId);

}