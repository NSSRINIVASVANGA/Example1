package com.example.dinemaster.model;

import com.example.dinemaster.model.Restaurant;

import javax.persistence.*;

@Entity
@Table(name = "chef")
public class Chef {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "expertise")
    private String expertise;
    @Column(name = "experienceyears")
    private int experienceYears;

    @ManyToOne
    @JoinColumn(name = "restaurantid")
    private Restaurant restaurant;

    public Chef() {
    }

    public Chef(int id, String firstName, String lastName, String expertise, int experienceYears,
            Restaurant restaurant) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.expertise = expertise;
        this.experienceYears = experienceYears;
        this.restaurant = restaurant;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getExpertise() {
        return expertise;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFristName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}