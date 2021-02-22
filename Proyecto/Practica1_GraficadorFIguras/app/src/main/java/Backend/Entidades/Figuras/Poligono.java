package Backend.Entidades.Figuras;

import java.io.Serializable;

public class Poligono extends Figura implements Serializable {
    public double largo;
    public double ancho;
    public int cantidadDeLados;

    public Poligono(double posicionInicialX, double posicionInicialY, double elLargo,
                    double elAncho,  double numeroDeLados, int elColor){
        super(posicionInicialX, posicionInicialY, elColor);
        largo = elLargo;
        ancho = elAncho;
        cantidadDeLados = (int)numeroDeLados;//puesto que no pueden haber 1.5 lados...
    }

    public int darCantidadDeLados(){
        return cantidadDeLados;
    }//aunque en realidad la var de cdad de lados debería ser de tipo entero, porque no pueden haber 3.5 lados :v xD, bueno sí pero no xD

    public double darLargo(){
        return largo;
    }

    public double darAncho(){
        return ancho;
    }
}
