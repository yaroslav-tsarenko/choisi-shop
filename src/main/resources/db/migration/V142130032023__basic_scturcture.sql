CREATE TABLE IF NOT EXISTS app_user
(
    id                         SERIAL8,
    name                       varchar(55)  NOT NULL,
    password                   varchar(255) NOT NULL,
    role                       varchar(10)  NOT NULL,
    is_account_non_locked      boolean      NOT NULL,
    is_credentials_non_expired boolean      NOT NULL,
    is_enabled                 boolean      NOT NULL,
    PRIMARY KEY (id)
);

-- CONTACTS
CREATE TABlE IF NOT EXISTS contact
(
    id         SERIAL8,
    user_id    int8,
    first_name varchar(255) NOT NULL,
    last_name  varchar(255) NOT NULL,
    email      varchar(255) NOT NULL,
    phone      varchar(255) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES app_user (id),
    PRIMARY KEY (id)
);

-- USER ORDERS
CREATE TABLE IF NOT EXISTS user_order
(
    id       SERIAL8,
    order_id int8,
    user_id  int8,
    FOREIGN KEY (order_id) REFERENCES app_order (id),
    FOREIGN KEY (user_id) REFERENCES app_user (id),
    PRIMARY KEY (id)
);

-- ORDERS
CREATE TABLE IF NOT EXISTS app_order
(
    id            SERIAL8,
    creation_date date    NOT NULL,
    comment       varchar(255),
    is_approved   boolean NOT NULL,
    is_canceled   boolean NOT NULL,
    PRIMARY KEY (id)
);

-- PRODUCTS
CREATE TABLE IF NOT EXISTS app_product
(
    id            SERIAL8,
    creation_date date         NOT NULL,
    name          varchar(255) NOT NULL,
    amount        bigint       NOT NULL,
    price         varchar(255) NOT NULL,
    discount      varchar(255) NOT NULL,
    description   varchar(255),
    PRIMARY KEY (id)
);


-- ORDERED PRODUCTS
CREATE TABLE IF NOT EXISTS ordered_products
(
    id         SERIAL8,
    order_id   int8,
    product_id int8,
    FOREIGN KEY (order_id) REFERENCES app_order (id),
    FOREIGN KEY (product_id) REFERENCES app_product (id),
    PRIMARY KEY (id)
);

-- FILE
CREATE TABLE IF NOT EXISTS app_file
(
    id             SERIAL8,
    file_name      varchar(255) NOT NULL,
    file_extension varchar(255) NOT NULL,
    creation_date  date         NOT NULL,
    file_data      bytea        NOT NULL,
    PRIMARY KEY (id)
);


-- PRODUCT FILES
CREATE TABLE IF NOT EXISTS product_files
(
    id         SERIAL8,
    product_id int8,
    file_id    int8,
    FOREIGN KEY (product_id) REFERENCES app_product (id),
    FOREIGN KEY (file_id) REFERENCES app_file (id),
    PRIMARY KEY (id)
);



