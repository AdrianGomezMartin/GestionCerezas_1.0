# GestionCerezas_1.0

### Para el correcto funcionamiento de la aplicación es necesario tener instalado JRE 8 
### Para el correcto funcionamiento de la base de datos se recomienda tener instalado XAMPP en Windows o LAMPP en Linux
#
## Pasos para configurar BBDD en Windows : 
### Iniciar en XAMPP servidor Apache y MYSQL una vez iniciados ambos servicios acceder a la dirección http://127.0.0.1/phpmyadmin una vez ahi ejecutar script crearBBDD.sql que se encuentra en este repositorio
#
## En Linux ejecutar los comandos : 
#### cd /opt/lampp/ 
#### sudo ./lampp start
##### Puede dar conflicto con el servicio de apache ya que el puerto 80 puede estar ocupado en cuyo caso ejecutaremos los siguientes comandos:
#### sudo netstat -ltpn | grep :80   (este comando nos dara el id del proceso que esta ocupando el puerto 80)
#### sudo kill id_proceso
