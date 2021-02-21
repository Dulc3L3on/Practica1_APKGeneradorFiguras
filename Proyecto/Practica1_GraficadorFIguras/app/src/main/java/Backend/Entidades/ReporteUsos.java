package Backend.Entidades;

import java.io.Serializable;

public class ReporteUsos extends Reporte implements Serializable {
    private int cantidadVecesUsado;

    public ReporteUsos(String elLexema){
        super(elLexema);

        cantidadVecesUsado = 1;//puesto que si se mandó a llamar es porque ya se usó una vez xD :)
    }

    public void incrementarCantidadUsos(){
        cantidadVecesUsado++;
    }

    public int darCantidasUsos(){
        return cantidadVecesUsado;
    }

}
