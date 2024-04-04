# Parcial 2 AREP
Mateo Olaya Garzón 

Los algoritmos de búsqueda son esenciales para desarrollo de las ciencias de la computación. En este ejercicio los estudiantes crearán una solución web que explora dos algortimos de búsqueda: la búsqueda lineal y la búsqueda binaria.

Diseñe, construya y despliegue un aplicación web para investigar los dos algoritmos de búsqueda. El programa debe estar desplegado en tres máquinas virtuales de EC2 de AWS como se describe abajo. Las tecnologías usadas en la solución deben ser maven, git, github, sparkjava, html5, y js. No use liberías adicionales.

## Arquitectura 

Diseñe un prototipo de sistema de microservicios que tenga un servicio (En la figura se representa con el nombre Math Services) para computar las funciones de ordenamiento.  El servicio de las funciones de ordenamiento debe estar desplegado en al menos dos instancias virtuales de EC2. Adicionalmente, debe implementar un service proxy que reciba las solicitudes de llamado desde los clientes  y se las delega a las dos instancias del servicio de ordenamiento usando un algoritmo de round-robin. El proxy deberá estar desplegado en otra máquina EC2. Asegúrese que se pueden configurar las direcciones y puertos de las instancias del servicio en el proxy usando variables de entorno del sistema operativo.  Finalmente, construya un cliente Web mínimo con un formulario que reciba el valor y de manera asíncrona invoke el servicio en el PROXY. Puede hacer un formulario para cada una de las funciones. El cliente debe ser escrito en HTML y JS.

![image](https://github.com/Mateo0laya/Parcial-2---AREP-/assets/89365336/c8af3a78-4709-43da-9955-51e983459aa9)


### Prerrequisitos

- Java 8
- Maven
- Git
- Navegador web
- AWS EC-2


## Instrucciones para ejecutar la aplicación 

1. Clone el repositorio

   ```git clone https://github.com/Mateo0laya/Parcial-2---AREP-.git```
   
3. En el repositorio encontrará dos clases en la ruta: src/main/java/com/edu/eci/arep/parcial2/Main.java y src/main/java/com/edu/eci/arep/parcial2/services/MathService.java
4. Debe ejecutar ambas clases, asegurese de ejecutar ambas clases o la aplicación no correra correctamente
5. En su navegador dirijase a http://localhost:35000/
6. Alli encontrara dos formularios, uno para LinearSearch y otro para BinarySearch

## Instrucciones en AWS EC2

1. Debe contar con 3 instancias en ejecución de EC2
2. Instale Java, Git y Maven:
   
   ```sudo yum install java```
   ```sudo yum install git```
   ```sudo yum install maven```

3. Clone el repositorio

   ```git clone https://github.com/Mateo0laya/Parcial-2---AREP-.git```

4. Cambie de directorio

   ```cd Parcial-2---AREP-```

5. Instale las dependencias:

   ```mvn clean install```

6. En la primera instancia (proxy) ejecute la clase Main:

   ```java -cp "target/classes:target/dependency/*" com.edu.eci.arep.parcial2.Main```

7. En las otras dos instancias ejecute la clase MathService:

   ```java -cp "target/classes:target/dependency/*" com.edu.eci.arep.parcial2.services.MathService```

Debe modificar las URLs provistas por AWS de las instancias MathService en la clase RRInvoker, especificamente en el metodo setUrl()
   

### Test de la aplicación

https://youtu.be/MBHlQVXqbmw?si=KGPoVLHj-K-iUPvR

LinearSearch, lista: 10,20,30,40,50, value: 30

![image](https://github.com/Mateo0laya/Parcial-2---AREP-/assets/89365336/25d2a6b8-0efc-47f4-8344-49de85b9b8be)

BinarySearch. lista: 10,20,30,40,50, value: 99

![image](https://github.com/Mateo0laya/Parcial-2---AREP-/assets/89365336/a6a5987c-a531-49b6-8dd4-4451abc30512)

Round Robin durante la ejecución, una de las instancias atendio la primer petición (LinearSearch) y a otra atendio la segunda (BinarySearch)

![image](https://github.com/Mateo0laya/Parcial-2---AREP-/assets/89365336/d14dacc2-e265-4fa1-b803-f2d83b54060a)


## Construido con

* [Java](https://www.java.com/es/) - The main programming language
* [Maven](https://maven.apache.org/) - Dependency Management
* [Spark](https://sparkjava.com/) - MicroFramework Web
* [EC-2 AWS](https://aws.amazon.com/es/ec2/) - cloud Processing

## Version

Version 1.0.0.
