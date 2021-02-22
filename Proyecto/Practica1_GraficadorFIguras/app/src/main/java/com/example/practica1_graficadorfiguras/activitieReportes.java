package com.example.practica1_graficadorfiguras;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import Backend.Entidades.Reporte;
import Backend.EstructurasDeDatos.ListaEnlazada;
import Backend.EstructurasDeDatos.Nodo;

public class activitieReportes extends AppCompatActivity {
    private ListaEnlazada<ListaEnlazada<Reporte>> listadoDeListadoDeReportes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitie_reportes);

        recibirReportes();

        //aquí haces algo simi a lo que se hizo en actividad secun para mostrar el lienzo como fondo...

        ConstraintLayout capa = findViewById(R.id.activitie_reportes);
        mostrarReportes(capa);

    }

    private void mostrarReportes(ConstraintLayout capa){
        Nodo<ListaEnlazada<Reporte>> nodoListadoDeReportes = listadoDeListadoDeReportes.darPrimerNodo();
        int altoTablaAnterior=0;

        for (int reporteActual = 0; reporteActual< listadoDeListadoDeReportes.darTamanio(); reporteActual++){
            lienzoReportes lienzoReportes = new lienzoReportes(this, nodoListadoDeReportes.contenido, new ListaEnlazada<>());//puesto que se sabe que aquí se llegará Ssi el listado de reportes no es el de los errores... xD
            lienzoReportes.setId(reporteActual);//es decir que no habrá un número asociado al tipo, sino que será según el orden de aparición...

            if(reporteActual>0){
                lienzoReportes.setTop(altoTablaAnterior);//yo supongo que estos son márgenes, es decir que no cortan la tabla en el punto que recibe commo parámetro xD, sino que pienso que son lso márgenes para ubicar el lienzo en cuestión, en el activity...
            }

            capa.addView(lienzoReportes);
            altoTablaAnterior = lienzoReportes.getBottom();//puesto que ese valor tiene acumuladas todas las alturas de las tablas...
        }
    }

    private void recibirReportes(){
        Bundle listadoEmpacado = getIntent().getExtras();

        if(listadoEmpacado!=null){
            listadoDeListadoDeReportes = (ListaEnlazada<ListaEnlazada<Reporte>>) listadoEmpacado.getSerializable("listaDeReportes");
        }

    }
}//Es lo único que debes hacer pues la axn se encarga de ejecutarla el lienzo... y además no tengo otros componentes como botones como para que pueda manejarlos...