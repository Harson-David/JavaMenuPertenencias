-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS sede_tic_sena_centro_colombo_aleman_regional_atlantico;

-- Seleccionar la base de datos
USE sede_tic_sena_centro_colombo_aleman_regional_atlantico;

-- Tabla usuarios
CREATE TABLE IF NOT EXISTS users (
    user_id INT PRIMARY KEY UNIQUE,
    user_rol ENUM('APRENDIZ', 'INSTRUCTOR', 'FUNCIONARIO', 'EXTERNO', 'ADMINISTRADOR') NOT NULL,
    user_type_document ENUM('CC', 'TI', 'CE', 'PASAPORTE') NOT NULL,
    user_password VARCHAR(255),
    user_name VARCHAR(255) NOT NULL,
    user_last_name VARCHAR(255) NOT NULL,
    user_num_contact INT NOT NULL,
    user_address VARCHAR(255) NOT NULL,
    user_email VARCHAR(255) NOT NULL,
    user_jornada VARCHAR(255),
    user_tipo_formacion VARCHAR(255),
    user_centro_formacion VARCHAR(255),
    user_coordinacion VARCHAR(255),
    user_num_ficha INT,
    user_formacion INT,
    user_cargo_actual VARCHAR(255),
    user_lugar_procedencia VARCHAR(255)
);

-- Tabla programas
CREATE TABLE IF NOT EXISTS programas (
    programa_id INT AUTO_INCREMENT PRIMARY KEY,
    programa_nombre_del_programa VARCHAR(255) NOT NULL,
    programa_centro_formacion VARCHAR(255) NOT NULL,
    programa_coordinacion VARCHAR(255) NOT NULL
);

-- Tabla intermedia programas_users
CREATE TABLE IF NOT EXISTS programas_users (
    programa_id INT,
    user_id INT,
    PRIMARY KEY (programa_id, user_id),
    FOREIGN KEY (programa_id) REFERENCES programas(programa_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

-- Tabla pertenencias con id como UUID
CREATE TABLE IF NOT EXISTS pertenencias (
    pertenencia_id VARCHAR(36) PRIMARY KEY,
    pertenencia_tipo VARCHAR(255) NOT NULL,
    pertenencia_descripcion VARCHAR(255) NOT NULL,
    idUsuario INT,
    FOREIGN KEY (idUsuario) REFERENCES users(user_id)
);

-- Tabla bitacora
CREATE TABLE IF NOT EXISTS bitacora (
    bitacora_id INT AUTO_INCREMENT PRIMARY KEY,
    bitacora_fecha_ingreso DATE NOT NULL,
    bitacora_hora_entrada TIME NOT NULL,
    bitacora_hora_salida TIME,
    bitacora_tipo VARCHAR(255),
    bitacora_descripcion VARCHAR(255),
    bitacora_fecha_salida DATE,
    bitacora_hora_salida_equipo_sena TIME,
    bitacora_motivo_salida VARCHAR(255),
    bitacora_motivo_ingreso VARCHAR(255)
);

-- Tabla intermedia pertenencias_bitacora para la relación muchos a muchos entre pertenencias y bitacora
CREATE TABLE IF NOT EXISTS pertenencias_bitacora (
    pertenencia_id VARCHAR(36),
    bitacora_id INT,
    PRIMARY KEY (pertenencia_id, bitacora_id),
    FOREIGN KEY (pertenencia_id) REFERENCES pertenencias(pertenencia_id),
    FOREIGN KEY (bitacora_id) REFERENCES bitacora(bitacora_id)
);

ALTER TABLE pertenencias
DROP FOREIGN KEY pertenencias_ibfk_1;

ALTER TABLE pertenencias
ADD CONSTRAINT pertenencias_ibfk_1 FOREIGN KEY (idUsuario)
REFERENCES users(user_id)
ON DELETE CASCADE;

ALTER TABLE pertenencias_bitacora
DROP FOREIGN KEY pertenencias_bitacora_ibfk_1;


ALTER TABLE pertenencias_bitacora
ADD CONSTRAINT pertenencias_bitacora_ibfk_1 FOREIGN KEY (pertenencia_id)
REFERENCES pertenencias(pertenencia_id)
ON DELETE CASCADE;


-- Agregar eliminación en cascada a la tabla programas_users
ALTER TABLE programas_users
DROP FOREIGN KEY programas_users_ibfk_1; -- Eliminar la restricción de clave externa existente

ALTER TABLE programas_users
ADD CONSTRAINT programas_users_ibfk_1 FOREIGN KEY (programa_id)
REFERENCES programas(programa_id)
ON DELETE CASCADE; -- Agregar eliminación en cascada para la relación con la tabla programas

ALTER TABLE programas_users
DROP FOREIGN KEY programas_users_ibfk_2; -- Eliminar la restricción de clave externa existente

ALTER TABLE programas_users
ADD CONSTRAINT programas_users_ibfk_2 FOREIGN KEY (user_id)
REFERENCES users(user_id)
ON DELETE CASCADE; -- Agregar eliminación en cascada para la relación con la tabla users

-- Agregar eliminación en cascada a la tabla pertenencias_bitacora
ALTER TABLE pertenencias_bitacora
DROP FOREIGN KEY pertenencias_bitacora_ibfk_1; -- Eliminar la restricción de clave externa existente

ALTER TABLE pertenencias_bitacora
ADD CONSTRAINT pertenencias_bitacora_ibfk_1 FOREIGN KEY (pertenencia_id)
REFERENCES pertenencias(pertenencia_id)
ON DELETE CASCADE; -- Agregar eliminación en cascada para la relación con la tabla pertenencias

ALTER TABLE pertenencias_bitacora
DROP FOREIGN KEY pertenencias_bitacora_ibfk_2; -- Eliminar la restricción de clave externa existente

ALTER TABLE pertenencias_bitacora
ADD CONSTRAINT pertenencias_bitacora_ibfk_2 FOREIGN KEY (bitacora_id)
REFERENCES bitacora(bitacora_id)
ON DELETE CASCADE; -- Agregar eliminación en cascada para la relación con la tabla bitacora
