package com.example.dinemaster.controller;

import com.example.dinemaster.model.*;
import com.example.dinemaster.repository.*;
import com.example.dinemaster.service.*;

import java.util.*;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class ChefController {
    @Autowired
    private ChefJpaService chefService;

    @GetMapping("/restaurants/chefs")
    public ArrayList<Chef> getChefs() {
        return chefService.getChefs();
    }

    @PostMapping("/restaurants/chefs")
    public Chef addChef(@RequestBody Chef chef) {
        return chefService.addChef(chef);
    }

    @GetMapping("/restaurants/chefs/{chefId}")
    public Chef getChefById(@PathVariable("chefId") int chefId) {
        return chefService.getChefById(chefId);
    }

    @PutMapping("/restaurants/chefs/{chefId}")
    public Chef updateChef(@PathVariable("chefId") int chefId, @RequestBody Chef chef) {
        return chefService.updateChef(chefId, chef);
    }

    @DeleteMapping("/restaurants/chefs/{chefId}")
    public void deleteChef(@PathVariable("chefId") int chefId) {
        chefService.deleteChef(chefId);
    }

    @GetMapping("/chefs/{chefId}/restaurant")
    public Restaurant getChefRestaurant(@PathVariable("ChefId") int chefId) {
        return chefService.getChefRestaurant(chefId);
    }
}