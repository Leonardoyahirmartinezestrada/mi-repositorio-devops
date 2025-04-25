/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad.pkg4;

/**
 *
 * @author Leo_1
 */
class ArbolBinario {
    Nodo raiz;

    public ArbolBinario() {
        raiz = null;
    }

    // Método para insertar un nodo en el árbol
    public void insertar(int id) {
        raiz = insertarRec(raiz, id);
    }

    private Nodo insertarRec(Nodo raiz, int id) {
        if (raiz == null) {
            raiz = new Nodo(id);
            return raiz;
        }
        if (id < raiz.id)
            raiz.izquierdo = insertarRec(raiz.izquierdo, id);
        else if (id > raiz.id)
            raiz.derecho = insertarRec(raiz.derecho, id);
        return raiz;
    }

    // Método para buscar un nodo
    public boolean buscar(int id) {
        return buscarRec(raiz, id) != null;
    }

    private Nodo buscarRec(Nodo raiz, int id) {
        if (raiz == null || raiz.id == id)
            return raiz;
        if (id < raiz.id)
            return buscarRec(raiz.izquierdo, id);
        return buscarRec(raiz.derecho, id);
    }

    // Método para eliminar un nodo
    public void eliminar(int id) {
        raiz = eliminarRec(raiz, id);
    }

    private Nodo eliminarRec(Nodo raiz, int id) {
        if (raiz == null) return raiz;

        if (id < raiz.id)
            raiz.izquierdo = eliminarRec(raiz.izquierdo, id);
        else if (id > raiz.id)
            raiz.derecho = eliminarRec(raiz.derecho, id);
        else {
            if (raiz.izquierdo == null)
                return raiz.derecho;
            else if (raiz.derecho == null)
                return raiz.izquierdo;
            raiz.id = valorMinimo(raiz.derecho);
            raiz.derecho = eliminarRec(raiz.derecho, raiz.id);
        }
        return raiz;
    }

    private int valorMinimo(Nodo raiz) {
        int minv = raiz.id;
        while (raiz.izquierdo != null) {
            minv = raiz.izquierdo.id;
            raiz = raiz.izquierdo;
        }
        return minv;
    }

    // Recorridos del árbol
    public void inorden() {
        inordenRec(raiz);
    }

    private void inordenRec(Nodo raiz) {
        if (raiz != null) {
            inordenRec(raiz.izquierdo);
            System.out.print(raiz.id + " ");
            inordenRec(raiz.derecho);
        }
    }

    public void preorden() {
        preordenRec(raiz);
    }

    private void preordenRec(Nodo raiz) {
        if (raiz != null) {
            System.out.print(raiz.id + " ");
            preordenRec(raiz.izquierdo);
            preordenRec(raiz.derecho);
        }
    }

    public void postorden() {
        postordenRec(raiz);
    }

    private void postordenRec(Nodo raiz) {
        if (raiz != null) {
            postordenRec(raiz.izquierdo);
            postordenRec(raiz.derecho);
            System.out.print(raiz.id + " ");
        }
    }
}
// Explicación del codigo
// Contiene los métodos esenciales para operar sobre el árbol binario, incluyendo la inserción, búsqueda, eliminación 
// y los tres tipos de recorridos (preorden, inorden y postorden).
