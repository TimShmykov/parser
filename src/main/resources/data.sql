CREATE TABLE users (
    id BIGINT AUTO_INCREMENT,
    username VARCHAR,
    url      VARCHAR
);

CREATE TABLE article (
        id BIGINT AUTO_INCREMENT,
        publishDate TIMESTAMP,
        title VARCHAR,
        description VARCHAR,
        url VARCHAR

);
CREATE TABLE category (
        id BIGINT AUTO_INCREMENT,
        name VARCHAR,
        url VARCHAR


);
CREATE TABLE statistic (
        id BIGINT AUTO_INCREMENT,
        rep LONG,
        views LONG,
        bookmarks LONG,
        comments LONG


);



