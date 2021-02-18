package com.example.practica1_graficadorfiguras;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import Backend.Entidades.Figuras.Figura;
import Backend.EstructurasDeDatos.Pila;
import Backend.Manejadores.Procesador;

public class Lienzo extends View {
    private Pila<Figura> pilaDeFiguras;
    private Paint pintor;
    private Procesador procesadorSolicitudes;

    public Lienzo(Context contexto, Pila<Figura> pilaFiguras){
        super(contexto);

        pilaDeFiguras = pilaFiguras;
        pintor = new Paint();
        procesadorSolicitudes = new Procesador();
    }

    @Override
    protected  void onDraw(Canvas canvas){
        canvas.drawARGB(229, 232, 232, 0 );//si no te gusta entonces usa 217, 221, 224, 0 xD

        procesadorSolicitudes.ProcesarSolicitudGraficar(pilaDeFiguras, pintor, canvas);
    }


}