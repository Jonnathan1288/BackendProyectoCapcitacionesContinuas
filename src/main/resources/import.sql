INSERT INTO roles (id_rol, nombre_rol, estado_rol_activo) VALUES (1, 'Administrador', true);
INSERT INTO roles (id_rol, nombre_rol, estado_rol_activo) VALUES (2, 'DocenteCapacitador', true);
INSERT INTO roles (id_rol, nombre_rol, estado_rol_activo) VALUES (3, 'Participante', true);
INSERT INTO personas (id_persona, identificacion, nombre1, nombre2, apellido1, apellido2, fecha_nacimiento, direccion, correo, telefono, celular, genero, etnia, nivelInstruccion) VALUES (1, '', '','', '', '', null, '', 'correo', '', '', 'M', 'Mestizo', 'Superior');
INSERT INTO usuarios (id_usuario, username, password, foto_perfil, estado_usuario_activo, token_password, id_persona) VALUE (1, 'ADMIN',  '$2a$12$0nN4Yv2NxlC9SAa20Kt3fenrvDRjqCLcVt7SrOgU8CfR7A1NCpOLu', '4bce1942-ba13-4569-9326-4eb87f663aed_userDefault.png', true, '', 1);
INSERT INTO users_roles (id_usuario, id_rol) VALUES (1,1);
INSERT INTO areas (id_area, codigo_area, nombre_area, estado_area_activo) VALUES (1, 'A', 'ADMINISTRACIÓN Y LEGISLACIÓN', true);
INSERT INTO areas (id_area, codigo_area, nombre_area, estado_area_activo) VALUES (2, 'B', 'AGRONOMÍA', true)

