package Backend.Figuras;

import android.graphics.Color;
import Backend.Animacion.Animacion;

public class Circulo extends Figura{
    private double radio;//si da problemas es por el hecho de que debe ser un objeto, por lo cual deberás emplear la envotura Integer

    public Circulo(double posicionInicialX, double posicionInicialY, Animacion animacion, Color color){
        super(posicionInicialX, posicionInicialY, animacion, color);
    }

    public double darRadio(){
        return radio;
    }

}
