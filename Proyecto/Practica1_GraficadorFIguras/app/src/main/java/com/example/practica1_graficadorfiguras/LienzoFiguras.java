package com.example.practica1_graficadorfiguras;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import Backend.Entidades.Figuras.Figura;
import Backend.EstructurasDeDatos.Cola;
import Backend.Manejadores.Procesador;

public class LienzoFiguras extends View {
    private final Cola<Figura> colaDeFiguras;
    private final Paint pintor;
    private final Procesador procesadorSolicitudes;

    public LienzoFiguras(Context contexto, Cola<Figura> colaFiguras){
        super(contexto);

        colaDeFiguras = colaFiguras;
        pintor = new Paint();
        procesadorSolicitudes = new Procesador();
    }

    @Override
    protected  void onDraw(Canvas canvas){
        canvas.drawARGB(63, 186, 179, 169 );//si no te gusta entonces usa 217, 221, 224, 0 xD

        procesadorSolicitudes.ProcesarSolicitudGraficar(colaDeFiguras, pintor, canvas);/*por una de 2 cosas es que si se mostó este liezo, 1. que de verdad el método esté mal ó que el no poseer esta llamada al método sea lo que tiene registrado en los bitecodes xD*/

    }


}