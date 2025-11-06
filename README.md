# TP7 – Relaciones entre clases, herencia y polimorfismo  

**Grupo 10**

## Integrantes
- Lautaro Muro  
- Lucas Luciano Camino  
- Thiago Rueda  
- Lucas Fernández  
- Marco Zumino  


## Descripción del trabajo

Se desarrolló un sistema que permite registrar clientes, productos y facturas, manejando relaciones entre clases y aplicando herencia y polimorfismo.

El programa permite:
- Crear productos y gestionar el stock.  
- Registrar clientes mayoristas y minoristas.  
- Realizar ventas y generar facturas.  
- Calcular totales con descuentos según el tipo de cliente.  
- Consultar facturas y el total de ventas.


## Estructura del proyecto

src/
├── ar.edu.unju.escmi.tp7.collections/
│ ├── CollectionCliente.java
│ ├── CollectionProducto.java
│ ├── CollectionFactura.java
│ └── CollectionStock.java
│
├── ar.edu.unju.escmi.tp7.dominio/
│ ├── Cliente.java
│ ├── ClienteMayorista.java
│ ├── ClienteMinorista.java
│ ├── Producto.java
│ ├── Stock.java
│ ├── Detalle.java
│ └── Factura.java
│
└── ar.edu.unju.escmi.tp7.principal/
└── Main.java

## Conceptos aplicados
- Encapsulamiento  
- Herencia y polimorfismo  
- Relaciones entre clases (asociación y composición)  
- Uso de colecciones (`ArrayList`)  
- Métodos estáticos para gestión de objetos 