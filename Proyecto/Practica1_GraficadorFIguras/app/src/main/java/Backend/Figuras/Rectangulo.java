package Backend.Figuras;

import android.graphics.Color;

import Backend.Animacion.Animacion;

public class Rectangulo extends Poligono{//lo mismo para el rectángulo, solo fue creado para ser más específica...

    public Rectangulo(double posicionInicialX, double posicionInicialY, Animacion animacion, Color color,
                      double largo, double ancho){
        super(posicionInicialX, posicionInicialY, animacion, color,largo, ancho, 4);
    }

}
