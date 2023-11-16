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
(10,'34567890B', 'raquel', 'Raquel', 'Garcia', 'raquel567', 'raquel@gmail.com', 'CLIENTE', 'BARCELONA', '698745632', 'FEMENINO', 'https://i.pravatar.cc/150?img=30');

-- Insertar productos
INSERT INTO producto (id, nombre, precio)
VALUES
(1, 'Instalaciones',400),
(2, 'Botelleros',200),
(3, 'Mostradores',100);

-- Insertar albaran
INSERT INTO albaran (id, user_id, fecha, vendedor, total, forma_pago, prep_y_conf)
VALUES
(1,4,'2023-11-07','3', 100 ,'Contado',false),
(2,5,'2023-11-08', '2',100 ,'Crédito', true),
(3,6,'2023-11-09', '1', 100 ,'Contado', false),
(4,8,'2023-11-10', '4', 100 ,'Crédito', true),
(5,10,'2023-11-11', '5',100 ,'Contado', false);

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
(9,4, 1, 3),
(10,4, 2, 2),
(11,4, 3, 1),
(12,5, 1, 2),
(13,5, 3, 1);