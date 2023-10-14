package com.pozwizd.royal_house.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "service")
public class Service {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "url_banner")
    private String urlBanner;

    @Column(name = "url_preview")
    private String urlPreview;

    @Column(name = "text")
    private String text;

    @Column(name = "visible")
    private String visible;

}