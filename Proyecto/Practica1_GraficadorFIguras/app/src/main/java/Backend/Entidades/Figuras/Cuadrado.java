package Backend.Entidades.Figuras;

import java.io.Serializable;

public class Cuadrado extends Poligono implements Serializable {//la verdad pensándolo bien, no es necesario que exista, por
                                       // el hecho de que solo se requiere crear un polígono y hacer los lados iguales
                                       // y por eso mismo, solo el constructor cambiará... pero lo agrego para
                                       // que pueda tener un mejor orden

    public Cuadrado(double posicionInicialX, double posicionInicialY, double largoDeLado,
                    int color){
        super(posicionInicialX, posicionInicialY, largoDeLado, largoDeLado, 4, color);
    }

}
