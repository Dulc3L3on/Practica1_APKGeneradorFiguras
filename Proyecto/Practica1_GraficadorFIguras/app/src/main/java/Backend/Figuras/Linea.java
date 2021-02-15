package Backend.Figuras;

import android.graphics.Color;

import Backend.Animacion.Animacion;

public class Linea extends Figura{
    private double posicionFinalX;
    private double posicionFinalY;

    public Linea(double posicionInicialX, double posicionInicialY, Animacion animacion, Color color,
                 double laPosicionFinalX, double laPosicionFinalY){
        super(posicionInicialX, posicionInicialY, animacion, color);

        posicionFinalX = laPosicionFinalX;
        posicionFinalY = laPosicionFinalY;
    }

    public double darPosicionFinalX(){
        return posicionFinalX;
    }

    public double darPosicionFinalY(){
        return posicionFinalY;
    }

    public double darLargoFigura(){
        return Math.hypot((posicionFinalX-posicionInicialX), (posicionFinalY-posicionInicialY));
    }
}
