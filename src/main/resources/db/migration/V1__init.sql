CREATE TABLE IF NOT EXISTS country (
    id SERIAL,
    code VARCHAR(10) NOT NULL,
    country_name VARCHAR(100) NOT NULL,
    continent_name VARCHAR(100) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (code)
    );

CREATE TABLE IF NOT EXISTS userr (
    id SERIAL,
    fullname VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    gender VARCHAR(10),
    date_of_birth DATE,
    created_at TIMESTAMP,
    country_id INT,
    PRIMARY KEY (id),
    UNIQUE (email),
    FOREIGN KEY (country_id) REFERENCES country(id)
    );

CREATE TABLE IF NOT EXISTS merchant (
    id SERIAL,
    merchant_name VARCHAR(100) NOT NULL,
    created_at TIMESTAMP,
    userr_id INT,
    country_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (country_id) REFERENCES country(id),
    FOREIGN KEY (userr_id) REFERENCES userr(id)
    );

CREATE TABLE IF NOT EXISTS product (
    id SERIAL,
    description VARCHAR(255) NOT NULL,
    merchant_id INT,
    price DECIMAL(10,2),
    status VARCHAR(50),
    created_at TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (merchant_id) REFERENCES merchant(id)
    );

CREATE TABLE IF NOT EXISTS orderr (
    id SERIAL,
    status VARCHAR(50),
    created_at TIMESTAMP,
    userr_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (userr_id) REFERENCES userr(id)
    );

CREATE TABLE IF NOT EXISTS order_item (
    id SERIAL,
    quantity INT NOT NULL,
    order_id INT,
    product_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (order_id) REFERENCES orderr(id),
    FOREIGN KEY (product_id) REFERENCES product(id)
    );
