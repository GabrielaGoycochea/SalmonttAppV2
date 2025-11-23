package com.Salmontt.App.version2.UI;



import com.Salmontt.App.version2.Model.Cargo;
import com.Salmontt.App.version2.Services.ServicesCentrosCultivos;
import com.Salmontt.App.version2.Model.CentrosCultivos;
import com.Salmontt.App.version2.Services.ServicesTrabajadores;
import com.Salmontt.App.version2.Util.gestorArchivos;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        gestorArchivos subirArchivo = new gestorArchivos();


        //Listas para traer la información del Excel
        List <CentrosCultivos> ExcelCentros = subirArchivo.cargarCentros();
        List <Cargo> ExcelEmpleados = subirArchivo.cargarTrabajadores();

     int opcion=0;

     //Menú interactivo.
    do {
        System.out.println("--------------------------");
        System.out.println("\n...:::SALMONTT APP:::...");
        System.out.println("--------------------------");
        System.out.println("...:::MENÚ:::...");
        System.out.println("1. Ver Centros de Cultivo.");
        System.out.println("2. Buscar Centro por Producto.");
        System.out.println("3. Ver Trabajadores.");
        System.out.println("4. Buscar Trabajadores por Rut.");
        System.out.println("5. Salir.");
        System.out.println("Favor elige una opción: ");

        try {
            opcion = tc.nextInt();
            tc.nextLine();


            //Manejo de opciones
            switch (opcion) {

                case 1:
                    ExcelCentros.forEach(System.out::println); //Muestra los Centros de cultivo
                    break;
                case 2:
                    System.out.println("Producto: ");
                    String producto = tc.nextLine();    //Se solicita al usuario ingreso de datos para búsqueda

                    //En la lista ,con la información de Excel, se genera la búsqueda por nombre del producto
                    List<CentrosCultivos> resultadosBusqueda = ServicesCentrosCultivos
                            .buscarPorProductos(ExcelCentros, producto);

                    //Si en el archivo no se encuentra producto
                    if (resultadosBusqueda.isEmpty()) {
                        System.out.println("No se encontraron centros para el producto: " + producto);
                    } else {
                        //De lo contrario muestra el producto y los datos del centro.
                        System.out.println("Centros encontrados para el producto: " + producto + ":");
                        resultadosBusqueda.forEach(System.out::println);
                    }
                    break;
                case 3:
                    ExcelEmpleados.forEach(System.out::println); //Muestra a los trabajadores ingresados en el Excel
                    break;
                case 4:
                    System.out.println("RUT: "); // Se solicita al usuario indicar un RUT para generar la búsqueda
                    String rut = tc.nextLine();

                    /**
                     * En la clase Cargo se acumula la información completa del trabajador y por esto se utiliza
                     * Al buscar por rut de no encontrarlo entregará el mensaje "Trabajador no encontrado"
                     * Si encuentra el RUT entregará toda la información que se encuentra en la clase Cargo.
                     */

                    Cargo buscar = ServicesTrabajadores.buscarPorRut(ExcelEmpleados, rut);
                    System.out.println(buscar != null ? buscar : "Trabajador no encontrado.");
                    break;
                case 5:
                    System.out.println("Saliendo,gracias por usar el programa"); //Genera una despedida para el usuario
                    break;
                default:
                    System.out.println("Opción marcada inválida.Intente nuevamente."); // Si no marca una de las opciones del menú.
            }

          //Se genera excepción para el error al marcar algo que no sea un número
        }catch (java.util.InputMismatchException e){
            System.out.println("Favor ingresa un número valido.");
            tc.nextLine();
        }

        }while(opcion !=5);

        tc.close();
    }

}
