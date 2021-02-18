import java_cup.runtime.*;

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

    private Symbol symbol(int tipo) {
        return new Symbol(tipo, yyline+1, yycolumn+1);
    }

    private Symbol symbol(int type, Object value) {
        return new Symbol(tipo, yyline+1, yycolumn+1, value);
    }

    private void anadirLexemaAnterior(String anterior){
        lexemaAnterior = anterior;
    }

    private String esAnimacion(){//esto lo hago así por el hecho de que cuando la instrucc esté bien, debería ser así xD
        if(lexemaAnterior.equals("graficar")){
            return "LINEA";
        }
        return "ANIMACION";
    }
%}


%%
/*Tercer sección: reglas lexicas*/

<YYINITIAL> "curva"                                                                           {anadirLexemaAnterior(yytext()); 
                                                                                                return symbol(ANIMACION, yytext());}
<YYINITIAL> "amarillo" | "azul"| "cafe"| "morado"| "naranja"| "negro"| "rojo"| "verde"        {anadirLexemaAnterior(yytext());
                                                                                                return symbol(COLOR, yytext());}
<YYINITIAL> "circulo" | "cuadrado"| "rectangulo"| "poligono"                                  {anadirLexemaAnterior(yytext());
                                                                                                return symbol(yytext().toUpperCase(), yytext());}/*si da error es por la falta del import de java.lang...*/
<YYINITIAL> "linea"                                                                           {return symbol(esAnimacion(), yytext());}
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

[^] {System.out.println("caracter no aceptado");/*aquí irá la llamada al método de la clase java
     que será importada hacia acá para hacer la debida 
     agegación de los errores xD, la cuestión es que 
     deberás hacer que sea la misma instacia por el hecho
     de que a esta misma lista que genere el obj ecargado
     de los errores, será a la que se add los errores
     hallados en el Sintact*/}/*sería interesante revisar el texto antes de este caracter para ver si tiene coincidencia con alguna de las ER [Pal reservadas o normales]y así decir
     "Linea: # Columna: #.Quizá quisiste decir: ylaPalabraCorrecta xD*/