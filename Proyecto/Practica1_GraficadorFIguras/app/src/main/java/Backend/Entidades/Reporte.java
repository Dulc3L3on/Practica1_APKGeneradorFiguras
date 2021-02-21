package Backend.Entidades;

import java.io.Serializable;

public class Reporte implements Serializable {
    String lexema;
    //String nombreReporte;//esto no es necesario, porque la lista será quien lleve el nombre de la agrupación, es decir: animacion, color, figura u objeto, operacion y errores

    public Reporte(String elLexema){
        lexema = elLexema;
      //  nombreReporte = tipoReporte;
    }

    public String darLexema(){
        return lexema;
    }

}

//estaba pensando crear otras clases para reporte, especificamente una para reporte de ocurrencias otro para cantidad de usos y cb el nombre de entidadError a reporteError
//pero no se si deba hacer esto o quedarme con el arreglo de enteros que irá en aumento cada vez que encuentre una coincidencia, lo malo de esto
//Es que si no hay uso de todo habrán objetos creados en vano, y eso es o que me detiene, pues aquellos que tengan -1 no serán add a la listaENlazada que se tendrá para
//mostrar todos los reportes recopilados si es que no hubieron errores...
