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
@Table(name = "service_banner")
public class ServiceBanner {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "url_image")
    private String urlImage;

    @Column(name = "title")
    private String title;

    @Column(name = "text")
    private String text;

}