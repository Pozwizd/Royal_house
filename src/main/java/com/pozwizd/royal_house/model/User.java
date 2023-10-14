package com.pozwizd.royal_house.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "viber")
    private String viber;

    @Column(name = "telegram")
    private String telegram;

    @Column(name = "email")
    private String email;

    @Column(name = "instagram")
    private String instagram;

    @Column(name = "facebook")
    private String facebook;

    @Column(name = "address")
    private String address;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private NewBuilding newBuilding;

}