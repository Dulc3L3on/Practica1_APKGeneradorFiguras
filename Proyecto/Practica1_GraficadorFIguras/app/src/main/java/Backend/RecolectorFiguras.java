package Backend;

import Backend.Animacion.Animacion;
import Backend.Figuras.Circulo;
import Backend.Figuras.Cuadrado;
import Backend.Figuras.Figura;
import Backend.Figuras.Linea;
import Backend.Figuras.Poligono;
import Backend.Figuras.Rectangulo;
import Backend.Herramientas.Pila;

public class RecolectorFiguras {
    private String color = null;
    private String tipoFigura = null;
    private String tipoAnimación = null;//se recibiría al exe la producción de animar... la cuestión es el arreglo para almacenar los parám... tendré que crear otro en operador? o hacer otra cosa, como crear una clase que se encargue de recibir los parám??? o que avise que se creará una anim, erpo en dónde digo esto pues las axn soo se exe al final de haber elido toda la intrucción ya sea de solo gra o graf y ani...


    /**
     * Ejecutado por el parser en la axn de la regla
     * Instruccion, en la cual se empleará el método
     * para devolver los paráms que están en la
     * clase instanciada en el parser...
     * @param hayQueAgregarAnmacion
     * @param parametrosNumericos
     */
    public void agregarDibujo(Pila<Figura> pilaFiguras, boolean hayQueAgregarAnmacion, double parametrosNumericos[], boolean salioBienLaOperacion){
        if(hayQueAgregarAnmacion && agregarFigura(pilaFiguras, tipoFigura, salioBienLaOperacion)){
            //Se instancia el obj obj Animación y se envía como parám a la figura en el toe de la pila... también se hace la revisión de los parámetros recibidos, como en el método para instanciar la figura
            //Animacion animacion = new Animacion()
        }
    }

    private boolean agregarFigura(Pila<Figura> pilaFiguras, String tipoFigura, boolean salioBienLaOperacion){
        if(salioBienLaOperacion && color!=null && tipoFigura!=null){
            switch (tipoFigura){
                case "circulo":
                    pilaFiguras.apilar(new Circulo());//Solo hace falta llenar los parámetros xD
                    break;
                case "cuadrado":
                    pilaFiguras.apilar(new Cuadrado());
                    break;
                case "rectangulo":
                    pilaFiguras.apilar(new Rectangulo());
                    break;
                case "poligono":
                    pilaFiguras.apilar(new Poligono());
                    break;
                case "linea":
                    pilaFiguras.apilar(new Linea());
                    break;
                default:
                    //jamás nunca se entrará aquí xD
                    break;
            }
            reestablecerValores();
            return true;
        }
        reestablecerValores();//pues sin importar si se haya logrado o no, deberá dejarse todo limpio para lo que sigue...
        return false;
    }

    private void reestablecerValores(){
        color = null;
        tipoFigura = null;
        tipoAnimación = null;
    }
}
