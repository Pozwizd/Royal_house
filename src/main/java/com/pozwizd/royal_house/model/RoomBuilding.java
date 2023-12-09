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
@Table(name = "room_building")
public class RoomBuilding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Lob
    @Column(name = "text", length = 65365)
    private String text;

    @Column(name = "url_slide_1")
    private String urlSlide1;

    @Column(name = "url_slide_2")
    private String urlSlide2;

    @Column(name = "url_slide_3")
    private String urlSlide3;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "building_id")
    private Building building;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "roomBuilding")
    private List<InfographicRoom> infographicRooms;
}