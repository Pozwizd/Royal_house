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

