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

            switch (figura.getClass().getSimpleName()){//yo me acuerdo que así obtengo bien el nombre del hijo xD, sino revisa el KOnquest :v :C xD
                case "Circulo"://Está listo
                    Circulo circulo = (Circulo) figura;
                    pintor.setStyle(Paint.Style.FILL);//para que se rellene
                    pintor.setColor(circulo.color);
                    canvas.drawCircle((float)circulo.posicionInicialX, (float)circulo.posicionInicialY, (float)circulo.darRadio(), pintor);//Creo que estos métodos no posicionan la figura en el espacio, solo le dan dimensiones...
                    break;
                case "Cuadrado"://está listo
                    Cuadrado cuadrado = (Cuadrado) figura;
                    pintor.setStyle(Paint.Style.FILL);//para que se rellene
                    pintor.setColor(figura.color);
                    canvas.drawRect((float)cuadrado.posicionInicialX, (float)cuadrado.posicionInicialY,
                            (float)cuadrado.posicionInicialX+(float)cuadrado.ancho, (float)cuadrado.posicionInicialY+(float)cuadrado.largo, pintor);//hice esto pues me debo asegurar, según el enunciado,
                    // que el cuadrado empiece en el punto inicial :v sin importar que tamaño se le haya dado al cuadrado xD, pues lo que estabas haciendo al solo darle el tamaño de los lados es que si este
                    // valor es < al pto inicial, entonces que este se vuelva punto inicial
                    break;
                case "Rectangulo"://listisimo xD
                    Rectangulo rectangulo = (Rectangulo) figura;
                    pintor.setStyle(Paint.Style.FILL);//para que se rellene
                    pintor.setColor(figura.color);
                    canvas.drawRect((float)rectangulo.posicionInicialX, (float)rectangulo.posicionInicialY,
                            (float)rectangulo.posicionInicialX+(float)rectangulo.ancho, (float)rectangulo.posicionInicialY+(float)rectangulo.largo, pintor);//puesto que así al igual que con el cuadrado,
                    //se asegura que el punto inicial, sea el verdadero punto inicial xD
                    break;
                case "Linea"://listisímia xD, a esta no le vamos a hacer la sumatoria del punto 1 al punto 2, porque no es como que diga largo de la línea, además se sobreentiende que esas son las posiciones literales y no relativas al punto inicial... en cambio en el caso del cuadrado y rectangulo así si porque dice ancho y es como decir punto2enX a partir del punto inicial... xD
                    Linea linea = (Linea) figura;
                    pintor.setStrokeWidth(3);//para que no sea tan delagada y así, se pueda ver mejor xD
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
