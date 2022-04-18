-- create order table
create table order_t
(
    order_id    int(10) primary key auto_increment,
    tax         float(10, 2),
    meals       varchar(255),
    price       float(10, 2),
    driver_name varchar(255)
);

-- insert data into order table
INSERT INTO order_t (tax, meals, price, driver_name)
VALUES (12.23, 'Meal 1', 12.3, 'Abdul Hakim');
INSERT INTO order_t (tax, meals, price, driver_name)
VALUES (2.28, 'Meal 2', 16.2, 'Mohammad Ali');
INSERT INTO order_t (tax, meals, price, driver_name)
VALUES (4.2, 'Meal 3', 16.4, 'Ibrahim Hasan');
INSERT INTO order_t (tax, meals, price, driver_name)
VALUES (4.2, 'Meal 4', 16.4, 'Mohammad Ali');

-- create restaurant table
create table restaurant
(
    rest_id      int(10) primary key auto_increment,
    offers       varchar(100),
    type_of_food varchar(256) not null,
    meal_name    varchar(256) not null,
    order_id     int,
    FOREIGN KEY (order_id) REFERENCES order_t (order_id)
);

-- insert into restaurant db
INSERT INTO restaurant (offers, type_of_food, meal_name, order_id)
VALUES ('Buy 1 get 1', 'Rice', 'Biriyani', 1);
INSERT INTO restaurant (offers, type_of_food, meal_name, order_id)
VALUES ('Buy 2 get 1', 'Rice', 'Kacchi', 2);
INSERT INTO restaurant (offers, type_of_food, meal_name, order_id)
VALUES ('Buy 3 get 1', 'Fast-food', 'Pizza', 3);
INSERT INTO restaurant (offers, type_of_food, meal_name, order_id)
VALUES ('Buy 4 get 1', 'Sea', 'Octopus', 4);

-- create registration table
create table registration
(
    reg_id    int(10) primary key auto_increment,
    email     varchar(256) unique not null,
    pass      varchar(255)        not null,
    phone_num varchar(256) unique not null,
    address   varchar(256)        not null,
    rest_id   int,
    FOREIGN KEY (rest_id) REFERENCES restaurant (rest_id)
);

-- insert into registration db
INSERT INTO registration (email, pass, phone_num, address, rest_id)
VALUES ('ali@mail.com', '1234', '+999', 'Damamm', 1);
INSERT INTO registration (email, pass, phone_num, address, rest_id)
VALUES ('momin@mail.com', '1233', '+111', 'ALKobar', 2);
INSERT INTO registration (email, pass, phone_num, address, rest_id)
VALUES ('hanif@mail.com', '1324', '+5234', 'Riyadh', 3);
INSERT INTO registration (email, pass, phone_num, address, rest_id)
VALUES ('akbar@mail.com', '6234', '+623', 'Riyadh', 4);

-- create admin table
create table admin
(
    admin_id   int(10) primary key auto_increment,
    cust_name  varchar(256) not null,
    all_orders varchar(256) not null,
    rest_menu  varchar(256) not null,
    order_id   int,
    FOREIGN KEY (order_id) REFERENCES order_t (order_id)
);

-- insert into admin db
INSERT INTO admin (cust_name, all_orders, rest_menu, order_id)
VALUES ('Mohammad ALi', 'All Order 1', 'Rest Menu 1', 1);
INSERT INTO admin (cust_name, all_orders, rest_menu, order_id)
VALUES ('Habib Ahmed', 'All Order 2', 'Rest Menu 2', 2);
INSERT INTO admin (cust_name, all_orders, rest_menu, order_id)
VALUES ('Zohan Hasan', 'All Order 3', 'Rest Menu 3', 3);
INSERT INTO admin (cust_name, all_orders, rest_menu, order_id)
VALUES ('Hasan Mia', 'All Order 4', 'Rest Menu 4', 4);
