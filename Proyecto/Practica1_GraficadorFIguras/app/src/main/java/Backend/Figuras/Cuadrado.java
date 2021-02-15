package Backend.Figuras;

import android.graphics.Color;

import Backend.Animacion.Animacion;

public class Cuadrado extends Poligono{//la verdad pensándolo bien, no es necesario que exista, por
                                       // el hecho de que solo se requiere crear un polígono y hacer los lados iguales
                                       // y por eso mismo, solo el constructor cambiará... pero lo agrego para
                                       // que pueda tener un mejor orden

    public Cuadrado(double posicionInicialX, double posicionInicialY, Animacion animacion, Color color,
                    double largoDeLado){
        super(posicionInicialX, posicionInicialY, animacion, color, largoDeLado, largoDeLado, 4);
    }

}
