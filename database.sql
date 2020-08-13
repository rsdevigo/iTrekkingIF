CREATE TABLE control_point (
    id int AUTO_INCREMENT,
    x int,
    y int,
    z int,
    name varchar(256),
    CONSTRAINT PK_CP PRIMARY KEY (id),
    CONSTRAINT UC_CP UNIQUE (x,y,z)
);

CREATE TABLE player_control_point (
    id int AUTO_INCREMENT,
    x int,
    y int,
    z int,
    point_name varchar(256),
    point_id int,
    player_name varchar(256),
    player_uuid varchar(512),
    epoch timestamp DEFAULT now(),
    CONSTRAINT PK_CP PRIMARY KEY (id),
    CONSTRAINT UC_CP UNIQUE (point_id,player_uuid)
);

-- Exemplo de inserção dos pontos de controle
-- INSERT INTO control_point(x, y, z, name) VALUES(141, 69, -303, "PONTO DE CONTROLE 1");