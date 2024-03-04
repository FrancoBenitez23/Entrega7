package desafio7_ej3;

public class CollectionCustom<T> {
    private T[] arreglo;
    private int tamaño;
    private static final int CAPACIDAD_POR_DEFECTO = 10; //se realizo de esta forma para no usar un scanner y no complejizar de mas el ejercicio

    public CollectionCustom() {
        arreglo = (T[]) new Object[CAPACIDAD_POR_DEFECTO];
        tamaño = 0;
    }

    public int tamaño() {
        return tamaño;
    }

    public void agregarPrimero(T elemento) {
        asegurarCapacidad();
        for (int i = tamaño; i > 0; i--) {
            arreglo[i] = arreglo[i - 1];
        }
        arreglo[0] = elemento;
        tamaño++;
    }

    public void agregarUltimo(T elemento) {
        asegurarCapacidad();
        arreglo[tamaño++] = elemento;
    }

    public void agregar(T elemento) {
        agregarUltimo(elemento);
    }

    public T remover(T elemento) {
        int indice = indiceDe(elemento);
        if (indice != -1) {
            T removido = arreglo[indice];
            for (int i = indice; i < tamaño - 1; i++) {
                arreglo[i] = arreglo[i + 1];
            }
            arreglo[tamaño - 1] = null;
            tamaño--;
            return removido;
        }
        return null;
    }

    public void removerTodos() {
       
        tamaño = 0;
    }

    
    public T obtener(int indice) {
        if (indice < 0 || indice >= tamaño) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + indice);
        }
        return arreglo[indice];
    }

    public boolean vacio() {
        return tamaño == 0;
    }

    private void asegurarCapacidad() {
        if (tamaño == arreglo.length) {
            T[] nuevoArreglo = (T[]) new Object[arreglo.length * 2];
            System.arraycopy(arreglo, 0, nuevoArreglo, 0, tamaño);
            arreglo = nuevoArreglo;
        }
    }

    private int indiceDe(T elemento) {
        for (int i = 0; i < tamaño; i++) {
            if (arreglo[i].equals(elemento)) {
                return i;
            }
        }
        return -1;
    }
}

