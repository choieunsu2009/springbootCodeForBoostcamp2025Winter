INSERT INTO article(title, content) values ('111', '111');
INSERT INTO article(title, content) values ('222', '222');
INSERT INTO article(title, content) values ('333', '333');

INSERT INTO comment(article_id, nickname, body) values (1, 'qwer', '1234');
INSERT INTO comment(article_id, nickname, body) values (1, 'asdf', '4321');
INSERT INTO comment(article_id, nickname, body) values (1, 'tyui', '7892');

INSERT INTO comment(article_id, nickname, body) values (2, 'qwer', '0987');
INSERT INTO comment(article_id, nickname, body) values (2, 'asdf', '7890');
INSERT INTO comment(article_id, nickname, body) values (2, 'tyui', '345678');

INSERT INTO comment(article_id, nickname, body) values (3, 'qwer', '37645');
INSERT INTO comment(article_id, nickname, body) values (3, 'asdf', 'weyrt');
INSERT INTO comment(article_id, nickname, body) values (3, 'tyui', 'tryuk');

ALTER TABLE comment
    ADD CONSTRAINT fk_child_parent
        FOREIGN KEY (article_id) REFERENCES article(id)
            ON DELETE CASCADE;