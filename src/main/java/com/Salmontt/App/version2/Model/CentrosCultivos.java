package com.Salmontt.App.version2.Model;

public class CentrosCultivos {
    /**
     * Clase donde se guardan los datos de nombre, ubicacion y producción de cada centro de cultivo
     * de la empresa Salmott
     */

    //ATRIBUTOS
    private String nombreCentros;
    private String ubicacionCentros;
    private String productoCentros;
    private int produccionCentros;

    //SE GENERA EL CONSTRUCTOR

    public CentrosCultivos(String nombreCentros, String ubicacionCentros,String productoCentros,int produccionCentros){
        this.nombreCentros=nombreCentros;
        this.ubicacionCentros=ubicacionCentros;
        this.productoCentros=productoCentros;
        this.produccionCentros=produccionCentros;
    }

    //INICIAN LOS MÉTODOS DE GET Y SET.

    /**
     * Metodos traen y muestran con @return la información.
     * Permite con set realizar modificaciones de ser necesarias.
     *
     */
    public String getNombre(){return nombreCentros;}
    public void setNombre(String nombre) {this.nombreCentros = nombre;}

    public String getUbicacion() {return ubicacionCentros;}
    public void setUbicacion(String ubicacion) {this.ubicacionCentros = ubicacion;}

    public String getProducto() {return productoCentros;}
    public void setProducto(String producto) {this.productoCentros = producto;}

    public int getProduccion() {return produccionCentros;}
    public void setProduccion(int produccion) {this.produccionCentros = produccion;}

    //Método ToString
    /**
     * ToString permite llamar y mostrar los datos al usuario de manera legible.
     */
    @Override
    public String toString() {
        return "Información:"+"\nNombre: "+nombreCentros+
                "\nUbicación: " +ubicacionCentros+"\nProducto: " +productoCentros+"\nProducción: "
                +produccionCentros+" Toneladas \n";

    }
}

