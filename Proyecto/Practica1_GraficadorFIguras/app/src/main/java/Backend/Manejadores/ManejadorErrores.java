package Backend.Manejadores;

import Backend.Entidades.ReporteError;
import Backend.EstructurasDeDatos.ListaEnlazada;

public class ManejadorErrores {//base terminada xD [es decir que puede tener cb pero ellos estarán basados en esta esructura...
    private ListaEnlazada<ReporteError> listaDeErrores;

    public ManejadorErrores(ListaEnlazada<ReporteError> listaErroresDelLexer){
        if(listaErroresDelLexer.estaVacia()){//Esto quiere decir que allá en el lexer tb deberás importar esta clase...
            listaDeErrores = new ListaEnlazada<>();
        }
        listaDeErrores = listaErroresDelLexer;
    }

    public void establecerError(String tipo, String nombreLexemAnterior, String nombreDelLexema,
                                String elLexema, int numeroLinea, int numeroColumna){//todo esto lo recibirás en la línea de la producción de eerror correspondiene...
        switch (tipo){
            case "Lexico":
                listaDeErrores.anadirAlFinal(new ReporteError(elLexema, numeroLinea, numeroColumna, tipo,
                        "Símbolo no aceptado"));
                break;
            case "Falta Tipo Figura":
                listaDeErrores.anadirAlFinal(new ReporteError(elLexema, numeroLinea, numeroColumna, "Sintáctico",//aquí el tipo era tipo xD[es decir lo que contenía esta var xD]
                        "Se esperaba el nombre de la figura a dibujar"));
                break;
            case "error en 3 Parametros"://con este tipo de error, hasta me hace pensar en que no estaría mal si no hago las producciones estra para ser específica en el tipo de error sucedido es decir si no se llegó al valor#, al color/animación o al ")"
                listaDeErrores.anadirAlFinal(new ReporteError(elLexema, numeroLinea, numeroColumna, "Sintáctico",//Aquí y en los demás parám era "error en parámetros"
                        "Se esperaba\n(valor#, valor#, valor#, animacion)"));//creo que vamos a tener que reducir estas descripcione delos paráms... debe caber en la pantalla de un teléfono :| xD
                break;
            case "error en 4 Parametros":
                listaDeErrores.anadirAlFinal(new ReporteError(elLexema, numeroLinea, numeroColumna, "Sintáctico",
                        "Se esperaba\n(valor#, valor#, valor#, valor#, animacion)"));
                break;
            case "error en 5 Parametros":
                listaDeErrores.anadirAlFinal(new ReporteError(elLexema, numeroLinea, numeroColumna, "Sintáctico",
                        "Se esperaba\n (valor#, valor#, valor#, valor#, valor#, animacion)"));
                break;
            case "error en 6 Parametros":
                listaDeErrores.anadirAlFinal(new ReporteError(elLexema, numeroLinea, numeroColumna, "Sintáctico",
                        "Se esperaba \n(valor#, valor#, valor#, valor#, valor#, animacion)"));
                break;
            case "Operacion invalida"://u "operación errada"
                listaDeErrores.anadirAlFinal(new ReporteError(elLexema, numeroLinea, numeroColumna, "Sintáctico",//aquí era tipo xD
                        manejadorErroresOperacion(nombreLexemAnterior, nombreDelLexema)));
                break;
            case "error de instruccion"://Se dará una definición u otra dependiendo del lexema, pero para decir y acertar en lo dicho, que las instrucciones de animación solo deberían aparecer 1 vez abajo de la instrucc graficar se reuqeiría del anterior... para ver si es un ")"... creo xD
                listaDeErrores.anadirAlFinal(new ReporteError(elLexema, numeroLinea, numeroColumna, "Sintáctico",//y aquí tb lo de la var tipo xD
                        "inicio de instruccion incorrecta"));//el colocar iniciao de instrucción incorrecta resulta ser ambiguo por lo cual podría entenderse como que no iniciió como debía la instrucción ó que no se inició con la instrucción graficar... xD que ofertón xD
                break;//haría falta el tipo de error en el que se indica que se esperaba las palabras con las que ini las instrucciones, graficar, o cualquiera de animar objeto anterior xD
            case "division por cero":
                listaDeErrores.anadirAlFinal(new ReporteError(elLexema, numeroLinea, numeroColumna, "Sintáctico",//y aquí tb lo de la var tipo xD
                        "División por 0"));
                break;
        }
    }

    private String manejadorErroresOperacion(String nombreLexemaAnterior, String nombreDelLexema){//Esto quiere decir que requeriré de los nombres a parte del lexema...
        if(nombreLexemaAnterior.equalsIgnoreCase("NUMERO") && nombreDelLexema.equals(nombreLexemaAnterior)){
            return "Falta signo de operacion";
        }else if((nombreLexemaAnterior.equals("NUMERO") && nombreDelLexema.equals("(")) || (nombreLexemaAnterior.equals(")") && nombreDelLexema.equals("NUMERO"))){
            return "Falta signo de operacion";
        }else if(nombreDelLexema.equals(nombreLexemaAnterior)){//Creo que este msje es mejor que decir, se esperaba signo de operación o agrupación...además o 2do no está bien dicho , porque sdesdepués de un signo de agergupación de cierre, si es qu este término no está al final, debe estar seguido de un singo de operación... así que SÍ, está mejor el msje que puse xD
            return "Caracter "+(nombreDelLexema.equals("SUM")?"+":(nombreDelLexema.equals("RES")?"-":(nombreDelLexema.equals("MULT")?"*":(nombreDelLexema.equals("DIV")?"/":(nombreDelLexema.equals("APER")?"(":(nombreDelLexema.equals("CIER")?")":nombreDelLexema))))))+ " repetido";//de esta forma es posible en globar el hecho de que se esperaba un número entre los signos repetidos :) xD
        }else if(nombreDelLexema.equals(")")){
            return ("Falta parentesis de apertura");
        }//el msje para indicar que hace falta un signo de cierre esta algo feito :v xD como no está separado como lo había hecho antes :,( aunque ahí tb estaba algo feito xD
            return "Formato de operacion incorrecto";
    }

    public ListaEnlazada<ReporteError> darListaErroresHallados(){
        return listaDeErrores;
    }
}

