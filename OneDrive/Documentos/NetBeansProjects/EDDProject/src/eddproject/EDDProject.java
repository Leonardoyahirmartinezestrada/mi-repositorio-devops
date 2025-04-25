/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package eddproject;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author jairmsmz
 */
public class EDDProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        
        LinkedLists<VideoGame> everyGame = new LinkedLists<>();
        
        HashHash gamesByGenre = new HashHash();
        Graphos gameConnections = new Graphos();
        BinaryTree gamesByRating = new BinaryTree();
        BinaryTree gamesByMins = new BinaryTree();
        Stack recentGames = new Stack();
        PQueue comingSoon = new PQueue();
        Queue pending = new Queue();
        ArrayList<String> gamesAtoZ = new ArrayList<>();
        
        //loading();
        waitasec();
        println("Le damos la bienvenida a GamesResort\n");
        waitasec();
        
        while (true) {
            println("\nSeleccione el menú que desea explorar:");
            println("""
                —————————————
                *  INICIO *
                1. Mi Biblioteca
                2. Próximos Lanzamientos
                3. Pendientes
                4. Salir
                """);
            int mainChoice = input.nextInt();
            input.nextLine();
            
            switch (mainChoice) {
                case 1:
                    // Mi Biblioteca
                    waitasec();
                    while (true) {
                        println("""
                                  —————————————
                                * MI BIBLIOTECA *\n
                                1. Añadir juegos
                                2. Eliminar juegos
                                3. Ver juegos de mi biblioteca
                                4. Último juego explorado
                                5. Explorar juegos por género
                                6. Explorar juegos por puntuación
                                7. Explorar juegos por minutos jugados
                                8. Explorar conexiones entre juegos
                                9. Regresar a Inicio
                                """);
                        int libraryChoice = input.nextInt();
                        input.nextLine();
                        
                        switch (libraryChoice) {
                            case 1:
                                // Añadir
                                println("Nombre del juego: ");
                                String title = input.nextLine();
                                println("Puntuación del 0 al 100: ");
                                int rating = input.nextInt();
                                input.nextLine();
                                println("Género del juego: ");
                                String genre = input.nextLine();
                                println("Tiempo jugado en minutos: ");
                                int minsPlayed = input.nextInt();
                                input.nextLine();
                                
                                VideoGame game = new VideoGame(title, rating, genre, minsPlayed);
                                
                                LLNode<VideoGame> gameX = new LLNode<>(game);
                                everyGame.LLappend(gameX);
                                
                                gamesAtoZ.add(game.getName());
                                SortSort.MergeSort(gamesAtoZ);
                                
                                gamesByGenre.addGameGenre(game.getGenre(), game.getName());
                                gamesByRating.insertInTree(game.getRating(), game.getName());
                                gamesByMins.insertInTree(game.getTimePlayed(), game.getName());
                                recentGames.pushGameToRecent(game.getName());
                                
                                loading();
                                println("\nSe ha añadido el siguiente juego a tu biblioteca: " + game.toStringGameLibrary());
                                waitasec();
                                break;
                                
                            case 2:
                                // Eliminar
                                println("\nNombre del juego: ");
                                String titleDel = input.nextLine();
                                
                                if (everyGame.findByName(titleDel) != null) {
                                    LLNode<VideoGame> foundGameDel = everyGame.findByName(titleDel);
                                    gamesAtoZ.remove(foundGameDel.getDato().getName());
                                    SortSort.MergeSort(gamesAtoZ);
                                    
                                    waitasec();
                                    gamesByGenre.removeGame(foundGameDel.getDato().getGenre(), foundGameDel.getDato().getName());
                                    waitasec();
                                    gamesByRating.deleteRateInTree(foundGameDel.getDato().getRating(), foundGameDel.getDato().getName());
                                    waitasec();
                                    gamesByMins.deleteMinsInTree(foundGameDel.getDato().getTimePlayed(), foundGameDel.getDato().getName());
                                    waitasec();
                                    recentGames.pushGameToRecent(foundGameDel.getDato().getName());
                                    
                                } else {
                                    println("\nNo se pudo eliminar el juego ya sea porque no hay juegos en tu biblioteca o porque no hay un juego bajo ese nombre.");
                                }
                                waitasec();
                                break;
                                
                            case 3:
                                // Ver lista de juegos
                                waitasec();
                                SortSort.imprimirVector(gamesAtoZ);
                                waitasec();
                                break;
                            case 4:
                                // Ver juego más recientemente visto
                                waitasec();
                                recentGames.peekRecentGame();
                                waitasec();
                                break;
                            case 5:
                                // Explorar juegos por género
                                waitasec();
                                gamesByGenre.showAllGames();
                                waitasec();
                                break;
                            case 6:
                                // Explorar juegos por puntuación
                                waitasec();
                                gamesByRating.printInOrdenRating();
                                waitasec();
                                break;
                            case 7:
                                // Explorar juegos por tiempo jugado
                                waitasec();
                                gamesByMins.printInOrdenMinutes();
                                waitasec();
                                break;
                            case 8:
                                // Ver conexiones
                                waitasec();
                                gameConnections.showGraph();
                                waitasec();
                                break;
                            case 9:
                                // Regresar a inicio
                                waitasec();
                                println("\nRegresando a Inicio");
                                loading();
                                waitasec();
                                break;
                            default:
                                println("\nOpción no válida. Intenta de nuevo.");
                        }

                        if (libraryChoice == 9) {
                            break;
                        }
                    }
                    break;
                
                case 2:
                    // Próximos Lanzamientos
                    waitasec();
                    while (true) {
                        println("""
                                  —————————————————————
                                * Próximos Lanzamientos *\n
                                1. Añadir a Próximos Lanzamientos
                                2. Ver siguiente juego
                                3. Ver próximos juegos
                                4. Actualizar Próximos Lanzamientos
                                5. Regresar a Inicio
                                """);
                        int soonChoice = input.nextInt();
                        input.nextLine();
                        
                        switch (soonChoice) {
                            case 1:
                                println("Nombre del juego: ");
                                String title = input.nextLine();
                                println("Género del juego: ");
                                String genre = input.nextLine();
                                println("Días restantes para su lanzamiento: ");
                                int days = input.nextInt();
                                input.nextLine();
                                
                                VideoGame gameSoon = new VideoGame(title, 0, genre, 0);
                                println("\nSe está añadiendo la siguiente información: ");
                                println("Juego: " + title + " | Días que faltan: " + days + "\n");
                                comingSoon.pushPQ(days, gameSoon);
                                loading();
                                waitasec();
                                break;
                            case 2:
                                waitasec();
                                comingSoon.printFirstOfPQueue();
                                waitasec();
                                break;
                            case 3:
                                waitasec();
                                comingSoon.printPQueue();
                                waitasec();
                                break;
                            case 4:
                                PQNode<VideoGame> pendingGame = comingSoon.popPQ();
                                
                                if (pendingGame != null) {
                                    waitasec();
                                    
                                    VideoGame game = new VideoGame(pendingGame.getDato().getName(), 0, pendingGame.getDato().getGenre(), 0);
                                    
                                    LLNode<VideoGame> gameX = new LLNode<>(game);
                                    everyGame.LLappend(gameX);
                                    
                                    gamesAtoZ.add(game.getName());
                                    SortSort.MergeSort(gamesAtoZ);
                                    
                                    gamesByGenre.addGameGenre(game.getGenre(), game.getName());
                                    gamesByRating.insertInTree(game.getRating(), game.getName());
                                    gamesByMins.insertInTree(game.getTimePlayed(), game.getName());
                                    recentGames.pushGameToRecent(game.getName());
                                    
                                    waitasec();
                                    println("\nYa llegó el siguiente juego y se añadió a tu biblioteca con esta información: " + game.toStringGameLibrary());
                                    waitasec();
                                } else {
                                    waitasec();
                                }
                                break;
                            case 5:
                                waitasec();
                                println("\nRegresando a Inicio");
                                loading();
                                break;
                            default:
                                println("\nOpción no válida. Intenta de nuevo.");
                        }

                        if (soonChoice == 5) {
                            break;
                        }
                    }
                    break;
                
                case 3:
                    // Pendientes
                    waitasec();
                    while (true) {
                        println("""
                                  ——————————
                                * Pendientes *\n
                                1. Añadir a Pendientes
                                2. Ver siguiente juego pendiente
                                3. Ver todos los juegos pendientes
                                4. Eliminar siguiente juego de pendientes y añadir a Mi Biblioteca
                                5. Regresar a Inicio
                                """);
                        int pendChoice = input.nextInt();
                        input.nextLine();
                        
                        switch (pendChoice) {
                            case 1:
                                println("Nombre del juego: ");
                                String title = input.nextLine();
                                println("Género del juego: ");
                                String genre = input.nextLine();
                                
                                waitasec();
                                VideoGame gamePending = new VideoGame(title, genre);
                                pending.addGameToPending(gamePending);
                                loading();
                                waitasec();
                                break;
                            case 2:
                                waitasec();
                                pending.seeNextPending();
                                waitasec();
                                break;
                            case 3:
                                waitasec();
                                pending.seeAllPending();
                                waitasec();
                                break;
                            case 4:
                                LLNode<VideoGame> penGame = pending.popPending();
                                
                                waitasec();
                                if (penGame != null) {
                                    VideoGame game = new VideoGame(penGame.getDato().getName(), 0, penGame.getDato().getGenre(), 0);
                                    
                                    LLNode<VideoGame> gameX = new LLNode<>(game);
                                    everyGame.LLappend(gameX);
                                    
                                    gamesAtoZ.add(game.getName());
                                    SortSort.MergeSort(gamesAtoZ);
                                    
                                    gamesByGenre.addGameGenre(game.getGenre(), game.getName());
                                    gamesByRating.insertInTree(game.getRating(), game.getName());
                                    gamesByMins.insertInTree(game.getTimePlayed(), game.getName());
                                    recentGames.pushGameToRecent(game.getName());
                                } else {
                                    waitasec();
                                }
                                break;
                            case 5:
                                waitasec();
                                println("\nRegresando a Inicio");
                                loading();
                                break;
                            default:
                                println("\nOpción no válida. Intenta de nuevo.");
                        }

                        if (pendChoice == 5){
                            break;
                        }
                    }
                    break;
                
                case 4:
                    loading();
                    println("\nGracias por usar GamesResort. ¡Hasta luego!");
                    input.close();
                    waitasec();
                    return;
                default:
                    println("\nOpción no válida. Intenta de nuevo.");
            }
        }
    }
    
    
    public static void println(String phrase) {
        System.out.println(phrase);
    }
    
    public static void print(String phrase){
        System.out.print(phrase);
    }
    
    
    public static void waitasec(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public static void loading(){
        System.out.print("Cargando [");
        for(int i = 0; i < 5; i++){
            waitasec();
            System.out.print("#");
        }
        println("]");
    }
}