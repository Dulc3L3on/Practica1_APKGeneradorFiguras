package Backend.Manejadores;

import Backend.Entidades.Reporte;
import Backend.Entidades.ReporteUsos;
import Backend.EstructurasDeDatos.ListaEnlazada;
import Backend.EstructurasDeDatos.Nodo;

public class ManejadorReportes {
    private ListaEnlazada<ListaEnlazada<Reporte>> listadoDeListadoDeReportes;

    public ManejadorReportes(){
        listadoDeListadoDeReportes = new ListaEnlazada<>();
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

    public void agregarReportesDeOcurrencia(){


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
