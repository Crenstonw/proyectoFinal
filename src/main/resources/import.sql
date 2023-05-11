insert into Cliente (cod_cliente, dni, nombre, apellidos, telefono, email) values (7, '926383728N', 'Pepe', 'Fanegas Deleto', '959632748', 'pepefan@gmail.com');
insert into Cliente (cod_cliente, dni, nombre, apellidos, telefono, email) values (4, '534109283F', 'Antonio', 'Vicente Cortés', '738028374', 'veceantonio@gmail.com');

insert into Trabajador (id_Trabajador, fecha_Nacimiento, dni, nombre, apellidos, foto_trabajador, is_Admin) values (1, 1999-02-03, '819473842M', 'Trevor', 'Santo Triste', 'https://robohash.org/129837', true);

ALTER SEQUENCE hibernate_sequence RESTART WITH 1000;