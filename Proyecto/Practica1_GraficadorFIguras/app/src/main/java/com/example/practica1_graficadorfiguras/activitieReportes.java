package com.example.practica1_graficadorfiguras;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import Backend.Entidades.Reporte;
import Backend.EstructurasDeDatos.ListaEnlazada;

public class activitieReportes extends AppCompatActivity {
    private ListaEnlazada<ListaEnlazada<Reporte>> listadoDeListadoDeReportes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitie_reportes);

        recibirReportes();

        //aquí haces algo simi a lo que se hizo en actividad secun para mostrar el lienzo como fondo...

        ConstraintLayout capa = findViewById(R.id.activitie_reportes);
        lienzoReportes lienzoReportes = new lienzoReportes(this, listadoDeListadoDeReportes);
        capa.addView(lienzoReportes);
    }

    private void recibirReportes(){
        Bundle listadoEmpacado = getIntent().getExtras();

        if(listadoEmpacado!=null){
            listadoDeListadoDeReportes = (ListaEnlazada<ListaEnlazada<Reporte>>) listadoEmpacado.getSerializable("listaDeReportes");
        }

    }
}//Es lo único que debes hacer pues la axn se encarga de ejecutarla el lienzo... y además no tengo otros componentes como botones como para que pueda manejarlos...