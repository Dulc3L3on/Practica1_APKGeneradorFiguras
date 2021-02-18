package Backend.Manejadores;

import android.graphics.Canvas;
import android.graphics.Paint;

import Backend.Entidades.Figuras.Circulo;
import Backend.Entidades.Figuras.Cuadrado;
import Backend.Entidades.Figuras.Figura;
import Backend.Entidades.Figuras.Linea;
import Backend.Entidades.Figuras.Poligono;
import Backend.Entidades.Figuras.Rectangulo;
import Backend.EstructurasDeDatos.Pila;

public class Procesador {

    public void ProcesarSolicitudGraficar(Pila<Figura> pilaDeFiguras, Paint pintor, Canvas canvas){
        for (int figuraActual= 0; figuraActual<pilaDeFiguras.darTamanio(); figuraActual++){
            Figura figura = pilaDeFiguras.darYEncolarUltimoElemnento();//a parte de encolarlo también lo da xD

            switch (figura.getClass().getName()){//yo me acuerdo que así obtengo bien el nombre del hijo xD, sino revisa el KOnquest :v :C xD
                case "Circulo":
                    Circulo circulo = (Circulo) figura;
                    pintor.setStyle(Paint.Style.FILL);//para que se rellene
                    pintor.setColor(figura.color);
                    canvas.drawCircle((float)figura.posicionInicialX, (float)figura.posicionInicialY, (float)circulo.darRadio(), pintor);//Creo que estos métodos no posicionan la figura en el espacio, solo le dan dimensiones...
                    break;
                case "Cuadrado":
                    Cuadrado cuadrado = (Cuadrado) figura;
                    pintor.setStyle(Paint.Style.FILL);//para que se rellene
                    pintor.setColor(figura.color);
                    canvas.drawRect((float)cuadrado.darLargo(), (float)cuadrado.darAncho(),
                            (float)cuadrado.darLargo(), (float)cuadrado.darAncho(), pintor);
                    break;
                case "Rectangulo":
                    Rectangulo rectangulo = (Rectangulo) figura;
                    pintor.setStyle(Paint.Style.FILL);//para que se rellene
                    pintor.setColor(figura.color);
                    canvas.drawRect((float)rectangulo.darLargo(), (float)rectangulo.darAncho(),
                            (float)rectangulo.darLargo(), (float)rectangulo.darAncho(), pintor);
                    break;
                case "Linea":
                    Linea linea = (Linea) figura;
                    pintor.setStyle(Paint.Style.FILL);//para que se rellene
                    pintor.setColor(figura.color);
                    canvas.drawLine((float)linea.darPosicionInicialX(), (float)linea.darPosicionIncialY(),
                            (float)linea.darPosicionFinalX(), (float)linea.darPosicionFinalY(), pintor);//Este si POSICIONA en el espacio...
                    break;
                case "Poligono":
                    Poligono poligono = (Poligono) figura;
                    pintor.setStyle(Paint.Style.FILL);//para que se rellene
                    pintor.setColor(figura.color);
                    //Aún no sé como dibujar un polígono xD
                    break;
            }
        }
    }

    public void procesarSolicitudAnimar(Pila<Figura> pilaDeFiguras){

    }
}
