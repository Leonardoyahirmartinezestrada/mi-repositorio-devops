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
public class HashHash {
    private HashMap<String, LinkedLists<String>> libraryGenre = new HashMap<>();
    private Graphos graph = new Graphos();
    
    public void addGameGenre(String genre, String name) {
        LLNode<String> title = new LLNode<>(name);
        
        libraryGenre.putIfAbsent(genre, new LinkedLists<>()); 
        libraryGenre.get(genre).LLappend(title);
        
        graph.addNode(name);
        
        LinkedLists<String> existingGames = libraryGenre.get(genre);
        if (existingGames != null) {
            LLNode<String> currentNode = existingGames.getFirst();
            while (currentNode != null) {
                String existingGameName = currentNode.getDato();
                if (!existingGameName.equalsIgnoreCase(name)) {
                    addRelationBetweenGames(name, existingGameName);
                }
                currentNode = currentNode.getNext();
            }
        }
    }

    public void addRelationBetweenGames(String game1, String game2) {
        graph.addEdge(game1, game2);
    }

    public void getGenreGames(String genre) {
        LinkedLists<String> titles = libraryGenre.get(genre);
        if (titles != null) {
            System.out.println("Se encontró el género " + genre);
            System.out.print("Títulos: " + titles.toStringLL() + "\n\n"); 
        } else {
            System.out.println("No tienes juegos en tu biblioteca con el género " + genre + "\n\n"); 
        }
    }

    public void getGenreAmount(String genre) {
        LinkedLists<String> amount = libraryGenre.get(genre);
        if (amount != null) {
            System.out.println("Se encontró el género " + genre);
            System.out.print("Cantidad de títulos: " + libraryGenre.get(genre).LLsize() + "\n\n"); 
        } else {
            System.out.println("No tienes juegos en tu biblioteca con el género " + genre + "\n\n"); 
        }
    }

    private int findGameIndex(LinkedLists<String> games, String name) {
        LLNode<String> currNode = games.getFirst(); 
        int index = 0;

        while (currNode != null) {
            if (currNode.getDato().equalsIgnoreCase(name)){ 
                return index;
            }
            currNode = currNode.getNext(); 
            index++;
        }

        return -1;
    }

    public void removeGame(String genre, String name) {
        LinkedLists<String> games = null;
        String foundGenre = null;
        for(String key : libraryGenre.keySet()) { 
            if (key.equalsIgnoreCase(genre)) { 
                foundGenre = key;
                games = libraryGenre.get(key); 
                break;
            }
        }

        if (games != null) {
            int index = findGameIndex(games, name); 
            if (index != -1) {
                games.LLdelete(index); 
                System.out.println("Se ha eliminado el juego " + name); 

                if(games.LLsize() == 0) { 
                    libraryGenre.remove(foundGenre); 
                    System.out.println("También se eliminó el género " + foundGenre + " porque ya no tiene juegos"); 
                }
            } else {
                System.out.println("El juego " + name + " no se encontró con el género " + foundGenre); 
            }
        } else {
            System.out.println("No tienes juegos en tu biblioteca con el género " + genre + ".\n"); 
        }
    }

    public void showAllGames() {
        if (libraryGenre.isEmpty()){
            System.out.println("\nNo hay juegos en tu biblioteca.");
        } else {
            System.out.println(toStringHash()); 
        }
    }

    public String toStringHash() {
        String res = "";
        for (String genre : libraryGenre.keySet()) { 
            res += "Género: " + genre + " | Cantidad: " + libraryGenre.get(genre).LLsize() + "\n"; 
            res += "Títulos: " + libraryGenre.get(genre).toStringLL() + "\n\n"; 
        }
        return res;
    }

    public void showGameGraph() {
        graph.showGraph(); 
    }
}