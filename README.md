README.
:::AUTOR:::
Gabriela Alejandra Goycochea Romero
Seccion 2
Analista Programador Computacional
Online
___________________________________________________________________________
Nombre del proyecto: SalmonttAppV2
___________________________________________________________________________
Descripción (DENTRO DEL PROYECTO HAY UNA ARCHIVO README DOCS EL CUAL MUESTRA CON IMAGENES)

El proyecto genera un menú de busqueda y visualización con respecto a los datos de centros de cultivos o trabajadores de la empresa Salmontt.

Los datos que te permite revisar el programa por centro:

-Nombre
-Ubicacion 
- Producto
- Producción total en base al producto en el centro de cultivo.
  

Los datos que te permite revisar el programa por trabajadores:
-Rut 
- Nombre Completo 
- Telefono 
- Correo de la empresa
- Cargo en la empresa
-Sueldo 
___________________________________________________________________________
Estructura.
Dentro de la carpeta src/main/java/com.Salmontt.App.version2
Se encuentran 4 paquetes de trabajo.

1.- Model que tiene la clase de los objetos a utilizar (Cargo - CentrosCultivos - Rut - Trabajadores)

2.-Service tiene la base para la busqueda dentro de los datos cargados (ServiceCentrosCultivos - ServicesTrabajadores)

3.- UI contiene el MAIN para la ejecución del programa.

4.- Util contiene el codigo que permitira cargar y leer el Archivo Excel (gestorArchivos)

Dentro de la carpeta src/main/resources/Excel

Se encuentra el archivo excel cargado "DatosAppSalmontt.xlsx" 
___________________________________________________________________________
Ejecutable
Proyecto contiene un archivo .jar
Para ejecutar debe abrir la consola y buscar la ruta donde se encuentra el archivo .jar

Ejemplo: buscar en el disco C:

C:\Carpeta\ruta\dondeseguardoelarchivo\SalmonttAppV2\out\artifacts\SalmonttV2_jar

Puede cambiar si se guarda en descargas u otro lugar pero siempre la ruta sera desde la carpeta del proyecto y el out.
 
Al buscar la ruta se nos cargara nuevamente la información en consola pero se cerrara con un >  , seguido del simbolo (>) debemos ingresar lo siguiente:
java - jar SalmonttV2.jar

Ejemplo:
C:\Carpeta\ruta\dondeseguardoelarchivo\SalmonttAppV2\out\artifacts\SalmonttV2_jar>java -jar SalmonttV2.jar

y listo se ejecutar el archivo por consola
 
y listo nuestra APP deberia ejecutarse por consola.

