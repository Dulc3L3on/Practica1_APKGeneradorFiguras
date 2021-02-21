package Backend.Manejadores;

import android.graphics.Color;

public class ManejadorColores {

    public int darColorCorrespondiente(String nombreColor){
        switch (nombreColor){
            case "azul":
                return (Color.parseColor("#1C0975"));
            case "rojo":
                return (Color.parseColor("#C6123D"));
            case "verde":
                return (Color.parseColor("#89C612"));//si no te gusta el que pusiste entonces usa: #77C612 xD
            case "amarillo":
                return (Color.parseColor("#E5EE78"));
            case "naranja":
                return (Color.parseColor("#E6B34F"));
            case "morado":
                return (Color.parseColor("#6B4B9A"));//Está mas bonito este: #924B9A o el violeta xD #9A4B7A
            case "cafe":
                return (Color.parseColor("#9A5D4B"));//o este xD #7A574C
        }
        return (Color.parseColor("#2D2F33"));//Es decir para el negro...
    }

}
