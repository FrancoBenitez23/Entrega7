package desafio7_ej2;

public class Helicoptero implements Volador {
 private boolean tieneAlas;

 public Helicoptero(boolean tieneAlas) {
     this.tieneAlas = tieneAlas;
 }

 @Override
 public boolean puedeAterrizar() {
     
     return !tieneAlas;
 }
}
