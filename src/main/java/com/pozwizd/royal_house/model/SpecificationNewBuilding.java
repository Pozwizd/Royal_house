package com.pozwizd.royal_house.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "specification_new_building")
public class SpecificationNewBuilding {
    @Id
    @Column(name = "id")
    private Long id;

    @Lob
    @Column(name = "text")
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "new_building_id")
    private NewBuilding newBuilding;

}