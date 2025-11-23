package com.Salmontt.App.version2.Model;

public class Trabajadores{

    //ATRIBUTOS
    private Rut rut;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String correo;

    /**
     *
     * @param rut Contiene los rut de los trabajadores ingresados a Salmontt
     * @param nombres Contiene primer y segundo nombre de trabajadores de Salmontt
     * @param apellidos Contiene primer y segundo apellido de trabajadores de Salmontt
     * @param telefono contiene telefono personal de trabajador de Salmontt
     * @param correo contiene correo corporativo entregado a trabajadores por la empresa Salmontt

    Información personal de trabajadores de empresa Salmontt.
    El constructor en este caso crea los datos especificos para agregar a los trabajadores, de requerir otros, se puede agregar a los atributos y a los datos agregados en el MAIN.
     */
    //CONSTRUCTOR
    public Trabajadores(Rut rut,String nombres,String apellidos,String telefono,String correo){

        //SI LOS ARCHIVOS LLAMADOS FALTAN DATOS SE GENERARA IGUAL EL MENSAJE
        this.rut=rut;
        this.nombres=nombres !=null ? nombres.trim() : "Sin Nombres";
        this.apellidos=apellidos != null ? apellidos.trim() :"Sin Apellidos";
        this.telefono=telefono != null ? telefono.trim() :"Sin Teléfono de Contacto";
        this.correo=correo != null ? correo.trim() : " Sin Correo";


    }//FIN CONSTRUCTOR.

    /**
     *En metodos get y set permite llamar y mostrar la información con @return,
     en set no retorna información, pero modifica según lo solicitado desde el dato llamado en main y cambia la información a mostrar.
     No muestra la modificación efectuada al usuario por VOID, ya que no genera retorno, pero una vez modificado lo llama con Get y muestra la información solicitada.
     */

    //GET Y SET

    public Rut getRut() {return rut;}
    //public void setRut(Rut rut){this.rut=rut;}

    public String getNombres() {return nombres;}
    //public void setNombres(String nombres) {this.nombres = nombres;}

    public String getApellidos() {return apellidos;}
    //public void setApellidos(String apellidos){this.apellidos=apellidos;}

    public String getTelefono(){return telefono;}
    //public void setTelefono(String telefono) {this.telefono = telefono;}

    public String getCorreo() {return correo;}
    public void setCorreo(String correo){this.correo=correo;}


    /**
     * METODO QUE PERMITE LA LEGIBILIDAD DE LOS DATOS ENTREGADOS
     */

    @Override
    public String toString(){
        return rut.toString()+"\nNombre: "+nombres+" "+apellidos+
                "\nTelefono: "+telefono;
    }



}


