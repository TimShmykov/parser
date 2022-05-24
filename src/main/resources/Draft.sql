INSERT INTO users (username) VALUES ('Tim'), ('Mike'), ('Antony');

SELECT username FROM users;
SELECT username FROM users                      ORDER BY username DESC LIMIT 3;
SELECT *        FROM users WHERE username = 'Tim';
SELECT count(*) FROM users;
UPDATE users SET url = 'http://vk.com/zdadco', username = '';
UPDATE users SET url = 'http://vk.com/zdadco' WHERE username = 'Tim';

DELETE FROM users WHERE url is null;