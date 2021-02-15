package Backend.Herramientas;

public class Pila <T> {//no es necesaria su existencia, pero se imagina mejor teniendo en mente una pila :v xD
    private ListaEnlazada<T> elementosPila;//xD

    public Pila(){
        elementosPila = new ListaEnlazada<>();
    }

    public void apilar(T elementoAApilar){//no veo necesario devulver si se hizo bien o no la operación...
        elementosPila.anadirAlFinal(elementoAApilar);
    }

    public T darUltimoElemento(){
        return elementosPila.darUltimoElemento();
    }

    public boolean estaVacia(){
        return elementosPila.estaVacia();
    }

    public int darTamanio(){//no creo que llegue a ser útil xD
       return elementosPila.darTamanio();
    }
}
