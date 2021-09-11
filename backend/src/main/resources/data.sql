INSERT INTO tb_user (name, email, password) VALUES ('Ana Brown', 'ana@gmail.com', '$2a$12$Sxm6igZeJFhDpAE3qjK/d.Hr6gZ7Mvn4khGgk/IvrSOYBY2Qo98W2');
INSERT INTO tb_user (name, email, password) VALUES ('James Red', 'james@gmail.com', '$2a$12$Sxm6igZeJFhDpAE3qjK/d.Hr6gZ7Mvn4khGgk/IvrSOYBY2Qo98W2');
INSERT INTO tb_user (name, email, password) VALUES ('Alex Green', 'alex@gmail,com', '$2a$12$Sxm6igZeJFhDpAE3qjK/d.Hr6gZ7Mvn4khGgk/IvrSOYBY2Qo98W2');

INSERT INTO tb_role (authority) VALUES ('ROLE_STUDENT');
INSERT INTO tb_role (authority) VALUES ('ROLE_INSTRUCTOR'); 
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 3);
