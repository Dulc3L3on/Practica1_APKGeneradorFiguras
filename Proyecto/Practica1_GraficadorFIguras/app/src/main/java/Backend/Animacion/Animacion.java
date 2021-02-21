package Backend.Animacion;

import java.io.Serializable;

public class Animacion implements Serializable {
    private final double puntoInicialX;
    private final double puntoInicialY;
    private final double puntoFinalX;
    private final double puntoFinalY;
    private final String tipo;

    public Animacion(double puntoPartidaX, double puntoPartidaY, double puntoDestinoX,
                     double puntoDestinoY, String tipoAnimacion){

        puntoInicialX = puntoPartidaX;
        puntoInicialY = puntoPartidaY;
        puntoFinalX = puntoDestinoX;
        puntoFinalY = puntoDestinoY;
        tipo = tipoAnimacion;
    }

    public double darPuntoPartidaX(){
        return puntoInicialX;
    }

    public double darPuntoPartidaY(){
        return puntoInicialY;
    }

    public double darPuntoFinalX(){
        return puntoFinalX;
    }

    public double darPuntoFinalY(){
        return puntoInicialY;
    }

    public String darTipoAnimacion(){
        return tipo;
    }
}
