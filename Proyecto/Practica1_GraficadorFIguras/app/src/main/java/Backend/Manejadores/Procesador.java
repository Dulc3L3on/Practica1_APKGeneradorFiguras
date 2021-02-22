package Backend.Manejadores;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import Backend.Entidades.Figuras.Circulo;
import Backend.Entidades.Figuras.Cuadrado;
import Backend.Entidades.Figuras.Figura;
import Backend.Entidades.Figuras.Linea;
import Backend.Entidades.Figuras.Poligono;
import Backend.Entidades.Figuras.Rectangulo;

public class Procesador {
    private double[] puntoMasAlaIzqYArriba = new double[2];
    private double[] puntoMasAlaDerYAbajo = new double[2];

    public Rect ProcesarSolicitudGraficar(Figura figura, Paint pintor, Canvas canvas){
            switch (figura.getClass().getSimpleName()){//yo me acuerdo que así obtengo bien el nombre del hijo xD, sino revisa el KOnquest :v :C xD
                case "Circulo"://Está listo [YEP listo xD]
                    Circulo circulo = (Circulo) figura;
                    pintor.setStyle(Paint.Style.FILL);//para que se rellene
                    pintor.setColor(circulo.color);
                    canvas.drawCircle((float)circulo.darPosicionInicialX()+(float) circulo.darRadio(), (float)circulo.posicionInicialY+(float) circulo.darRadio(),
                            (float)circulo.darRadio(), pintor);//hago esto porque ahora el que se posicionará en el espacio, será el lienzo y la figura se colocará en una posición centrada al lienzo, puesto que a este se le dará el tamaño de la figura... y en el caso del círuclo, la posición que se da se coloca para el punto del centro... por ello hay que sumarle el radio, para que la esquine izq sea la que esté en esa posición inicial,como sucede cn las demás fig [excepto la línea xD]
                    return new Rect((int)circulo.posicionInicialX, (int)circulo.posicionInicialY,
                            (int)circulo.posicionInicialX+((int)circulo.darRadio()*2), (int)circulo.posicionInicialY+((int)circulo.darRadio()*2));
                    //a mi parecer el valor para left y top no están correctos, pues es para formar un rectángulo... a menos que estas posiciones de una vez involucren la posición... en ese caso debería eliminar a left y a top, pues estas hacen ese trabajo de una vez, prueba y si no sale entonces haz estos 2 valores de RECT 0...
                case "Cuadrado"://está listo [YEP listo xD]
                    Cuadrado cuadrado = (Cuadrado) figura;
                    pintor.setStyle(Paint.Style.FILL);//para que se rellene
                    pintor.setColor(figura.color);
                    canvas.drawRect((float)cuadrado.posicionInicialX, (float)cuadrado.posicionInicialY,//A mi pensar debería ser 0 los valores donde están las posiciones iniciales, puesto que el lienzo es el que va a ubicarse en el espacio, espués...
                            (float)cuadrado.posicionInicialX+(float)cuadrado.ancho, (float)cuadrado.posicionInicialY+(float)cuadrado.largo, pintor);//hice esto pues me debo asegurar, según el enunciado,
                    // que el cuadrado empiece en el punto inicial :v sin importar que tamaño se le haya dado al cuadrado xD, pues lo que estabas haciendo al solo darle el tamaño de los lados es que si este
                    // valor es < al pto inicial, entonces que este se vuelva punto inicial
                    return new Rect((int)cuadrado.darPosicionInicialX(), (int)cuadrado.darPosicionIncialY(), (int)cuadrado.darPosicionInicialX()+(int)cuadrado.ancho,
                            (int)cuadrado.darPosicionIncialY()+(int)cuadrado.darLargo());
                case "Rectangulo"://listisimo xD [YEP listo xD]
                    Rectangulo rectangulo = (Rectangulo) figura;
                    pintor.setStyle(Paint.Style.FILL);//para que se rellene
                    pintor.setColor(figura.color);
                    canvas.drawRect((float)rectangulo.posicionInicialX, (float)rectangulo.posicionInicialY,
                            (float)rectangulo.posicionInicialX+(float)rectangulo.ancho, (float)rectangulo.posicionInicialY+(float)rectangulo.largo, pintor);//puesto que así al igual que con el cuadrado,
                    //se asegura que el punto inicial, sea el verdadero punto inicial xD [creo que debes colocar primero la Y y luego la X para dar el largo y ancho, respectivamente xD]
                    return new Rect((int)rectangulo.darPosicionInicialX(), (int)rectangulo.darPosicionIncialY(), (int)rectangulo.darPosicionInicialX()+(int)rectangulo.ancho,
                            (int)rectangulo.darPosicionIncialY()+(int)rectangulo.darLargo());
                case "Linea"://listisímia xD, [YEP listo xD]  [no se para qué acción hice el comentario siguiente xD, creo que tenía que ver con el rectángulo delimitador xD, pero ya está bien xD así que ignora el cment sig a este xD -->]          a esta no le vamos a hacer la sumatoria del punto 1 al punto 2, porque no es como que diga largo de la línea, además se sobreentiende que esas son las posiciones literales y no relativas al punto inicial... en cambio en el caso del cuadrado y rectangulo así si porque dice ancho y es como decir punto2enX a partir del punto inicial... xD
                    Linea linea = (Linea) figura;
                    pintor.setStrokeWidth(3);//para que no sea tan delagada y así, se pueda ver mejor xD
                    pintor.setColor(figura.color);
                    canvas.drawLine((float)linea.darPosicionInicialX(), (float)linea.darPosicionIncialY(),
                            (float)linea.darPosicionFinalX(), (float)linea.darPosicionFinalY(), pintor);//Este si POSICIONA en el espacio...
                    if(linea.darPosicionFinalX() == linea.darPosicionInicialX()){
                        return new Rect((int) linea.darPosicionInicialX()-7, (int) linea.darPosicionIncialY(), (int)linea.darPosicionFinalX()+7, (int)linea.darPosicionFinalY()); //solo se le aumentará a una coordenada, porque sino volvería a "no verse nada" porque vuelven a estar en el mismo punto xD
                    }else if(linea.darPosicionFinalY() == linea.darPosicionIncialY()){
                        return new Rect((int) linea.darPosicionInicialX(), (int) linea.darPosicionIncialY()-7, (int)linea.darPosicionFinalX(), (int)linea.darPosicionFinalY()+7);
                    }
                    return new Rect((int) linea.darPosicionInicialX(), (int) linea.darPosicionIncialY(), (int)linea.darPosicionFinalX(), (int)linea.darPosicionFinalY());//con tal de que no hallan errores cuando sea o vertical u horizontal...
                case "Poligono":
                    Poligono poligono = (Poligono) figura;
                    pintor.setStrokeWidth(3);
                    pintor.setColor(poligono.color);
                    procesarPoligono(poligono, canvas, pintor);
                    return new Rect((int)puntoMasAlaIzqYArriba[0], (int)puntoMasAlaIzqYArriba[1], (int)puntoMasAlaDerYAbajo[0],
                            (int)puntoMasAlaDerYAbajo[1]);//así le mando un recuadro que abarque todos los puntos...
            }
            return null;
    }

    public void procesarSolicitudAnimar(Figura figura, View vista){//pendiente
        switch(figura.darAnimacion().darTipoAnimacion()){
            case "linea":
                ObjectAnimator objetoAnimadorEnX = ObjectAnimator.ofFloat(vista, "x", (float) figura.darAnimacion().darPuntoFinalX());
                objetoAnimadorEnX.setDuration(1500);

                ObjectAnimator objetoAnimadorEnY = ObjectAnimator.ofFloat(vista, "y", (float) figura.darAnimacion().darPuntoFinalY());
                objetoAnimadorEnY.setDuration(1500);

                AnimatorSet setAnimadorX = new AnimatorSet();
                setAnimadorX.playTogether(objetoAnimadorEnX, objetoAnimadorEnY);
                setAnimadorX.start();//Así es posible moverlo en cualquier tipo de línea...
            break;
            case "curva":


            break;
        }
    }

    private void procesarPoligono(Poligono poligono, Canvas canvas, Paint pintor){
        double[][] puntosAUnir = hallarPuntos(poligono);

        if(puntosAUnir.length>1){
            for (int parejaActual = 0; parejaActual < (puntosAUnir.length-1); parejaActual++){//puesto que en un mismo ciclo se revisará al sigueinte...
                canvas.drawLine((float) puntosAUnir[parejaActual][0], (float) puntosAUnir[parejaActual][1],
                        (float) puntosAUnir[parejaActual+1][0], (float) puntosAUnir[parejaActual][1], pintor);
            }

            canvas.drawLine((float) puntosAUnir[puntosAUnir.length-1][0], (float) puntosAUnir[puntosAUnir.length-1][1],
                    (float) puntosAUnir[0][0], (float) puntosAUnir[0][1], pintor);//para así cerrar la figura xD
        }else{//pues no hay nada más que hacer xD
            canvas.drawPoint((float)puntosAUnir[0][0], (float)puntosAUnir[0][0], pintor);
        }


        //Path trazo = new Path();

        /*trazo.moveTo((float) puntosAUnir[0][0], (float) puntosAUnir[0][1]);//para que almenos si genere bien la figura... :1 :c xD
        for (int puntoActual = 1; puntoActual < puntosAUnir.length; puntoActual++){
            trazo.lineTo((float) puntosAUnir[puntoActual][0], (float) puntosAUnir[puntoActual][1]);//si no sale, es porque hay que hacer de primero el moveTo, para que se posicione como primer punto, entonces al ser así según lo queestoy pensando ahorita, debería comenzar en el for en el 2do punto... pero en ese caso el close, se haría la punto del moveTo [orque aunque se haya hecho con otro método, de todos modos es el primer punto] o con el primero en el que se usó el lineTo? fmmm, a ver se ha dicho xD
        }
        trazo.close();//vamos a ver si este métodoo se encarga de unir el último punto con el primero, si no.... sé que se podría add una linea pue ya tengos los puntos, peor la cuestión es la animada...
        return trazo;*/
    }

    private double[][] hallarPuntos(Poligono poligono){
        double[][]centroPoligono = {{poligono.posicionInicialX+ ((poligono.ancho)/2), poligono.posicionInicialY+((poligono.largo)/2)}};//puedo hacer esto por el hecho de que al hacer los ajustes [cuando no esté encerrado en un cuadro sino en un rectángulo, se sumará posi o negatimaente el valor faltante, por lo cual t
        double anguloEnCadaLado = (2*Math.PI)/poligono.cantidadDeLados;
        double[][] verticesPoligono = new double[(int) poligono.cantidadDeLados][2];

        for (int verticeActual= 0; verticeActual < verticesPoligono.length; verticeActual++){
            verticesPoligono[verticeActual][0] = (poligono.ancho/2)*Math.cos(anguloEnCadaLado);//recuerda que se acordó que el ancho haría la función de diametro siempre; por esa razón el ajuste se hace de la manera que se codificó abajito xD
            verticesPoligono[verticeActual][1] = (poligono.ancho/2)*Math.sin(anguloEnCadaLado);
            verticesPoligono = ajustarALargoReal(anguloEnCadaLado, verticesPoligono, poligono.ancho, poligono.largo, verticeActual);//vamos a probar ponerle un margen al recuadro para que así no tenga que estar haciendo el ajuste en cada punto, sino que hacerlo en todos de una sola vez xD [Esto con el setLeft y setTop...]
            hallarPuntosDelimitadores(verticeActual, verticesPoligono[verticeActual][0] , verticesPoligono[verticeActual][1]);//Esto es para colocarle el margen al lienzo completo a todos los puntos de una sola vez xD y así no estarlos trasladando unopor uno xD
            anguloEnCadaLado+= ((2*Math.PI)/poligono.cantidadDeLados);
        }//fin del for ubicador de puntos del polígono..

        return verticesPoligono;
    }

    private void hallarPuntosDelimitadores(int verticeActual, double verticeX, double verticeY){
        if(verticeActual==0){
            puntoMasAlaIzqYArriba[0] = verticeX;
            puntoMasAlaIzqYArriba[1] = verticeY;

            puntoMasAlaDerYAbajo[0] =puntoMasAlaIzqYArriba[0];
            puntoMasAlaDerYAbajo[1] =puntoMasAlaIzqYArriba[1];
        }else{
            if(verticeX < puntoMasAlaIzqYArriba[0]){//pues sin importar si es de la misma pareja o no, se requiere registrar el punto más a la izq en este caso, lo mismo aplica para los demás casos, por el hecho de que si no es así, posiblemente no todos los puntos aparezcan en el recuadro... xD
                puntoMasAlaIzqYArriba[0] = verticeX;//pues es el punto más a la izquierda que ha existido, pero no el más "alto"

            }else if(verticeX > puntoMasAlaDerYAbajo[0]){
                puntoMasAlaDerYAbajo[0] = verticeX;
            }

            if(verticeY < puntoMasAlaIzqYArriba[1]){
                puntoMasAlaIzqYArriba[1] = verticeY;//puesto que aquí un punto está más arriba mientras menor valor de y posee

            }else if(verticeY > puntoMasAlaDerYAbajo[1]){
                puntoMasAlaDerYAbajo[1] = verticeY;
            }
        }

    }

    private double[][] ajustarALargoReal(double angulo, double verticesPoligono[][], double ancho, double largo, int verticeActual){//aah creo que al final no era útil el centro xD
        if(ancho != largo){//pues sino, quiere decir que sí está encerrado en un cuadrado, es decir que si es un poligono cuadrangular xD
                if(ancho>largo){
                    if(angulo > 0 && angulo < Math.PI){//Se debe hacer la traslación puesto que el centro sí se encuentra ubicado en la posicón real es decir, no posee solo tamaños, como en el caso de los puntos, sino una posición en el espacio bidimensional xD
                        verticesPoligono[verticeActual][1] += (ancho-largo);//esto es para disminuir el tamaño del lado, no para cambiar de ubicación, por eso es que hago que la y aumente de valor, para que esté más cerca del centro y así del punto con el que se unirá

                    }else if(angulo > Math.PI && angulo < (2*Math.PI)){//lo coloco así porque los puntos que justo están en el centro, no tendrían porque moverse xD
                        verticesPoligono[verticeActual][1] -= (ancho-largo);
                    }
                }else{
                    if(angulo > 0 && angulo < Math.PI){
                        verticesPoligono[verticeActual][1] -= (largo-ancho);//puesto que lo que quiero es agrandar el tamaño, por lo cual debo hacer que la y sea más pequeña para que esté más lejos del centro y así del punto con el que se unirá

                    }else if(angulo > Math.PI && angulo < (2*Math.PI)){
                        verticesPoligono[verticeActual][1] += (largo-ancho);
                    }
                }//se miraba más como debe ser cuando le sumabas el centro? o era cuando no le sumabas nada :| xD, prueba, de todos modos solo puede ser una de estas 2 opciones, que de ahí ya no tocaste nada xD
                //Ahor así debuggea!!!
        }
        return verticesPoligono;//pues se debe devolver el arreglo, sea que se halla modificado o no xD
    }
}
