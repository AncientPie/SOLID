# SOLID

Este proyecto está desarrollado por el equipo La Banda.

## Integrantes del equipo

1. Camilo Arciniegas Guerrero
2. Ricardo Andrés Cortés Coronell
3. Miguel Ángel Feo Merchan

## Clase "Employee"
A simple vista, esta clase parece bastante sencilla y que no viola ningún principio SOLID, pero sí lo hace. El principio SOLID que no está cumpliendo es:
1. _Dependency Inversion/Injection - Inversión/Inyección de Dependencias_

¿Por qué? Porque esta clase no cuenta con constructor, y los constructores son una manera de inyectar dependencias (la otra forma es mediante parámetros) sin crear instancias de otros objetos en la clase. Esto, claramente afecta a otra clase hija (PartTimeEmployee), por lo que también se añadió un constructor allí.

## Clase "ReportGenerator"
Esta clase viola dos principios SOLID:
1. _Single Responsibility - Responsabilidad Única_

Esta clase tiene varias responsabilidades que tienen que ver con generar un reporte (Excel y PDF), pero si se encargara únicamennte de "generarReporte" y ya, podría volverse más flexible. Para arreglarlo, se decidió cambiar "ReporGenerator" de clase a interfaz, depués se crearon dos clases específicas para Excel y para PDF.

2. _Open/Closed Principle - Principio Abierto/Cerrado_

Esta clase no deja claro la fomra de expandirla, pues si se quiere agregar otro tipo de formatos que no sea Excel o PDf, tocará crear una función nueva para cada uno, lo cual a largo plazo puede dejar el código con una cantidad de métodos exagerada para una úncia clase. Al dejar ReportGenerator como una interfaz y hacer que las distintas clases la implementen, es más fácil dividir cada proceso, pues lo único que tocaría hacer si se desea añadir otro formato, es crear una clase nueva que implemente ReportGenerator pero con su propia lógica. Esto es bueno para que sea mantenible a largo plazo.

## Clase "SalaryCalculator"
En esta clase se viola el siguiente principio SOlID:
1. _Dependency Inversion/Injection - Inversión/Inyección de Dependencias_
Similar a la clase Employee acá se añade un constructor para así emplear el principio de inversión/inyección de dependencias para evitar que se deba modificar ambos códigos teniendo en cuenta que se busca que los objetos sean creados para la clase y no que la clase sean quien vaya a crearlos evitando la violación de otros principios.
