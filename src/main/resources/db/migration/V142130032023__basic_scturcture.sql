CREATE TABLE IF NOT EXISTS app_user(
    id SERIAL NOT NULL PRIMARY KEY,
    user_name varchar(55) NOT NULL,
    user_password varchar(255) NOT NULL,
    user_role varchar(10) NOT NULL,
    user_account_expired boolean NOT NULL,
    user_account_locked boolean NOT NULL,
    user_credentials_expired boolean NOT NULL,
    user_enabled boolean NOT NULL
);

-- CONTACTS
CREATE TABlE IF NOT EXISTS contact(
  id SERIAL NOT NULL PRIMARY KEY,
  user_id int8,
  first_name varchar(255) NOT NULL,
  last_name varchar(255) NOT NULL,
  email varchar(255) NOT NULL,
  phone varchar(255) NOT NULL,
  FOREIGN KEY (user_id) REFERENCES app_user (id)
);

-- USER ORDERS
CREATE TABLE IF NOT EXISTS  user_order(
    id SERIAL NOT NULL PRIMARY KEY,
    order_id int8,
    user_id int8,
    FOREIGN KEY (order_id) REFERENCES app_order (id),
    FOREIGN KEY (user_id) REFERENCES app_user (id)
);


-- ORDERS
CREATE TABLE IF NOT EXISTS app_order(
    id SERIAL NOT NULL PRIMARY KEY,
    creation_date date NOT NULL,
    order_comment varchar(255),
    order_approved boolean NOT NULL,
    order_canceled boolean NOT NULL
);

-- PRODUCTS
CREATE TABLE IF NOT EXISTS  app_product(
    id SERIAL NOT NULL PRIMARY KEY,
    creation_date date NOT NULL,
    product_name varchar(255) NOT NULL,
    product_amount bigint NOT NULL,
    product_price varchar(255) NOT NULL,
    product_discount varchar(255) NOT NULL,
    product_description varchar(255)
);

-- ORDERED PRODUCTS
CREATE TABLE IF NOT EXISTS ordered_product(
    id SERIAL NOT NULL PRIMARY KEY,
    order_id int8,
    product_id int8,
    FOREIGN KEY (order_id) REFERENCES app_order (id),
    FOREIGN KEY (product_id) REFERENCES app_product (id)
);

-- FILE
CREATE TABLE IF NOT EXISTS app_file(
  id SERIAL NOT NULL PRIMARY KEY,
  file_name varchar(255) NOT NULL,
  file_extension varchar(255) NOT NULL,
  creation_date date NOT NULL,
  file_data varchar(255) NOT NULL
);


-- PRODUCT FILES
CREATE TABLE IF NOT EXISTS product_file(
    id SERIAL NOT NULL PRIMARY KEY,
    product_id int8,
    file_id int8,
    FOREIGN KEY (product_id) REFERENCES app_product (id),
    FOREIGN KEY (file_id) REFERENCES app_file (id)
);



