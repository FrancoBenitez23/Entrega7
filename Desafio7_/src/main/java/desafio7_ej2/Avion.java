package desafio7_ej2;

public class Avion implements Volador {
 private boolean tieneAlas;

 public Avion(boolean tieneAlas) {
     this.tieneAlas = tieneAlas;
 }

 @Override
 public boolean puedeAterrizar() {
     // Si el avión tiene alas, puede aterrizar en la pista 1
     return tieneAlas;
 }
}
