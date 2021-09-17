CREATE DATABASE onlineshop;
USE onlineshop;

CREATE TABLE user (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    first VARCHAR(50) NOT NULL,
    last VARCHAR(50) NOT NULL,
    address VARCHAR(100) NOT NULL,
    isvendor BOOLEAN DEFAULT(0)
);

CREATE TABLE product (
    id BIGINT PRIMARY KEY,
    vid BIGINT NOT NULL,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(500) NOT NULL,
    stock INTEGER DEFAULT(1),
    price DOUBLE DEFAULT(0.0),
    FOREIGN KEY(vid) REFERENCES user(id) ON DELETE CASCADE
);


CREATE TABLE order (
    id BIGINT PRIMARY KEY,
    cid BIGINT NOT NULL,
    vid BIGINT NOT NULL,
    pid BIGINT NOT NULL,
    qty INTEGER NOT NULL,
    price DOUBLE NOT NULL,
    FOREIGN KEY (cid) REFERENCES user(id),
    FOREIGN KEY (pid) REFERENCES product(id),
    FOREIGN KEY (vid) REFERENCES product(vid)
);

CREATE TABLE cart (
    cid BIGINT PRIMARY KEY,
    oid BIGINT,
    FOREIGN KEY (cid) REFERENCES user(id) ON DELETE CASCADE
);






























