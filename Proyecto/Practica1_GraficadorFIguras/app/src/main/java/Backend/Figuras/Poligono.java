package Backend.Figuras;

import android.graphics.Color;

import Backend.Animacion.Animacion;

public class Poligono extends Figura{
    public double largo;
    public double ancho;
    public double cantidadDeLados;

    public Poligono(double posicionInicialX, double posicionInicialY, Animacion animacion, Color elColor,
                    double elLargo, double elAncho,  double numeroDeLados){
        super(posicionInicialX, posicionInicialY, animacion, elColor);
        largo = elLargo;
        ancho = elAncho;
        cantidadDeLados = numeroDeLados;
    }

    public double darCantidadDeLados(){
        return cantidadDeLados;
    }

    public double darLargo(){
        return largo;
    }

    public double darAncho(){
        return ancho;
    }
}
