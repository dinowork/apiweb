INSERT INTO usuario (id, nome, senha) values (nextval('sq_usuario'), 'jao'  , '123');
INSERT INTO usuario (id, nome, senha) values (nextval('sq_usuario'), 'ana'  , '123');
INSERT INTO usuario (id, nome, senha) values (nextval('sq_usuario'), 'mara' , '123');

INSERT INTO estado (id, uf) values (nextval('sq_estado'), 'SP');
INSERT INTO estado (id, uf) values (nextval('sq_estado'), 'RJ');
INSERT INTO estado (id, uf) values (nextval('sq_estado'), 'MG');
INSERT INTO estado (id, uf) values (nextval('sq_estado'), 'BA');

INSERT INTO cliente (id, nome, email) values (nextval('sq_cliente'), 'Jota', 'jota@jota.com.br');