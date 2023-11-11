-- Insertar usuarios
INSERT INTO users (id, dni,username, name, last_name, password, email, rol_user, city, telephone, gender, avatar)
VALUES
    (1,'77256372L','admin', 'Admin', 'Admin', 'admin', 'admin@gmail.com', 'ADMIN', 'PONTEVEDRA', '643758474', 'MASCULINO', 'https://cdn.cloudflare.steamstatic.com/steamcommunity/public/images/avatars/0f/0f2cfc78fa769b6d050cbf873d892285943a70df_full.jpg'),
    (2,'77256372L', 'barba', 'Francisco Javier', 'Barba Trejo', 'barba', 'barba@gmail.com', 'OFICINA', 'SEVILLA', '643758474', 'MASCULINO', 'https://cdn.cloudflare.steamstatic.com/steamcommunity/public/images/avatars/3d/3ded2173d0cf1494a849e268cf1166af014b062b_full.jpg'),
    (3,'77256372L', 'jose', 'Jose', 'Jose', 'jose','jose@gmail.com', 'ALMACEN', 'SEVILLA', '643758474', 'MASCULINO', 'https://i.pravatar.cc/150?img=5'),
    (4,'55263728L', 'maria', 'maria', 'maria', 'maria','maria@gmail.com','CLIENTE', 'SEVILLA', '643758474', 'FEMENINO', 'https://i.pravatar.cc/150?img=7'),
    (5,'77256372L', 'pepe', 'pepe', 'pepe', 'pepe','pepe@gmail.com','CLIENTE', 'SEVILLA', '643758474', 'FEMENINO', 'https://i.pravatar.cc/150?img=10');

-- Insertar productos
INSERT INTO producto (id,referencia, nombre, descripcion,precio)
VALUES
    (1,'42800056', 'Termostato digital ELIWELL EW961 (GREEN)', 'Termostato para uso industrial',20),
    (2,'42800051', 'Termostato DINFER IC200 ATX ( GREEN)', 'Termostato DINFER para aplicaciones industriales',10),
    (3,'42800101', 'Ventilador 10W', 'Ventilador de 10W para sistemas de refrigeración',5),
    (4,'42800234', 'Sensor de temperatura y humedad', 'Sensor para medir temperatura y humedad en ambientes controlados', 15),
    (5,'42800245', 'Interruptor inteligente Wi-Fi', 'Interruptor con conectividad Wi-Fi para control remoto', 18),
    (6,'42800312', 'Luz LED ajustable', 'Luz LED con intensidad ajustable para ambientes diversos', 12),
    (7,'42800326', 'Cámara de seguridad HD', 'Cámara de seguridad con resolución HD para vigilancia en tiempo real', 30),
    (8,'42800402', 'Cargador inalámbrico rápido', 'Cargador inalámbrico con tecnología de carga rápida', 25);

-- Insertar albaran
INSERT INTO albaran (id,user_id, fecha, no_cliente, vendedor, total_bruto, porcentaje_descuento, importe_descuento, base_imponible, porcentaje_iva, importe_iva, porcentaje_rec, importe_rec, total, forma_pago)
VALUES
    (1,3,'2023-11-07', '37', '3', 419.54, 21, 76.56, 342.98, 21, 72.03, 0, 0, 491.57, 'Contado');

-- Insertar detalles de albaranes
INSERT INTO detalle_albaran (id,albaran_id, producto_id, unidades, porcentaje_descuento, importe)
VALUES
    (1,1, 1, 5, 0, 117.00),
    (2,1, 2, 10, 0, 114.90),
    (3,1, 3, 5, 0, 37.30);
