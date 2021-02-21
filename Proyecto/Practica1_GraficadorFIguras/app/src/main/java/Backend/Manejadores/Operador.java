package Backend.Manejadores;

public class Operador {
    private final double[] parametrosNumericos = new double[6];
    private double segundoNumero = 0;//que se requiere para realizar la operación en cuestión
    private boolean hayQueSeguirOperando = true;
    private int posicionDeValorNumerico = 0;//hago la inicialización desde aqupi por el hecho de que sería redundante para el caso del arreglo y además no creo que de problemas, pues estos tipos son "primi", pues cuando no es así puede dar problemas como el stackOverFLow, por tener el obj que crea al obj que etá intentando instanciarlo xD
    private String signo = null;
    private final ManejadorErrores manejadorErrores;

    public Operador(ManejadorErrores elManejadorErrores){/*recibes la instancia de la calse que maneja los errores, en el init code, para evitar que se trabaje con otra lista de errores que será pasada a los reportes, al final del archi <<EOF>>...*/
        manejadorErrores = elManejadorErrores;
    }
    /**
     * EMpleado al llegar a la opción NUMERO de la regla
     * valorNUmerico
     * @param numero
     */
    public void establecerNumeroAOperar(double numero){
        if(signo == null){
            parametrosNumericos[posicionDeValorNumerico] = numero;//vamos a dejarlo así, PERO A MI PENSAR
            //CUP ejecuta las axn "más externas" hasta haber terminado de realizar todas las internas
            // [que se exe por errores o por una producción "normal"
            //por lo cual esta var para posicionar el número en el arr sería -1 hasta que se termine con las prod de valor#...
        }else{
            segundoNumero = numero;
        }
    }

    /**
     * Empleado al terminar cualquiera de las reglas de
     * producción de la regla valorNumerico, que coresponda
     * a una operación matemática
     * @param tipoOperacion
     */
    public void establecerTipoOperacion(String tipoOperacion, int linea, int columna){//puesto que se sabe que se recibirá después de ecibir los 2 números necesaruos, entonces es un hecho que se puede proceder a operar... a menos que algo haya salido mal en una op para hallar e valNumerico, debido a una entrada mala o div por  0...
        signo = tipoOperacion;//solo me será util para saber si es el primer número recibido :v xD

        operar(tipoOperacion, linea, columna);
    }

    private void operar(String tipoOperacion, int linea, int columna){
        switch (tipoOperacion){
            case "SUM":
                parametrosNumericos[posicionDeValorNumerico]+= segundoNumero;
                break;
            case "RES":
                parametrosNumericos[posicionDeValorNumerico]-= segundoNumero;
                break;
            case "MULT":
                parametrosNumericos[posicionDeValorNumerico]*= segundoNumero;
                break;
            case "DIV":
                try{
                    parametrosNumericos[posicionDeValorNumerico]/= segundoNumero;
                }catch (NumberFormatException e){
                    //se llama el métood para agregar el error
                    //por ello deberás tener la isma instancia que el parser xD
                    //lo harás, pasándola en el init code en el que
                    //Se realizarán las instancias...
                    hayQueSeguirOperando = false;
                    manejadorErrores.establecerError("division por cero", null, null, "/0", linea, columna);//Ahí miras si colocar o no el /0, porque puede que haya salido de una operación... en ee caso yo diría que sería mejor no mandar algo así, sino quizá nada u otra cosa xD
                }
                break;
        }
    }

    /**
     * Ejecutado por el parser en la axn de la regla "instrucción"
     * con el fin de no mperer los objetos
     * por estar haciendo ref a otra instancia...
     * @return
     */
    public double[] darParametrosNumericos(){
        return parametrosNumericos;
    }

    /**
     * Método ejecutado por el parser para enviar al método de instanciación
     * este dato, al entrar a la axn de la regla "Instrucción"
     * y saber si las operaciones fueron realizadas corectamente
     * @return
     */
    public boolean todosLosParametrosCorrectos(){
        boolean noSeDejoDeEvaluar = hayQueSeguirOperando;//puesto que si se canceló en cualquier parte el realizar las op, no todos estaban correctos...
        //reestablecerValores();//puesto que si se llega a la instanciación quiere decir que se avecina una figura nueva...---------pero no debe hacerse aquí, sino todo el trabjao realizado, se reiniciará sin siquiera haberlo revisado :v xD
        return noSeDejoDeEvaluar;
    }

    public void prepararVariablesParaProximoValor(){
        posicionDeValorNumerico++;
        segundoNumero = 0;
        signo = null;
    }

    /**
     * Método ejecutado luego de intentar crear una figura
     * sea que se haya logrado o que se haya fallado, tb
     * se ejecuta luego de haber intentado animar
     */
     public void reestablecerValores(){
         prepararVariablesParaProximoValor();
         hayQueSeguirOperando = true;
         posicionDeValorNumerico =0;//por el hecho de que la producción que redirija aquí le dará un valor de 1 al 1er parám...

        for (int parametroActual = 0; parametroActual < parametrosNumericos.length; parametroActual++){
            parametrosNumericos[parametroActual] = 0;
        }
    }




}
