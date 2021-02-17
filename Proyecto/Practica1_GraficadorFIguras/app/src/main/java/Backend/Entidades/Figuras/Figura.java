package Backend.Entidades.Figuras;

import Backend.Animacion.Animacion;

public class Figura {
    public double posicionInicialX;
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
