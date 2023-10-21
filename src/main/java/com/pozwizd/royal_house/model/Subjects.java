package com.pozwizd.royal_house.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "subjects")
public class Subjects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "property_type")
    private String propertyType;

    @Column(name = "area")
    private String area;

    @Column(name = "price")
    private String price;

    @Column(name = "price_per_meter")
    private String pricePerMeter;

    @Column(name = "rooms")
    private String rooms;

    @Column(name = "floor")
    private String floor;

    @Column(name = "floor_area")
    private String floorArea;

    @Column(name = "date_addition")
    private LocalDateTime dateAddition;

}