package com.pozwizd.royal_house.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "room_building")
public class RoomBuilding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "text")
    private String text;

    @Column(name = "url_slide_1")
    private String urlSlide1;

    @Column(name = "url_slide_2")
    private String urlSlide2;

    @Column(name = "url_slide_3")
    private String urlSlide3;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "new_building_id")
    private Building building;

}