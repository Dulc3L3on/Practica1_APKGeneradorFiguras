package com.example.practica1_graficadorfiguras;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.io.StringReader;
import java.security.NoSuchAlgorithmException;

import Backend.Analizadores.lexer_Figuras;
import Backend.Analizadores.parser_Figuras;
import Backend.Entidades.Figuras.Figura;
import Backend.Entidades.Reporte;
import Backend.Entidades.ReporteError;
import Backend.EstructurasDeDatos.ListaEnlazada;
import Backend.EstructurasDeDatos.Cola;

public class MainActivity extends AppCompatActivity {
    private EditText areaEntrada;
    private Button btnCompilar;

    @Override
    public <T extends View> T findViewById(int id) {
        return super.findViewById(id);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {//ejecutado al nada más crear el "lienzo" principal
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        areaEntrada = findViewById(R.id.txtArea_Especificaciones);
        btnCompilar = findViewById(R.id.btn_compilar);

        areaEntrada.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                btnCompilar.setEnabled(!areaEntrada.getText().toString().isEmpty());
            }
        });

        btnCompilar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vista) {
                try {
                    /*codigo de compilacion*/
                    String entrada = areaEntrada.getText().toString();
                    StringReader lector = new StringReader(entrada);

                    lexer_Figuras lexer = new lexer_Figuras(lector);
                    parser_Figuras parser = new parser_Figuras(lexer);
                    parser.recibirListadoErroresYReportesUso(lexer.darListadoErrores(), lexer.darListadoDeListadoDeReportes());
                    //se ejecuta el análisis sintáctico
                    parser.parse();
                    ejecutarResultadoDeAnalisis(parser.darListadoDeErrores(), parser.darListadoDeListadoDeReportes(), parser.darColaDeFiguras());

                } catch (NoSuchAlgorithmException e) { //error en onclick
                    System.out.println("error al dar click -> "+e.getMessage());
                    e.printStackTrace();
                } catch (Exception ex) { //error en parser
                    System.out.println("Error irrecuperable" +ex.getMessage());//aunque esto jamás se debería ejecutar
                    ex.printStackTrace();
                    // por el hecho de que tendría que tener todos los errores controlados...
                }
            }
        });
    }

    private void ejecutarResultadoDeAnalisis(ListaEnlazada<ReporteError> listadoDeErrores, ListaEnlazada<ListaEnlazada<Reporte>> listadoDeReportes, Cola<Figura> colaDeFiguras){
        if(listadoDeErrores.estaVacia()){//Se muestra la pantalla que contiene las figuras y 2 btn 1 para mostrarReportes y otro para animar [auqnue creo que debería ir de primero el de animar, pues sería a el más utilizado]...
            Intent nuevoIntento = new Intent(this, actividadFiguras.class);//El paquete y la clase en la que se encuentra la actvidad [o pantalla] nueva
            Bundle nuevoPaqueteDatos = new Bundle();

            nuevoPaqueteDatos.putSerializable("pilaDeFiguras", colaDeFiguras);//este método es similar al del request, en el qe se le enviaba el id con el que se iba a emplear el dato envuado en el otro parámetro xD, solo que esn este caso, requiere de un obj más en este caso intent para hacer la trancisión, que sería lo eqquivalente a la redirección en JSP's xD
            nuevoPaqueteDatos.putSerializable("listadoReportes", listadoDeReportes);//si da errores es porque estas clases deben implementar a Serializable...

            nuevoIntento.putExtras(nuevoPaqueteDatos);
            startActivity(nuevoIntento);
        }
        //sino entonces lo que se hace es add una tabla abajo de los botones para que visualice los reportes y así puede corregir de una vez lo que corresponde...
        //y luego se actualiza la pantalla [no se si es neceario xD, pero por si acaso xD]
    }
}