package com.Salmontt.App.version2.Model;

public class Cargo extends Trabajadores{

    //ATRIBUTOS
    private String cargo;
    private double sueldo;

    /**
     * @param rut corresponde al RUT ingresado en la clase Trabajadores
     * @param nombres corresponde al primer y segundo nombre ingresado en la clase Trabajadores
     * @param apellidos corresponde a primer y segundo apellido ingresado en la clase Trabajadores
     * @param telefono corresponde al telefono ingresado en la clase Trabajadores (según cada trabajador)
     * @param correo corresponde al correo corporativo de la clase Trabajadores (según cada trabajador)
     * @param cargo cargo correspondiente según el trabajador (esta clase)
     * @param sueldo sueldo correspondiente al cargo de cada trabajador (esta clase)

    El constructor toma datos de la clase trabajadores como rut (que viene de la clase rut), nombres, apellidos, telefono y correo
    los llama para complementar la información al momento de aplicar el toString.
    Clase especifica para sueldos y cargo para el sueldo correspondiente, donde se llaman y/o modifican por los metodos aplicados.
    Al momento de aplicar @Override llama a la info completa guardada anteriormente en clase Trabajadores y agrega solo sueldo y cargo en "texto".
     */
    //CONSTRUCTOR
    public Cargo(Rut rut, String nombres, String apellidos, String telefono, String correo, String cargo, double sueldo){
        super(rut,nombres,apellidos,telefono,correo); //HERENCIA

        this.cargo=cargo != null ? cargo.trim() : "SIN ESPECIFICAR"; // Para evitar que el cargo de error al estar en blanco dejara el mensaje.
        this.sueldo=sueldo <0 ? 0: sueldo; //Si el ingreso es - negativo se asignará como 0 a sueldo

    }//FIN CONSTRUCTOR

    //MÉTODOS GET Y SET
    public String getCargo(){return cargo;}
    //public void setCargo(String cargo){this.cargo=cargo;}

    public double getSueldo(){return sueldo;}
    //public void setSueldo(double sueldo){this.sueldo=sueldo;}

    /**
     * METODO QUE PERMITE LA LEGIBILIDAD DE LOS DATOS ENTREGADOS
     */
    @Override
    public String toString(){
        return super.toString()+"\nCorreo: "+getCorreo()
                +"\nCargo: "+cargo+"\nSueldo: $"+sueldo+"\n";

    }

}


