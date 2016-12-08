ENGLISH
BinarySequence.java:
	Creates an 'binary.txt' file with a string of random bits.
	The loop defines the number of samples to save in file.

LZ77.java:
	Open the file 'binary.txt' and creates the LZ77 compresion:
		format (L, D)
		binary format [Example: (2, 6) = 10110]
	Calculat the compresion factor

REMARK:
	The maximun compresion factor reached is with big 'slider' and 'entry windows' of 16 bits.
		-Big sliders allow the algorith to find long sequences of matches, and a random numbers finds matches the most long around 10-13 bits.
		-Biggest compresion reached is 0.7 what it means that the compresion file is longer than the non-compresion.
	There is already a 'binary.txt' file created with 1.000.000 random bits created to make proves.

CONCLUSION:
	-A compresion of 0.7 (less than 1.0) is very bad  because do not compress anything. The reason is that LZ77 is good algorithm finding repetitions
	and a random sample do not usually have long repetitions.
	-I is a good algorithm for image compresion, where colors of closer pixels has the same bit codification.
	-It can be good for text too. 


ESPAÑOL
BinarySequence.java :
	Crea un archivo 'binary.txt' en el que guarda una cadena de bits aleatorios de tamaño 'x'. 
	'x' Se define en el loop del programa.
LZ77.java :
	Abre el archivo 'binary.txt' y genera la compresión:
		En formato (L,D)
		En formato binario [Ej.(2,6) = 10110]
	Calcula el factor de compresión alcancanzado

OBSERVACIONES :
	He tenido en cuenta en la longitud de la compresión los espacios.
	Máxima 'compresión' alcanzada para ficheros muy grandes con 'Mdes' muy alto y 'Ment' de 16bits
		-Esto se debe a que con una ventana deslizante muy alta la mayoria de las colisiones o los mas grandes los encuentra en torno a grupos de 10-13 bits
		por lo que resulta mal poner valores de 'Ment' mayores a 16.
		-Máxima compresion alcanzada: 0.7 (lo cual hace la cadena mas larga), teniendo en cuenta los espacios
	Hay un fichero 'binary.txt' de 1.000.000 bits aleatorios con el que se puede hacer la prueba y otro de 'binary_25.txt' que contiene 25 bits aleatorios
	con los que se puede probar el funcionamiento correcto de la conclusión.

	He llegado a la conclusión de que una compresión de 0.7 es mala, de hecho hace la cadena comprimida más larga. Quizás si no se tienen en cuenta los espacios el
	factor de compresión puede aumentar por encima de 1.
		   			