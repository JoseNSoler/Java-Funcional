# Java funcional - Predicate


<p align="center">
<img src="https://www.sofka.com.co/wp-content/uploads/2021/02/sofkau-logo-horizontal.png">
</p>
<p align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white">
</p>
<p align="center">
  <img src="https://img.shields.io/github/v/release/JoseNSoler/PracticaMVC?style=flat-square"
</p>   



## Informacion General

Se recomienda clonar el repositorio y ejecutarlo directamente desde IntelliJ IDEA para una mejor ejecucion, ademas
de tener instalado java >= 8 en la maquina

**Para ejecutar y cambiar los parametros pasados al filtro Predicate, porfavor referirse a las funciones y valores internos presentes en el archivo App.java, el programa contiene casos de uso con parametros unicos**


El programa crea una lista de Facturas, Solo se necesita pasar como parametro, la descripcion, importe y cantidad

El ID es autogenerado por medio de UUID.now(), agregando "FACTURA#" al inicio de este id
La fecha esta formateada de la manera "MM/dd/uuuu HH:mm", autogenerada y comparada en formato ZoneDateTime y entregada al
usuario como un string mas ententible

*Ejemplo de formato de una factura*

```plain
Factura{ IDfactura='FACTURA#_2b33d12f-9a88-4ce5-aff8-818796b2dfd5'
Descripcion='movil'
Importe=300
Fecha=03/16/2022 23:38
Cantidad=10}
```
Despues Usando la clase Predicate, crea un filtro personalizado teniendo en cuenta las siguientes condiciones

- Factura con Fecha Mayor o menor a la especificada
- Factura con un precio Mayor a la especificada
- Factura con un ID unico identico a el especificado
- Facutura con una cantidad de valores Mayor Igual o menor a la especificada


Los predicados Predicate se usan de manera grupal, o individual, logrando poder combinar multiples predicados para un filtro personalizado