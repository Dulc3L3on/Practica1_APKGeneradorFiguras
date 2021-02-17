package Backend.EstructurasDeDatos;

public class Nodo <E>{
    public E contenido;
    public Nodo<E> nodoSiguiente;

    public Nodo(E elemento){
        this(elemento, null);//mando a llamar al ctrctor que recibe 2 parámetros
    }

    public Nodo(E elemento, Nodo siguiente){
        contenido=elemento;
        nodoSiguiente=siguiente;
    }

    public Nodo obtenerSiguiente(){
        return nodoSiguiente;
    }
}
