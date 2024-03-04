package desafio7_ej3;

public class Ejercicio3 {
    public static void main(String[] args) {
        
        CollectionCustom<Alumno> alumnosColeccion = new CollectionCustom<>();

        // Se añaden dos alumnos al principio
        alumnosColeccion.agregarPrimero(new Alumno("Juan", "Perez", 1001));
        alumnosColeccion.agregarPrimero(new Alumno("Maria", "Gomez", 1002));
        System.out.println("Tamaño de la colección: " + alumnosColeccion.tamaño());

        
        // Mostrar los datos de los alumnos en la colección
        System.out.println("Datos de los alumnos en la colección:");
        for (int i = 0; i < alumnosColeccion.tamaño(); i++) {
            Alumno alumno = alumnosColeccion.obtener(i);
            System.out.println("Nombre: " + alumno.getNombre());
            System.out.println("Apellido: " + alumno.getApellido());
            System.out.println("Legajo: " + alumno.getLegajo());
            System.out.println();
        }

        // Se añaden dos alumnos intercalando entre agregar primero y agregar último
        alumnosColeccion.agregarPrimero(new Alumno("Pedro", "Martinez", 1003));
        alumnosColeccion.agregarUltimo(new Alumno("Ana", "Lopez", 1004));

 
        System.out.println("Datos de los alumnos en la colección después de la intercalación:");
        for (int i = 0; i < alumnosColeccion.tamaño(); i++) {
            Alumno alumno = alumnosColeccion.obtener(i);
            System.out.println("Nombre: " + alumno.getNombre());
            System.out.println("Apellido: " + alumno.getApellido());
            System.out.println("Legajo: " + alumno.getLegajo());
            System.out.println();
        }

        // Eliminar un alumno específico
        System.out.println("Eliminar un alumno específico:");
        Alumno alumnoABorrar = new Alumno("Maria", "Gomez", 1002);
        System.out.println("Remover: " + alumnoABorrar);
        alumnosColeccion.remover(alumnoABorrar); 
       
        System.out.println("Datos de los alumnos en la colección después de eliminar:");
        for (int i = 0; i < alumnosColeccion.tamaño(); i++) {
            Alumno alumno = alumnosColeccion.obtener(i);
            System.out.println("Nombre: " + alumno.getNombre());
            System.out.println("Apellido: " + alumno.getApellido());
            System.out.println("Legajo: " + alumno.getLegajo());
            System.out.println();
        }

        
        System.out.println("Tamaño de la colección después de remover un elemento: " + alumnosColeccion.tamaño());
        System.out.println();

        // Verificar si la colección está vacía
        System.out.println("¿La colección está vacía? " + alumnosColeccion.vacio());
        System.out.println();

        // Vaciar la colección
        System.out.println("Vaciar la colección:");
        alumnosColeccion.removerTodos(); // Aquí se vacía completamente la colección
        for (int i = 0; i < alumnosColeccion.tamaño(); i++) {
            Alumno alumno = alumnosColeccion.obtener(i);
            System.out.println("Nombre: " + alumno.getNombre());
            System.out.println("Apellido: " + alumno.getApellido());
            System.out.println("Legajo: " + alumno.getLegajo());
            System.out.println();
        }
        System.out.println();

        
        System.out.println("¿La colección está vacía después de vaciarla? " + alumnosColeccion.vacio());
    }
}



