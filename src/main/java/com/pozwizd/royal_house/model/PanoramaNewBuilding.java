package com.pozwizd.royal_house.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "panorama_new_building")
public class PanoramaNewBuilding {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "url")
    private String url;

    @Column(name = "alt")
    private String alt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "new_building_id")
    private NewBuilding newBuilding;

}