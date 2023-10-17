package com.pozwizd.royal_house.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "building")
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "main_banner")
    private String mainBanner;

    @Column(name = "url_slide_1")
    private String urlSlide1;

    @Column(name = "url_slide_2")
    private String urlSlide2;

    @Column(name = "url_slide_3")
    private String urlSlide3;

    @Column(name = "text_about")
    private String textAbout;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "text_location")
    private String textLocation;

    @Column(name = "url_panorama")
    private String urlPanorama;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "infrastructure_building_id")
    private InfrastructureBuilding infrastructureBuilding;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "building")
    private List<RoomBuilding> roomBuildings;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "building")
    private List<SpecificationBuilding> specificationBuildings;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "building")
    private List<InfographicBuilding> infographicBuildings;



}