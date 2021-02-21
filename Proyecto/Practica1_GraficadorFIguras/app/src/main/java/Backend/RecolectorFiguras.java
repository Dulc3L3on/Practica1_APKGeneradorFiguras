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
import Backend.Manejadores.Operador;

public class RecolectorFiguras {
    private String color;
    private boolean seCreoCorrectamenteLaFigura;//no se tendrá problemas de que posea un valor que no corresponde a la situación de la figura por el hecho de que cada vez que se cree una figura nueva, esta variable actualizará su valor xD
    private final Pila<Figura> pilaDeFiguras;
    private final ManejadorColores manejadorColores;
    //no se requerirá una var global para el tipo de figuras por el hecho de que es posible add la animación en la prod de 3parám porque ya se tiene todo lo nec para hacer la revisión :3 xD
    //al final de cuentas no serán necesarias vars globales pues es posible recibirlas de una vez, y eso evita que se tenga dudas de si se recibió bien el valor de figura, color y tipo de animación cuando se rquiera emplear de estar var...

    public RecolectorFiguras(){
        pilaDeFiguras = new Pila<>();
        manejadorColores = new ManejadorColores();
        seCreoCorrectamenteLaFigura = true;
        color = null;
    }

    /**
     * Ejecutado por el parser en la axn de la regla
     * TresPARAM [ya no en Animar], puetso que en ese punto ya se ha recibido
     * todo lo necesario para saber si se debe o no add
     * una animación... y si en dado caso algo sale mal pues
     * no se exe la axn, lo cual es lo que debería suceder...
     */
    public void agregarAnimacion(String tipoAnimacion, Operador operador){//estos se obtenien del obj operador instanciado en el parser.cup...
        if(seCreoCorrectamenteLaFigura && operador.todosLosParametrosCorrectos()){
            double parametrosNumericos[] = operador.darParametrosNumericos();

            //Se instancia el obj obj Animación y se envía como parám a la figura en el toe de la pila... también se hace la revisión de los parámetros recibidos, como en el método para instanciar la figura
            //Animacion animacion = new Animacion()
            pilaDeFiguras.inspeccionarUltimoElemento().establecerAnimacion(new Animacion(parametrosNumericos[0], parametrosNumericos[1],//Recuerda que puedes hacer esto, pues el método de inspeccionar devuelve al obj, por ello al app el punto sobre el método es como si lo estuvieras haciendo sobre el obj porque ese es su "resultado"
                    parametrosNumericos[2], parametrosNumericos[3], tipoAnimacion));//:3 xD
        }

        operador.reestablecerValores();//pues debe dejarse limpio todo sea que haya salido bien o no, para trabajar con lo que sigue xD
    }

    /**
     * Método empleado en cada producción de la regla TIPO
     * puesto que si se llega hasta ese punto quiere decir
     * que se terminó de revisar todo, y por ello puede procederse
     * a decidir si crear o no la figura
     * @param tipoFigura se recibe de manera directa de la var de la prod...
     * @param operador
     * @return
     */
    public void agregarFigura(String tipoFigura, Operador operador){//Este arreglo de parámetros numéricos es brindado por la instancia del operador que se encontrará en el CUP...
        if(operador.todosLosParametrosCorrectos() && color!=null){//NO es necesario revisar si el color o el tipo de figura el != null, pues si se llegó aquí, lo único que podría estar mal son los parám#...
            double parametrosNumericos[] = operador.darParametrosNumericos();

            switch (tipoFigura){//Este tipo de figura es el lexema...
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
            color = null;
            seCreoCorrectamenteLaFigura =  true;
        }
        color = null;//esto lo coloco por el hecho de que puede que haya salido algo mal en los parám, por lo cual esta var no tendría que tener algo, pues si es así, se tomaría como color el de la figura anterior aunque en realdidad se haya fallado al momento de revisar lo recibido co lo esperado con respecto al color de la figura en la prod de los parám...
        seCreoCorrectamenteLaFigura = false;
        operador.reestablecerValores();//puesto que debe desecharse todo lo hecho hasta el momento, halla salido bien o no, para hacer nuevamente el proceso pero con la figura nueva... xD
    }

    public void establecerColor(String elColor){
        color = elColor;
    }

    /*se empleará en el método del parser que se encargará
    * de dar la pila a la actividad principal, para emplear
    * lo que contiente...*/
    public Pila<Figura> darPilaDeFiguras(){
        return pilaDeFiguras;
    }

}
