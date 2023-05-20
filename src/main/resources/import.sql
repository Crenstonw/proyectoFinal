insert into Cliente (cod_cliente, dni, nombre, apellidos, telefono, email) values (7, '926383728N', 'Pepe', 'Fanegas Deleto', '959632748', 'pepefan@gmail.com');
insert into Cliente (cod_cliente, dni, nombre, apellidos, telefono, email) values (4, '534109283F', 'Antonio', 'Vicente Cortés', '738028374', 'veceantonio@gmail.com');

insert into Trabajador (id_trabajador, fecha_nacimiento, dni, nombre, apellidos, foto_trabajador, is_admin) values (1, '1999-02-03', '819473842M', 'Trevor', 'Santo Triste', 'https://robohash.org/129837', false);
insert into Trabajador (id_trabajador, fecha_nacimiento, dni, nombre, apellidos, foto_trabajador, is_admin) values (2, '1983-12-23', '837291048S', 'Vicente', 'Del Bosque', 'https://robohash.org/323487', false);

insert into Vehiculo (matricula, tipo_vehiculo, bastidor, marca, modelo) values ('2938GAK', 'AUTOBUS', 'kjas82dskj3', 'Audi', 'A3');
insert into Vehiculo (matricula, tipo_vehiculo, bastidor, marca, modelo) values ('7482LWJ', 'TURISMO', 'yqiebc82nd1', 'BMW', 'serie X');

insert into proveedor (id_proveedor, nombre, direccion, descripcion) values (1, 'Lodrones', 'C/laundra 23', 'distribuidor de trocolas');
INSERT INTO proveedor (id_proveedor, nombre, direccion, descripcion) VALUES (2, 'SpeedTech', 'C/Hawthorn Drive nº 37', 'Especialistas en productos de rendimiento para automóviles.');
INSERT INTO proveedor (id_proveedor, nombre, direccion, descripcion) VALUES (3, 'AutoPartsPlus', 'C/Hawthorn Drive nº 22', 'Proveedores de sistemas de suspensión de alto rendimiento.');
INSERT INTO proveedor (id_proveedor, nombre, direccion, descripcion) VALUES (4, 'RaceGear', 'C/Beech Avenue nº 59', 'Suministro de combustible de alto octanaje para competición.');
INSERT INTO proveedor (id_proveedor, nombre, direccion, descripcion) VALUES (5, 'MotorSportSupplies', 'C/Ash Street nº 92', 'Ofrecemos soluciones de motores y sistemas de diagnóstico.');
INSERT INTO proveedor (id_proveedor, nombre, direccion, descripcion) VALUES (6, 'TurboTech', 'C/Ash Street nº 17', 'Suministro de combustible de alto octanaje para competición.');
INSERT INTO proveedor (id_proveedor, nombre, direccion, descripcion) VALUES (7, 'PerformanceWheels', 'C/Maple Avenue nº 74', 'Ofrecemos equipamiento para pilotos y entusiastas del automovilismo.');
INSERT INTO proveedor (id_proveedor, nombre, direccion, descripcion) VALUES (8, 'TrackTires', 'C/Ash Street nº 43', 'Ofrecemos soluciones de motores y sistemas de diagnóstico.');
INSERT INTO proveedor (id_proveedor, nombre, direccion, descripcion) VALUES (9, 'ExhaustMasters', 'C/Maple Avenue nº 49', 'Expertos en sistemas de turboalimentación de alto rendimiento.');
INSERT INTO proveedor (id_proveedor, nombre, direccion, descripcion) VALUES (10, 'CarbonFiberTech', 'C/Alder Court nº 35', 'Especialistas en aceites y lubricantes para automóviles.');
INSERT INTO proveedor (id_proveedor, nombre, direccion, descripcion) VALUES (11, 'RacingBrakeSystems', 'C/Juniper Lane nº 51', 'Especialistas en aceites y lubricantes para automóviles.');

insert into producto (referencia, proveedor_id_proveedor, nombre, precio, pvp, descripcion) values ('kj23jsd', 1, 'junta la trocola', 12.3, 15, 'una perfercamente normal junta la trocola');

ALTER SEQUENCE hibernate_sequence RESTART WITH 1000;