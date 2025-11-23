package com.Salmontt.App.version2.Model;

public class Rut {

    //ATRIBUTOS
    private String dni;

    /**
     *@param trabajadoresRut guarda el dato ingresado (si corresponde) del RUT CHILENO solicitado.
     */

    //CONSTRUCTOR
    public Rut(String trabajadoresRut ) {

        trabajadoresRut = trabajadoresRut.trim().toUpperCase();

        /**
         * [0-9]+ uno o más digitos permitidos en rut sin dígito verificador
         * No condicionar digito exacto {} por rut -10 millones
         * Permite, en el caso anterior, ingreso de rut con o sin 0 delante
         * En digito verificador puede ser número o la letra K/k
         * */

        //VALIDACIÓN SIMPLE

        if(!trabajadoresRut.matches("[0-9]+-[0-9kK]")){
            //EXCEPCIÓN THROW YA QUE ES ESPECIFICA.
            throw new IllegalArgumentException("El RUT "+trabajadoresRut+" es inválido");

        }//FIN IF.
        this.dni = trabajadoresRut;
    }//FIN CONSTRUCTOR

    //MÉTODO GET
    /**
     * RUT AL SER UNICO NO DEBERIA MODIFICARSE.
     * Solo se utiliza get, ya que solo muestra el dato, pero no lo llama para realizar modificaciones en el RUT, ya que es dato unico.
     */

    public String getDni() {
        return dni;
    }

    /**
     * METODO QUE PERMITE LA LEGIBILIDAD DE LOS DATOS ENTREGADOS
     */

    @Override
    public String toString(){
        return "RUT: "+dni;
    }

}


