CREATE TABLE users (
    id      BIGSERIAL   PRIMARY KEY,
    username            VARCHAR    NOT NULL,
    url                 VARCHAR    NOT NULL
);

CREATE TABLE statistic (
        id          BIGSERIAL PRIMARY KEY,
        rep         BIGINT NOT NULL,
        views       BIGINT NOT NULL,
        bookmarks   BIGINT NOT NULL,
        comments    BIGINT NOT NULL
);


CREATE TABLE category (
        id  BIGSERIAL     PRIMARY KEY,
        name              VARCHAR NOT NULL,
        url               VARCHAR NOT NULL


);


CREATE TABLE article (
        id          BIGSERIAL    PRIMARY KEY,
        user_id     BIGINT      NOT NULL REFERENCES users (id),
        statistic_id BIGINT     NOT NULL REFERENCES statistic(id),
        publish_date TIMESTAMP   NOT NULL,
        title       VARCHAR     NOT NULL,
        description VARCHAR     NOT NULL,
        url         VARCHAR     NOT NULL,
        UNIQUE (user_id, title)

    );


CREATE TABLE articles_categories
(
article_id  BIGINT NOT NULL REFERENCES article(id),
category_id BIGINT NOT NULL REFERENCES category (id)
)


