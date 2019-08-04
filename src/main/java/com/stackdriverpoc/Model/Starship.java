package com.stackdriverpoc.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Starship {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String manufacturer;

    @Column(nullable = false)
    private String costInCredits;

    @Column(nullable = false)
    private String length;

    @Column(nullable = false)
    private String maxAtomspheringSpeed;

    @Column(nullable = false)
    private String crew;

    @Column(nullable = false)
    private String passengers;

    @Column(nullable = false)
    private String cargoCapacity;

    @Column(nullable = false)
    private String consumables;

    @Column(nullable = false)
    private String hyperdriveRating;


}
