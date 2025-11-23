package com.Salmontt.App.version2.Services;

import com.Salmontt.App.version2.Model.CentrosCultivos;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ServicesCentrosCultivos {

    /**
     *Se realiza la busqueda por producto, tomando el dato de una colección, dentro de los centros de cultivo
     * Se realiza un filtro dentro del archivo excel (no se llama al archivo directamente, solo se hace referencia al nombre de la carpeta que lo contiene)
     * Se trae la lista generada (con el archivo directo) en la clase "gestosArchivos"
     * Luego de generar el filtro muestra una nueva lista con las coincidencias de busqueda
     * De no encontrar el producto entregara un mensaje en el main
     */

    public static List<CentrosCultivos> buscarPorProductos
            (List<CentrosCultivos> listaCentros, String producto){
        return listaCentros.stream()
                .filter(Excel-> Excel.getProducto()
                .equalsIgnoreCase(producto)).collect(Collectors.toList());
    }

    //Se ordenan centros de mayor a menor según producción

    public static List<CentrosCultivos> ordenarProductosPorProduccion
            (List<CentrosCultivos>listaCentros){
        return listaCentros.stream()
                    //Comparación de la producción en la clase Centros de cultivo (hace referencia)
                .sorted(Comparator.comparingInt(CentrosCultivos::getProduccion)
                        //mayor a menor.
                        .reversed()).collect(Collectors.toList());
    }
}


