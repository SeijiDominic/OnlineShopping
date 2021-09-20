CREATE TABLE user (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    vendor_id BIGINT,
    first VARCHAR(50) NOT NULL,
    last VARCHAR(50) NOT NULL
);

CREATE TABLE product (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    description VARCHAR(100),
    stock INTEGER DEFAULT(0),
    price DOUBLE DEFAULT(0)
);

CREATE TABLE cart (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    customer_id BIGINT
);

CREATE TABLE item (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    cart_id BIGINT,
    customer_id BIGINT,
    product_id BIGINT,
    vendor_id BIGINT,
    quantity INTEGER DEFAULT(0),
    total DOUBLE DEFAULT(0.0)

);

CREATE TABLE orders (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    vendor_id BIGINT,
    item_id BIGINT
);

# ALTER TABLE user
#     ADD CONSTRAINT FOREIGN KEY(cart_id) REFERENCES cart(id);

ALTER TABLE product
    ADD CONSTRAINT FOREIGN KEY(vendor_id) REFERENCES user(id);

ALTER TABLE item
    ADD CONSTRAINT FOREIGN KEY(cart_id) REFERENCES cart(id),
    ADD CONSTRAINT FOREIGN KEY(product_id) REFERENCES product(id),
    ADD CONSTRAINT FOREIGN KEY(customer_id) REFERENCES cart(customer_id),
    ADD CONSTRAINT FOREIGN KEY(vendor_id) REFERENCES product(vendor_id);

ALTER TABLE cart
    ADD CONSTRAINT FOREIGN KEY(customer_id) REFERENCES user(id);

ALTER TABLE orders
    ADD CONSTRAINT FOREIGN KEY(vendor_id) REFERENCES item(vendor_id),
    ADD CONSTRAINT FOREIGN KEY(item_id) REFERENCES item(id);