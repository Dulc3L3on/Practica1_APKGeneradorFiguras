package com.example.practica1_graficadorfiguras;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

import Backend.Manejadores.Procesador;

public class sublienzo_poligono extends View {
    private Procesador procesador;

    public sublienzo_poligono(Context contexto, Procesador elProcesador){
        super(contexto);

        procesador = elProcesador;
    }

    @Override
    protected  void onDraw(Canvas canvas){

    }


}