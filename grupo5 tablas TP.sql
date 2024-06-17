Use `bd-grupo5tp`;
CREATE TABLE Usuario(nombreUsuario varchar(50) NOT NULL,
contraseña varchar(50) NOT NULL,
activado BOOLEAN NOT NULL,
PRIMARY KEY(nombreUsuario));

CREATE TABLE UsuarioRol(idUsuarioRol INT NOT NULL,
rol varchar(50) NOT NULL,
usuario_id varchar(50) NOT NULL,
PRIMARY KEY(idUsuarioRol),
FOREIGN KEY(usuario_id) references Usuario(nombreUsuario));

CREATE TABLE Producto(idProducto INT NOT NULL,
descripcion varchar(50) NOT NULL,
precioVenta INT NOT NULL,
cantidad INT NOT NULL,
PRIMARY KEY(idProducto));

CREATE TABLE LoteStock(idLote INT NOT NULL,
producto varchar(50) NOT NULL,
cantidad INT NOT NULL,
fechaDeRecepcion DATE NOT NULL,
proveedor varchar(50) NOT NULL,
precio INT NOT NULL,
producto_id INT NOT NULL,
PRIMARY KEY(idLote),
FOREIGN KEY(producto_id) references Producto(idProducto));

CREATE TABLE PedidoAprovisionamiento(idPedidoAprovicionamiento INT NOT NULL,
producto varchar(50) NOT NULL,
cantidadSolicitada INT NOT NULL,
fechaDeSolicitud DATE NOT NULL,
estado BOOLEAN NOT NULL,
lote_id INT NOT NULL,
PRIMARY KEY(idPedidoAprovicionamiento),
FOREIGN KEY(lote_id) references LoteStock(idLote));

CREATE TABLE InformeProducto(idInformeProducto INT NOT NULL,
estado BOOLEAN NOT NULL,
descripcion varchar(50) NOT NULL,
precioVenta INT NOT NULL,
cantidad INT NOT NULL,
lote_id INT NOT NULL,
PRIMARY KEY(idInformeProducto),
FOREIGN KEY(lote_id) references LoteStock(idLote));

CREATE TABLE Registro(idRegistro INT NOT NULL,
producto_id INT NOT NULL,
PRIMARY KEY(idRegistro),
FOREIGN KEY(producto_id) references Producto(idProducto)); 
