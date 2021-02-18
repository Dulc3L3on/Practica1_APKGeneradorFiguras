package Backend.Analizadores;
import java_cup.runtime.*;
import static Backend.Analizadores.parser_FigurasSym.*;
import Backend.Manejadores.ManejadorErrores;//Agregado
import Backend.Entidades.ReporteError;//Agregado
import Backend.Manejadores.ManejadorReportes;//Agregado
import Backend.EstructurasDeDatos.ListaEnlazada;//Agregado
import Backend.Entidades.Reporte;//Agregado

%%
/*Segunda Sección: configuracion*/
%class lexer_Figuras
%cup /*si estuviera el CUP entonces tendría que ser sustituido por la directiva CUP*/
%unicode
%line 
%column
%public /*si no se incluye esto un problema se generaría al intentar usarlo en el cup*/

numero = [0-9]
finDeLinea = \r|\n|\r\n
tabulacion = [ \t\f]/*no olvides que ese espacio en blanco siempre debe ir, de lo contrario no funcionará para todas las poribles formas de un blankSpace*/
espacioEnBlanco = {finDeLinea} | {tabulacion}

%{
    String lexemaAnterior;
    ManejadorErrores manejadorErrores = new ManejadorErrores(new ListaEnlazada<ReporteError>());//Agregado
    ManejadorReportes manejadorReportes = new ManejadorReportes();//Agregado

    private Symbol symbol(int tipo) {
        return new Symbol(tipo, yyline+1, yycolumn+1);
    }

    private Symbol symbol(int tipo, Object value) {
        return new Symbol(tipo, yyline+1, yycolumn+1, value);
    }

    private void anadirLexemaAnterior(String anterior){
        lexemaAnterior = anterior;
    }

    private int esAnimacion(){//esto lo hago así por el hecho de que cuando la instrucc esté bien, debería ser así xD
        if(lexemaAnterior.equals("graficar")){
            return 7;
        }
        return 2;
    }

     private int darCodificacionFigura(){
            if(yytext().equals("cuadrado")){
              return 5;
            }else if(yytext().equals("circulo")){
              return 4;
            }else if(yytext().equals("rectangulo")){
              return 6;
            }
            return 8;
     }

     public ListaEnlazada<ReporteError> darListadoErrores(){//agregado
        return manejadorErrores.darListaErroresHallados();
     }

     public ListaEnlazada<ListaEnlazada<Reporte>> darListadoDeListadoDeReportes(){//Agregado
        return manejadorReportes.darListadoReportesFormada();
     }
%}


%%
/*Tercer sección: reglas lexicas*/

<YYINITIAL> "curva"                                                                           {anadirLexemaAnterior(yytext());
                                                                                                 manejadorReportes.agregarReportesDeUso("Animacion", yytext());
                                                                                                return symbol(ANIMACION, yytext());}
<YYINITIAL> "amarillo" | "azul"| "cafe"| "morado"| "naranja"| "negro"| "rojo"| "verde"        {anadirLexemaAnterior(yytext());
                                                                                                manejadorReportes.agregarReportesDeUso("Color", yytext());
                                                                                                return symbol(COLOR, yytext());}
<YYINITIAL> "circulo" | "cuadrado"| "rectangulo"| "poligono"                                  {anadirLexemaAnterior(yytext());
                                                                                                manejadorReportes.agregarReportesDeUso("Objeto", yytext());//Recuerda, esto es equivalente a decir figura
                                                                                                return symbol(darCodificacionFigura(), yytext());}/*si da error es por la falta del import de java.lang...*/
<YYINITIAL> "linea"                                                                           {manejadorReportes.agregarReportesDeUso(((esAnimacion()==2)?"Animacion":"Objeto"), yytext());
                                                                                                return symbol(esAnimacion(), yytext());}//no hago la llamada al método para hacer la add al leema anterior, por el hecho de que no afecta al redactar bien la instrucción, pues después de haber escrito "línea" no tendría que aparecer nuevamente esta palabra sino hasta desués de haber terminado de escribir la instrucción, para lo cual ya se habrían escrito los lex que se requieren para decir si es anim u objeto :3 xD
<YYINITIAL> "graficar"                                                                        {anadirLexemaAnterior(yytext());
                                                                                                return symbol(GRAFICAR, yytext());}
<YYINITIAL> "animar"                                                                          {anadirLexemaAnterior(yytext());
                                                                                                return symbol(ANIMAR, yytext());}//esta frase "animar objeto anterior" hubiera podido tomarse como una sola "palabra" para el lex, pero por la def de que devuelve un lexema por vez, mejor lo dejamos así separado xD
<YYINITIAL> "objeto"                                                                          {anadirLexemaAnterior(yytext());
                                                                                                return symbol(OBJETO, yytext());}
<YYINITIAL> "anterior"                                                                        {anadirLexemaAnterior(yytext());
                                                                                                return symbol(ANTERIOR, yytext());}/*por el momento, no pienso que me resulte útil el mandar el texto, tanto en estas prod de 1 sola palabra como en la de las figuras [pues estas tiene como nombre del tkn el lexema como tal...]... aunque ahora que lo pienso, creo que esto me será útil para enviar el nombre del tkn erroneo al método para add los errores, por medio de la colocación de la variable con el mismo nombre para todos los T :)*/

<YYINITIAL>{
    {numero}+("."{numero}+)?             {anadirLexemaAnterior(yytext());
                                           return symbol(NUMERO, yytext());}
    "*"|"+"                              {anadirLexemaAnterior(yytext());
                                           return symbol( (yytext().equals("*"))?MULT:SUM);}
    "-"|"/"                              {anadirLexemaAnterior(yytext());
                                            return symbol( (yytext().equals("-"))?RES:DIV);}
    "("|")"|","                          {anadirLexemaAnterior(yytext());
                                            return symbol( (yytext().equals("("))?APER:(yytext().equals(")"))?CIER:COMA);}

    {espacioEnBlanco}                         {/*se ingnora*/}   
}

[^] {System.out.println("caracter no aceptado"); manejadorErrores.establecerError("lexico", null, null, yytext(), yyline+1, yycolumn+1);}/*sería interesante revisar el texto antes de este caracter para ver si tiene coincidencia con alguna de las ER [Pal reservadas o normales]y así decir
     "Linea: # Columna: #.Quizá quisiste decir: ylaPalabraCorrecta xD*/