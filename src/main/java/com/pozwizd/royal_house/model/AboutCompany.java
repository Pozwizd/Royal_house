package com.pozwizd.royal_house.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "about_company")
public class AboutCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "url_banner")
    private String urlBanner;

    @Column(name = "title")
    private String title;

    @Lob
    @Column(name = "text", length = 1000000000)
    private String text;

    @Lob
    @Column(name = "banner_text",length = 1000000000)
    private String bannerText;

}