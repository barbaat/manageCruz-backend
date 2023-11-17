-- Insertar usuarios
INSERT INTO users (id, dni, username, name, last_name, password, email, rol_user, city, telephone, gender, avatar)
VALUES
(1,'77256372L','admin', 'Admin', 'Admin', 'admin', 'admin@gmail.com', 'ADMIN', 'PONTEVEDRA', '643758474', 'MASCULINO', 'https://cdn.cloudflare.steamstatic.com/steamcommunity/public/images/avatars/0f/0f2cfc78fa769b6d050cbf873d892285943a70df_full.jpg'),
(2,'77256372L', 'barba', 'Francisco Javier', 'Barba Trejo', 'barba', 'barba@gmail.com', 'ADMIN', 'SEVILLA', '643758474', 'MASCULINO', 'https://cdn.cloudflare.steamstatic.com/steamcommunity/public/images/avatars/3d/3ded2173d0cf1494a849e268cf1166af014b062b_full.jpg'),
(3,'77256372L', 'jose', 'Jose', 'Jose', 'jose783','jose@gmail.com', 'ALMACEN', 'SEVILLA', '643758474', 'MASCULINO', 'https://i.pravatar.cc/150?img=5'),
(4,'55263728L', 'maria', 'Francisco', 'Alarcón', 'isco342','maria@gmail.com','CLIENTE', 'SEVILLA', '643758474', 'FEMENINO', 'https://i.pravatar.cc/150?img=7'),
(5,'77256372L', 'pepe', 'Pepe', 'Costa', 'pepe','pepe@gmail.com','CLIENTE', 'SEVILLA', '643758474', 'FEMENINO', 'https://i.pravatar.cc/150?img=10'),
(6,'12345678X', 'laura', 'Laura', 'Gomez', 'laura123', 'laura@gmail.com', 'CLIENTE', 'MADRID', '612345678', 'FEMENINO', 'https://i.pravatar.cc/150?img=12'),
(7,'98765432Y', 'carlos', 'Carlos', 'Rodriguez', 'carlos456', 'carlos@gmail.com', 'OFICINA', 'BARCELONA', '698745632', 'MASCULINO', 'https://i.pravatar.cc/150?img=15'),
(8,'87654321Z', 'ana', 'Ana', 'Martinez', 'ana789', 'ana@gmail.com', 'CLIENTE', 'MADRID', '612345678', 'FEMENINO', 'https://i.pravatar.cc/150?img=20'),
(9,'23456789A', 'david', 'David', 'Lopez', 'david234', 'david@gmail.com', 'ALMACEN', 'VALENCIA', '634567890', 'MASCULINO', 'https://i.pravatar.cc/150?img=25'),
(10,'34567890B', 'raquel', 'Raquel', 'Garcia', 'raquel567', 'raquel@gmail.com', 'CLIENTE', 'BARCELONA', '698745632', 'FEMENINO', 'https://i.pravatar.cc/150?img=30'),

(11,'11111111A', 'RocioComercial1', 'Rocío', 'Gutierrez', 'password1', 'rocio1@gmail.com', 'COMERCIAL', 'PONTEVEDRA', '643758474', 'FEMENINO', 'https://i.pravatar.cc/150?img=35'),
(12,'22222222B', 'FJComercial1', 'F.J.', 'Campaña', 'password2', 'fj1@gmail.com', 'COMERCIAL', 'SEVILLA', '643758474', 'MASCULINO', 'https://i.pravatar.cc/150?img=40'),
(13,'33333333C', 'JoseComercial1', 'Jose Manuel', 'Rubio', 'password3', 'jose1@gmail.com', 'COMERCIAL', 'SEVILLA', '643758474', 'MASCULINO', 'https://i.pravatar.cc/150?img=45'),
(14,'44444444D', 'ClaudiaComercial1', 'Claudia', 'Tomé', 'password4', 'claudia1@gmail.com', 'COMERCIAL', 'SEVILLA', '643758474', 'FEMENINO', 'https://i.pravatar.cc/150?img=50'),
(15,'55555555E', 'EustaquioComercial1', 'Eustaquio', 'Eustaquio', 'password5', 'eustaquio1@gmail.com', 'COMERCIAL', 'SEVILLA', '643758474', 'MASCULINO', 'https://i.pravatar.cc/150?img=55'),
(16,'66666666F', 'SergioCaro1', 'Sergio', 'Caro', 'password6', 'sergio1@gmail.com', 'COMERCIAL', 'SEVILLA', '643758474', 'MASCULINO', 'https://i.pravatar.cc/150?img=60'),
(17,'77777777G', 'SergioLopez1', 'Sergio', 'López', 'password7', 'sergio2@gmail.com', 'COMERCIAL', 'SEVILLA', '643758474', 'MASCULINO', 'https://i.pravatar.cc/150?img=65');


-- Insertar productos
INSERT INTO producto (id, nombre, precio)
VALUES
(1, 'Instalaciones',400),
(2, 'Botelleros',200),
(3, 'Mostradores',100);

-- Insertar albaran
INSERT INTO albaran (id, user_id, fecha, vendedor, total, forma_pago, prep_y_conf, tipo_instalacion)
VALUES
(1,4,'2023-11-07','3', 100 ,'Contado',false,'GLACIAL'),
(2,5,'2023-11-08', '2',100 ,'Crédito', true,'GLACIAL'),
(3,6,'2023-11-09', '1', 100 ,'Contado', false,'GLACIAL'),
(4,8,'2023-11-10', '4', 100 ,'Crédito', true,''),
(5,10,'2023-11-11', '5',100 ,'Contado', false,'GLACIAL');

-- Insertar detalles de albaranes
INSERT INTO detalle_albaran (id, albaran_id, producto_id, unidades)
VALUES
(1,1, 1, 5),
(2,1, 2, 10),
(3,1, 3, 5),
(4,2, 1, 2),
(5,2, 2, 1),
(6,2, 3, 3),
(7,3, 1, 1),
(8,3, 2, 2),
(9,4, 2, 3),
(10,4, 3, 2),
(11,5, 1, 2),
(12,5, 3, 1);

INSERT INTO caseta (id, calle, numero, user_id)
VALUES
(1, 'ANTONIO_BIENVENIDA', 1, 3),
(2, 'PEPE_HILLO', 2, 4),
(3, 'PEPE_LUIS_VAZQUEZ', 3, 5),
(4, 'CHICUELO', 4, 6),
(5, 'BOMBITA', 5, 7),
(6, 'COSTILLARES', 6, 8),
(7, 'ESPARTERO', 7, 9),
(8, 'GITANILLO_DE_TRIANA', 8, 10),
(9, 'JOSELITO_EL_GALLO', 9, 3),
(10, 'JUAN_BELMONTE', 10, 4),
(11, 'PASCUAL_MARQUEZ', 11, 5),
(12, 'CURRO_ROMERO', 12, 6),
(13, 'SANCHEZ_MEJIAS', 13, 7),
(14, 'GOMEZ_ORTEGA', 14, 8),
(15, 'MANOLO_VAZQUEZ', 15, 9);