package Backend.Animacion;

public class Animacion {
    private double puntoInicialX;
    private double puntoInicialY;
    private double puntoFinalX;
    private double puntoFinalY;
    private String tipo;

    public Animacion(double puntoPartidaX, double puntoPartidaY, double puntoDestinoX,
                     double puntoDestinoY, String tipoAnimacion){

        puntoInicialX = puntoPartidaX;
        puntoInicialY = puntoPartidaY;
        puntoFinalX = puntoDestinoX;
        puntoFinalY = puntoDestinoY;
        tipo = tipoAnimacion;
    }

    public double darPuntoPartidaX(){
        return puntoInicialX;
    }

    public double darPuntoPartidaY(){
        return puntoInicialY;
    }

    public double darPuntoFinalX(){
        return puntoFinalX;
    }

    public double darPuntoFinalY(){
        return puntoInicialY;
    }

    public String darTipoAnimacion(){
        return tipo;
    }
}
