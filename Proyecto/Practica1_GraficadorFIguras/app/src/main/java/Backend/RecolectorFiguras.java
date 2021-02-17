package Backend;

import Backend.Animacion.Animacion;
import Backend.Entidades.Figuras.Circulo;
import Backend.Entidades.Figuras.Cuadrado;
import Backend.Entidades.Figuras.Figura;
import Backend.Entidades.Figuras.Linea;
import Backend.Entidades.Figuras.Poligono;
import Backend.Entidades.Figuras.Rectangulo;
import Backend.EstructurasDeDatos.Pila;
import Backend.Manejadores.ManejadorColores;

public class RecolectorFiguras {
    private boolean seCreoCorrectamenteLaFigura;//no se tendrá problemas de que posea un valor que no corresponde a la situación de la figura por el hecho de que cada vez que se cree una figura nueva, esta variable actualizará su valor xD
    private Pila<Figura> pilaDeFiguras;
    private ManejadorColores manejadorColores;
    //no se requerirá una var global para el tipo de figuras por el hecho de que es posible add la animación en la prod de 3parám porque ya se tiene todo lo nec para hacer la revisión :3 xD
    //al final de cuentas no serán necesarias vars globales pues es posible recibirlas de una vez, y eso evita que se tenga dudas de si se recibió bien el valor de figura, color y tipo de animación cuando se rquiera emplear de estar var...

    public RecolectorFiguras(){
        pilaDeFiguras = new Pila<>();
        manejadorColores = new ManejadorColores();
        seCreoCorrectamenteLaFigura = true;
    }

    /**
     * Ejecutado por el parser en la axn de la regla
     * animar, puetso que en ese punto ya se ha recibido
     * todo lo necesario para saber si se debe o no add
     * una animación... aunque tb podría hacerse en la priducción
     * de ters parám pues al llegar ahí se ha obtenido el último
     * dato necesario para tomar la decisión xD
     * @param parametrosNumericos
     */
    public void agregarAnimacion(String tipoAnimacion, double parametrosNumericos[], boolean salioBienLaOperacion){//estos se obtenien del obj operador instanciado en el parser.cup...
        if(seCreoCorrectamenteLaFigura && salioBienLaOperacion){
            //Se instancia el obj obj Animación y se envía como parám a la figura en el toe de la pila... también se hace la revisión de los parámetros recibidos, como en el método para instanciar la figura
            //Animacion animacion = new Animacion()
            pilaDeFiguras.darUltimoElemento().establecerAnimacion(new Animacion(parametrosNumericos[0], parametrosNumericos[1],
                    parametrosNumericos[2], parametrosNumericos[3], tipoAnimacion));//:3 xD
        }
    }

    /**
     * Método empleado en cada producción de la regla Tipo
     * puesto que si se llega hasta ese punto quiere decir
     * que se terminó de revisar todo, y por ello puede procederse
     * a decidir si crear o no la figura
     * @param tipoFigura se recibe de manera directa de la var de la prod...
     * @param salioBienLaOperacion
     * @param parametrosNumericos
     * @return
     */
    public void agregarFigura(String tipoFigura, String color, boolean salioBienLaOperacion, double[] parametrosNumericos){//Este arreglo de parámetros numéricos es brindado por la instancia del operador que se encontrará en el CUP...
        if(salioBienLaOperacion){//NO es necesario revisar si el color o el tipo de figura el != null, pues si se llegó aquí, lo único que podría estar mal son los parám#...
            switch (tipoFigura){
                case "circulo":
                    pilaDeFiguras.apilar(new Circulo(parametrosNumericos[0], parametrosNumericos[1], parametrosNumericos[2],
                            manejadorColores.darColorCorrespondiente(color)));//Solo hace falta llenar los parámetros xD
                    break;
                case "cuadrado":
                    pilaDeFiguras.apilar(new Cuadrado(parametrosNumericos[0], parametrosNumericos[1], parametrosNumericos[2],
                            manejadorColores.darColorCorrespondiente(color)));
                    break;
                case "rectangulo":
                    pilaDeFiguras.apilar(new Rectangulo(parametrosNumericos[0], parametrosNumericos[1], parametrosNumericos[2],
                            parametrosNumericos[3], manejadorColores.darColorCorrespondiente(color)));
                    break;
                case "poligono":
                    pilaDeFiguras.apilar(new Poligono(parametrosNumericos[0], parametrosNumericos[1], parametrosNumericos[2],
                            parametrosNumericos[3], parametrosNumericos[4], manejadorColores.darColorCorrespondiente(color)));
                    break;
                case "linea":
                    pilaDeFiguras.apilar(new Linea(parametrosNumericos[0], parametrosNumericos[1], parametrosNumericos[2],
                            parametrosNumericos[4], manejadorColores.darColorCorrespondiente(color)));
                    break;
                default:
                    //jamás nunca se entrará aquí xD
                    break;
            }
            seCreoCorrectamenteLaFigura =  true;
        }
        seCreoCorrectamenteLaFigura = false;
    }

    /*se empleará en el método del parser que se encargará
    * de dar la pila a la actividad principal, para emplear
    * lo que contiente...*/
    public Pila<Figura> darPilaDeFiguras(){
        return pilaDeFiguras;
    }

}
