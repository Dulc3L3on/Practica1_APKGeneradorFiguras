package Backend.Entidades.Figuras;

public class Circulo extends Figura{
    private double radio;//si da problemas es por el hecho de que debe ser un objeto, por lo cual deberás emplear la envotura Integer

    public Circulo(double posicionInicialX, double posicionInicialY, double elRadio, int color){
        super(posicionInicialX, posicionInicialY, color);

        radio = elRadio;
    }

    public double darRadio(){
        return radio;
    }

}
