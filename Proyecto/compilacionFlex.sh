#! /bin/bash
echo "INICIANDO COMPILACION JFLEX"
java -jar jflex-1.8.2/lib/jflex-full-1.8.2.jar lexer.jflex
javac lexer_Figuras.java
java lexer_Figuras 