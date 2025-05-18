INSERT INTO categoria (nombre_categoria) VALUES ('Lacteos');
INSERT INTO categoria (nombre_categoria) VALUES ('Bebidas');
INSERT INTO categoria (nombre_categoria) VALUES ('Galletas');
INSERT INTO categoria (nombre_categoria) VALUES ('Jugos');

INSERT INTO producto (cod_barra, nombre_producto, descripcion, precio_unitario, stock_min, id_categoria) 
VALUES (1001, 'Leche Chocolate 200cc ', 'Leche Fluida Semidescremada Chocolate Colun, 200ml', 590, 100, 1);
INSERT  INTO producto (cod_barra, nombre_producto, descripcion, precio_unitario, stock_min, id_categoria) 
VALUES (1002, 'Yoghurt Protein Natural 155 g', 'Yoghurt Batido Protein+ Natural Endulzado Soprole, 155g', 650, 150, 1);
INSERT INTO producto (cod_barra, nombre_producto, descripcion, precio_unitario, stock_min, id_categoria) 
VALUES (2001, 'Agua Mineral Con Gas Botella 1,6 L', 'Agua Mineral Gasificada Cachantun, 1600ml', 1090, 20, 2);
INSERT INTO producto (cod_barra, nombre_producto, descripcion, precio_unitario, stock_min, id_categoria) 
VALUES (2002, 'Bebida Coca-Cola Original 350 cc', 'Bebida de Fantasía Original Coca-Cola, 350ml', 700, 25, 2);
INSERT INTO producto (cod_barra, nombre_producto, descripcion, precio_unitario, stock_min, id_categoria) 
VALUES (3001, 'Galletas De Chocolate Crema Vainilla 108 g', 'Galletas Rellenas Original Oreo 108g', 790, 12, 3);
INSERT INTO producto (cod_barra, nombre_producto, descripcion, precio_unitario, stock_min, id_categoria) 
VALUES (3002, 'Galletas Frac Vainilla 110 g', 'Galletas Frac Vainilla Costa 110g', 690, 12, 3);
INSERT INTO producto (cod_barra, nombre_producto, descripcion, precio_unitario, stock_min, id_categoria) 
VALUES (4001, 'Néctar Multi-Frutilla Caja, 200 ml', 'Néctar de Fruta Multi Frutilla Del Valle, 200ml', 400, 8, 4);
INSERT INTO producto (cod_barra, nombre_producto, descripcion, precio_unitario, stock_min, id_categoria) 
VALUES (4002, 'Jugo Manzana Ciruela Orgánico Caja 330 ml', 'Jugo de Fruta Orgánico Manzana y Ciruela Ama Time, 330ml', 1300, 8, 4);

INSERT INTO proveedor (rut_proveedor, dv_proveedor, nombre_proveedor, telefono_proveedor, email_proveedor, direccion_proveedor)
VALUES (76543210, '7', 'Distribuidora Dulce Sabor', '987123456', 'ventas@dulcesabor.cl', 'Calle Los Dulces 789, Valparaíso');
INSERT INTO proveedor (rut_proveedor, dv_proveedor, nombre_proveedor, telefono_proveedor, email_proveedor, direccion_proveedor)
VALUES (23456789, '2', 'Snacks y Galletas Ltda.', '912678345', 'contacto@snacksygalletas.cl', 'Avenida Colaciones 321, Concepción');
INSERT INTO proveedor (rut_proveedor, dv_proveedor, nombre_proveedor, telefono_proveedor, email_proveedor, direccion_proveedor)
VALUES (67890123, 'K', 'Importadora de Golosinas', '923456789', 'golosinas@importadora.cl', NULL);

INSERT INTO lote (cod_barra, numero_lote, stock_lote, fecha_vencimiento, id_orden_compra, id_proveedor)
VALUES (1001, 101, 50, '2025-12-31', NULL, 1);
INSERT INTO lote (cod_barra, numero_lote, stock_lote, fecha_vencimiento, id_orden_compra, id_proveedor)
VALUES (3001, 102, 150, '2025-11-15', NULL, 2);
INSERT INTO lote (cod_barra, numero_lote, stock_lote, fecha_vencimiento, id_orden_compra, id_proveedor)
VALUES (4002, 103, 100, '2025-10-10', NULL, 3);
INSERT INTO lote (cod_barra, numero_lote, stock_lote, fecha_vencimiento, id_orden_compra, id_proveedor)
VALUES (2001, 104, 180, '2026-01-20', NULL, 1);
INSERT INTO lote (cod_barra, numero_lote, stock_lote, fecha_vencimiento, id_orden_compra, id_proveedor)
VALUES (2001, 106, 100, '2026-04-20', NULL, 1);

INSERT INTO usuario (nombre_usuario, contrasenia, rol)
VALUES ('administrador', '{noop}barlacteo', 'ADMIN');