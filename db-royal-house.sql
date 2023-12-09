create schema db_royal_house;

USE db_royal_house;

# select *
# from requests
# where name like '% %'
#   and phone_number like '% %'
#   and email like '% %'
#   and status = ' ';

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

INSERT INTO subjects (name, area, price, price_per_meter, rooms, floor, floor_area, date_addition)
VALUES ('Квартира', '80 кв. м', '1000000', '12500', '3', '2', '60 кв. м', '2023-10-21 10:00:00'),
       ('Квартира', '65 кв. м', '800000', '12308', '2', '3', '50 кв. м', '2023-10-18 16:20:00'),
       ('Дом', '250 кв. м', '1800000', '7200', '7', '2', '200 кв. м', '2023-10-10 11:55:00'),
       ('Дом', '220 кв. м', '1600000', '7273', '5', '1', '180 кв. м', '2023-10-07 09:30:00');

INSERT INTO about_company (id, text, title, url_banner)
VALUES
    (1, 'Текст о компании 1', 'Заголовок о компании 1', 'https://example.com/banner1.jpg');

INSERT INTO building (id, address, latitude, longitude, main_banner, name, status, text_about, text_location, url_panorama, url_slide_1, url_slide_2, url_slide_3)
VALUES
    (1, 'Адрес здания 1', '50.123456', '30.123456', '/images/Желтый.png',
     'Название здания 1', 'Активен', 'Описание здания 1', 'Описание местоположения 1', 'https://example.com/panorama1.jpg',
     'https://example.com/slide1_1.jpg', 'https://example.com/slide1_2.jpg', 'https://example.com/slide1_3.jpg'),

    (2, 'Адрес здания 2', '52.123456', '32.123456', '/images/Красный.png',
     'Название здания 2', 'Отключен', 'Описание здания 2', 'Описание местоположения 2', 'https://example.com/panorama2.jpg',
     'https://example.com/slide2_1.jpg', 'https://example.com/slide2_2.jpg', 'https://example.com/slide2_3.jpg'),

    (3, 'Адрес здания 3', '52.123456', '32.123456', '/images/Коричневый.png',
     'Название здания 3', 'Отключен', 'Описание здания 3', 'Описание местоположения 3', 'https://example.com/panorama3.jpg',
     'https://example.com/slide3_1.jpg', 'https://example.com/slide3_2.jpg', 'https://example.com/slide3_3.jpg'),

    (4, 'Адрес здания 4', '52.123456', '32.123456', '/images/Серый.png',
     'Название здания 4', 'Отключен', 'Описание здания 4', 'Описание местоположения 4', 'https://example.com/panorama4.jpg',
     'https://example.com/slide4_1.jpg', 'https://example.com/slide4_2.jpg', 'https://example.com/slide4_3.jpg'),

    (5, 'Адрес здания 5', '52.123456', '32.123456', '/images/Синий.png',
     'Название здания 5', 'Отключен', 'Описание здания 5', 'Описание местоположения 5', 'https://example.com/panorama5.jpg',
     'https://example.com/slide5_1.jpg', 'https://example.com/slide5_2.jpg', 'https://example.com/slide5_3.jpg'),

    (6, 'Адрес здания 6', '52.123456', '32.123456', '/images/Фиолетовый.png',
     'Название здания 6', 'Отключен', 'Описание здания 6', 'Описание местоположения 6', 'https://example.com/panorama6.jpg',
     'https://example.com/slide6_1.jpg', 'https://example.com/slide6_2.jpg', 'https://example.com/slide6_3.jpg'),

    (7, 'Адрес здания 7', '52.123456', '32.123456', '/images/Черный.png',
     'Название здания 7', 'Отключен', 'Описание здания 7', 'Описание местоположения 7', 'https://example.com/panorama7.jpg',
     'https://example.com/slide7_1.jpg', 'https://example.com/slide7_2.jpg', 'https://example.com/slide7_3.jpg'),

    (8, 'Адрес здания 8', '52.123456', '32.123456', '/images/Зеленый.png',
     'Название здания 8', 'Отключен', 'Описание здания 8', 'Описание местоположения 8', 'https://example.com/panorama8.jpg',
     'https://example.com/slide8_1.jpg', 'https://example.com/slide8_2.jpg', 'https://example.com/slide8_3.jpg');

INSERT INTO infographic_building (id, description, url_image, building_id)
VALUES
    (1, 'Описание инфографики здания 1', '/images/infographic1.jpg', 1),
    (2, 'Описание инфографики здания 2', '/images/infographic2.jpg', 2);

INSERT INTO infrastructure_building (id, text, url_slide_1, url_slide_2, url_slide_3, building_id)
VALUES
    (1, 'Текст инфраструктуры здания 1', '/images/infra1_slide1.jpg', '/images/infra1_slide2.jpg', '/images/infra1_slide3.jpg', 1),
    (2, 'Текст инфраструктуры здания 2', '/images/infra2_slide1.jpg', '/images/infra2_slide2.jpg', '/images/infra2_slide3.jpg', 2);

INSERT INTO infographic_infrastructure (id, description, url_image, infrastructure_building_id)
VALUES
    (1, 'Описание инфраструктуры 1', '/images/infra1.jpg', 1),
    (2, 'Описание инфраструктуры 2', '/images/infra2.jpg', 2);


INSERT INTO room_building (id, text, url_slide_1, url_slide_2, url_slide_3, building_id)
VALUES
    (1, 'Текст помещения здания 1', '/images/room1_slide1.jpg', '/images/room1_slide2.jpg', '/images/room1_slide3.jpg', 1),
    (2, 'Текст помещения здания 2', '/images/room2_slide1.jpg', '/images/room2_slide2.jpg', '/images/room2_slide3.jpg', 2);

INSERT INTO infographic_rooms (id, alt_image, description, url_image, room_id)
VALUES
    (1, 'Альт помещения 1', 'Описание помещения 1', '/images/room1.jpg', 1),
    (2, 'Альт помещения 2', 'Описание помещения 2', '/images/room2.jpg', 2);

INSERT INTO service (id, name, text, url_banner, url_preview, visible)
VALUES
    (1, 'Название услуги 1', 'Описание услуги 1', '/images/service1.jpg', '/images/preview1.jpg', 'Да'),
    (2, 'Название услуги 2', 'Описание услуги 2', '/images/service2.jpg', '/images/preview2.jpg', 'Нет');

INSERT INTO service_banner (id, text, title, url_image)
VALUES
    (1, 'Текст баннера услуг 1', 'Заголовок баннера услуг 1', '/images/service_banner1.jpg');

INSERT INTO specification_building (id, text, building_id)
VALUES
    (1, 'Спецификация здания 1', 1),
    (2, 'Спецификация здания 2', 2);

INSERT INTO user (id, address, email, facebook, instagram, name, password, phone_number, telegram, viber, building_id)
VALUES
    (1, 'ул. Багованная 1', 'user1@example.com', 'facebook1', 'instagram1', 'user1', '$2a$10$tBs464npVGww.e5RhfkLKOHmIi1FjzCHYy7XfD4M3KPgJewAC2kVq', '+38099999999', 'telegram1', 'viber1', 1);

INSERT INTO additional_email (id, email, users_id)
VALUES
    (1, 'additional1@example.com', 1);

insert into secondary_market (id, url_image, text, url)
VALUES
    (1, '/images/secondary_market1.jpg', 'Описание 1', '/url/to/event1');

insert into image_subject(url_image, subject)
    VALUE
    ('/images/Зеленый.png', 1),
    ('/images/Красный.png', 1),
    ('/images/Синий.png', 1),
    ('/images/Зеленый.png', 2),
    ('/images/Красный.png', 2),
    ('/images/Синий.png', 2),
    ('/images/Зеленый.png', 3),
    ('/images/Красный.png', 3),
    ('/images/Синий.png', 3),
    ('/images/Зеленый.png', 4),
    ('/images/Красный.png', 4),
    ('/images/Синий.png', 4);
