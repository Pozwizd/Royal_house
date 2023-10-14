package com.pozwizd.royal_house.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "infographic_infrastructure")
public class InfographicInfrastructure {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "url_image")
    private String urlImage;

    @Column(name = "description")
    private String description;

    @Column(name = "alt_image")
    private String altImage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "infrastructure_id")
    private InfographicInfrastructure infographicInfrastructure;

}