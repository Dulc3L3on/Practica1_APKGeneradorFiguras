package Backend.EstructurasDeDatos;

public class ListaEnlazada <E>{
    private int tamanio = 0;
    private Nodo<E> primerNodo;
    private Nodo<E> ultimoNodo;

    public ListaEnlazada(){
        limpiarLista();//aunque no veo necesario hacer esto :v xD
    }

    public void anadirAlFinal(E elemento){//yo sé que los métodos de inserción funcionan, por ello no veo necesario devolver un boolean para saberlo...
        if(estaVacia()){
            primerNodo=ultimoNodo= new Nodo<E>(elemento);
            tamanio++;
        }
        else{
            ultimoNodo=ultimoNodo.nodoSiguiente= new Nodo<E>(elemento);
            tamanio++;
        }
    }

    /**
     * será empleado cuando el último se saque ... creo que será para la exe
     * de las animaciones de las figuras... si es que se mantendrá la pila a menos que
     * decida generar otro arch de entrada...
     * @param elemento
     */
    public void anadirAlPrincipio(E elemento){//Creo que no será últil a menos que la pila se mantenga hasta que decida generar otro arch de entrada...
        //simi a lo del eje de C [la cabeza pasa a ser el siguiente del nuevo
        // y luego la cabeza se hace igual a este último...]
        Nodo nuevoElemento = new Nodo<E>(elemento, primerNodo);//El sigNuevo apunta a la dir del 1erNodo que contiene la dir inicial de la lista
        primerNodo = nuevoElemento;//ahora el primer nodo apunta al nuevo nodo como la dir inicial de la lista...
        tamanio++;
    }

    public E darUltimoElemento(){
        return ultimoNodo.contenido;
    }

    public void limpiarLista(){
        primerNodo = ultimoNodo = null;
        tamanio = 0;
    }

    public int darTamanio(){
        return tamanio;
    }

    public boolean estaVacia(){
        if (tamanio == 0){
            return true;
        }
        return false;
    }
}
