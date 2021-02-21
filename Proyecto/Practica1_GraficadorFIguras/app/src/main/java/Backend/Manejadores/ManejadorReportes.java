package Backend.Manejadores;

import Backend.Entidades.Reporte;
import Backend.Entidades.ReporteError;
import Backend.Entidades.ReporteOcurrencias;
import Backend.Entidades.ReporteUsos;
import Backend.Entidades.Token;
import Backend.EstructurasDeDatos.ListaEnlazada;
import Backend.EstructurasDeDatos.Nodo;

public class ManejadorReportes {
    private final ListaEnlazada<ListaEnlazada<Reporte>> listadoDeListadoDeReportes;
    private ListaEnlazada<Reporte> listadoReportesDeOcurrencia;//y los hijos ya serían del reporte correspondiente, puesto que a pesar de la herencia, en las listas si debe ser el tipo que se colocó... no como en los arreglos, pues en ellos si se detecta la herencia, en cb en las listas supogo que hay que hacer algo más para que se haga algo así xD

    public ManejadorReportes(){
        listadoDeListadoDeReportes = new ListaEnlazada<>();
        listadoReportesDeOcurrencia = new ListaEnlazada<>();
    }

    /**
     * Este método será empleado por CUP para que pueda hacer
     * las debidas agregaciones de los objetos ReporteOcurrencia
     * a la lista formada hasta el momento...
     * @param listaReportesDeUso
     */
    public ManejadorReportes(ListaEnlazada<ListaEnlazada<Reporte>> listaReportesDeUso){
        listadoDeListadoDeReportes = listaReportesDeUso;
    }

    public void agregarReportesDeUso(String grupoDelToken, String lexema){//grupo de token: animacion, figura, color; lexema; listado de colores, listado de anim y listado de figuras
        ListaEnlazada<Reporte> listaDeReportes= buscarListaDeReportesPorNombre(grupoDelToken);
        buscarLexemaUsado(listaDeReportes, lexema);
    }

    public void agregarReportesDeOcurrencia(ListaEnlazada<ReporteError> listadoDeErrores, Token token){//mejor voy a recibir el token de una vez para así obtner de manera directa estos valores y hacerlo solo sí la lista de errores está vacía... xD
        if(listadoDeErrores.estaVacia()){
            if(listadoReportesDeOcurrencia.estaVacia()){
                listadoDeListadoDeReportes.anadirAlFinal(listadoReportesDeOcurrencia);
            }

            listadoReportesDeOcurrencia.anadirAlFinal(new ReporteOcurrencias(token.darLexemaAnterior()+token.darLexema()+token.darLexemaSiguiente(), token.darFila(), token.darColumna()));
        }
    }

    private ListaEnlazada<Reporte> buscarListaDeReportesPorNombre(String nombreReporte){
        Nodo<ListaEnlazada<Reporte>> nodoAuxiliar = listadoDeListadoDeReportes.darPrimerNodo();

        for (int listaReportesActual = 0; listaReportesActual < listadoDeListadoDeReportes.darTamanio(); listaReportesActual++){
            if(nodoAuxiliar.contenido.darPrimerNodo().equals(nombreReporte)){
                return nodoAuxiliar.contenido;//Se retorna la lista correspondiente... xD
            }
        }

        //si se llegó aquí es porque no se halló la lista y eso es, porque no existe xD
        listadoDeListadoDeReportes.anadirAlFinal(new ListaEnlazada<>());
        listadoDeListadoDeReportes.establecerNombreDeLista(nombreReporte);
        return listadoDeListadoDeReportes.darUltimoElemento();
    }

    private void buscarLexemaUsado(ListaEnlazada<Reporte> listaDeReportes, String lexema){
        Nodo<Reporte> nodoAuxiliar = listaDeReportes.darPrimerNodo();

        for (int reporteActual = 0; reporteActual < listaDeReportes.darTamanio(); reporteActual++){
            if(nodoAuxiliar.contenido.darLexema().equals(lexema)){
                ReporteUsos reporteUsos = (ReporteUsos) nodoAuxiliar.contenido;
                reporteUsos.incrementarCantidadUsos();
                return;//pues ya no tiene sentido seguir :) :3 xD
            }
        }
        //Si llegamos aquí es porque el tipo de lexema no había sido utilizado antes...
        listaDeReportes.anadirAlFinal(new ReporteUsos(lexema));
    }

    /**
     * Este será incluido como cuerpo de un método del lexer
     * para que CUP pueda agregar los reportes de ocurrencia
     * [si existieran] a este listado
     * @return
     */
    public ListaEnlazada<ListaEnlazada<Reporte>> darListadoReportesFormada(){
        return listadoDeListadoDeReportes;
    }
}
