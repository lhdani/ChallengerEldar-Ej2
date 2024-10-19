# ChallengerEldar-Ej2

Ejercicio 3 

Patrón Observer 
Cada cámara puede ser tratada como un sujeto que está constantemente capturando imágenes, 
pero solo cuando haya un cambio en la imagen, se notifica a los observadores.

Cada monitor que muestra las imágenes de las cámaras actúa como un observador, 
El monitor se suscribe a una cámara y recibe notificaciones solo cuando hay un cambio en la imagen 
que la cámara captura. Si la cámara sigue capturando la misma imagen 
(es decir, no hay movimiento o cambio en la escena), el monitor no recibe ninguna actualización.
