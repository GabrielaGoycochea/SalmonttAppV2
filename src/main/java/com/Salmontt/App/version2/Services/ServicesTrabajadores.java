package com.Salmontt.App.version2.Services;

import com.Salmontt.App.version2.Model.Cargo;
import java.util.List;

public class ServicesTrabajadores {

    /**
     *Se realiza la busqueda por RUT dentro de la información en el Excel "DatosAppSalmontt.xlsx" correspondiente a los trabajadores
     *Se realiza un filtro dentro del archivo excel (no se llama al archivo, solo se hace referencia al nombre de la carpeta que lo contiene)
     * Luego al generar la busqueda dentro del archivo devuelve la primera coincidencia
     * De no encontrar el RUT entregara un mensaje en el main.
     */

    public static Cargo buscarPorRut(List<Cargo> listaCargo, String rutIngresado){
        return listaCargo.stream()
                .filter(Excel -> Excel.getRut().getDni().equalsIgnoreCase(rutIngresado))
                .findFirst().orElse(null);



    }
}
