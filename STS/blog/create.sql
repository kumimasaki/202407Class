CREATE TABLE blogs (
    blog_id SERIAL PRIMARY KEY,
    blog_title VARCHAR NOT NULL,
    register_date DATE NOT NULL,
    blog_image VARCHAR NOT NULL,
    blog_detail TEXT NOT NULL,
    category VARCHAR NOT NULL,
    user_id BIGINT
);

CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    user_name VARCHAR NOT NULL,
    email VARCHAR NOT NULL,
    password VARCHAR NOT NULL,
    register_date TIMESTAMP NOT NULL
);