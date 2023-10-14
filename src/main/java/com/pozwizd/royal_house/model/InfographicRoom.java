package com.pozwizd.royal_house.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "infographic_rooms")
public class InfographicRoom {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "url_image")
    private String urlImage;

    @Column(name = "description")
    private String description;

    @Column(name = "alt_image")
    private String altImage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rooms_id")
    private RoomNewBuilding roomNewBuilding;

}