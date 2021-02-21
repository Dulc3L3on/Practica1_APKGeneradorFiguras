package Backend.EstructurasDeDatos;

import java.io.Serializable;

public class ListaEnlazada <E> implements Serializable {
    private String nombre;
    private int tamanio = 0;
    private Nodo<E> primerNodo;
    private Nodo<E> ultimoNodo;

    public ListaEnlazada(){
        limpiarLista();//aunque no veo necesario hacer esto :v xD
    }

    public void establecerNombreDeLista(String elNombre){
        nombre = elNombre;
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

    public E darPrimerElemento(){//Se que no es necesario[igual que dar el último contenido], pero por si acaso alguna vez no quiesieras tener que estar importando los nodos...
        return primerNodo.contenido;
    }

    public E darUltimoElemento(){
        return ultimoNodo.contenido;
    }

    public E darYEliminarPrimerElemento(){
        if(tamanio>0){
            E elementoAEliminar = primerNodo.contenido;

            primerNodo = primerNodo.nodoSiguiente;//daría lo mismo si hubiera sido el aux un nodo y hubiera dicho 1erNodo = nodoAux.siguiente... puesto que Java de primero hace lo de la derecha para así saber a que es = lo de la izquierda xD
            tamanio--;
            return elementoAEliminar;
        }
        return null;
    }

    public E darYEliminarUltimoELemento(){
        if(tamanio>0){
            E elementoAEliminar = ultimoNodo.contenido;

            Nodo<E> nodoAuxiliar = primerNodo;
            for (int elementoActual=2; elementoActual < tamanio; elementoActual++){//puesto que se entra estando en el primer elemento, por ello debe ini en 1, para así llegar al penúltimo xD... mejor así xD porque en la vuelta con i=2 obtniene el nodo #2 xD
                nodoAuxiliar = nodoAuxiliar.nodoSiguiente;
            }
            nodoAuxiliar.nodoSiguiente = null;//se pierde la referencia del último nodo, por lo cual se pierde la dirección del último contenido...
            ultimoNodo = nodoAuxiliar;
            tamanio--;//pues es una eliminación y al ser así hay que disminuir, pues si en otros lados se empleen este y el método para añadir y no se hace la disminución, entonces parecería que la lista está creciendo cuando en realidad solo está reacomodando la pila por medio del movimiento de la fila xd [Es decir ingresado a los primeros al final xD]

            return elementoAEliminar;
        }
        return null;
    }

    public void limpiarLista(){
        primerNodo = ultimoNodo = null;
        tamanio = 0;
    }

    public String darNombre(){
        return nombre;
    }

    public int darTamanio(){
        return tamanio;
    }

    public boolean estaVacia(){
        return tamanio == 0;
    }

    public Nodo<E> darPrimerNodo(){
        return primerNodo;
    }

    public Nodo<E> darUltimoNodo(){
        return ultimoNodo;
    }
}
