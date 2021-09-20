CREATE DATABASE onlineshop;
USE onlineshop;

CREATE TABLE user (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    cart BIGINT,
    first VARCHAR(50) NOT NULL,
    last VARCHAR(50) NOT NULL,
    address VARCHAR(100) NOT NULL,
    isvendor BOOLEAN DEFAULT(0),
    FOREIGN KEY (cart) REFERENCES cart(id)
);

CREATE TABLE product (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    vid BIGINT NOT NULL,
    name VARCHAR(100) NOT NULL,
    des VARCHAR(500) NOT NULL,
    stock INTEGER DEFAULT(1),
    price DOUBLE DEFAULT(0.0),
    FOREIGN KEY(vid) REFERENCES user(id) ON DELETE CASCADE
);

CREATE TABLE cart (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    customer BIGINT NOT NULL,
    total DOUBLE NOT NULL,
    FOREIGN KEY (customer) REFERENCES user(id)
);

CREATE TABLE cart_item (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    product BIGINT NOT NULL,
    qty INTEGER NOT NULL,
    FOREIGN KEY (id) REFERENCES cart(id),
    FOREIGN KEY (product) REFERENCES product(id)
);

CREATE TABLE orders (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    cart BIGINT NOT NULL,
    FOREIGN KEY (id) REFERENCES user(id) ON DELETE CASCADE,
    FOREIGN KEY (cart) REFERENCES cart(id) ON DELETE CASCADE
);

/*
FOREIGN KEY (cid) REFERENCES user(id),
    FOREIGN KEY (pid) REFERENCES product(id),
    FOREIGN KEY (vid) REFERENCES product(vid)
*/

#
# CREATE TABLE orders (
#     id BIGINT PRIMARY KEY AUTO_INCREMENT,
#     cid BIGINT NOT NULL,
#     vid BIGINT NOT NULL,
#     pid BIGINT NOT NULL,
#     qty INTEGER NOT NULL,
#     price DOUBLE NOT NULL,
#     FOREIGN KEY (cid) REFERENCES user(id),
#     FOREIGN KEY (pid) REFERENCES product(id),
#     FOREIGN KEY (vid) REFERENCES product(vid)
# );
#
# CREATE TABLE cart (
#     id BIGINT PRIMARY KEY AUTO_INCREMENT,
#     oid BIGINT,
#     FOREIGN KEY (id) REFERENCES user(id) ON DELETE CASCADE,
#     FOREIGN KEY (oid) REFERENCES orders(id) ON DELETE CASCADE
# );

CREATE TABLE user (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    vendor_id BIGINT,
    cart_id BIGINT,
    first VARCHAR(50) NOT NULL,
    last VARCHAR(50) NOT NULL
);

CREATE TABLE product (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    description VARCHAR(100),
    vendor_id BIGINT,
    stock INTEGER DEFAULT(0),
    price DOUBLE DEFAULT(0)
);

CREATE TABLE cart (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT,
    total DOUBLE DEFAULT(0.0)
);

CREATE TABLE item (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    cart_id BIGINT,
    customer_id BIGINT,
    product_id BIGINT,
    vendor_id BIGINT,
    quantity INTEGER DEFAULT(0),
    price DOUBLE DEFAULT(0.0)

);

CREATE TABLE orders (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    vendor_id BIGINT,
    item_id BIGINT
);

ALTER TABLE product
    ADD CONSTRAINT FOREIGN KEY(vendor_id) REFERENCES user(vendor_id);

ALTER TABLE item
    ADD CONSTRAINT FOREIGN KEY(cart_id) REFERENCES cart(id),
    ADD CONSTRAINT FOREIGN KEY(product_id) REFERENCES product(id),
    ADD CONSTRAINT FOREIGN KEY(customer_id) REFERENCES user(id),
    ADD CONSTRAINT FOREIGN KEY(vendor_id) REFERENCES product(vendor_id);

ALTER TABLE cart
    ADD CONSTRAINT FOREIGN KEY(id) REFERENCES item(cart_id),
    ADD CONSTRAINT FOREIGN KEY(user_id) REFERENCES user(id);

ALTER TABLE orders
    ADD CONSTRAINT FOREIGN KEY(id) REFERENCES item(vendor_id),
    ADD CONSTRAINT FOREIGN KEY(item_id) REFERENCES item(id);



























