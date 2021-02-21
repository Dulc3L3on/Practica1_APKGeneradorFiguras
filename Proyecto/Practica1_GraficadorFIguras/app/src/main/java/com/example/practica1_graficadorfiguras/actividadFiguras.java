package com.example.practica1_graficadorfiguras;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.security.NoSuchAlgorithmException;

import Backend.Entidades.Figuras.Figura;
import Backend.Entidades.Reporte;
import Backend.EstructurasDeDatos.Cola;
import Backend.EstructurasDeDatos.ListaEnlazada;

public class actividadFiguras extends AppCompatActivity {
    private Cola<Figura> colaDeFiguras;
    private ListaEnlazada<ListaEnlazada<Reporte>> listadoDeListadoDeReportes;
    private Button botonAnimar;
    private Button botonVerReportes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_figuras);

        botonAnimar = findViewById(R.id.btn_animar);
        botonVerReportes = findViewById(R.id.btn_verReportes);
        try{
            recibirPilaYReportes();
        }catch(NoSuchAlgorithmException e){
            System.out.println("Error al recibir pila y reportes -> "+ e.getMessage());
        }

        //se recibe el contenedor en el que se mostrarán los datos, en este caso sería un layout que permita libertad en colocación...
        ConstraintLayout capa = findViewById(R.id.actividad_figuras);
        LienzoFiguras lienzo = new LienzoFiguras(this, colaDeFiguras);
        capa.addView(lienzo);//se agrega la pantalla en la que se mostrarán las figuras... sería bonito que el fondo fuera cuadriculado xD

        botonAnimar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vista) {
                //se llama al método correspondiente del procesador
            }
        });

        botonVerReportes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ejecutarVentanaReportes();
            }
        });

    }

    private void recibirPilaYReportes() throws NoSuchAlgorithmException {
        Bundle paqueteDatos = getIntent().getExtras();

        if(paqueteDatos!=null){//pero en este caso, siempre será así porque solo se compila si había mas de alguna texto, de lo contrario no xD...aunque quizá sea util por la existencia de las flechita para regresar que todos los tel traen...
            colaDeFiguras = (Cola<Figura>) paqueteDatos.getSerializable("pilaDeFiguras");
            listadoDeListadoDeReportes = (ListaEnlazada<ListaEnlazada<Reporte>>) paqueteDatos.getSerializable("listadoReportes");//Esta será enviada a otra pantalla, de manera similar a como se hizo para enviar estos datos aquí... solo que en este caso,sucederá al preionar el btn "ver Reportes" o solo Reportes xD

        }

    }

    private void ejecutarVentanaReportes(){
        Intent intentoMOstrarReportes = new Intent(this, activitieReportes.class);
        Bundle paqueteDeReportes = new Bundle();

        paqueteDeReportes.putSerializable("listaDeReportes", listadoDeListadoDeReportes);

        intentoMOstrarReportes.putExtras(paqueteDeReportes);
        startActivity(intentoMOstrarReportes);
    }
}