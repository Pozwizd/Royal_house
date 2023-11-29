package com.pozwizd.royal_house.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "secondary_market")
public class SecondaryMarket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "url_image")
    private String urlImage;

    @Column(name = "text")
    private String text;

    @Column(name = "url")
    private String url;

}