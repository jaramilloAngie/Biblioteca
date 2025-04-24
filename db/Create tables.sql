-- Biblioteca
CREATE TABLE Biblioteca (
    id_biblioteca INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
    nombre_biblioteca VARCHAR(100) NOT NULL UNIQUE,
    direccion VARCHAR(255) NULL,
	ciudad VARCHAR(64) NULL,
	pais VARCHAR(64) NULL
);

-- Libro
CREATE TABLE Libro (
    id_libro INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(100) NOT NULL,
    editorial VARCHAR(100) NULL,
    año_publicacion SMALLINT NULL,--Un tipo de dato más adecuado para el año
    ISBN VARCHAR(20) NULL UNIQUE
);

-- Inventario_Libro
CREATE TABLE Inventario_Libro (
    id_inventario_libro INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
    id_libro INT NOT NULL,
    id_biblioteca INT NOT NULL,
    cantidad_total INT NOT NULL DEFAULT 0,
    cantidad_disponible INT NOT NULL DEFAULT 0,
    activo BIT NOT NULL DEFAULT 1,
    FOREIGN KEY (id_libro) REFERENCES Libro(id_libro),
    FOREIGN KEY (id_biblioteca) REFERENCES Biblioteca(id_biblioteca)
);

-- Rol
CREATE TABLE Rol (
    id_rol INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
    nombre_rol VARCHAR(50) NOT NULL UNIQUE,
    descripcion TEXT NULL
);

-- Permiso
CREATE TABLE Permiso (
    id_permiso INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
    modulo VARCHAR(50) NOT NULL,
    accion VARCHAR(20) NOT NULL--"ver", "crear", "editar", "eliminar"
);

-- Rol_Permiso
CREATE TABLE Rol_Permiso (
    id_rol_permiso INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
    id_rol INT NOT NULL,
    id_permiso INT NOT NULL,
    FOREIGN KEY (id_rol) REFERENCES Rol(id_rol),
    FOREIGN KEY (id_permiso) REFERENCES Permiso(id_permiso),
    CONSTRAINT UQ_RolPermiso UNIQUE (id_rol, id_permiso)
);

-- Usuario
CREATE TABLE Usuario (
    id_usuario INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    correo VARCHAR(100) NOT NULL UNIQUE,--Para asegurar que cada usuario tenga un correo único
    contraseña VARCHAR(255) NOT NULL,
    fecha_registro DATETIME DEFAULT GETDATE(),
    activo BIT NOT NULL DEFAULT 1
);

-- Usuario_Rol
CREATE TABLE Usuario_Rol (
    id_usuario_rol INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
    id_usuario INT NOT NULL,
    id_rol INT NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario),
    FOREIGN KEY (id_rol) REFERENCES Rol(id_rol),
    CONSTRAINT UQ_UsuarioRol UNIQUE (id_usuario, id_rol)
);

-- Usuario_Biblioteca
CREATE TABLE Usuario_Biblioteca (
    id_usuario_biblioteca INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
    id_usuario INT NOT NULL,
    id_biblioteca INT NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario),
    FOREIGN KEY (id_biblioteca) REFERENCES Biblioteca(id_biblioteca),
    CONSTRAINT UQ_UsuarioBiblioteca UNIQUE (id_usuario, id_biblioteca)
);

-- Solicitud_Prestamo
CREATE TABLE Solicitud_Prestamo (
    id_solicitud INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
    id_usuario INT NOT NULL,
    id_inventario_libro INT NOT NULL,
    fecha_solicitud DATETIME DEFAULT GETDATE(),
    estado_solicitud VARCHAR(20) NOT NULL,--"Pendiente", "Aprobada"
    FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario),
    FOREIGN KEY (id_inventario_libro) REFERENCES Inventario_Libro(id_inventario_libro)
);

-- Prestamo
CREATE TABLE Prestamo (
    id_prestamo INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
    id_usuario INT NOT NULL,
    id_inventario_libro INT NOT NULL,
    fecha_prestamo DATETIME DEFAULT GETDATE(),
    fecha_devolucion_esperada DATETIME NOT NULL,
    fecha_devolucion_real DATETIME NULL,
    estado_prestamo VARCHAR(20) NOT NULL,--"Pendiente", "Activo", "Devuelto", "Vencido", "Cancelado"
    FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario),
    FOREIGN KEY (id_inventario_libro) REFERENCES Inventario_Libro(id_inventario_libro)
);

