create schema db_royal_house;

USE db_royal_house;


CREATE TABLE IF NOT EXISTS inquiry
(
    id           BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name         VARCHAR(255),
    phone_number VARCHAR(100),
    email        VARCHAR(100),
    comment      TEXT(255),
    date         DATETIME,
    status       ENUM ('Новый', 'Отвечено')
);

CREATE TABLE IF NOT EXISTS subject
(
    id              BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    property_type   VARCHAR(255),
    area            VARCHAR(100),
    price           VARCHAR(100),
    price_per_meter VARCHAR(100),
    rooms           VARCHAR(100),
    floor           VARCHAR(100),
    floor_area      VARCHAR(100),
    date_addition   DATETIME
);

CREATE TABLE IF NOT EXISTS user
(
    id           BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name         VARCHAR(255),
    password     VARCHAR(100),
    phone_number VARCHAR(100),
    viber        VARCHAR(100),
    telegram     VARCHAR(100),
    email        VARCHAR(100),
    instagram    VARCHAR(100),
    facebook     VARCHAR(100),
    address      VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS additional_email_user
(
    id      BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    email   VARCHAR(255),
    user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES user (id)
);

CREATE TABLE IF NOT EXISTS new_building
(
    id          BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name        VARCHAR(255),
    address     VARCHAR(100),
    main_banner VARCHAR(100),
    user_id     BIGINT,
    FOREIGN KEY (user_id) REFERENCES user (id)
);


CREATE TABLE IF NOT EXISTS about_project
(
    id              BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    url_slide_1     VARCHAR(100),
    url_slide_2     VARCHAR(100),
    url_slide_3     VARCHAR(100),
    text            VARCHAR(255),
    new_building_id BIGINT,
    FOREIGN KEY (new_building_id) REFERENCES new_building (id)
);

CREATE TABLE IF NOT EXISTS infographic_new_building
(
    id              BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    url_image       VARCHAR(255),
    description     VARCHAR(100),
    new_building_id BIGINT,
    FOREIGN KEY (new_building_id) REFERENCES new_building (id)
);


CREATE TABLE IF NOT EXISTS location_new_building
(
    id              BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    longitude       VARCHAR(255),
    latitude        VARCHAR(100),
    text            TEXT(255),
    new_building_id BIGINT,
    FOREIGN KEY (new_building_id) REFERENCES new_building (id)

);

CREATE TABLE IF NOT EXISTS infrastructure_new_building
(
    id              BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    text            VARCHAR(255),
    url_slide_1     VARCHAR(100),
    url_slide_2     VARCHAR(100),
    url_slide_3     VARCHAR(100),
    new_building_id BIGINT,
    FOREIGN KEY (new_building_id) REFERENCES new_building (id)
);


CREATE TABLE IF NOT EXISTS infographic_infrastructure
(
    id                BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    url_image         VARCHAR(255),
    description       VARCHAR(100),
    alt_image         VARCHAR(100),
    infrastructure_id BIGINT,
    FOREIGN KEY (infrastructure_id) REFERENCES infrastructure_new_building (id)
);


CREATE TABLE IF NOT EXISTS rooms_new_building
(
    id              BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    text            VARCHAR(255),
    url_slide_1     VARCHAR(100),
    url_slide_2     VARCHAR(100),
    url_slide_3     VARCHAR(100),
    new_building_id BIGINT,
    FOREIGN KEY (new_building_id) REFERENCES new_building (id)
);


CREATE TABLE IF NOT EXISTS infographic_rooms
(
    id          BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    url_image   VARCHAR(255),
    description VARCHAR(100),
    alt_image   VARCHAR(100),
    rooms_id    BIGINT,
    FOREIGN KEY (rooms_id) REFERENCES rooms_new_building (id)
);


CREATE TABLE IF NOT EXISTS panorama_new_building
(
    id              BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    url             VARCHAR(255),
    alt             VARCHAR(100),
    new_building_id BIGINT,
    FOREIGN KEY (new_building_id) REFERENCES new_building (id)
);



CREATE TABLE IF NOT EXISTS specification_new_building
(
    id              BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    text            LONGTEXT,
    new_building_id BIGINT,
    FOREIGN KEY (new_building_id) REFERENCES new_building (id)
);


CREATE TABLE IF NOT EXISTS service
(
    id          BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name        VARCHAR(255),
    url_banner  VARCHAR(100),
    url_preview VARCHAR(100),
    text        VARCHAR(100),
    visible     VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS service_banner
(
    id        BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    url_image VARCHAR(255),
    title     VARCHAR(100),
    text      VARCHAR(100)
);


CREATE TABLE IF NOT EXISTS about_company
(
    id         BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    url_banner VARCHAR(255),
    title      VARCHAR(100),
    text       LONGTEXT
);

use db_royal_house;
select *
from requests
where name like '% %'
  and phone_number like '% %'
  and email like '% %'
  and status = ' ';


INSERT INTO requests (name, phone_number, email, comment, date, status)
VALUES ('John Doe', '+380501234567', 'john@example.com', 'Need help with order', NOW(), 'Новый'),
       ('Jane Smith', '+380509876543', 'jane@gmail.com', 'Shipping question', NOW(), 'Отвечено'),
       ('Mike Johnson', '+380681234567', 'mike_johnson@yahoo.com', 'Payment didn''t go through', NOW(), 'Новый'),
       ('Sarah Williams', '+380637891234', 'swilliams@icloud.com', 'Missing item in delivery', NOW(), 'Отвечено'),
       ('Robert Brown', '+380505554444', 'rob@brown.com', 'Requesting refund', NOW(), 'Новый'),
       ('Michael Miller', '+380507776666', 'millerm@company.com', 'Order confirmation', NOW(), 'Новый'),
       ('David Jones', '+380671119999', 'djones@email.net', 'Inquiry about new product', NOW(), 'Новый'),
       ('James Smith', '+380503335556', 'smithj@provider.org', 'Need replacement for damaged item', NOW(), 'Отвечено'),
       ('Richard Williams', '+380501234567', 'rwilliams@website.edu', 'Check order status', NOW(), 'Новый'),
       ('William Davis', '+380672234567', 'wdavis@isp.gov', 'Product recommendation', NOW(), 'Новый');

INSERT INTO subjects (property_type, area, price, price_per_meter, rooms, floor, floor_area, date_addition)
VALUES ('Квартира', '80 кв. м', '1000000', '12500', '3', '2', '60 кв. м', '2023-10-21 10:00:00'),
       ('Участок', '1000 кв. м', '500000', '500', NULL, NULL, NULL, '2023-10-20 14:30:00'),
       ('Дом', '200 кв. м', '1500000', '7500', '5', '1', '150 кв. м', '2023-10-19 09:45:00'),
       ('Квартира', '65 кв. м', '800000', '12308', '2', '3', '50 кв. м', '2023-10-18 16:20:00'),
       ('Участок', '500 кв. м', '300000', '600', NULL, NULL, NULL, '2023-10-17 11:15:00'),
       ('Дом', '150 кв. м', '1200000', '8000', '4', '2', '120 кв. м', '2023-10-16 08:30:00'),
       ('Квартира', '90 кв. м', '1100000', '12222', '3', '4', '70 кв. м', '2023-10-15 13:40:00'),
       ('Участок', '800 кв. м', '600000', '750', NULL, NULL, NULL, '2023-10-14 17:50:00'),
       ('Дом', '180 кв. м', '1400000', '7778', '6', '3', '150 кв. м', '2023-10-13 09:10:00'),
       ('Квартира', '75 кв. м', '900000', '12000', '2', '1', '55 кв. м', '2023-10-12 14:25:00'),
       ('Участок', '1200 кв. м', '800000', '667', NULL, NULL, NULL, '2023-10-11 10:35:00'),
       ('Дом', '250 кв. м', '1800000', '7200', '7', '2', '200 кв. м', '2023-10-10 11:55:00'),
       ('Квартира', '70 кв. м', '850000', '12143', '3', '5', '55 кв. м', '2023-10-09 15:05:00'),
       ('Участок', '600 кв. м', '400000', '667', NULL, NULL, NULL, '2023-10-08 18:15:00'),
       ('Дом', '220 кв. м', '1600000', '7273', '5', '1', '180 кв. м', '2023-10-07 09:30:00');