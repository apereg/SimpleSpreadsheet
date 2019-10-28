# SimpleSpreadsheet
Mid term assigment of PRG2.

Requirements:

La primera hoja de cálculo fue desarrollada allá por 1979. La idea es muy sencilla pero poderosa: una hoja de cálculo es una tabla en la que cada celda puede contener un número o una fórmula. Cada fórmula es una expresión que depende del valor de otras celdas. Las celdas también pueden contener texto con el objetivo de mejorar la presentación.

En este programa deberás crear una aplicación de hoja de cálculo muy sencilla.  Cada celda de una hoja de cálculo puede contener números (sólo enteros) o una fórmula que sólo permite operaciones de suma. Después de haber calculado los valores de todas las fórmulas, el programa debe imprimir la hoja de cálculo resultante donde todas las fórmulas han sido reemplazadas por su valor. El programa deberá aceptar varias hojas de cálculo.

Entrada del programa

La primera línea de la entrada estándar contiene el número de hojas de cálculo que siguen. Cada hoja de cálculo comienza con una línea que consta de dos números enteros, separadas por un espacio, dando el número de columnas y filas. Las siguientes líneas de la hoja de cálculo contienen cada uno una fila. Una fila se compone de las celdas de esa fila, separados por un solo espacio.

Una celda consiste ya sea de un valor entero numérico o de una fórmula. Una fórmula comienza con un signo igual (=). Después de eso, uno o más nombres de celdas siguen, separados por signos más (+). El valor de una fórmula de este tipo es la suma de todos los valores que se encuentran en las celdas de referencia. Estas células puedencontener de nuevo una fórmula. No hay espacios dentro de una fórmula.

Se puede asumir con seguridad que no hay dependencias cíclicas entre las celdas. Así que cada hoja de cálculo se puede calcular completamente. El nombre de una celda consta de una a tres letras para la columna, seguido de un número entre 1 y 999 (incluido) para la fila. Las letras de la columna forman las siguientes series: 

A, B, C, ..., Z, AA, AB, AC, ..., AZ, BA, ..., BZ, CA, ..., ZZ, AAA, AAB, ..., AAZ, ABA, ..., ABZ, ACA, ..., ZZZ, 

usando sólo letras del alfabeto inglés. 

Figura1 : Nombre de las céldas de la parte superior izquierda

Estas letras se corresponden con el número de 1 a 18278. La celda superior izquierda tiene el nombre A1 (Ver figura 1).

Salida del programa

La salida del programa debe tener el mismo formato que el de entrada, salvo que el número de hojas de cálculo y el número de columnas y filas no se repiten. Además, todas las fórmulas deben ser reemplazados por su valor.

Ejemplo 
Entrada
1
4 3
10 34 37 =A1+B1+C1
40 17 34 =A2+B2+C2
=A1+A2 =B1+B2 =C1+C2 =D1+D2

Salida
10 34 37 81
40 17 34 91
50 51 71 172
