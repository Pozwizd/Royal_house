package com.pozwizd.royal_house.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "infographic_new_building")
public class InfographicNewBuilding {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "url_image")
    private String urlImage;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "new_building_id")
    private NewBuilding newBuilding;

}