package Backend.EstructurasDeDatos;

import java.io.Serializable;

public class Cola<T> implements Serializable {//no es necesaria su existencia, pero se imagina mejor teniendo en mente una pila :v xD
    private final ListaEnlazada<T> elementosCola;//xD

    public Cola(){
        elementosCola = new ListaEnlazada<>();
    }

    public void encolar(T elementoAEncolar){//no veo necesario devulver si se hizo bien o no la operación...
        elementosCola.anadirAlFinal(elementoAEncolar);
    }

    public T inspeccionarPrimerElemento(){
        return elementosCola.darPrimerElemento();
    }//No elimina de la pila, solo se da para que se inspeccione...

    public T inspeccionarUltimoElemento(){
        return elementosCola.darUltimoElemento();
    }

    public T darYEncolarPrimerElemnento(){//xD es que prácticamente hacer esto es usar la funcionalidad de una cola xD
        T elementoPrimeroAntiguo = elementosCola.darYEliminarPrimerElemento();
        elementosCola.anadirAlFinal(elementoPrimeroAntiguo);//debe ser añadir al último puesto que en la cola el orden de llegada es el normal... xD

        return elementoPrimeroAntiguo;
    }

    public boolean estaVacia(){
        return elementosCola.estaVacia();
    }

    public int darTamanio(){//no creo que llegue a ser útil xD
       return elementosCola.darTamanio();
    }
}
