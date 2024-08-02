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

## Interface "EmployeeOperations"
Acá se viola el siguiente principio:
1. _Interface Segregation - Segregación de Interfaces_
Anteriormente, en el código se presentaban los métodos de "addEmployee", "removeEmployee", "calculateSalary" y "saveToFile". En ese caso se viola este principio debido a que, con relación a lo que dicta este mismo, dos de esos métodos ("calculateSalary" y "saveToFile") no concuerdan con el objetivo de manejo de empleados como se presenta en la clase EmployeeManager entonces no tiene sentido crear una interfaz general con métodos que difieren los unos con los otros, por lo tanto, lo correcto es crear interfaces distintas según el objetivo específico que quieran buscar. Por lo tanto, se crearon las siguientes interfaces: 
- EmployeeOperations: Contiene los métodos "addEmployee" y "removeEmployee".
- SalaryOperations: Contiene el método "calculateSalary".
- FileOperations: Contiene el método "saveToFile".
Por lo tanto, se cumple el principio teniendo en cuenta varía interfaces para un objetivo específico en específico cada una, dejando de lado el tener una general.

## Clase "EmployeeManager"
Se viola un principio el cual es:
1. _Single Responsibility - Responsabilidad Única_
Dado que este principio dicta que cada clase debe enfocarse en una única función en específica, sucede que teniendo en cuenta que se crearon interfaces específicas para cada función en ese caso se tienen ahora 3 clases que implementan de dichas interfaces para así garantizar que cada una cumpla una única responsabilidad propia del objetivo que busca. Dichas clases son:
- EmployeeManager (implementa de EmployeeOperations).
- SalaryManager (implementa de SalaryOperations).
- FileManager (implementa de FileOperations).
