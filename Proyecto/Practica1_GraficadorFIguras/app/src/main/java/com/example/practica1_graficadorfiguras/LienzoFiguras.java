package com.example.practica1_graficadorfiguras;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import Backend.Entidades.Figuras.Circulo;
import Backend.Entidades.Figuras.Figura;
import Backend.EstructurasDeDatos.Pila;
import Backend.Manejadores.Procesador;

public class LienzoFiguras extends View {
    private final Pila<Figura> pilaDeFiguras;
    private final Paint pintor;
    private final Procesador procesadorSolicitudes;

    public LienzoFiguras(Context contexto, Pila<Figura> pilaFiguras){
        super(contexto);

        pilaDeFiguras = pilaFiguras;
        pintor = new Paint();
        procesadorSolicitudes = new Procesador();
    }

    @Override
    protected  void onDraw(Canvas canvas){
        canvas.drawARGB(63, 186, 179, 169 );//si no te gusta entonces usa 217, 221, 224, 0 xD

        Circulo circulo = (Circulo) pilaDeFiguras.darYEncolarUltimoElemnento();
        pintor.setStyle(Paint.Style.FILL);//para que se rellene
        pintor.setColor(circulo.color);
        canvas.drawCircle((float)circulo.posicionInicialX, (float)circulo.posicionInicialY, (float)circulo.darRadio(), pintor);


       /*procesadorSolicitudes.ProcesarSolicitudGraficar(pilaDeFiguras, pintor, canvas);*//*por una de 2 cosas es que si se mostó este liezo, 1. que de verdad el método esté mal ó que el no poseer esta llamada al método sea lo que tiene registrado en los bitecodes xD*/
    }


}