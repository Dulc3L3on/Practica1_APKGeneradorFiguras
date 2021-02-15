package Backend.Figuras;

import android.graphics.Color;

import Backend.Animacion.Animacion;

public class Figura {
    public double posicionInicialX;
    public double posicionInicialY;
    public Animacion animacion;
    public Color color;

    public Figura(double posicionX, double posicionY, Animacion laAnimacion, Color elColor){
        posicionInicialX = posicionX;
        posicionInicialY = posicionY;
        animacion = laAnimacion;
        color = elColor;
    }

    public double darPosicionInicialX(){
        return posicionInicialX;
    }

    public double darPosicionIncialY(){
        return posicionInicialY;
    }

    public Animacion darAnimacion(){
        return animacion;
    }
}
