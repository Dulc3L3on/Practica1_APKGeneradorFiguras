package Backend.Entidades.Figuras;

import java.io.Serializable;

import Backend.Animacion.Animacion;

public class Figura implements Serializable {
    public double posicionInicialX;//si en dado caso se requiere en la nimación un float, entonces pasarás todo esto a float, sino, dejarás el parseo en los parámetros para dibujar las figuras xD
    public double posicionInicialY;
    public Animacion animacion;
    public int color;

    public Figura(double posicionX, double posicionY,int elColor){
        posicionInicialX = posicionX;
        posicionInicialY = posicionY;
        color = elColor;
    }

    public void establecerAnimacion(Animacion laAnimacion){
        animacion= laAnimacion;
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
