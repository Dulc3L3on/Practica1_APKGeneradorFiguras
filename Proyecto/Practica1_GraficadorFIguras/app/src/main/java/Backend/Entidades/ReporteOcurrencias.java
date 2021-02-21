package Backend.Entidades;

import java.io.Serializable;

public class ReporteOcurrencias extends Reporte implements Serializable {
    String numeroLinea;//bueno, creo que al final de cuentas tendría que ser String[al igual que el #column...] porque debo enviar este dato a la tabla... a menos que lo vuelva todo a String como en HTML xD
    String numeroColumna;
    String ocurrencia;//Esto involucra al anterior, al lexema y al siguiente...


    public ReporteOcurrencias(String elLexema, int laFila, int laColumna){
        super(elLexema);

        numeroLinea = String.valueOf(laFila);
        numeroColumna = String.valueOf(laColumna);
    }

    public ReporteOcurrencias(String elLexema, int laFila, int laColumna, String laOcurrecia){
        super(elLexema);

        numeroLinea = String.valueOf(laFila);
        numeroColumna = String.valueOf(laColumna);
        ocurrencia = laOcurrecia;
    }

    public String darNumeroLinea(){
        return numeroLinea;
    }

    public String darNumeroColumna(){
        return numeroColumna;
    }

    public String darOcurrencia(){
        return ocurrencia;
    }

}
