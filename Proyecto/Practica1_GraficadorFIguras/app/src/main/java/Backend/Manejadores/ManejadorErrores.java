package Backend.Manejadores;

import Backend.EstructurasDeDatos.ListaEnlazada;

public class ManejadorErrores {
    private ListaEnlazada<Error> listaDeErrores;

    public ManejadorErrores(){
        listaDeErrores = new ListaEnlazada<>();
    }

    public void establecerError(String tipo, int numeroLinea, int numeroColumna){
        switch (tipo){
            case "tipo Figura faltante":
                break;
            case "error en Parametros"://con este tipo de error, hasta me hace pensar en que no estaría mal si no hago las producciones estra para ser específica en el tipo de error sucedido es decir si no se llegó al valor#, al color/animación o al ")"
                break;
            case "error en operación "://u "operación errada"
                break;
            case "":
                break;//haría falta el tipo de error en el que se indica que se esperaba las palabras con las que ini las instrucciones, graficar, o cualquiera de animar objeto anterior xD


        }

    }

}
