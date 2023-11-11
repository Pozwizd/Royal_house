package com.pozwizd.royal_house.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
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

    @Lob
    @Column(name = "text_about", length = 65535)
    private String textAbout;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "text_location")
    private String textLocation;

    @Column(name = "url_panorama")
    private String urlPanorama;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusBuilding statusBuilding;

    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToOne(fetch = FetchType.EAGER)
    private InfrastructureBuilding infrastructureBuilding;

    @OneToOne(fetch = FetchType.LAZY)
    private RoomBuilding roomBuilding;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "building")
    private List<SpecificationBuilding> specificationBuildings;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "building")
    private List<InfographicBuilding> infographicBuildings;



}