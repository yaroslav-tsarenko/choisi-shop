CREATE TABLE IF NOT EXISTS app_user(
    id SERIAL8,
    user_name varchar(55) NOT NULL,
    user_password varchar(255) NOT NULL,
    user_role varchar(10) NOT NULL,
    user_account_expired boolean NOT NULL,
    user_account_locked boolean NOT NULL,
    user_credentials_expired boolean NOT NULL,
    user_enabled boolean NOT NULL,
    PRIMARY KEY(id)
);

-- CONTACTS
CREATE TABlE IF NOT EXISTS contact(
  id SERIAL8,
  user_id int8,
  first_name varchar(255) NOT NULL,
  last_name varchar(255) NOT NULL,
  email varchar(255) NOT NULL,
  phone varchar(255) NOT NULL,
  FOREIGN KEY (user_id) REFERENCES app_user (id),
  PRIMARY KEY(id)
);

-- USER ORDERS
CREATE TABLE IF NOT EXISTS  user_order(
    id SERIAL8,
    order_id int8,
    user_id int8,
    FOREIGN KEY (order_id) REFERENCES app_order (id),
    FOREIGN KEY (user_id) REFERENCES app_user (id),
    PRIMARY KEY(id)
);


-- ORDERS
CREATE TABLE IF NOT EXISTS app_order(
    id SERIAL8,
    creation_date date NOT NULL,
    order_comment varchar(255),
    order_approved boolean NOT NULL,
    order_canceled boolean NOT NULL,
    PRIMARY KEY(id)
);

-- PRODUCTS
CREATE TABLE IF NOT EXISTS  app_product(
    id SERIAL8,
    creation_date date NOT NULL,
    product_name varchar(255) NOT NULL,
    product_amount bigint NOT NULL,
    product_price varchar(255) NOT NULL,
    product_discount varchar(255) NOT NULL,
    product_description varchar(255),
    PRIMARY KEY(id)
);

-- ORDERED PRODUCTS
CREATE TABLE IF NOT EXISTS ordered_products(
    id SERIAL8,
    order_id int8,
    product_id int8,
    FOREIGN KEY (order_id) REFERENCES app_order (id),
    FOREIGN KEY (product_id) REFERENCES app_product (id),
    PRIMARY KEY(id)
);

-- FILE
CREATE TABLE IF NOT EXISTS app_file(
  id SERIAL8,
  file_name varchar(255) NOT NULL,
  file_extension varchar(255) NOT NULL,
  creation_date date NOT NULL,
  file_data varchar(255) NOT NULL,
  PRIMARY KEY(id)
);



-- PRODUCT FILES
CREATE TABLE IF NOT EXISTS product_files(
    id SERIAL8,
    product_id int8,
    file_id int8,
    FOREIGN KEY (product_id) REFERENCES app_product (id),
    FOREIGN KEY (file_id) REFERENCES file (id),
    PRIMARY KEY(id)
);



