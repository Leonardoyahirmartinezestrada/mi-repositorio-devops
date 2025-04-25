/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eddproject;
import java.util.HashMap;
/**
 *
 * @author jairmsmz
 */
public class Graphos {
    private HashMap<String, LinkedLists<String>> adjacencyList;

    public Graphos() {
        adjacencyList = new HashMap<>();
    }

    // Agregar un videojuego (nodo) al grafo
    public void addNode(String gameName) {
        if (gameName == null || gameName.isEmpty()) {
            System.out.println("El nombre del juego no puede estar vacío.");
            return;
        }
        
        adjacencyList.putIfAbsent(gameName, new LinkedLists<>());
    }

    // Agregar una relación entre dos juegos 
    public void addEdge(String game1, String game2) {
        if (game1 == null || game2 == null || game1.isEmpty() || game2.isEmpty()) {
            System.out.println("Los nombres de los juegos no pueden estar vacíos.");
            return;
        }

        addNode(game1); 
        addNode(game2);
        
        adjacencyList.get(game1).LLappend(new LLNode<>(game2));
        adjacencyList.get(game2).LLappend(new LLNode<>(game1)); 
    }

    
    public LinkedLists<String> getConnections(String game) {
        if (!adjacencyList.containsKey(game)) {
            System.out.println("El juego " + game + " no existe.");
            return new LinkedLists<>(); 
        }
        return adjacencyList.get(game);
    }

    public void showGraph() {
        if (adjacencyList.isEmpty()) {
            System.out.println("No hay conexiones porque no hay suficientes juegos.");
            return;
        }

        for (String game : adjacencyList.keySet()) {
            LinkedLists<String> connections = adjacencyList.get(game);
            System.out.print("Juego: " + game + " -> Conexiones: ");
            connections.printList(); 
        }
    }
}