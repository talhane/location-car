CREATE TABLE IF NOT EXISTS car (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  brand VARCHAR(255),
  model VARCHAR(255),
  registration_number VARCHAR(255) UNIQUE,
  status VARCHAR(255),
  price_per_day DOUBLE
);

CREATE TABLE IF NOT EXISTS client (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(255),
  last_name VARCHAR(255),
  email VARCHAR(255) UNIQUE,
  phone VARCHAR(255),
  address VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS rental (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  car_id BIGINT,
  client_id BIGINT,
  start_date DATE,
  end_date DATE,
  total_price DOUBLE,
  FOREIGN KEY (car_id) REFERENCES car(id),
  FOREIGN KEY (client_id) REFERENCES client(id)
);
