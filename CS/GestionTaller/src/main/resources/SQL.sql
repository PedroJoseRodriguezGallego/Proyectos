CREATE DATABASE ProyectoReportesPJRG;
USE ProyectoReportesPJRG;

-- --------------------------------------------------------------------
CREATE TABLE Operarios
(
IDOperario INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
DNI VARCHAR(9) NOT NULL,
Nombre VARCHAR(15) NOT NULL,
Apellidos VARCHAR(30) NOT NULL,
Direccion VARCHAR(30) NOT NULL,
Telefono VARCHAR(9) NOT NULL
);

INSERT INTO Operarios VALUES (1,"20229530H","Pedro","Rodriguez","Mairena del alcor","619649414");
INSERT INTO Operarios VALUES (2,"61153904J","Pepe","Ramirez","Viso del alcor","768543213");
INSERT INTO Operarios VALUES (3,"87654832K","Juan","Delgado","Alcala de Guadaira","654327891");
INSERT INTO Operarios VALUES (4,"12334578G","Roberto","Perera","Carmona","778654332");

-- ---------------------

CREATE TABLE Trabajos
(
IDTrabajo INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
Descripcion VARCHAR(50) NOT NULL,
Horas INT NOT NULL,
Precio DECIMAL(8,2),
Coste DECIMAL(8,2),
ReparacionesMecanicas INT NOT NULL,
ReparacionesChapistas INT NOT NULL,
ReparacionesRevisiones INT NOT NULL,
FechaInicio DATE NOT NULL,
FechaFin DATE,
IDOperario INT NOT NULL DEFAULT 1,
FOREIGN KEY(IDOperario) REFERENCES Operarios(IDOperario) ON DELETE CASCADE
);

INSERT INTO Trabajos VALUES (1,"Descripcion trabajo 1",5,30.00,1000.00,2,2,2,"2020-08-15","2020-08-20",1);