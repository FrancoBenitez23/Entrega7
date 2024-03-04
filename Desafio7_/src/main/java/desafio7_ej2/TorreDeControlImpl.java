package desafio7_ej2;

public class TorreDeControlImpl extends TorreDeControl {
 @Override
 void autorizarAterrizaje(Volador volador) {
     if (volador instanceof CamionTransportista) {
         System.out.println("El " + volador.getClass().getSimpleName() + " no es un objeto volador y no puede aterrizar ni en la pista 1 ni en la pista 2.");
     } else if (volador.puedeAterrizar()) {
         System.out.println("El " + volador.getClass().getSimpleName() + " puede aterrizar en la pista 1");
     } else {
         System.out.println("El " + volador.getClass().getSimpleName() + " no puede aterrizar en la pista 1. Solicitando autorización para pista 2.");
      
     }
 }
}
