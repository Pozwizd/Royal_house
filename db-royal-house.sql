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


USE db_royal_house;
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

INSERT INTO about_company (id, text, title, url_banner)
VALUES
    (1, 'Текст о компании 1', 'Заголовок о компании 1', 'https://example.com/banner1.jpg'),
    (2, 'Текст о компании 2', 'Заголовок о компании 2', 'https://example.com/banner2.jpg');

INSERT INTO building (id, address, latitude, longitude, main_banner, name, status, text_about, text_location, url_panorama, url_slide_1, url_slide_2, url_slide_3)
VALUES
    (1, 'Адрес здания 1', '50.123456', '30.123456', 'https://example.com/building1.jpg', 'Название здания 1', 'Активен', 'Описание здания 1', 'Описание местоположения 1', 'https://example.com/panorama1.jpg', 'https://example.com/slide1_1.jpg', 'https://example.com/slide1_2.jpg', 'https://example.com/slide1_3.jpg'),
    (2, 'Адрес здания 2', '52.123456', '32.123456', 'https://example.com/building2.jpg', 'Название здания 2', 'Отключен', 'Описание здания 2', 'Описание местоположения 2', 'https://example.com/panorama2.jpg', 'https://example.com/slide2_1.jpg', 'https://example.com/slide2_2.jpg', 'https://example.com/slide2_3.jpg');

INSERT INTO infographic_building (id, description, url_image, building_id)
VALUES
    (1, 'Описание инфографики здания 1', 'https://example.com/infographic1.jpg', 1),
    (2, 'Описание инфографики здания 2', 'https://example.com/infographic2.jpg', 2);

INSERT INTO infrastructure_building (id, text, url_slide_1, url_slide_2, url_slide_3, building_id)
VALUES
    (1, 'Текст инфраструктуры здания 1', 'https://example.com/infra1_slide1.jpg', 'https://example.com/infra1_slide2.jpg', 'https://example.com/infra1_slide3.jpg', 1),
    (2, 'Текст инфраструктуры здания 2', 'https://example.com/infra2_slide1.jpg', 'https://example.com/infra2_slide2.jpg', 'https://example.com/infra2_slide3.jpg', 2);

INSERT INTO infographic_infrastructure (id, alt_image, description, url_image, infrastructure_building_id)
VALUES
    (1, 'Альт инфраструктуры 1', 'Описание инфраструктуры 1', 'https://example.com/infra1.jpg', 1),
    (2, 'Альт инфраструктуры 2', 'Описание инфраструктуры 2', 'https://example.com/infra2.jpg', 2);


INSERT INTO room_building (id, text, url_slide_1, url_slide_2, url_slide_3, building_id)
VALUES
    (1, 'Текст помещения здания 1', 'https://example.com/room1_slide1.jpg', 'https://example.com/room1_slide2.jpg', 'https://example.com/room1_slide3.jpg', 1),
    (2, 'Текст помещения здания 2', 'https://example.com/room2_slide1.jpg', 'https://example.com/room2_slide2.jpg', 'https://example.com/room2_slide3.jpg', 2);

INSERT INTO infographic_rooms (id, alt_image, description, url_image, room_id)
VALUES
    (1, 'Альт помещения 1', 'Описание помещения 1', 'https://example.com/room1.jpg', 1),
    (2, 'Альт помещения 2', 'Описание помещения 2', 'https://example.com/room2.jpg', 2);

INSERT INTO service (id, name, text, url_banner, url_preview, visible)
VALUES
    (1, 'Название услуги 1', 'Описание услуги 1', 'https://example.com/service1.jpg', 'https://example.com/preview1.jpg', 'Да'),
    (2, 'Название услуги 2', 'Описание услуги 2', 'https://example.com/service2.jpg', 'https://example.com/preview2.jpg', 'Нет');

INSERT INTO service_banner (id, text, title, url_image)
VALUES
    (1, 'Текст баннера услуг 1', 'Заголовок баннера услуг 1', 'https://example.com/service_banner1.jpg'),
    (2, 'Текст баннера услуг 2', 'Заголовок баннера услуг 2', 'https://example.com/service_banner2.jpg');

INSERT INTO specification_building (id, text, building_id)
VALUES
    (1, 'Спецификация здания 1', 1),
    (2, 'Спецификация здания 2', 2);

INSERT INTO user (id, address, email, facebook, instagram, name, password, phone_number, telegram, viber)
VALUES
    (1, 'Адрес пользователя 1', 'user1@example.com', 'facebook1', 'instagram1', 'Имя пользователя 1', 'password1', '+79991112233', 'telegram1', 'viber1'),
    (2, 'Адрес пользователя 2', 'user2@example.com', 'facebook2', 'instagram2', 'Имя пользователя 2', 'password2', '+79993334455', 'telegram2', 'viber2');

INSERT INTO additional_email (id, email, users_id)
VALUES
    (1, 'additional1@example.com', 1),
    (2, 'additional2@example.com', 2);