INSERT INTO categoria (nombre_categoria) VALUES
('Lacteos'),
('Bebidas'),
('Galletas'),
('Jugos'),
('Panadería'),
('Congelados'),
('Snacks');

INSERT INTO ubicacion(id_ubicacion, descripcion) VALUES
(1, 'Bodega'),
(2, 'Mostrador Principal');


INSERT INTO producto (cod_barra, nombre_producto, descripcion, precio_unitario, stock_min, id_categoria) VALUES
(1001, 'Leche Chocolate 200cc ', 'Leche Fluida Semidescremada Chocolate Colun, 200ml', 590, 130, 1),
(1002, 'Yoghurt Protein Natural 155 g', 'Yoghurt Batido Protein+ Natural Endulzado Soprole, 155g', 650, 150, 1),
(2001, 'Agua Mineral Con Gas Botella 1,6 L', 'Agua Mineral Gasificada Cachantun, 1600ml', 1090, 20, 2),
(2002, 'Bebida Coca-Cola Original 350 cc', 'Bebida de Fantasía Original Coca-Cola, 350ml', 700, 25, 2),
(3001, 'Galletas De Chocolate Crema Vainilla 108 g', 'Galletas Rellenas Original Oreo 108g', 790, 200, 3),
(3002, 'Galletas Frac Vainilla 110 g', 'Galletas Frac Vainilla Costa 110g', 690, 50, 3),
(4001, 'Néctar Multi-Frutilla Caja, 200 ml', 'Néctar de Fruta Multi Frutilla Del Valle, 200ml', 400, 80, 4),
(4002, 'Jugo Manzana Ciruela Orgánico Caja 330 ml', 'Jugo de Fruta Orgánico Manzana y Ciruela Ama Time, 330ml', 1300, 30, 4),
(5001, 'Pan Integral Rebanado 500g', 'Pan de molde integral con semillas', 1800, 15, 5),
(5002, 'Baguette Pre-cocida 200g', 'Baguette para hornear en casa', 950, 20, 5),
(6001, 'Helado Vainilla 1L', 'Helado cremoso sabor vainilla', 3500, 25, 6),
(6002, 'Papas Fritas Congeladas 1kg', 'Papas pre-fritas y congeladas', 2200, 50, 6),
(7001, 'Mix de Frutos Secos 150g', 'Almendras, nueces y pasas', 2100, 20, 7),
(7002, 'Barra de Cereal Avena y Miel', 'Barra energética individual', 600, 30, 7),
(1003, 'Leche Descremada 1L', 'Leche fluida descremada Larga Vida', 990, 50, 1),
(2003, 'Agua Purificada Sin Gas 500ml', 'Botella de agua purificada', 600, 40, 2);

INSERT INTO proveedor (rut_proveedor, dv_proveedor, nombre_proveedor, telefono_proveedor, email_proveedor, direccion_proveedor) VALUES
(76543210, '7', 'Distribuidora Dulce Sabor', '987123456', 'ventas@dulcesabor.cl', 'Calle Los Dulces 789, Valparaíso'),
(23456789, '2', 'Snacks y Galletas Ltda.', '912678345', 'contacto@snacksygalletas.cl', 'Avenida Colaciones 321, Concepción'),
(67890123, 'K', 'Importadora de Golosinas', '923456789', 'golosinas@importadora.cl', NULL);

INSERT INTO lote (cod_barra, numero_lote, stock_lote, fecha_vencimiento, id_orden_compra, id_proveedor, id_ubicacion) VALUES
(1001, 101, 50, '2025-12-31', NULL, 1, 1), -- Leche Chocolate 200cc (Bodega)
(3001, 102, 150, '2025-11-15', NULL, 2, 2), -- Galletas Oreo 108g (Mostrador Principal)
(4002, 103, 100, '2025-10-10', NULL, 3, 1), -- Jugo Manzana Ciruela 330ml (Bodega)
(2001, 104, 180, '2026-01-20', NULL, 1, 1), -- Agua Mineral Con Gas 1.6L (Bodega)
(2001, 106, 100, '2026-04-20', NULL, 1, 2), -- Agua Mineral Con Gas 1.6L (Mostrador Principal)
(5001, 201, 40, '2025-07-20', NULL, 1, 1), -- Pan Integral 500g (Bodega)
(5002, 202, 30, '2025-07-25', NULL, 1, 1), -- Baguette 200g (Bodega)
(6001, 203, 25, '2026-06-30', NULL, 2, 1), -- Helado Vainilla 1L (Bodega)
(6002, 204, 35, '2026-05-15', NULL, 2, 1), -- Papas Fritas 1kg (Bodega)
(7001, 205, 50, '2025-09-01', NULL, 3, 2), -- Mix Frutos Secos 150g (Mostrador Principal)
(7002, 206, 60, '2025-10-01', NULL, 3, 2), -- Barra de Cereal (Mostrador Principal)
(1003, 107, 120, '2025-08-01', NULL, 1, 1), -- Leche Descremada 1L (Bodega)
(2003, 108, 100, '2026-07-01', NULL, 1, 2), -- Agua Purificada 500ml (Mostrador Principal)
(1001, 109, 70, '2025-11-01', NULL, 1, 2), -- Leche Chocolate 200cc (Mostrador Principal)
(3002, 110, 80, '2025-12-01', NULL, 2, 1); -- Galletas Frac V vainilla 110g (Bodega)

INSERT INTO lote (cod_barra, numero_lote, stock_lote, fecha_vencimiento, id_orden_compra, id_proveedor, id_ubicacion) VALUES
(1001, 111, 60, '2025-10-15', NULL, 1, 1), -- Leche Chocolate 200cc (Bodega)
(1003, 112, 100, '2025-09-01', NULL, 1, 2), -- Leche Descremada 1L (Mostrador Principal)
(2001, 113, 150, '2026-03-15', NULL, 1, 1), -- Agua Mineral Con Gas 1.6L (Bodega)
(2003, 114, 80, '2026-08-01', NULL, 1, 1), -- Agua Purificada 500ml (Bodega)
(3001, 115, 120, '2025-12-15', NULL, 2, 1), -- Galletas Oreo 108g (Bodega)
(3002, 116, 90, '2025-11-30', NULL, 2, 2), -- Galletas Frac Vainilla 110g (Mostrador Principal)
(4001, 117, 70, '2025-09-30', NULL, 3, 2), -- Néctar Multi-Frutilla 200ml (Mostrador Principal)
(4002, 118, 50, '2025-11-10', NULL, 3, 1), -- Jugo Manzana Ciruela 330ml (Bodega)
(5001, 119, 35, '2025-08-01', NULL, 1, 2), -- Pan Integral 500g (Mostrador Principal)
(5002, 120, 25, '2025-08-05', NULL, 1, 2), -- Baguette 200g (Mostrador Principal)
(6001, 121, 30, '2026-07-15', NULL, 2, 1), -- Helado Vainilla 1L (Bodega)
(6002, 122, 40, '2026-06-01', NULL, 2, 2), -- Papas Fritas 1kg (Mostrador Principal)
(7001, 123, 45, '2025-10-15', NULL, 3, 1), -- Mix Frutos Secos 150g (Bodega)
(7002, 124, 50, '2025-11-15', NULL, 3, 1), -- Barra de Cereal (Bodega)
(1001, 125, 80, '2025-12-01', NULL, 1, 2); -- Leche Chocolate 200cc (Mostrador Principal)

INSERT INTO usuario (nombre_usuario, contrasenia, rol) VALUES
('administrador', '{noop}barlacteo', 'ADMIN');

INSERT INTO tipo_movimiento (descripcion_Tipo_Movimiento, es_entrada) VALUES
('Entrada por Compra', TRUE),
('Salida por Venta', FALSE),
('Salida por Devolución a Proveedor', FALSE),
('Salida por Merma/Desperdicio', FALSE),
('Entrada por Ajuste de Inventario', TRUE),
('Salida por Ajuste de Inventario', FALSE),
('Salida por Traslado/Transferencia', FALSE),
('Entrada por Traslado/Transferencia', TRUE);

INSERT INTO movimiento (id_usuario, unidades, motivo, cod_barra, id_tipo_movimiento, id_lote, id_ubicacion, fecha_movimiento) VALUES
(1, 5, NULL, 1001, 2, 1, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 7 DAY), '%Y-%m-%d 08:45:00'), '%Y-%m-%d %H:%i:%s')), -- Leche Chocolate, Lote ID 1
(1, 3, NULL, 3001, 2, 2, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 2 DAY), '%Y-%m-%d 10:30:00'), '%Y-%m-%d %H:%i:%s')), -- Galletas Chocolate, Lote ID 2
(1, 2, NULL, 2001, 2, 4, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 12 DAY), '%Y-%m-%d 14:15:00'), '%Y-%m-%d %H:%i:%s')), -- Agua Mineral, Lote ID 4
(1, 1, NULL, 2002, 2, 4, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 4 DAY), '%Y-%m-%d 09:20:00'), '%Y-%m-%d %H:%i:%s')), -- Bebida Coca-Cola
(1, 4, NULL, 3001, 2, 2, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 10 DAY), '%Y-%m-%d 16:50:00'), '%Y-%m-%d %H:%i:%s')), -- Galletas Chocolate, Lote ID 2
(1, 2, NULL, 3002, 2, 15, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 17 DAY), '%Y-%m-%d 11:10:00'), '%Y-%m-%d %H:%i:%s')), -- Galletas Frac, Lote ID 15
(1, 1, NULL, 4001, 2, 3, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 1 DAY), '%Y-%m-%d 13:25:00'), '%Y-%m-%d %H:%i:%s')), -- Néctar Multi-Frutilla
(1, 2, NULL, 4002, 2, 3, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 14 DAY), '%Y-%m-%d 15:40:00'), '%Y-%m-%d %H:%i:%s')), -- Jugo Manzana Ciruela, Lote ID 3
(1, 3, NULL, 5001, 2, 6, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 5 DAY), '%Y-%m-%d 12:00:00'), '%Y-%m-%d %H:%i:%s')), -- Pan Integral, Lote ID 6
(1, 1, NULL, 5002, 2, 7, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 8 DAY), '%Y-%m-%d 17:30:00'), '%Y-%m-%d %H:%i:%s')), -- Baguette, Lote ID 7
(1, 2, NULL, 6001, 2, 8, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 3 DAY), '%Y-%m-%d 09:50:00'), '%Y-%m-%d %H:%i:%s')), -- Helado Vainilla, Lote ID 8
(1, 4, NULL, 6002, 2, 9, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 11 DAY), '%Y-%m-%d 18:20:00'), '%Y-%m-%d %H:%i:%s')), -- Papas Fritas Congeladas, Lote ID 9
(1, 5, NULL, 7001, 2, 10, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 6 DAY), '%Y-%m-%d 08:10:00'), '%Y-%m-%d %H:%i:%s')), -- Mix de Frutos Secos, Lote ID 10
(1, 6, NULL, 7002, 2, 11, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 9 DAY), '%Y-%m-%d 20:15:00'), '%Y-%m-%d %H:%i:%s')), -- Barra de Cereal, Lote ID 11
(1, 2, NULL, 1003, 2, 12, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 13 DAY), '%Y-%m-%d 10:45:00'), '%Y-%m-%d %H:%i:%s')), -- Leche Descremada, Lote ID 12
(1, 3, NULL, 2003, 2, 13, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 16 DAY), '%Y-%m-%d 14:30:00'), '%Y-%m-%d %H:%i:%s')), -- Agua Purificada, Lote ID 13
(1, 7, NULL, 1001, 2, 14, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 1 DAY), '%Y-%m-%d 16:00:00'), '%Y-%m-%d %H:%i:%s')), -- Leche Chocolate, Lote ID 14
(1, 4, NULL, 3001, 2, 2, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 4 DAY), '%Y-%m-%d 11:55:00'), '%Y-%m-%d %H:%i:%s')), -- Galletas Chocolate, Lote ID 2
(1, 3, NULL, 2001, 2, 5, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 15 DAY), '%Y-%m-%d 13:10:00'), '%Y-%m-%d %H:%i:%s')), -- Agua Mineral, Lote ID 5
(1, 2, NULL, 2002, 2, 4, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 7 DAY), '%Y-%m-%d 19:25:00'), '%Y-%m-%d %H:%i:%s')), -- Bebida Coca-Cola
(1, 5, NULL, 3001, 2, 2, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 10 DAY), '%Y-%m-%d 08:30:00'), '%Y-%m-%d %H:%i:%s')), -- Galletas Chocolate, Lote ID 2
(1, 3, NULL, 3002, 2, 15, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 12 DAY), '%Y-%m-%d 17:45:00'), '%Y-%m-%d %H:%i:%s')), -- Galletas Frac, Lote ID 15
(1, 2, NULL, 4001, 2, 3, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 2 DAY), '%Y-%m-%d 12:20:00'), '%Y-%m-%d %H:%i:%s')), -- Néctar Multi-Frutilla
(1, 1, NULL, 4002, 2, 3, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 8 DAY), '%Y-%m-%d 15:15:00'), '%Y-%m-%d %H:%i:%s')), -- Jugo Manzana Ciruela, Lote ID 3
(1, 4, NULL, 5001, 2, 6, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 5 DAY), '%Y-%m-%d 09:40:00'), '%Y-%m-%d %H:%i:%s')), -- Pan Integral, Lote ID 6
(1, 2, NULL, 5002, 2, 7, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 9 DAY), '%Y-%m-%d 18:00:00'), '%Y-%m-%d %H:%i:%s')), -- Baguette, Lote ID 7
(1, 3, NULL, 6001, 2, 8, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 3 DAY), '%Y-%m-%d 11:30:00'), '%Y-%m-%d %H:%i:%s')), -- Helado Vainilla, Lote ID 8
(1, 5, NULL, 6002, 2, 9, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 11 DAY), '%Y-%m-%d 20:30:00'), '%Y-%m-%d %H:%i:%s')), -- Papas Fritas Congeladas, Lote ID 9
(1, 6, NULL, 7001, 2, 10, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 6 DAY), '%Y-%m-%d 08:20:00'), '%Y-%m-%d %H:%i:%s')), -- Mix de Frutos Secos, Lote ID 10
(1, 7, NULL, 7002, 2, 11, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 13 DAY), '%Y-%m-%d 14:45:00'), '%Y-%m-%d %H:%i:%s')), -- Barra de Cereal, Lote ID 11
(1, 3, NULL, 1003, 2, 12, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 9 DAY), '%Y-%m-%d 10:15:00'), '%Y-%m-%d %H:%i:%s')), -- Leche Descremada, Lote ID 12
(1, 4, NULL, 2003, 2, 13, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 4 DAY), '%Y-%m-%d 16:10:00'), '%Y-%m-%d %H:%i:%s')), -- Agua Purificada, Lote ID 13
(1, 8, NULL, 1001, 2, 1, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 7 DAY), '%Y-%m-%d 12:50:00'), '%Y-%m-%d %H:%i:%s')), -- Leche Chocolate, Lote ID 1
(1, 5, NULL, 3001, 2, 2, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 2 DAY), '%Y-%m-%d 09:25:00'), '%Y-%m-%d %H:%i:%s')), -- Galletas Chocolate, Lote ID 2
(1, 4, NULL, 2001, 2, 4, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 18 DAY), '%Y-%m-%d 17:20:00'), '%Y-%m-%d %H:%i:%s')), -- Agua Mineral, Lote ID 4
(1, 3, NULL, 2002, 2, 5, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 5 DAY), '%Y-%m-%d 13:35:00'), '%Y-%m-%d %H:%i:%s')), -- Bebida Coca-Cola
(1, 6, NULL, 3001, 2, 2, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 10 DAY), '%Y-%m-%d 08:55:00'), '%Y-%m-%d %H:%i:%s')), -- Galletas Chocolate, Lote ID 2
(1, 4, NULL, 3002, 2, 15, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 12 DAY), '%Y-%m-%d 19:10:00'), '%Y-%m-%d %H:%i:%s')), -- Galletas Frac, Lote ID 15
(1, 3, NULL, 4001, 2, 3, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 3 DAY), '%Y-%m-%d 11:45:00'), '%Y-%m-%d %H:%i:%s')), -- Néctar Multi-Frutilla
(1, 2, NULL, 4002, 2, 3, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 8 DAY), '%Y-%m-%d 15:50:00'), '%Y-%m-%d %H:%i:%s')), -- Jugo Manzana Ciruela, Lote ID 3
(1, 5, NULL, 5001, 2, 6, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 6 DAY), '%Y-%m-%d 10:20:00'), '%Y-%m-%d %H:%i:%s')), -- Pan Integral, Lote ID 6
(1, 3, NULL, 5002, 2, 7, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 9 DAY), '%Y-%m-%d 18:30:00'), '%Y-%m-%d %H:%i:%s')), -- Baguette, Lote ID 7
(1, 4, NULL, 6001, 2, 8, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 4 DAY), '%Y-%m-%d 12:15:00'), '%Y-%m-%d %H:%i:%s')), -- Helado Vainilla, Lote ID 8
(1, 6, NULL, 6002, 2, 9, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 11 DAY), '%Y-%m-%d 20:45:00'), '%Y-%m-%d %H:%i:%s')), -- Papas Fritas Congeladas, Lote ID 9
(1, 7, NULL, 7001, 2, 10, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 7 DAY), '%Y-%m-%d 08:40:00'), '%Y-%m-%d %H:%i:%s')), -- Mix de Frutos Secos, Lote ID 10
(1, 8, NULL, 7002, 2, 11, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 13 DAY), '%Y-%m-%d 14:25:00'), '%Y-%m-%d %H:%i:%s')), -- Barra de Cereal, Lote ID 11
(1, 4, NULL, 1003, 2, 12, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 5 DAY), '%Y-%m-%d 10:50:00'), '%Y-%m-%d %H:%i:%s')), -- Leche Descremada, Lote ID 12
(1, 5, NULL, 2003, 2, 13, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 3 DAY), '%Y-%m-%d 16:35:00'), '%Y-%m-%d %H:%i:%s')), -- Agua Purificada, Lote ID 13
(1, 9, NULL, 1001, 2, 14, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 1 DAY), '%Y-%m-%d 12:40:00'), '%Y-%m-%d %H:%i:%s')), -- Leche Chocolate, Lote ID 14
(1, 6, NULL, 3001, 2, 2, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 10 DAY), '%Y-%m-%d 09:15:00'), '%Y-%m-%d %H:%i:%s')), -- Galletas Chocolate, Lote ID 2
(1, 50, 'Nueva compra a Distribuidora Dulce Sabor', 1001, 1, 1, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 3 DAY), '%Y-%m-%d 08:00:00'), '%Y-%m-%d %H:%i:%s')), -- Entrada por Compra
(1, 30, 'Reabastecimiento de Panadería', 5001, 1, 6, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 6 DAY), '%Y-%m-%d 09:15:00'), '%Y-%m-%d %H:%i:%s')), -- Entrada por Compra
(1, 20, 'Compra semanal de congelados', 6001, 1, 8, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 9 DAY), '%Y-%m-%d 11:30:00'), '%Y-%m-%d %H:%i:%s')), -- Entrada por Compra
(1, 40, 'Reposición de Jugos Del Valle', 4001, 1, 3, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 2 DAY), '%Y-%m-%d 13:45:00'), '%Y-%m-%d %H:%i:%s')), -- Entrada por Compra
(1, 25, 'Entrega de Lácteos', 1003, 1, 12, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 12 DAY), '%Y-%m-%d 15:00:00'), '%Y-%m-%d %H:%i:%s')), -- Entrada por Compra
(1, 60, 'Nueva adquisición de snacks', 7001, 1, 10, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 7 DAY), '%Y-%m-%d 17:15:00'), '%Y-%m-%d %H:%i:%s')), -- Entrada por Compra
(1, 35, 'Compra de Agua Mineral', 2001, 1, 4, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 5 DAY), '%Y-%m-%d 19:30:00'), '%Y-%m-%d %H:%i:%s')), -- Entrada por Compra
(1, 20, 'Reabastecimiento de Galletas', 3001, 1, 2, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 4 DAY), '%Y-%m-%d 08:25:00'), '%Y-%m-%d %H:%i:%s')), -- Entrada por Compra
(1, 45, 'Nuevo pedido de Bebidas', 2002, 1, 4, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 11 DAY), '%Y-%m-%d 10:40:00'), '%Y-%m-%d %H:%i:%s')), -- Entrada por Compra
(1, 15, 'Compra de Leche Chocolate Adicional', 1001, 1, 14, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 8 DAY), '%Y-%m-%d 12:55:00'), '%Y-%m-%d %H:%i:%s')), -- Entrada por Compra
(1, 5, 'Lote 101 defectuoso', 1001, 3, 1, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 13 DAY), '%Y-%m-%d 14:20:00'), '%Y-%m-%d %H:%i:%s')), -- Salida por Devolución
(1, 2, 'Producto equivocado', 5002, 3, 7, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 6 DAY), '%Y-%m-%d 16:35:00'), '%Y-%m-%d %H:%i:%s')), -- Salida por Devolución
(1, 3, 'Vencimiento próximo, devolución anticipada', 6002, 3, 9, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 3 DAY), '%Y-%m-%d 18:50:00'), '%Y-%m-%d %H:%i:%s')), -- Salida por Devolución
(1, 1, 'Envase dañado', 4002, 3, 3, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 9 DAY), '%Y-%m-%d 20:05:00'), '%Y-%m-%d %H:%i:%s')), -- Salida por Devolución
(1, 4, 'Exceso de stock no vendible', 7002, 3, 11, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 2 DAY), '%Y-%m-%d 08:10:00'), '%Y-%m-%d %H:%i:%s')), -- Salida por Devolución
(1, 1, 'Producto vencido', 1002, 4, 2, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 10 DAY), '%Y-%m-%d 09:35:00'), '%Y-%m-%d %H:%i:%s')), -- Salida por Merma
(1, 2, 'Paquetes rotos', 3002, 4, 15, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 7 DAY), '%Y-%m-%d 11:50:00'), '%Y-%m-%d %H:%i:%s')), -- Salida por Merma
(1, 1, 'Helado derretido por corte de luz', 6001, 4, 8, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 5 DAY), '%Y-%m-%d 14:05:00'), '%Y-%m-%d %H:%i:%s')), -- Salida por Merma
(1, 3, 'Pan quemado', 5001, 4, 6, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 4 DAY), '%Y-%m-%d 16:20:00'), '%Y-%m-%d %H:%i:%s')), -- Salida por Merma
(1, 1, 'Bebida con fuga', 2003, 4, 13, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 12 DAY), '%Y-%m-%d 18:35:00'), '%Y-%m-%d %H:%i:%s')), -- Salida por Merma
(1, 2, 'Merma por manipulación', 7001, 4, 10, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 8 DAY), '%Y-%m-%d 20:50:00'), '%Y-%m-%d %H:%i:%s')), -- Salida por Merma
(1, 3, 'Conteo físico: se encontraron más unidades', 1001, 5, 14, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 3 DAY), '%Y-%m-%d 08:45:00'), '%Y-%m-%d %H:%i:%s')), -- Entrada por Ajuste
(1, 1, 'Reubicación de stock perdido', 2001, 5, 5, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 9 DAY), '%Y-%m-%d 10:00:00'), '%Y-%m-%d %H:%i:%s')), -- Entrada por Ajuste
(1, 2, 'Corrección de registro de entrada anterior', 3001, 5, 2, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 6 DAY), '%Y-%m-%d 12:15:00'), '%Y-%m-%d %H:%i:%s')), -- Entrada por Ajuste
(1, 1, 'Unidad extra encontrada en bodega', 4002, 5, 3, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 2 DAY), '%Y-%m-%d 14:30:00'), '%Y-%m-%d %H:%i:%s')), -- Entrada por Ajuste
(1, 2, 'Inventario inicial faltante', 5002, 5, 7, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 11 DAY), '%Y-%m-%d 16:45:00'), '%Y-%m-%d %H:%i:%s')), -- Entrada por Ajuste
(1, 2, 'Conteo físico: faltan unidades', 1003, 6, 12, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 7 DAY), '%Y-%m-%d 19:00:00'), '%Y-%m-%d %H:%i:%s')), -- Salida por Ajuste
(1, 1, 'Unidad perdida sin explicación', 2002, 6, 4, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 5 DAY), '%Y-%m-%d 08:20:00'), '%Y-%m-%d %H:%i:%s')), -- Salida por Ajuste
(1, 3, 'Error en despacho anterior', 6002, 6, 9, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 4 DAY), '%Y-%m-%d 10:35:00'), '%Y-%m-%d %H:%i:%s')), -- Salida por Ajuste
(1, 1, 'Merma no registrada previamente', 7002, 6, 11, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 10 DAY), '%Y-%m-%d 12:50:00'), '%Y-%m-%d %H:%i:%s')), -- Salida por Ajuste
(1, 2, 'Discrepancia de inventario', 1001, 6, 1, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 8 DAY), '%Y-%m-%d 15:05:00'), '%Y-%m-%d %H:%i:%s')), -- Salida por Ajuste
(1, 10, 'Traslado a vitrina frontal', 1001, 7, 1, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 3 DAY), '%Y-%m-%d 17:20:00'), '%Y-%m-%d %H:%i:%s')), -- Salida por Traslado
(1, 5, 'Envío a otra sucursal (demo)', 3001, 7, 2, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 9 DAY), '%Y-%m-%d 19:35:00'), '%Y-%m-%d %H:%i:%s')), -- Salida por Traslado
(1, 3, 'Movido a almacén de descontinuados', 2001, 7, 4, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 6 DAY), '%Y-%m-%d 08:50:00'), '%Y-%m-%d %H:%i:%s')), -- Salida por Traslado
(1, 8, 'Para degustación en punto de venta', 7001, 7, 10, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 2 DAY), '%Y-%m-%d 11:05:00'), '%Y-%m-%d %H:%i:%s')), -- Salida por Traslado
(1, 4, 'Traslado a estantería de ofertas', 4001, 7, 3, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 12 DAY), '%Y-%m-%d 13:20:00'), '%Y-%m-%d %H:%i:%s')), -- Salida por Traslado
(1, 10, 'Devolución de vitrina frontal', 1001, 8, 1, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 7 DAY), '%Y-%m-%d 15:35:00'), '%Y-%m-%d %H:%i:%s')), -- Entrada por Traslado
(1, 5, 'Retorno de otra sucursal', 3001, 8, 2, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 5 DAY), '%Y-%m-%d 17:50:00'), '%Y-%m-%d %H:%i:%s')), -- Entrada por Traslado
(1, 3, 'Recuperado de almacén secundario', 2001, 8, 4, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 4 DAY), '%Y-%m-%d 20:05:00'), '%Y-%m-%d %H:%i:%s')), -- Entrada por Traslado
(1, 8, 'Sobras de degustación devueltas', 7001, 8, 10, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 11 DAY), '%Y-%m-%d 08:15:00'), '%Y-%m-%d %H:%i:%s')), -- Entrada por Traslado
(1, 4, 'Retorno de estantería de ofertas', 4001, 8, 3, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 8 DAY), '%Y-%m-%d 10:30:00'), '%Y-%m-%d %H:%i:%s')), -- Entrada por Traslado
(1, 7, 'Nueva compra bebidas', 2003, 1, 13, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 3 DAY), '%Y-%m-%d 12:45:00'), '%Y-%m-%d %H:%i:%s')), -- Entrada por Compra
(1, 2, 'Merma por producto caducado', 1001, 4, 14, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 9 DAY), '%Y-%m-%d 15:00:00'), '%Y-%m-%d %H:%i:%s')), -- Salida por Merma
(1, 1, 'Ajuste por conteo incorrecto', 3002, 6, 15, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 6 DAY), '%Y-%m-%d 17:15:00'), '%Y-%m-%d %H:%i:%s')), -- Salida por Ajuste
(1, 5, 'Reingreso de panadería de exhibición', 5001, 8, 6, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 2 DAY), '%Y-%m-%d 19:30:00'), '%Y-%m-%d %H:%i:%s')), -- Entrada por Traslado
(1, 15, 'Gran compra de lácteos', 1003, 1, 12, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 12 DAY), '%Y-%m-%d 08:25:00'), '%Y-%m-%d %H:%i:%s')), -- Entrada por Compra
(1, 3, 'Devolución a proveedor por lote fallido', 6001, 3, 8, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 7 DAY), '%Y-%m-%d 10:40:00'), '%Y-%m-%d %H:%i:%s')), -- Salida por Devolución
(1, 2, 'Unidad de congelado dañada', 6002, 4, 9, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 5 DAY), '%Y-%m-%d 12:55:00'), '%Y-%m-%d %H:%i:%s')), -- Salida por Merma
(1, 10, 'Traslado a promoción', 7001, 7, 10, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 4 DAY), '%Y-%m-%d 15:10:00'), '%Y-%m-%d %H:%i:%s')), -- Salida por Traslado
(1, 4, 'Ajuste de inventario encontrado', 2001, 5, 5, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 11 DAY), '%Y-%m-%d 17:25:00'), '%Y-%m-%d %H:%i:%s')), -- Entrada por Ajuste
(1, 1, 'Error de sistema en stock', 2002, 6, 4, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 8 DAY), '%Y-%m-%d 19:40:00'), '%Y-%m-%d %H:%i:%s')); -- Salida por Ajuste
INSERT INTO movimiento (id_usuario, unidades, motivo, cod_barra, id_tipo_movimiento, id_lote, id_ubicacion, fecha_movimiento) VALUES
(1, 8, NULL, 3001, 2, 2, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 0 DAY), '%Y-%m-%d 08:55:52'), '%Y-%m-%d %H:%i:%s')),
(1, 7, NULL, 2002, 2, 5, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 0 DAY), '%Y-%m-%d 17:41:29'), '%Y-%m-%d %H:%i:%s')),
(1, 7, NULL, 6001, 2, 8, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 0 DAY), '%Y-%m-%d 17:13:41'), '%Y-%m-%d %H:%i:%s')),
(1, 8, NULL, 4002, 2, 3, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 0 DAY), '%Y-%m-%d 16:15:58'), '%Y-%m-%d %H:%i:%s')),
(1, 9, NULL, 6001, 2, 8, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 0 DAY), '%Y-%m-%d 09:47:58'), '%Y-%m-%d %H:%i:%s')),
(1, 1, NULL, 2002, 2, 5, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 17 DAY), '%Y-%m-%d 10:06:35'), '%Y-%m-%d %H:%i:%s')),
(1, 4, NULL, 2003, 2, 13, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 11 DAY), '%Y-%m-%d 13:26:17'), '%Y-%m-%d %H:%i:%s')),
(1, 9, NULL, 2002, 2, 5, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 8 DAY), '%Y-%m-%d 16:04:41'), '%Y-%m-%d %H:%i:%s')),
(1, 2, NULL, 2001, 2, 4, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 16 DAY), '%Y-%m-%d 12:24:41'), '%Y-%m-%d %H:%i:%s')),
(1, 10, NULL, 7001, 2, 10, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 16 DAY), '%Y-%m-%d 10:13:27'), '%Y-%m-%d %H:%i:%s')),
(1, 4, NULL, 4002, 2, 3, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 5 DAY), '%Y-%m-%d 10:36:36'), '%Y-%m-%d %H:%i:%s')),
(1, 3, NULL, 1001, 2, 1, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 12 DAY), '%Y-%m-%d 19:57:11'), '%Y-%m-%d %H:%i:%s')),
(1, 4, NULL, 3002, 2, 15, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 21 DAY), '%Y-%m-%d 14:44:02'), '%Y-%m-%d %H:%i:%s')),
(1, 5, NULL, 6002, 2, 9, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 13 DAY), '%Y-%m-%d 10:00:28'), '%Y-%m-%d %H:%i:%s')),
(1, 3, NULL, 2003, 2, 13, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 2 DAY), '%Y-%m-%d 15:03:45'), '%Y-%m-%d %H:%i:%s')),
(1, 6, NULL, 1001, 2, 1, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 6 DAY), '%Y-%m-%d 13:13:08'), '%Y-%m-%d %H:%i:%s')),
(1, 10, NULL, 3002, 2, 15, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 3 DAY), '%Y-%m-%d 08:19:24'), '%Y-%m-%d %H:%i:%s')),
(1, 9, NULL, 6002, 2, 9, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 20 DAY), '%Y-%m-%d 18:40:46'), '%Y-%m-%d %H:%i:%s')),
(1, 6, NULL, 1001, 2, 1, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 7 DAY), '%Y-%m-%d 08:56:11'), '%Y-%m-%d %H:%i:%s')),
(1, 4, NULL, 2001, 2, 4, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 9 DAY), '%Y-%m-%d 18:21:38'), '%Y-%m-%d %H:%i:%s')),
(1, 2, NULL, 1003, 2, 12, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 15 DAY), '%Y-%m-%d 08:49:01'), '%Y-%m-%d %H:%i:%s')),
(1, 3, NULL, 3001, 2, 2, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 10 DAY), '%Y-%m-%d 12:50:32'), '%Y-%m-%d %H:%i:%s')),
(1, 7, NULL, 7002, 2, 11, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 14 DAY), '%Y-%m-%d 18:13:43'), '%Y-%m-%d %H:%i:%s')),
(1, 6, NULL, 7001, 2, 10, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 1 DAY), '%Y-%m-%d 08:21:03'), '%Y-%m-%d %H:%i:%s')),
(1, 4, NULL, 3002, 2, 15, NULL, STR_TO_DATE(DATE_FORMAT(DATE_SUB(NOW(), INTERVAL 19 DAY), '%Y-%m-%d 09:33:23'), '%Y-%m-%d %H:%i:%s'));

