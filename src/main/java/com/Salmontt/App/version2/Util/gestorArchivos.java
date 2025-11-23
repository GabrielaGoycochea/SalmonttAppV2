package com.Salmontt.App.version2.Util;

import com.Salmontt.App.version2.Model.Cargo;
import com.Salmontt.App.version2.Model.CentrosCultivos;
import com.Salmontt.App.version2.Model.Rut;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase para gestionar el archivo Excel cargado, dentro de la clase hay 2 listas.
 * Archivo contiene 2 hojas.
 * Primera hoja/lista contiene datos de Centros de Cultivos
 * Segunda hoja/lista contiene los datos de los Trabajadores
 * Ya que valores numericos se mezclan con String para evitar agregar más try and catch
 * Se agrega la validación para el telefono que sea numerico y no decimal y pueda devolverse en String
 */


public class gestorArchivos {


//Primera hoja Centros de cultivo
    public List<CentrosCultivos> cargarCentros() {
        List<CentrosCultivos> listaCentros = new ArrayList<>();

        //Se llama al archivo Excel
        try (InputStream archivoExcel = getClass().getClassLoader()
                .getResourceAsStream("Excel/DatosAppSalmontt.xlsx");

             //Se genera un libro desde el archivo excel
             XSSFWorkbook libroExcel = new XSSFWorkbook(archivoExcel)) {

            //De no lograr leer o encontrar el archivo entrega el mensaje
            if(archivoExcel == null){
                System.out.println("NO SE ENCONTRÓ ARCHIVO EXCEL EN CARPETA RESOURCES");
                return listaCentros;
            }
            //Se llama a la primera hoja en el libro
            XSSFSheet hojaLibroExcel = libroExcel.getSheetAt(0);

               //Se recorre la información de la hoja y se generan en filas
            for (int i = 1; i <= hojaLibroExcel.getLastRowNum(); i++) {
                var fila = hojaLibroExcel.getRow(i);
                if (fila == null) continue;

                //Se realiza separación de datos en cada fila correspondiente
                String nombreCentros = fila.getCell(0).toString();
                String ubicacionCentros = fila.getCell(1).toString();
                String productoCentros = fila.getCell(2).toString();
                int produccionCentros = (int)fila.getCell(3).getNumericCellValue();

                //crea la lista y la agrega
                listaCentros.add(new CentrosCultivos(nombreCentros, ubicacionCentros, productoCentros, produccionCentros));
            }

            //De no lograr llamar el archivo entrega el mensaje y muestra porque falla.
        } catch (Exception e) {
            System.out.println("Error al leer archivo Excel con Centros de Cultivo: " + e.getMessage());
        }
        return listaCentros;
    }//FIN PRIMERA HOJA

// SEGUNDA HOJA TRABAJADORES
    public List<Cargo> cargarTrabajadores() {
        List<Cargo> listaTrabajadores = new ArrayList<>();

        //Se llama al Excel con los datos de los trabajadores
        try(InputStream archivoExcel = getClass().getClassLoader()
                .getResourceAsStream("Excel/DatosAppSalmontt.xlsx");

            //Se genera un libro
             XSSFWorkbook libroExcel = new XSSFWorkbook(archivoExcel)) {

            //De no lograr leer o encontrar el archivo entrega el mensaje
            if(archivoExcel==null){
                System.out.println("NO SE ENCONTRÓ ARCHIVO EXCEL EN CARPETA RESOURCES");
            }
                //Hoja 2 del libro
            XSSFSheet hojaLibroExcel = libroExcel.getSheetAt(1);

            //Se recorre la información de la hoja y se generan en filas
            for (int i = 1; i <= hojaLibroExcel.getLastRowNum(); i++) {
                var fila = hojaLibroExcel.getRow(i);
                if (fila == null) continue;

                //Se realiza separación de datos en cada fila correspondiente
                String trabajadorRut = fila.getCell(0).toString();
                String nombres = fila.getCell(1).toString();
                String apellidos = fila.getCell(2).toString();

                 //Se verifica que la celda del telefono
                Cell celdaTelefono= fila.getCell(3);
                String telefono;

                    //Si la celda de telefono es numérica le quita el decimal y devuelve en texto
                   if(celdaTelefono.getCellType()== CellType.NUMERIC){
                       telefono= String.valueOf((long)celdaTelefono.getNumericCellValue());
                   }else{
                       telefono= celdaTelefono.getStringCellValue(); // Si viene en texto se deja igual.
                   }

                String correo = fila.getCell(4).toString();
                String cargo = fila.getCell(5).toString();
                double sueldo = fila.getCell(6).getNumericCellValue();


            Rut identificador = new Rut (trabajadorRut); //Genera el dato con la información tomada desde el Excel
            listaTrabajadores.add(new Cargo(identificador,nombres,apellidos,telefono,correo,cargo,sueldo));
            }
        }catch (Exception e){
            //De no lograr llamar el archivo entrega el mensaje y muestra porque falla
            System.out.println("Error al leer archivo Excel de Trabajadores "+ e.getMessage());
        }
        return listaTrabajadores;
    }

}