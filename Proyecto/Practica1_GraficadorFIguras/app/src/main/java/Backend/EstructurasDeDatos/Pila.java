package Backend.EstructurasDeDatos;

import java.io.Serializable;

public class Pila <T> implements Serializable {//no es necesaria su existencia, pero se imagina mejor teniendo en mente una pila :v xD
    private final ListaEnlazada<T> elementosPila;//xD

    public Pila(){
        elementosPila = new ListaEnlazada<>();
    }

    public void apilar(T elementoAApilar){//no veo necesario devulver si se hizo bien o no la operación...
        elementosPila.anadirAlFinal(elementoAApilar);
    }

    public T inspeccionarUltimoElemento(){
        return elementosPila.darUltimoElemento();
    }//No elimina de la pila, solo se da para que se inspeccione...

    public T darYEncolarUltimoElemnento(){//xD es que prácticamente hacer esto es usar la funcionalidad de una cola xD
        T elementoUltimoAntiguo = elementosPila.darYEliminarUltimoELemento();
        elementosPila.anadirAlPrincipio(elementoUltimoAntiguo);//si hay un error, puede que sea el método anadirAlPrincipio... auqnue tb dudaría del método que elimina y da el último xD

        return elementoUltimoAntiguo;
    }

    public boolean estaVacia(){
        return elementosPila.estaVacia();
    }

    public int darTamanio(){//no creo que llegue a ser útil xD
       return elementosPila.darTamanio();
    }
}
