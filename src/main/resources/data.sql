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
INSERT INTO producto (id, referencia, nombre, descripcion, precio)
VALUES
(1,'42800056', 'Termostato digital ELIWELL EW961 (GREEN)', 'Termostato para uso industrial',20),
(2,'42800051', 'Termostato DINFER IC200 ATX ( GREEN)', 'Termostato DINFER para aplicaciones industriales',10),
(3,'42800101', 'Ventilador 10W', 'Ventilador de 10W para sistemas de refrigeración',5),
(4,'42800234', 'Sensor de temperatura y humedad', 'Sensor para medir temperatura y humedad en ambientes controlados', 15),
(5,'42800245', 'Interruptor inteligente Wi-Fi', 'Interruptor con conectividad Wi-Fi para control remoto', 18),
(6,'42800312', 'Luz LED ajustable', 'Luz LED con intensidad ajustable para ambientes diversos', 12),
(7,'42800326', 'Cámara de seguridad HD', 'Cámara de seguridad con resolución HD para vigilancia en tiempo real', 30),
(8,'42800402', 'Cargador inalámbrico rápido', 'Cargador inalámbrico con tecnología de carga rápida', 25),
(9,'42800345', 'Altavoz Bluetooth portátil', 'Altavoz con tecnología Bluetooth para reproducción inalámbrica', 35),
(10,'42800412', 'Auriculares inalámbricos con cancelación de ruido', 'Auriculares con tecnología de cancelación de ruido', 80),
(11,'42800423', 'Teclado mecánico para gaming', 'Teclado mecánico diseñado para jugadores exigentes', 60),
(12,'42800501', 'Monitor LED 27 pulgadas', 'Monitor LED con resolución Full HD para una experiencia visual inmersiva', 200),
(13,'42800515', 'Impresora multifunción', 'Impresora con funciones de impresión, escaneo y copia', 120);

-- Insertar albaran
INSERT INTO albaran (id, user_id, fecha, no_cliente, vendedor, total_bruto, porcentaje_descuento, importe_descuento, base_imponible, porcentaje_iva, importe_iva, porcentaje_rec, importe_rec, total, forma_pago, prep_y_conf)
VALUES
(1,4,'2023-11-07', '37', '3', 419.54, 21, 76.56, 342.98, 21, 72.03, 0, 0, 491.57, 'Contado',false),
(2,5,'2023-11-08', '45', '2', 670.20, 18, 120.84, 549.36, 21, 115.17, 0, 0, 644.53, 'Crédito', true),
(3,6,'2023-11-09', '22', '1', 265.80, 15, 39.87, 225.93, 21, 47.44, 0, 0, 273.37, 'Contado', false),
(4,8,'2023-11-10', '11', '4', 480.00, 20, 96.00, 384.00, 21, 80.64, 0, 0, 464.64, 'Crédito', true),
(5,10,'2023-11-11', '89', '5', 495.00, 10, 49.50, 445.50, 21, 93.44, 0, 0, 538.94, 'Contado', false);

-- Insertar detalles de albaranes
INSERT INTO detalle_albaran (id, albaran_id, producto_id, unidades, porcentaje_descuento, importe)
VALUES
(1,1, 1, 5, 0, 117.00),
(2,1, 2, 10, 0, 114.90),
(3,1, 3, 5, 0, 37.30),
(4,2, 9, 2, 0, 70.00),
(5,2, 10, 1, 0, 80.00),
(6,2, 11, 3, 0, 180.00),
(7,3, 12, 1, 0, 200.00),
(8,3, 13, 2, 0, 240.00),
(9,4, 9, 3, 0, 105.00),
(10,4, 10, 2, 0, 160.00),
(11,4, 11, 1, 0, 60.00),
(12,5, 12, 2, 0, 240.00),
(13,5, 13, 1, 0, 120.00);