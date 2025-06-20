INSERT INTO categoria (nombre_categoria) VALUES
('Lacteos'),
('Bebidas'),
('Galletas'),
('Jugos'),
('Panadería'),
('Congelados'),
('Snacks');

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
(2003, 'Agua Purificada Sin Gas 500ml', 'Botella de agua purificada', 600, 40, 2),
(1004, 'Leche Entera 1L', 'Leche fluida entera Larga Vida Colun, 1 litro', 950, 60, 1),
(1005, 'Leche Semidescremada 1L', 'Leche fluida semidescremada Soprole, 1 litro', 970, 70, 1);

INSERT INTO proveedor (rut_proveedor, dv_proveedor, nombre_proveedor, telefono_proveedor, email_proveedor, direccion_proveedor) VALUES
(76543210, '7', 'Distribuidora Dulce Sabor', '987123456', 'ventas@dulcesabor.cl', 'Calle Los Dulces 789, Valparaíso'),
(23456789, '2', 'Snacks y Galletas Ltda.', '912678345', 'contacto@snacksygalletas.cl', 'Avenida Colaciones 321, Concepción'),
(67890123, 'K', 'Importadora de Golosinas', '923456789', 'golosinas@importadora.cl', NULL);

INSERT INTO lote (cod_barra, numero_lote, stock_lote, fecha_vencimiento, id_orden_compra, id_proveedor) VALUES
(1001, 101, 50, '2025-12-31', NULL, 1),
(3001, 102, 150, '2025-11-15', NULL, 2),
(4002, 103, 100, '2025-10-10', NULL, 3),
(2001, 104, 180, '2026-01-20', NULL, 1),
(2001, 106, 100, '2026-04-20', NULL, 1),
(5001, 201, 40, '2025-07-20', NULL, 1), -- Pan Integral
(5002, 202, 30, '2025-07-25', NULL, 1), -- Baguette
(6001, 203, 25, '2026-06-30', NULL, 2), -- Helado Vainilla
(6002, 204, 35, '2026-05-15', NULL, 2), -- Papas Fritas
(7001, 205, 50, '2025-09-01', NULL, 3), -- Mix Frutos Secos
(7002, 206, 60, '2025-10-01', NULL, 3), -- Barra de Cereal
(1003, 107, 120, '2025-08-01', NULL, 1), -- Leche Descremada
(2003, 108, 100, '2026-07-01', NULL, 1), -- Agua Purificada
(1001, 109, 70, '2025-11-01', NULL, 1), -- Leche Chocolate (additional lot)
(3002, 110, 80, '2025-12-01', NULL, 2); -- Galletas Frac (additional lot)

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
(1, 5, NULL, 1001, 2, 1, NULL, CURRENT_TIMESTAMP), -- Leche Chocolate, Lote ID 1
(1, 3, NULL, 3001, 2, 2, NULL, CURRENT_TIMESTAMP), -- Galletas Chocolate, Lote ID 2
(1, 2, NULL, 2001, 2, 4, NULL, CURRENT_TIMESTAMP), -- Agua Mineral, Lote ID 4
(1, 1, NULL, 2002, 2, 4, NULL, CURRENT_TIMESTAMP), -- Bebida Coca-Cola (Using Lote ID 4 as a shared lot if applicable, or assign a specific one if 2002 has its own)
(1, 4, NULL, 3001, 2, 2, NULL, CURRENT_TIMESTAMP), -- Galletas Chocolate, Lote ID 2
(1, 2, NULL, 3002, 2, 15, NULL, CURRENT_TIMESTAMP), -- Galletas Frac, Lote ID 15
(1, 1, NULL, 4001, 2, 3, NULL, CURRENT_TIMESTAMP), -- Néctar Multi-Frutilla (Using Lote ID 3 as a shared lot if applicable)
(1, 2, NULL, 4002, 2, 3, NULL, CURRENT_TIMESTAMP), -- Jugo Manzana Ciruela, Lote ID 3
(1, 3, NULL, 5001, 2, 6, NULL, CURRENT_TIMESTAMP), -- Pan Integral, Lote ID 6
(1, 1, NULL, 5002, 2, 7, NULL, CURRENT_TIMESTAMP), -- Baguette, Lote ID 7
(1, 2, NULL, 6001, 2, 8, NULL, CURRENT_TIMESTAMP), -- Helado Vainilla, Lote ID 8
(1, 4, NULL, 6002, 2, 9, NULL, CURRENT_TIMESTAMP), -- Papas Fritas Congeladas, Lote ID 9
(1, 5, NULL, 7001, 2, 10, NULL, CURRENT_TIMESTAMP), -- Mix de Frutos Secos, Lote ID 10
(1, 6, NULL, 7002, 2, 11, NULL, CURRENT_TIMESTAMP), -- Barra de Cereal, Lote ID 11
(1, 2, NULL, 1003, 2, 12, NULL, CURRENT_TIMESTAMP), -- Leche Descremada, Lote ID 12
(1, 3, NULL, 2003, 2, 13, NULL, CURRENT_TIMESTAMP), -- Agua Purificada, Lote ID 13
(1, 7, NULL, 1001, 2, 14, NULL, CURRENT_TIMESTAMP), -- Leche Chocolate, Lote ID 14
(1, 4, NULL, 3001, 2, 2, NULL, CURRENT_TIMESTAMP), -- Galletas Chocolate, Lote ID 2
(1, 3, NULL, 2001, 2, 5, NULL, CURRENT_TIMESTAMP), -- Agua Mineral, Lote ID 5
(1, 2, NULL, 2002, 2, 4, NULL, CURRENT_TIMESTAMP), -- Bebida Coca-Cola
(1, 5, NULL, 3001, 2, 2, NULL, CURRENT_TIMESTAMP), -- Galletas Chocolate, Lote ID 2
(1, 3, NULL, 3002, 2, 15, NULL, CURRENT_TIMESTAMP), -- Galletas Frac, Lote ID 15
(1, 2, NULL, 4001, 2, 3, NULL, CURRENT_TIMESTAMP), -- Néctar Multi-Frutilla
(1, 1, NULL, 4002, 2, 3, NULL, CURRENT_TIMESTAMP), -- Jugo Manzana Ciruela, Lote ID 3
(1, 4, NULL, 5001, 2, 6, NULL, CURRENT_TIMESTAMP), -- Pan Integral, Lote ID 6
(1, 2, NULL, 5002, 2, 7, NULL, CURRENT_TIMESTAMP), -- Baguette, Lote ID 7
(1, 3, NULL, 6001, 2, 8, NULL, CURRENT_TIMESTAMP), -- Helado Vainilla, Lote ID 8
(1, 5, NULL, 6002, 2, 9, NULL, CURRENT_TIMESTAMP), -- Papas Fritas Congeladas, Lote ID 9
(1, 6, NULL, 7001, 2, 10, NULL, CURRENT_TIMESTAMP), -- Mix de Frutos Secos, Lote ID 10
(1, 7, NULL, 7002, 2, 11, NULL, CURRENT_TIMESTAMP), -- Barra de Cereal, Lote ID 11
(1, 3, NULL, 1003, 2, 12, NULL, CURRENT_TIMESTAMP), -- Leche Descremada, Lote ID 12
(1, 4, NULL, 2003, 2, 13, NULL, CURRENT_TIMESTAMP), -- Agua Purificada, Lote ID 13
(1, 8, NULL, 1001, 2, 1, NULL, CURRENT_TIMESTAMP), -- Leche Chocolate, Lote ID 1
(1, 5, NULL, 3001, 2, 2, NULL, CURRENT_TIMESTAMP), -- Galletas Chocolate, Lote ID 2
(1, 4, NULL, 2001, 2, 4, NULL, CURRENT_TIMESTAMP), -- Agua Mineral, Lote ID 4
(1, 3, NULL, 2002, 2, 5, NULL, CURRENT_TIMESTAMP), -- Bebida Coca-Cola (Using Lote ID 5 as a shared lot if applicable)
(1, 6, NULL, 3001, 2, 2, NULL, CURRENT_TIMESTAMP), -- Galletas Chocolate, Lote ID 2
(1, 4, NULL, 3002, 2, 15, NULL, CURRENT_TIMESTAMP), -- Galletas Frac, Lote ID 15
(1, 3, NULL, 4001, 2, 3, NULL, CURRENT_TIMESTAMP), -- Néctar Multi-Frutilla
(1, 2, NULL, 4002, 2, 3, NULL, CURRENT_TIMESTAMP), -- Jugo Manzana Ciruela, Lote ID 3
(1, 5, NULL, 5001, 2, 6, NULL, CURRENT_TIMESTAMP), -- Pan Integral, Lote ID 6
(1, 3, NULL, 5002, 2, 7, NULL, CURRENT_TIMESTAMP), -- Baguette, Lote ID 7
(1, 4, NULL, 6001, 2, 8, NULL, CURRENT_TIMESTAMP), -- Helado Vainilla, Lote ID 8
(1, 6, NULL, 6002, 2, 9, NULL, CURRENT_TIMESTAMP), -- Papas Fritas Congeladas, Lote ID 9
(1, 7, NULL, 7001, 2, 10, NULL, CURRENT_TIMESTAMP), -- Mix de Frutos Secos, Lote ID 10
(1, 8, NULL, 7002, 2, 11, NULL, CURRENT_TIMESTAMP), -- Barra de Cereal, Lote ID 11
(1, 4, NULL, 1003, 2, 12, NULL, CURRENT_TIMESTAMP), -- Leche Descremada, Lote ID 12
(1, 5, NULL, 2003, 2, 13, NULL, CURRENT_TIMESTAMP), -- Agua Purificada, Lote ID 13
(1, 9, NULL, 1001, 2, 14, NULL, CURRENT_TIMESTAMP), -- Leche Chocolate, Lote ID 14
(1, 6, NULL, 3001, 2, 2, NULL, CURRENT_TIMESTAMP); -- Galletas Chocolate, Lote ID 2
INSERT INTO movimiento (id_usuario, unidades, motivo, cod_barra, id_tipo_movimiento, id_lote, id_ubicacion, fecha_movimiento) VALUES
-- --- Entrada por Compra (id_tipo_movimiento = 1) ---
(1, 50, 'Nueva compra a Distribuidora Dulce Sabor', 1001, 1, 1, NULL, CURRENT_TIMESTAMP),
(1, 30, 'Reabastecimiento de Panadería', 5001, 1, 6, NULL, CURRENT_TIMESTAMP),
(1, 20, 'Compra semanal de congelados', 6001, 1, 8, NULL, CURRENT_TIMESTAMP),
(1, 40, 'Reposición de Jugos Del Valle', 4001, 1, 3, NULL, CURRENT_TIMESTAMP),
(1, 25, 'Entrega de Lácteos', 1003, 1, 12, NULL, CURRENT_TIMESTAMP),
(1, 60, 'Nueva adquisición de snacks', 7001, 1, 10, NULL, CURRENT_TIMESTAMP),
(1, 35, 'Compra de Agua Mineral', 2001, 1, 4, NULL, CURRENT_TIMESTAMP),
(1, 20, 'Reabastecimiento de Galletas', 3001, 1, 2, NULL, CURRENT_TIMESTAMP),
(1, 45, 'Nuevo pedido de Bebidas', 2002, 1, 4, NULL, CURRENT_TIMESTAMP),
(1, 15, 'Compra de Leche Chocolate Adicional', 1001, 1, 14, NULL, CURRENT_TIMESTAMP),

-- --- Salida por Devolución a Proveedor (id_tipo_movimiento = 3) ---
(1, 5, 'Lote 101 defectuoso', 1001, 3, 1, NULL, CURRENT_TIMESTAMP),
(1, 2, 'Producto equivocado', 5002, 3, 7, NULL, CURRENT_TIMESTAMP),
(1, 3, 'Vencimiento próximo, devolución anticipada', 6002, 3, 9, NULL, CURRENT_TIMESTAMP),
(1, 1, 'Envase dañado', 4002, 3, 3, NULL, CURRENT_TIMESTAMP),
(1, 4, 'Exceso de stock no vendible', 7002, 3, 11, NULL, CURRENT_TIMESTAMP),

-- --- Salida por Merma/Desperdicio (id_tipo_movimiento = 4) ---
(1, 1, 'Producto vencido', 1002, 4, 2, NULL, CURRENT_TIMESTAMP),
(1, 2, 'Paquetes rotos', 3002, 4, 15, NULL, CURRENT_TIMESTAMP),
(1, 1, 'Helado derretido por corte de luz', 6001, 4, 8, NULL, CURRENT_TIMESTAMP),
(1, 3, 'Pan quemado', 5001, 4, 6, NULL, CURRENT_TIMESTAMP),
(1, 1, 'Bebida con fuga', 2003, 4, 13, NULL, CURRENT_TIMESTAMP),
(1, 2, 'Merma por manipulación', 7001, 4, 10, NULL, CURRENT_TIMESTAMP),

-- --- Entrada por Ajuste de Inventario (id_tipo_movimiento = 5) ---
(1, 3, 'Conteo físico: se encontraron más unidades', 1001, 5, 14, NULL, CURRENT_TIMESTAMP),
(1, 1, 'Reubicación de stock perdido', 2001, 5, 5, NULL, CURRENT_TIMESTAMP),
(1, 2, 'Corrección de registro de entrada anterior', 3001, 5, 2, NULL, CURRENT_TIMESTAMP),
(1, 1, 'Unidad extra encontrada en bodega', 4002, 5, 3, NULL, CURRENT_TIMESTAMP),
(1, 2, 'Inventario inicial faltante', 5002, 5, 7, NULL, CURRENT_TIMESTAMP),

-- --- Salida por Ajuste de Inventario (id_tipo_movimiento = 6) ---
(1, 2, 'Conteo físico: faltan unidades', 1003, 6, 12, NULL, CURRENT_TIMESTAMP),
(1, 1, 'Unidad perdida sin explicación', 2002, 6, 4, NULL, CURRENT_TIMESTAMP),
(1, 3, 'Error en despacho anterior', 6002, 6, 9, NULL, CURRENT_TIMESTAMP),
(1, 1, 'Merma no registrada previamente', 7002, 6, 11, NULL, CURRENT_TIMESTAMP),
(1, 2, 'Discrepancia de inventario', 1001, 6, 1, NULL, CURRENT_TIMESTAMP),

-- --- Salida por Traslado/Transferencia (id_tipo_movimiento = 7) ---
(1, 10, 'Traslado a vitrina frontal', 1001, 7, 1, NULL, CURRENT_TIMESTAMP),
(1, 5, 'Envío a otra sucursal (demo)', 3001, 7, 2, NULL, CURRENT_TIMESTAMP),
(1, 3, 'Movido a almacén de descontinuados', 2001, 7, 4, NULL, CURRENT_TIMESTAMP),
(1, 8, 'Para degustación en punto de venta', 7001, 7, 10, NULL, CURRENT_TIMESTAMP),
(1, 4, 'Traslado a estantería de ofertas', 4001, 7, 3, NULL, CURRENT_TIMESTAMP),

-- --- Entrada por Traslado/Transferencia (id_tipo_movimiento = 8) ---
(1, 10, 'Devolución de vitrina frontal', 1001, 8, 1, NULL, CURRENT_TIMESTAMP),
(1, 5, 'Retorno de otra sucursal', 3001, 8, 2, NULL, CURRENT_TIMESTAMP),
(1, 3, 'Recuperado de almacén secundario', 2001, 8, 4, NULL, CURRENT_TIMESTAMP),
(1, 8, 'Sobras de degustación devueltas', 7001, 8, 10, NULL, CURRENT_TIMESTAMP),
(1, 4, 'Retorno de estantería de ofertas', 4001, 8, 3, NULL, CURRENT_TIMESTAMP),

-- --- More Mixed Movements to reach 50 ---
(1, 7, 'Nueva compra bebidas', 2003, 1, 13, NULL, CURRENT_TIMESTAMP),
(1, 2, 'Merma por producto caducado', 1001, 4, 14, NULL, CURRENT_TIMESTAMP),
(1, 1, 'Ajuste por conteo incorrecto', 3002, 6, 15, NULL, CURRENT_TIMESTAMP),
(1, 5, 'Reingreso de panadería de exhibición', 5001, 8, 6, NULL, CURRENT_TIMESTAMP),
(1, 15, 'Gran compra de lácteos', 1003, 1, 12, NULL, CURRENT_TIMESTAMP),
(1, 3, 'Devolución a proveedor por lote fallido', 6001, 3, 8, NULL, CURRENT_TIMESTAMP),
(1, 2, 'Unidad de congelado dañada', 6002, 4, 9, NULL, CURRENT_TIMESTAMP),
(1, 10, 'Traslado a promoción', 7001, 7, 10, NULL, CURRENT_TIMESTAMP),
(1, 4, 'Ajuste de inventario encontrado', 2001, 5, 5, NULL, CURRENT_TIMESTAMP),
(1, 1, 'Error de sistema en stock', 2002, 6, 4, NULL, CURRENT_TIMESTAMP)
;