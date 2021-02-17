package com.example.practica1_graficadorfiguras;

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
        btnCompilar = findViewById(R.id.btn_Compilar);

        areaEntrada.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                if(!areaEntrada.getText().toString().isEmpty()){
                    btnCompilar.setEnabled(true);
                }else{
                    btnCompilar.setEnabled(false);
                }
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
                    //se ejecuta el análisis sintáctico
                    parser.parse();

                } catch (NoSuchAlgorithmException e) { //error en onclick
                    e.printStackTrace();
                } catch (Exception ex) { //error en parser
                    System.out.println("Error irrecuperable");//aunque esto jamás se debería ejecutar
                    // por el hecho de que tendría que tener todos los errores controlados...
                }
            }
        });

    }
}