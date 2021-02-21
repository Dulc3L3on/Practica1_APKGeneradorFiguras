package Backend.Entidades.Figuras;

import java.io.Serializable;

public class Rectangulo extends Poligono implements Serializable {//lo mismo para el rectángulo, solo fue creado para ser más específica...

    public Rectangulo(double posicionInicialX, double posicionInicialY, double largo,
                      double ancho, int color){
        super(posicionInicialX, posicionInicialY, largo, ancho, 4, color);
    }

}
