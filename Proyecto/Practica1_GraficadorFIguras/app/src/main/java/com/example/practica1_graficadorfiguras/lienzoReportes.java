package com.example.practica1_graficadorfiguras;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import Backend.Entidades.Reporte;
import Backend.Entidades.ReporteError;
import Backend.Entidades.ReporteOcurrencias;
import Backend.Entidades.ReporteUsos;
import Backend.EstructurasDeDatos.ListaEnlazada;
import Backend.EstructurasDeDatos.Nodo;


public class lienzoReportes extends View {//Debemos hacer que de alguna forma el lienzo tenga el alto de la tabla...
    private ListaEnlazada<Reporte> listadoDeReportes;
    private ListaEnlazada<ReporteError> listadoDeErrores;
    private TableLayout tabla;
    private TableRow filasDeTabla;
    private TextView celdaDeTexto;

    public lienzoReportes(Context contexto, ListaEnlazada<Reporte> elListadoDeReportes, ListaEnlazada<ReporteError> elListadoDeErrores){
        super(contexto);

        listadoDeReportes = elListadoDeReportes;
        listadoDeErrores = elListadoDeErrores;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    protected  void onDraw(Canvas canvas){

        //se llama al método del procesador o del manejador de repoprte o de otra clase que crerás xD y
        //mostrarás las tablas, recuerda que solo cuando el nombre de la lista sea reporte de ocurrencias
        //la tabla deberá ser diferente, en esta caso más grande, esto lo harás en el lienzo para reportes...
        llenarTabla();

        this.setClipBounds(new Rect(0,0, tabla.getRight(), tabla.getBottom()));//para que así el lienzo tenga el tamaño de la tabla...
        //se colocan los margenes, supongo que son los puntos a partir de los cuales podrá estar en el activity, y no los márgenes que el contenido del lienzo deberá tener...
    }

    private void llenarTabla(){
        tabla = findViewById(R.id.table_Reportes);

        if(listadoDeReportes.darNombre().equals("Operador") || listadoDeErrores.darNombre().equals("Error") ){//no habrá un null pointer porque cuando la lista no se requiera enviar, se enviará una lista "nueva" para que no de error de nullPointer xD
            llenarTablaDeOcurrencias();
        }else{
            llenarTablaDeUsos();
        }
    }

    private void agregarEncabezadosReportesUsos(){
        filasDeTabla = new TableRow(getContext());//sería bueno hacer alguna vez un método en el que así como habías pensado que funcionaha el add viewRow, solo necesitara crearse una vez y que cuando se pasara al objeto que corresponde, entonces se vaciara y cuando se volviera a emplear sería como que si fuera un objeto nuevo... xD esto sería útil para reducir el número de reservaciones de espacio...
        crearYFormatearCelda(true, listadoDeReportes.darNombre());
        crearYFormatearCelda(true, "Cantidad de Usos");
        tabla.addView(filasDeTabla);
    }

    private void llenarTablaDeUsos(){
        agregarEncabezadosReportesUsos();

        Nodo<Reporte> nodoReporteAuxiliar = listadoDeReportes.darPrimerNodo();
        for (int reporteActual = 0; reporteActual < listadoDeReportes.darTamanio(); reporteActual++){
            filasDeTabla = new TableRow(getContext());//pues se requiere una nueva fila...
            ReporteUsos reporteAuxiliar = (ReporteUsos) nodoReporteAuxiliar.contenido;

            crearYFormatearCelda(false, reporteAuxiliar.darLexema());
            crearYFormatearCelda(false, String.valueOf(reporteAuxiliar.darCantidasUsos()));
            tabla.addView(filasDeTabla);//para cortar lo recopilado en la fila y empezar con una nueva...
        }
    }

    private void llenarTablaDeOcurrencias(){
        agregarEncabezadosReportesOcurrencias();

        if(!listadoDeReportes.estaVacia()){
            llenarTablaDeOperaciones();
        }else{
            llenarTablaErrores();
        }
    }

    private void agregarEncabezadosReportesOcurrencias(){
        filasDeTabla = new TableRow(getContext());
        crearYFormatearCelda(true, listadoDeReportes.darNombre());
        crearYFormatearCelda(true, "Linea");
        crearYFormatearCelda(true, "Columna");
        if(listadoDeReportes.darNombre().equals("Operador")){
            crearYFormatearCelda(true, "Ocurrencia");
        }else{
            crearYFormatearCelda(true, "Tipo");
            crearYFormatearCelda(true, "Descripcion");
        }
        tabla.addView(filasDeTabla);
    }

    private void llenarTablaDeOperaciones(){
        Nodo<Reporte> nodoReporte = listadoDeReportes.darPrimerNodo();

        for (int reporteActual = 0; reporteActual < listadoDeReportes.darTamanio(); reporteActual++){
            filasDeTabla = new TableRow(getContext());//pues se requiere una nueva fila...
            ReporteOcurrencias reporteOcurrencias = (ReporteOcurrencias) nodoReporte.contenido;

            crearYFormatearCelda(false, reporteOcurrencias.darLexema());
            crearYFormatearCelda(false, reporteOcurrencias.darNumeroLinea());
            crearYFormatearCelda(false, reporteOcurrencias.darNumeroColumna());
            crearYFormatearCelda(false, reporteOcurrencias.darOcurrencia());

            tabla.addView(filasDeTabla);//para cortar lo recopilado en la fila y empezar con una nueva...
        }
    }

    private void llenarTablaErrores(){
        Nodo<ReporteError> nodoReporteError = listadoDeErrores.darPrimerNodo();

        for (int reporteActual = 0; reporteActual < listadoDeErrores.darTamanio(); reporteActual++){
            filasDeTabla = new TableRow(getContext());//pues se requiere una nueva fila...
            ReporteError reporteError = (ReporteError) nodoReporteError.contenido;

            crearYFormatearCelda(false, reporteError.darLexema());
            crearYFormatearCelda(false, reporteError.darNumeroLinea());
            crearYFormatearCelda(false, reporteError.darNumeroColumna());
            crearYFormatearCelda(false, reporteError.darTipoError());
            crearYFormatearCelda(false, reporteError.darDescripcion());

            tabla.addView(filasDeTabla);//para cortar lo recopilado en la fila y empezar con una nueva...
        }
    }

    /**
     * Este método se usa considerando que
     * ya se ha inicializado una fila, previo
     * a la add de las celdas...
     * @param esTitulo
     * @param texto
     */
    private void crearYFormatearCelda(boolean esTitulo, String texto){
        celdaDeTexto = new TextView(getContext());
        celdaDeTexto.setGravity(Gravity.CENTER);
        celdaDeTexto.setTextSize(18);
        celdaDeTexto.setText(texto);

        if(esTitulo){
            celdaDeTexto.setTextColor(Color.DKGRAY);
        }
        filasDeTabla.addView(celdaDeTexto);//se van acumulando las celdas [es decir las columnas] hasta que se pasen estos datos a la tabla con tabla.addView(fila)...
    }

}