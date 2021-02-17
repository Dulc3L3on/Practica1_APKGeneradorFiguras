package Backend.Entidades.Figuras;

public class Poligono extends Figura{
    public double largo;
    public double ancho;
    public double cantidadDeLados;

    public Poligono(double posicionInicialX, double posicionInicialY, double elLargo,
                    double elAncho,  double numeroDeLados, int elColor){
        super(posicionInicialX, posicionInicialY, elColor);
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
