Este ejemplo tiene un test de integración sencillo.

Tenemos un test de integración RMI que simula un cliente.
Incluye creación de RMIregistry
El setUp lanza el servidor y lo registra y el código del cliente invoca a los servicios del servidor remoto.

Hay que arrancar MySQL pero NO Rmiregistry
