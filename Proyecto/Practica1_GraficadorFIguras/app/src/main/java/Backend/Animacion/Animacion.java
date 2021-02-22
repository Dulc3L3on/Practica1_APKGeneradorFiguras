package Backend.Animacion;

import java.io.Serializable;

public class Animacion implements Serializable {
    private double puntoInicialX;
    private double puntoInicialY;
    /*private final double puntoFinalX;
    private final double puntoFinalY;*/
    private double desplazamientoEnX;
    private double desplazamientoEnY;

    private String tipo;

    public Animacion(double elPuntoInicialX, double elPuntoInicialY, double elDesplazamientoEnX, double elDesplazamientoEnY, String tipoAnimacion){//en realidad los punto siniciales son los puntos finales del contorno del dibujo xD
        puntoInicialX = elPuntoInicialX;
        puntoInicialY = elDesplazamientoEnY;
        desplazamientoEnX = elDesplazamientoEnX;
        desplazamientoEnY = elDesplazamientoEnY;
        tipo = tipoAnimacion;
    }

    public double darPuntoPartidaX(){
        return puntoInicialX;
    }

    public double darPuntoPartidaY(){
        return puntoInicialY;
    }

    /*public double darPuntoFinalX(){
        return puntoFinalX;
    }

    public double darPuntoFinalY(){
        return puntoInicialY;
    }*/

    public double darDesplazamientoEnX(){
        return desplazamientoEnX;
    }

    public double darDesplazamientoEnY(){
        return desplazamientoEnY;
    }

    public String darTipoAnimacion(){
        return tipo;
    }
}
