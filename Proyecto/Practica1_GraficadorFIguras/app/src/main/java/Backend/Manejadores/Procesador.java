package Backend.Manejadores;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

import Backend.Entidades.Figuras.Circulo;
import Backend.Entidades.Figuras.Cuadrado;
import Backend.Entidades.Figuras.Figura;
import Backend.Entidades.Figuras.Linea;
import Backend.Entidades.Figuras.Poligono;
import Backend.Entidades.Figuras.Rectangulo;
import Backend.EstructurasDeDatos.Cola;

public class Procesador {

    public void ProcesarSolicitudGraficar(Cola<Figura> colaDeFiguras, Paint pintor, Canvas canvas){
        for (int figuraActual = 0; figuraActual< colaDeFiguras.darTamanio(); figuraActual++){
            Figura figura = colaDeFiguras.darYEncolarPrimerElemnento();//a parte de encolarlo también lo da xD

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
                    //se asegura que el punto inicial, sea el verdadero punto inicial xD [creo que debes colocar primero la Y y luego la X para dar el largo y ancho, respectivamente xD]
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
                    pintor.setColor(poligono.color);
                    canvas.drawPath(procesarPoligono(poligono), pintor);
                    break;
            }
        }
    }

    public void procesarSolicitudAnimar(Cola<Figura> colaDeFiguras){//pendiente

    }

    private Path procesarPoligono(Poligono poligono){
        double[][] puntosAUnir = hallarPuntos(poligono);
        Path trazo = new Path();

        trazo.moveTo((float) poligono.posicionInicialX, (float) poligono.posicionInicialY);
        for (int puntoActual = 0; puntoActual < puntosAUnir.length; puntoActual++){
            trazo.lineTo((float) puntosAUnir[puntoActual][0], (float) puntosAUnir[puntoActual][1]);//si no sale, es porque hay que hacer de primero el moveTo, para que se posicione como primer punto, entonces al ser así según lo queestoy pensando ahorita, debería comenzar en el for en el 2do punto... pero en ese caso el close, se haría la punto del moveTo [orque aunque se haya hecho con otro método, de todos modos es el primer punto] o con el primero en el que se usó el lineTo? fmmm, a ver se ha dicho xD
        }
        trazo.close();//vamos a ver si este métodoo se encarga de unir el último punto con el primero, si no.... sé que se podría add una linea pue ya tengos los puntos, peor la cuestión es la animada...
        return trazo;
    }

    private double[][] hallarPuntos(Poligono poligono){
        double[][]centroPoligono = {{poligono.posicionInicialX+ ((poligono.ancho)/2), poligono.posicionInicialY+((poligono.largo)/2)}};//puedo hacer esto por el hecho de que al hacer los ajustes [cuando no esté encerrado en un cuadro sino en un rectángulo, se sumará posi o negatimaente el valor faltante, por lo cual t
        double gradosEnCadaLado = (2*Math.PI)/poligono.cantidadDeLados;
        double[][] verticesPoligono = new double[(int) poligono.cantidadDeLados][2];

        for (int parejaPuntosActual= 0; parejaPuntosActual < verticesPoligono.length; parejaPuntosActual++){
            asignarPuntos(poligono, gradosEnCadaLado, verticesPoligono, parejaPuntosActual);//debe hacerse de primero, sino estarías obviando el primer punto xD
            gradosEnCadaLado+= ((2*Math.PI)/poligono.cantidadDeLados);
        }//fin del for ubicador de puntos del polígono..

        return ajustarALargoReal(poligono.posicionInicialY,verticesPoligono, poligono.ancho, poligono.largo, centroPoligono);
    }

    private double[][] asignarPuntos(Poligono poligono, double gradosActuales, double[][] verticesDelPoligono, int verticeActual){
        if(gradosActuales<=(Math.PI/2)){
            verticesDelPoligono[verticeActual][0] = (poligono.ancho/2)*Math.cos(gradosActuales);//recuerda que se acordó que el ancho haría la función de diametro siempre; por esa razón el ajuste se hace de la manera que se codificó abajito xD
            verticesDelPoligono[verticeActual][1] = (poligono.ancho/2)*Math.sin(gradosActuales);
        }
        if(gradosActuales > (Math.PI/2) && gradosActuales <= (Math.PI)){
            verticesDelPoligono[verticeActual][0] = (poligono.ancho/2)*Math.cos((Math.PI)-gradosActuales);
            verticesDelPoligono[verticeActual][1] = (poligono.ancho/2)*Math.sin((Math.PI)-gradosActuales);
        }
        if(gradosActuales > (Math.PI) && gradosActuales <= ((3*Math.PI)/2)){
            verticesDelPoligono[verticeActual][0] = (poligono.ancho/2)*Math.cos(gradosActuales-(Math.PI));
            verticesDelPoligono[verticeActual][1] = (poligono.ancho/2)*Math.sin(gradosActuales-(Math.PI));
        }
        if(gradosActuales > ((3*Math.PI)/2) && gradosActuales <= (2*Math.PI)){//aunque también hubiera podido ser un else...puesto que sabemos que nnca va a pasarse de 2pi, lo  cual es lo que debe suceder...
            verticesDelPoligono[verticeActual][0] = (poligono.ancho/2)*Math.cos((2*Math.PI)-gradosActuales);
            verticesDelPoligono[verticeActual][1] = (poligono.ancho/2)*Math.sin((2*Math.PI)-gradosActuales);
        }
        return verticesDelPoligono;//no me acuerdo si los arreglos se pasan por referencia o por valor, creo que es por refrencia, pero por si acaso no, mejor lo devuelvo xD
    }

    private double[][] ajustarALargoReal(double puntoInicialY, double puntosDelPoligonoCuadrangular[][], double ancho, double largo, double[][] centro){
        if(ancho != largo){//pues sino, quiere decir que sí está encerrado en un cuadrado, es decir que si es un poligono cuadrangular xD
            for (int puntoActualX =0; puntoActualX<puntosDelPoligonoCuadrangular.length; puntoActualX++){
                if(ancho>largo){
                    if((puntosDelPoligonoCuadrangular[puntoActualX][1]+puntoInicialY)< centro[0][1]){//Se debe hacer la traslación puesto que el centro sí se encuentra ubicado en la posicón real es decir, no posee solo tamaños, como en el caso de los puntos, sino una posición en el espacio bidimensional xD
                        puntosDelPoligonoCuadrangular[puntoActualX][1] += (ancho-largo);

                    }else if((puntosDelPoligonoCuadrangular[puntoActualX][1]+puntoInicialY)> centro[0][1]){//lo coloco así porque los puntos que justo están en el centro, no tendrían porque moverse xD
                        puntosDelPoligonoCuadrangular[puntoActualX][1] -= (ancho-largo);
                    }
                }else{
                    if((puntosDelPoligonoCuadrangular[puntoActualX][1]+puntoInicialY)< centro[0][1]){
                        puntosDelPoligonoCuadrangular[puntoActualX][1] -= (largo-ancho);

                    }else if((puntosDelPoligonoCuadrangular[puntoActualX][1]+puntoInicialY)> centro[0][1]){
                        puntosDelPoligonoCuadrangular[puntoActualX][1] += (largo-ancho);
                    }
                }//se miraba más como debe ser cuando le sumabas el centro? o era cuando no le sumabas nada :| xD, prueba, de todos modos solo puede ser una de estas 2 opciones, que de ahí ya no tocaste nada xD
                //Ahor así debuggea!!!
            }
        }
        return puntosDelPoligonoCuadrangular;//pues se debe devolver el arreglo, sea que se halla modificado o no xD
    }
}
