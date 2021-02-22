package com.example.practica1_graficadorfiguras;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;

import androidx.annotation.RequiresApi;

import Backend.Entidades.Figuras.Figura;
import Backend.Manejadores.Procesador;

public class LienzoFiguras extends View {
    private final Figura figura;
    private final Paint pintor;
    private final Procesador procesadorSolicitudes;

    public LienzoFiguras(Context contexto, Figura laFigura){
        super(contexto);

        figura = laFigura;
        pintor = new Paint();
        procesadorSolicitudes = new Procesador();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    protected  void onDraw(Canvas canvas){
        canvas.drawARGB(63, 186, 179, 169 );//si no te gusta entonces usa 217, 221, 224, 0 xD esto por ahora, solo para ver como está el tamaño es decir para ver qué es lo que hace RECT, media vez corrobores, pasará a ser transparente... xD

        Rect rectanguloLimite = procesadorSolicitudes.ProcesarSolicitudGraficar(figura, pintor, canvas);/*por una de 2 cosas es que si se mostó este liezo, 1. que de verdad el método esté mal ó que el no poseer esta llamada al método sea lo que tiene registrado en los bitecodes xD*/
        /**///Esto por si acaso el Rect toma como posiciones en el plano, los puntos que se le introducen en left y top... así como al crear las figuras...
        this.setClipBounds(rectanguloLimite);//Se establece el tamaño de acuerdo al de la figura...
        if(figura.getClass().getSimpleName().equals("Poligono")){
            this.setLeft((int) figura.posicionInicialX);
            this.setTop((int) figura.posicionInicialY);//con tal de no tener que hacer un método para hacer la traslación xD
        }
    }//pdt: yo sé que la figura nunca podrá ser nula, por eso no reviso eso xD

    public void animar(){
        procesadorSolicitudes.procesarSolicitudAnimar(figura, this);
    }


}
