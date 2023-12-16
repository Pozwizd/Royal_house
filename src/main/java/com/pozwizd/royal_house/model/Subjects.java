package com.pozwizd.royal_house.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "subjects")
public class Subjects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

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

    @Column(name = "address")
    private String address;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "subjects")
    private List<ImageSubject> imageSubjects;

}