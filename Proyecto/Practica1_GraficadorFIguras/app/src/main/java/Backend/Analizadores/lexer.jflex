package Backend.Analizadores;
import java_cup.runtime.*;
import static Backend.Analizadores.parser_FigurasSym.*;
import Backend.Manejadores.ManejadorErrores;//Agregado
import Backend.Entidades.ReporteError;//Agregado
import Backend.Manejadores.ManejadorReportes;//Agregado
import Backend.EstructurasDeDatos.ListaEnlazada;//Agregado
import Backend.Entidades.Reporte;//Agregado
import Backend.Entidades.Token;//agregado

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
    Token tokenAnterior = null;

    private Symbol symbol(int tipo, String nombreToken) {
        Token tokenActual = new Token(nombreToken, yytext(), tokenAnterior, yyline+1, yycolumn+1);

        if(tokenAnterior!=null){
            tokenAnterior.establecerSiguiente(tokenActual);
        }

        tokenAnterior = tokenActual;//por esto, ya no es necesario tener el método añadirAnterior... pues se puede revisar directamente esta var de tipo Token... xD
        return new Symbol(tipo, tokenActual);
    }

    private int esAnimacion(){//esto lo hago así por el hecho de que cuando la instrucc esté bien, debería ser así xD
        if(tokenAnterior== null){
            return 7;//solo por el hecho de ser más probable en apariciones al principio de la entrada xD, aunque en realidad no importa xD, porque de todos modos sería un error :v
        }
        if(tokenAnterior.darLexema().equals("graficar")){
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

<YYINITIAL> "curva"                                                                           {manejadorReportes.agregarReportesDeUso("Animacion", yytext());
                                                                                                return symbol(ANIMACION, "animacion");}
<YYINITIAL> "amarillo" | "azul"| "cafe"| "morado"| "naranja"| "negro"| "rojo"| "verde"        {manejadorReportes.agregarReportesDeUso("Color", yytext());
                                                                                                return symbol(COLOR, "color");}
<YYINITIAL> "circulo" | "cuadrado"| "rectangulo"| "poligono"                                  {manejadorReportes.agregarReportesDeUso("Objeto", yytext());//Recuerda, esto es equivalente a decir figura
                                                                                                return symbol(darCodificacionFigura(), "objeto");}/*si da error es por la falta del import de java.lang...*/
<YYINITIAL> "linea"                                                                           {int tipo = esAnimacion();/*con la imple de la var token anterior, no es necesario hacer esto, pero para evitar exe un método del cual no cb su valor, mejor guardo el dato en una var xD y listo xD*/
                                                                                                manejadorReportes.agregarReportesDeUso(((tipo==2)?"Animacion":"Objeto"), yytext());
                                                                                                return symbol(tipo, (tipo==2)?"animacion":"objeto");}//no hago la llamada al método para hacer la add al leema anterior, por el hecho de que no afecta al redactar bien la instrucción, pues después de haber escrito "línea" no tendría que aparecer nuevamente esta palabra sino hasta desués de haber terminado de escribir la instrucción, para lo cual ya se habrían escrito los lex que se requieren para decir si es anim u objeto :3 xD
<YYINITIAL> "graficar"                                                                        {return symbol(GRAFICAR, "graficar");}
<YYINITIAL> "animar"                                                                          {return symbol(ANIMAR, "animar");}//esta frase "animar objeto anterior" hubiera podido tomarse como una sola "palabra" para el lex, pero por la def de que devuelve un lexema por vez, mejor lo dejamos así separado xD
<YYINITIAL> "objeto"                                                                          {return symbol(OBJETO, "object");}/*para que no halla problemas con el nombramiento de las figuras...*/
<YYINITIAL> "anterior"                                                                        {return symbol(ANTERIOR, "anterior");}/*por el momento, no pienso que me resulte útil el mandar el texto, tanto en estas prod de 1 sola palabra como en la de las figuras [pues estas tiene como nombre del tkn el lexema como tal...]... aunque ahora que lo pienso, creo que esto me será útil para enviar el nombre del tkn erroneo al método para add los errores, por medio de la colocación de la variable con el mismo nombre para todos los T :)*/

<YYINITIAL>{
    {numero}+("."{numero}+)?             {return symbol(NUMERO, "numero");}
    "*"|"+"                              {return symbol( (yytext().equals("*"))?MULT:SUM, (yytext().equals("*"))?"MULT":"SUM");}
    "-"|"/"                              {return symbol( (yytext().equals("-"))?RES:DIV, (yytext().equals("*"))?"RES":"DIV");}
    "("|")"|","                          {return symbol( (yytext().equals("("))?APER:(yytext().equals(")"))?CIER:COMA, (yytext().equals("("))?"(":(yytext().equals(")"))?")":"COMA");}/*SI HAY ERROR es por haber colocado como nombre los ( y ) en lugar del nombre literal APER o CIER respectivamente...*/

    {espacioEnBlanco}                         {/*se ingnora*/}   
}

[^] {System.out.println("caracter no aceptado"); manejadorErrores.establecerError("lexico", null, null, yytext(), yyline+1, yycolumn+1);}/*sería interesante revisar el texto antes de este caracter para ver si tiene coincidencia con alguna de las ER [Pal reservadas o normales]y así decir
     "Linea: # Columna: #.Quizá quisiste decir: ylaPalabraCorrecta xD*//*aquí ya tendría acceso al anterior, pero no veo que sea necesario especificar eso, si de todos modos ya doy la fila y columna xD*/