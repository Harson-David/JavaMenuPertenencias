-- Ejemplo de inserción en la tabla usuarios
INSERT INTO users (user_id, user_rol, user_type_document, user_password, user_name, user_last_name, user_num_contact, user_address, user_email, user_jornada, user_tipo_formacion, user_centro_formacion, user_coordinacion, user_num_ficha, user_formacion, user_cargo_actual, user_lugar_procedencia)
VALUES 
(1, 'APRENDIZ', 'CC', 'password123', 'Juan', 'Perez', 123456789, 'Calle 123', 'juan@example.com', 'Mañana', 'Tipo 1', 'Centro 1', 'Coordinación A', 123, 1, 'Cargo A', 'Lugar 1'),
(2, 'INSTRUCTOR', 'TI', 'password456', 'Maria', 'Lopez', 987654321, 'Carrera 456', 'maria@example.com', 'Tarde', 'Tipo 2', 'Centro 2', 'Coordinación B', 456, 2, 'Cargo B', 'Lugar 2'),
(3, 'APRENDIZ', 'CC', 'password123', 'Ana', 'Gonzalez', 987654321, 'Avenida 456', 'ana@example.com', 'Tarde', 'Tipo 2', 'Centro 2', 'Coordinación B', 789, 3, 'Cargo C', 'Lugar 3'),
(4, 'INSTRUCTOR', 'TI', 'password789', 'Pedro', 'Martinez', 654321987, 'Calle 789', 'pedro@example.com', 'Noche', 'Tipo 3', 'Centro 3', 'Coordinación C', 321, 4, 'Cargo D', 'Lugar 4'),
(5, 'FUNCIONARIO', 'CE', 'password456', 'Laura', 'Rodriguez', 741852963, 'Carrera 789', 'laura@example.com', 'Mañana', 'Tipo 1', 'Centro 1', 'Coordinación A', 654, 5, 'Cargo E', 'Lugar 5'),
(6, 'EXTERNO', 'PASAPORTE', 'password012', 'Carlos', 'Sanchez', 852963741, 'Carrera 123', 'carlos@example.com', 'Tarde', 'Tipo 2', 'Centro 2', 'Coordinación B', 987, 6, 'Cargo F', 'Lugar 6'),
(7, 'ADMINISTRADOR', 'CC', 'admin123', 'Admin', 'Admin', 123456789, 'Calle Admin', 'admin@example.com', 'Noche', 'Tipo 3', 'Centro 3', 'Coordinación C', 456, 7, 'Cargo G', 'Lugar 7');

-- Ejemplo de inserción en la tabla programas
INSERT INTO programas (programa_nombre_del_programa, programa_centro_formacion, programa_coordinacion)
VALUES 
('Programa A', 'Centro 1', 'Coordinación A'),
('Programa B', 'Centro 2', 'Coordinación B'),
('Programa C', 'Centro 3', 'Coordinación C'),
('Programa D', 'Centro 1', 'Coordinación A'),
('Programa E', 'Centro 2', 'Coordinación B'),
('Programa F', 'Centro 3', 'Coordinación C'),
('Programa G', 'Centro 1', 'Coordinación A'),
('Programa H', 'Centro 2', 'Coordinación B'),
('Programa I', 'Centro 3', 'Coordinación C');

-- Insertar datos en la tabla intermedia programas_users
INSERT INTO programas_users (programa_id, user_id) VALUES
(1, 1), -- Juan (APRENDIZ) - Programa A
(2, 2), -- Maria (INSTRUCTOR) - Programa B
(2, 3), -- Ana (APRENDIZ) - Programa B
(3, 4), -- Pedro (INSTRUCTOR) - Programa C
(1, 5), -- Laura (FUNCIONARIO) - Programa A
(2, 6), -- Carlos (EXTERNO) - Programa B
(3, 7); -- Admin (ADMINISTRADOR) - Programa C


-- Ejemplo de inserción en la tabla pertenencias
INSERT INTO pertenencias (pertenencia_id, pertenencia_tipo, pertenencia_descripcion, idUsuario)
VALUES 
('f47ac10b-58cc-4372-a567-0e02b2c3d479', 'Tipo A', 'Descripción A', 1),
('fa4e3ff1-7a04-45e4-a698-76f43b6d4a3e', 'Tipo B', 'Descripción B', 2),
('f47ac10b-58cc-4372-a567-0e02b2c3d480', 'Tipo C', 'Descripción C', 3),
('fa4e3ff1-7a04-45e4-a698-76f43b6d4a3f', 'Tipo D', 'Descripción D', 4),
('f47ac10b-58cc-4372-a567-0e02b2c3d481', 'Tipo E', 'Descripción E', 5),
('fa4e3ff1-7a04-45e4-a698-76f43b6d4a3g', 'Tipo F', 'Descripción F', 6),
('f47ac10b-58cc-4372-a567-0e02b2c3d482', 'Tipo G', 'Descripción G', 7);

-- Ejemplo de inserción en la tabla bitacora con todas las columnas
INSERT INTO bitacora (bitacora_fecha_ingreso, bitacora_hora_entrada, bitacora_hora_salida, bitacora_tipo, bitacora_descripcion, bitacora_fecha_salida, bitacora_hora_salida_equipo_sena, bitacora_motivo_salida, bitacora_motivo_ingreso)
VALUES 
('2024-03-29', '08:00:00', '17:00:00', 'Salida', 'Usuario Juan salió del sistema', '2024-03-29', '17:00:00', 'Fin de la jornada', 'Inicio de la jornada'),
('2024-03-29', '09:00:00', '16:00:00', 'Salida', 'Usuario Maria salió del sistema', '2024-03-29', '16:00:00', 'Fin de la jornada', 'Inicio de la jornada'),
('2024-03-30', '08:00:00', '17:00:00', 'Salida', 'Usuario Ana salió del sistema', '2024-03-30', '17:00:00', 'Fin de la jornada', 'Inicio de la jornada'),
('2024-03-30', '09:00:00', '16:00:00', 'Salida', 'Usuario Pedro salió del sistema', '2024-03-30', '16:00:00', 'Fin de la jornada', 'Inicio de la jornada'),
('2024-03-30', '07:00:00', '18:00:00', 'Salida', 'Usuario Laura salió del sistema', '2024-03-30', '18:00:00', 'Fin de la jornada', 'Inicio de la jornada'),
('2024-03-31', '08:00:00', '17:00:00', 'Salida', 'Usuario Carlos salió del sistema', '2024-03-31', '17:00:00', 'Fin de la jornada', 'Inicio de la jornada'),
('2024-03-31', '09:00:00', '16:00:00', 'Salida', 'Usuario Admin salió del sistema', '2024-03-31', '16:00:00', 'Fin de la jornada', 'Inicio de la jornada');

-- Ejemplo de inserción en la tabla intermedia pertenencias_bitacora con códigos UUID
INSERT INTO pertenencias_bitacora (pertenencia_id, bitacora_id)
VALUES 
('f47ac10b-58cc-4372-a567-0e02b2c3d479', 1), -- Ejemplo de UUID para pertenencia 1
('fa4e3ff1-7a04-45e4-a698-76f43b6d4a3e', 2), -- Ejemplo de UUID para pertenencia 2
('f47ac10b-58cc-4372-a567-0e02b2c3d480', 3), -- Ejemplo de UUID para pertenencia 3
('fa4e3ff1-7a04-45e4-a698-76f43b6d4a3f', 4), -- Ejemplo de UUID para pertenencia 4
('f47ac10b-58cc-4372-a567-0e02b2c3d481', 5), -- Ejemplo de UUID para pertenencia 5
('fa4e3ff1-7a04-45e4-a698-76f43b6d4a3g', 6), -- Ejemplo de UUID para pertenencia 6
('f47ac10b-58cc-4372-a567-0e02b2c3d482', 7); -- Ejemplo de UUID para pertenencia 7
