package desafio7_ej2;


import java.util.ArrayList;
import java.util.List;

public class Ejercicio2 {
 public static void main(String[] args) {
     TorreDeControl torre = new TorreDeControlImpl();
     
   
     List<Volador> objetosVoladores = new ArrayList<>();
     
     
     objetosVoladores.add(new Avion(true)); 
     objetosVoladores.add(new Helicoptero(false)); 
     
   
     CamionTransportista CamionTransportista = new CamionTransportista();
     objetosVoladores.add(CamionTransportista);
     
 
     for (Volador volador : objetosVoladores) {
         
         torre.autorizarAterrizaje(volador);
     }
 }
}

