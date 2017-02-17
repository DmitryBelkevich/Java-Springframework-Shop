DROP DATABASE IF EXISTS database001;
CREATE DATABASE database001;
USE database001;

CREATE TABLE product (id bigint not null auto_increment, count integer, description longtext, price decimal(19,2), title varchar(50), product_category_id bigint, primary key (id));
CREATE TABLE product_category (id bigint not null auto_increment, title varchar(255), primary key (id));
CREATE TABLE product_order (id bigint not null auto_increment, date datetime, product_id bigint, user_id bigint, primary key (id));
CREATE TABLE role (id bigint not null auto_increment, description varchar(255), title varchar(25) not null check (title>=4), primary key (id));
CREATE TABLE user (id bigint not null auto_increment, password varchar(64) not null, username varchar(25) not null, primary key (id));
CREATE TABLE user_role (user_id bigint not null, role_id bigint not null, primary key (user_id, role_id));

ALTER TABLE product add constraint FKcwclrqu392y86y0pmyrsi649r foreign key (product_category_id) references product_category (id);
ALTER TABLE product_order add constraint FKh73acsd9s5wp6l0e55td6jr1m foreign key (product_id) references product (id);
ALTER TABLE product_order add constraint FKa9own0mc8gwle8cckiij9ubsl foreign key (user_id) references user (id);
ALTER TABLE user_role add constraint FKa68196081fvovjhkek5m97n3y foreign key (role_id) references role (id);
ALTER TABLE user_role add constraint FK859n2jvi8ivhui0rl0esws6o foreign key (user_id) references user (id);

INSERT INTO role (description, title) VALUES
('simple users', 'ROLE_USER'),
('has access to admin page', 'ROLE_ADMIN'),
('has access to database', 'ROLE_ADMIN_DB');

INSERT INTO user (username, password) VALUES
('user', '81dc9bdb52d04dc20036dbd8313ed055'),
('admin', '81dc9bdb52d04dc20036dbd8313ed055'),
('admin_db', '81dc9bdb52d04dc20036dbd8313ed055');

INSERT INTO user_role (user_id, role_id) VALUES
(1, 1),
(2, 2),
(3, 3);