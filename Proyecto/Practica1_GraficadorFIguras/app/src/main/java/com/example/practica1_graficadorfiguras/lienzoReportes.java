package com.example.practica1_graficadorfiguras;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

import Backend.Entidades.Reporte;
import Backend.EstructurasDeDatos.ListaEnlazada;


public class lienzoReportes extends View {
    private ListaEnlazada<ListaEnlazada<Reporte>> listadoDeListadoDeReportes;


    public lienzoReportes(Context contexto, ListaEnlazada<ListaEnlazada<Reporte>> elListadoDeListadoDeReportes){
        super(contexto);

        listadoDeListadoDeReportes = elListadoDeListadoDeReportes;
    }

    @Override
    protected  void onDraw(Canvas canvas){

        //se llama al método del procesador o del manejador de repoprte o de otra clase que crerás xD y
        //mostrarás las tablas, recuerda que solo cuando el nombre de la lista sea reporte de ocurrencias
        //la tabla deberá ser diferente, en esta caso más grande, esto lo harás en el lienzo para reportes...
    }
}