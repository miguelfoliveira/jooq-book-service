DROP TABLE IF EXISTS author_book, author, book;

CREATE TABLE author (
                        id             INT          NOT NULL PRIMARY KEY AUTO_INCREMENT,
                        first_name     VARCHAR(50),
                        last_name      VARCHAR(50)  NOT NULL ,
                        creationTime   TIMESTAMP default CURRENT_TIMESTAMP NOT NULL ,
                        modificationTime   TIMESTAMP default CURRENT_TIMESTAMP


);

CREATE TABLE book (
                      id             INT          NOT NULL PRIMARY KEY AUTO_INCREMENT,
                      title          VARCHAR(100) NOT NULL ,
                      creationTime   TIMESTAMP default CURRENT_TIMESTAMP
                          NOT NULL ,
                      modificationTime   TIMESTAMP default CURRENT_TIMESTAMP

);

CREATE TABLE author_book (
                             author_id      INT          NOT NULL,
                             book_id        INT          NOT NULL,
                             creationTime   TIMESTAMP default CURRENT_TIMESTAMP
                                 NOT NULL ,
                             modificationTime   TIMESTAMP default CURRENT_TIMESTAMP
    ,

                             PRIMARY KEY (author_id, book_id),
                             CONSTRAINT fk_ab_author     FOREIGN KEY (author_id)  REFERENCES author (id)
                                 ON UPDATE CASCADE ON DELETE CASCADE,
                             CONSTRAINT fk_ab_book       FOREIGN KEY (book_id)    REFERENCES book   (id)
);

INSERT INTO author(first_name, last_name, creationTime) VALUES
                       ('Kathy', 'Sierra','2000-01-01 00:00:00'),
                       ('Bert', 'Bates', '2000-01-01 00:00:00'),
                       ('Bryan', 'Basham','2000-01-01 00:00:00');

INSERT INTO book(title) VALUES
                     ('Head First Java'),
                     ('Head First Servlets and JSP'),
                     ('OCA/OCP Java SE 7 Programmer');

INSERT INTO author_book(author_id, book_id) VALUES (1, 1), (1, 3), (2, 1);