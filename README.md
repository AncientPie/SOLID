# SOLID

Este proyecto está desarrollado por el equipo LosCazaDragones33.

## Integrantes del equipo

1. Camilo Arciniegas Guerrero
2. Ricardo Andrés Cortés Coronell
3. Miguel Ángel Feo Merchan

## Clase "Employee"
A simple vista, esta clase parece bastante sencilla y que no viola ningún principio SOLID, pero sí lo hace. El principio SOLID que no está cumpliendo es:
1. Dependency Inversion/Injection - Inversión/Inyección de Dependencias
    ¿Por qué? Porque esta clase no cuenta con constructor, y los constructores son una manera de inyectar dependencias (la otra forma es mediante parámetros) sin crear instancias de otros objetos en la clase. Esto, claramente afecta a otra clase hija (PartTimeEmployee), por lo que también se añadió un constructor allí.

## Clase "ReportGenerator"
Esta clase viola dos principios SOLID:
1. Single Responsibility - Responsabilidad Única
    Esta clase tiene varias responsabilidades que tienen que ver con generar un reporte (Excel y PDF), pero si se encargara únicamennte de "generarReporte" y ya, podría volverse más flexible. Para arreglarlo, se decidió cambiar "ReporGenerator" de clase a interfaz, depués se crearon dos clases específicas para Excel y para PDF.

2. Open/Closed Principle - Principio Abierto/Cerrado
Esta clase no deja claro la fomra de expandirla, pues si se quiere agregar otro tipo de formatos que no sea Excel o PDf, tocará crear una función nueva para cada uno, lo cual a largo plazo puede dejar el código con una cantidad de métodos exagerada para una úncia clase. Al dejar ReportGenerator como una interfaz y hacer que las distintas clases la implementen, es más fácil dividir cada proceso, pues lo único que tocaría hacer si se desea añadir otro formato, es crear una clase nueva que implemente ReportGenerator pero con su propia lógica. Esto es bueno para que sea mantenible a largo plazo.