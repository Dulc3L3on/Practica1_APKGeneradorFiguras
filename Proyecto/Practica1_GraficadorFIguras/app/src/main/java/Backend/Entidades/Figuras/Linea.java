package Backend.Entidades.Figuras;

public class Linea extends Figura{
    private double posicionFinalX;
    private double posicionFinalY;

    public Linea(double posicionInicialX, double posicionInicialY, double laPosicionFinalX,
                 double laPosicionFinalY, int color){
        super(posicionInicialX, posicionInicialY, color);

        posicionFinalX = laPosicionFinalX;
        posicionFinalY = laPosicionFinalY;
    }

    public double darPosicionFinalX(){
        return posicionFinalX;
    }

    public double darPosicionFinalY(){
        return posicionFinalY;
    }

    public double darLargoFigura(){
        return Math.hypot((posicionFinalX-posicionInicialX), (posicionFinalY-posicionInicialY));
    }
}
