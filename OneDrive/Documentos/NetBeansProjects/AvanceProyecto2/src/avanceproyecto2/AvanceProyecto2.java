/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package avanceproyecto2;
import java.util.Scanner;

/**
 *
 * @author Leo_1
 */
public class AvanceProyecto2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner equipo = new Scanner (System.in);
        
        NormalQueue <Task> tareasEnEjecucion = new NormalQueue<>();
        NormalStack <Task> tareasUrgentes = new NormalStack<>();
        NormalStack <Task> Historial = new NormalStack<>();
        
        println("Le damos la bienvenida a nuestro gestor de tareas 2.0.");
        
        while(true){
            println("""
                    \nPor favor ingrese el número de lo que desea realizar: 
                    1. Añadir tarea.
                    2. Ejecutar tarea.
                    3. Ver historial.
                    4. Ver tareas pendientes.
                    5. Borrar historial.
                    6. Borrar tareas.
                    7. Salir.""");
            
            int choice = equipo.nextInt();
            equipo.nextLine();
            
            switch(choice){
                case 1:
                    //añadir tarea
                    println("\nNombre de la tarea: ");
                    String name = equipo.nextLine();
                    
                    println("\nDepartamento de la tarea: ");
                    String depto = equipo.nextLine();
                    
                    println("\nBreve descripción de la tarea: ");
                    String descrp = equipo.nextLine();
                    
                    println("\nNivel de urgencia(cualquier número arriba de 0): ");
                    int urgency = equipo.nextInt();
                    equipo.nextLine();
                    
                    Task tarea = new Task(name, urgency, depto, descrp);
                    int level = tarea.getUrgencia();
                    
                    if (level<= 0){
                        skullOfDeath();
                        waitasec();
                        println("\nOh no, decidiste desafiar a los dioses de la programación.");
                        waitasec();
                        println("Has cometido un gran java-error.");
                        waitasec();
                        println("Ahora pagarás las consecuencias.");
                        waitasec();
                        println("Buena suerte.\nLa necesitarás...");
                        return;
                    } else {
                        if (level < 4){
                        tareasUrgentes.pushStack(tarea);
                        tareasUrgentes.organizarUrgent();
                        println("\nSe detectó una tarea urgente — se ha añadido a la pila de urgencia: " + tarea);
                        break;
                        } else{
                            tareasEnEjecucion.pushQ(tarea);
                            break;
                        }
                    }
                case 2:
                    //ejecutar tarea
                    while (true){
                        println("""
                            \n¿Desea ejecutar una tarea urgente o una tarea normal?
                            1. Tarea normal
                            2. Tarea urgente""");
                        int taskKind = equipo.nextInt();
                        equipo.nextLine();
                        switch (taskKind){
                            case 1:
                                //tarea normal ejecutada y al historial
                                Task test = tareasEnEjecucion.popQ();
                                if (test == null) {
                                    break;
                                } else {
                                    Historial.pushStack(test);
                                    break;
                                }
                            case 2:
                                //tarea urgente ejecutada y al historial
                                tareasUrgentes.organizarUrgent();
                                Task urgT = tareasUrgentes.popStack();
                                if (urgT == null) {
                                    break;
                                } else {
                                    Historial.pushStack(urgT);
                                    break;
                                }
                            default:
                                println("Ingrese una opción válida.");
                                continue;
                        }
                        break;
                    }
                    break;
                case 3:
                    //ver historial
                    while (true){
                        println("""
                            \n¿Desea ver todo el historial o sólo el último elemento?
                            1. Mostrar historial completo
                            2. Mostrar sólo último elemento""");
                        int histType = equipo.nextInt();
                        equipo.nextLine();
                        switch (histType){
                            case 1:
                                //mostrar todo el historial
                                Historial.seeAllHistory();
                                break;
                            case 2:
                                //mostrar último elemento del historial
                                Historial.peekStack();
                                break;
                            default:
                                println("Ingrese una opción válida.");
                                continue;
                        }
                        break;
                    }
                    break;
                case 4:
                    //ver tareas pendientes
                    while (true){
                        println("""
                            \n¿Desea ver las tareas normales, las urgentes o por departamento?
                            1. Ver tareas normales pendientes
                            2. Ver tareas urgentes pendientes
                            3. Ver por departamento""");
                        int taskType = equipo.nextInt();
                        equipo.nextLine();
                        switch (taskType){
                            case 1:
                                //ver las tareas normales pendientes
                                while (true){
                                    println("""
                                            \n¿Desea ver TODAS las tareas pendientes o sólo la próxima?
                                            1. Ver todas las tareas pendientes
                                            2. Ver sólo la próxima""");
                                    taskType = equipo.nextInt();
                                    equipo.nextLine();
                                    switch (taskType){
                                        case 1:
                                        //ver TODAS las tareas pendientes
                                        tareasEnEjecucion.seeAllQ();
                                        break;
                                    case 2:
                                        //ver sólo UNA
                                        tareasEnEjecucion.front();
                                        break;
                                    default:
                                        println("Ingrese una opción válida.");
                                        continue;
                                    }
                                    break;
                                }
                                break;
                            case 2:
                                while (true){
                                    println("""
                                            \n¿Desea ver TODAS las tareas pendientes o sólo la próxima?
                                            1. Ver todas las tareas pendientes
                                            2. Ver sólo la próxima""");
                                    taskType = equipo.nextInt();
                                    equipo.nextLine();
                                    switch (taskType){
                                        case 1:
                                        tareasUrgentes.organizarUrgent();
                                        tareasUrgentes.seeAllUrgentStack();
                                        break;
                                    case 2:
                                        tareasUrgentes.organizarUrgent();
                                        tareasUrgentes.peekUrgentStack();
                                        break;
                                    default:
                                        println("Ingrese una opción válida.");
                                        continue;
                                    }
                                    break;
                                }
                                break;
                            case 3:
                                //buscar por departamento
                                println("\nIngrese el nombre del departamento: ");
                                String findDept = equipo.nextLine();
                                
                                int n = tareasEnEjecucion.getSize();
                                if (n == 0){
                                    println("\nNo hay tareas en la cola de ejecución.");
                                } else {
                                    for (int i = 0; i<n; i++){
                                        Task findT = tareasEnEjecucion.findInQ(i);
                                    
                                    if (findT != null && findT.getDepartamento().equalsIgnoreCase(findDept)){
                                        println(findT.toString());
                                    }
                                    }
                                }
                                
                                tareasUrgentes.organizarUrgent();
                                int m = tareasUrgentes.getSize();
                                if (m == 0){
                                    println("\nNo hay tareas en la pila de urgencia.");
                                } else {
                                    for (int i = 0; i<m; i++){
                                        Task findTU = tareasUrgentes.findInUS(i);
                                    
                                    if (findTU != null && findTU.getDepartamento().equalsIgnoreCase(findDept)){
                                        println(findTU.toString());
                                    }
                                    }
                                }
                                
                                
                        }
                        break;
                    }
                    break;
                case 5:
                    //borrar historial
                    while (true){
                        println("""
                            \n¿Desea borrar todo el historial o sólo el último elemento?
                            1. Borrar historial completo
                            2. Borrar sólo último elemento""");
                        int histType = equipo.nextInt();
                        equipo.nextLine();
                        switch (histType){
                            case 1:
                                //borrar todo el historial
                                int times = Historial.getSize();
                                if (times == 0){
                                    println("No hay nada para borrar en el historial");
                                    break;
                                } else{
                                    for (int i = 0; i < times; i++){
                                    Historial.popHistoryStack();
                                    }
                                }
                                break;
                            case 2:
                                //borrar último elemento del historial
                                Historial.popHistoryStack();
                                break;
                            default:
                                println("Ingrese una opción válida.");
                                continue;
                        }
                        break;
                    }
                    break;
                case 6:
                    //borrar tareas pendientes
                    while (true){
                        println("""
                            \n¿Desea borrar las tareas normales o las urgentes?
                            1. Borrar tareas normales pendientes
                            2. Borrar tareas urgentes pendientes""");
                        int taskType = equipo.nextInt();
                        equipo.nextLine();
                        switch (taskType){
                            case 1:
                                //borrar las tareas normales pendientes
                                while (true){
                                    println("""
                                            \n¿Desea borrar TODAS las tareas pendientes o sólo la próxima?
                                            1. Borrar todas las tareas pendientes
                                            2. Borrar sólo la próxima""");
                                    taskType = equipo.nextInt();
                                    equipo.nextLine();
                                    switch (taskType){
                                        case 1:
                                        //borrar TODAS las tareas pendientes
                                        int times = tareasEnEjecucion.getSize();
                                        if (times == 0){
                                            println("No quedan tareas por borrar.");
                                            break;
                                        } else{
                                            for (int i = 0; i < times; i++){
                                            tareasEnEjecucion.popTaskQ();
                                            }
                                        }
                                        break;
                                    case 2:
                                        //borrar sólo UNA
                                        tareasEnEjecucion.popTaskQ();
                                        break;
                                    default:
                                        println("Ingrese una opción válida.");
                                        continue;
                                    }
                                    break;
                                }
                                break;
                            case 2:
                                //borrar las tareas urgentes pendientes
                                while (true){
                                    println("""
                                            \n¿Desea borrar TODAS las tareas pendientes o sólo la próxima?
                                            1. Borrar todas las tareas pendientes
                                            2. Borrar sólo la próxima""");
                                    taskType = equipo.nextInt();
                                    equipo.nextLine();
                                    switch (taskType){
                                        case 1:
                                        //borrar TODAS las tareas pendientes URGENTES
                                        tareasUrgentes.organizarUrgent();
                                        int times = tareasUrgentes.getSize();
                                        if (times == 0){
                                            println("No quedan tareas urgentes por borrar.");
                                            break;
                                        } else{
                                            for (int i = 0; i < times; i++){
                                            tareasUrgentes.popUrgentStack();
                                            }
                                        }
                                        break;
                                    case 2:
                                        tareasUrgentes.organizarUrgent();
                                        tareasUrgentes.popUrgentStack();
                                        break;
                                    default:
                                        println("Ingrese una opción válida.");
                                        continue;
                                    }
                                    break;
                                }
                                break;
                        }
                        break;
                    }
                    break;
                case 7:
                    //salir del programa
                    println("\nEso ha sido todo. Gracias por usar el programa.");
                    println("Y recuerda...");
                    println("NUNCA USAR NIVEL DE URGENCIA 0");
                    return;
            }
            
        }
    }
    
    public static void print(String pr){
        System.out.print(pr);
    }
    
    public static void println(String pr){
        System.out.println(pr);
    }
    
    public static void waitasec(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public static void skullOfDeath(){
        String[] skullLines = {
            "⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣤⣤⠴⠶⠶⠶⠶⠶⠶⠶⠶⢤⣤⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
            "⠀⠀⠀⠀⢀⣤⠶⠛⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠛⠶⣤⡀⠀⠀⠀⠀⠀",
            "⠀⠀⢀⡴⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠛⢷⡄⠀⠀⠀",
            "⠀⣰⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⣦⠀⠀",
            "⢰⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⣧⠀",
            "⣿⠀⠀⣤⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⡄⠀⢹⡄",
            "⡏⠀⢰⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⠀⢸⡇",
            "⣿⠀⠘⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡟⠀⢸⡇",
            "⢹⡆⠀⢹⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⠃⠀⣾⠀",
            "⠈⢷⡀⢸⡇⠀⢀⣠⣤⣶⣶⣶⣤⡀⠀⠀⠀⠀⠀⢀⣠⣶⣶⣶⣶⣤⣄⠀⠀⣿⠀⣼⠃⠀",
            "⠀⠀⠈⢷⣼ ⣿⣿⣿⣿⣿⣿⣿⣿⡄⠀⠀⠀⠀⣾⣿⣿⣿⣿⣿⣿⣿⡇⠀⢸⡾⠃⠀⠀",
            "⠀⠀⠈⣿⠀⠀⢿⣿⣿⣿⣿⣿⣿⣿⠁⠀⠀⠀⠀⢹⣿⣿⣿⣿⣿⣿⣿⠃⠀⢸⡇⠀⠀⠀",
            "⠀⠀⠀⣿⠀⠀⠘⢿⣿⣿⣿⣿⡿⠃⠀⢠⠀⣄⠀⠀⠙⢿⣿⣿⣿⡿⠏⠀⠀⢘⡇⠀⠀⠀",
            "⠀⠀⠀⢻⡄⠀⠀⠀⠈⠉⠉⠀⠀⠀⣴⣿⠀⣿⣷⠀⠀⠀⠀⠉⠁⠀⠀⠀⠀⢸⡇⠀⠀⠀",
            "⠀⠀⠀⠈⠻⣄⡀⠀⠀⠀⠀⠀⠀⢠⣿⣿⠀⣿⣿⣇⠀⠀⠀⠀⠀⠀⠀⢀⣴⠟⠀⠀⠀⠀",
            "⠀⠀⠀⠀⠀⠘⣟⠳⣦⡀⠀⠀⠀⠸⣿⡿⠀⢻⣿⡟⠀⠀⠀⠀⣤⡾⢻⡏⠁⠀⠀⠀⠀⠀",
            "⠀⠀⠀⠀⠀⠀⢻⡄⢻⠻⣆⠀⠀⠀⠈⠀⠀⠀⠈⠀⠀⠀⢀⡾⢻⠁⢸⠁⠀⠀⠀⠀⠀⠀",
            "⠀⠀⠀⠀⠀⠀⢸⡇⠀⡆⢹⠒⡦⢤⠤⡤⢤⢤⡤⣤⠤⡔⡿⢁⡇⠀⡿⠀⠀⠀⠀⠀⠀⠀",
            "⠀⠀⠀⠀⠀⠀⠘⡇⠀⢣⢸⠦⣧⣼⣀⡇⢸⢀⣇⣸⣠⡷⢇⢸⠀⠀⡇⠀⠀⠀⠀⠀⠀⠀",
            "⠀⠀⠀⠀⠀⠀⠀⣷⠀⠈⠺⣄⣇⢸⠉⡏⢹⠉⡏⢹⢀⣧⠾⠋⠀⢠⡇⠀⠀⠀⠀⠀⠀⠀",
            "⠀⠀⠀⠀⠀⠀⠀⠻⣆⠀⠀⠀⠈⠉⠙⠓⠚⠚⠋⠉⠁⠀⠀⠀⢀⡾⠁⠀⠀⠀⠀⠀⠀⠀",
            "⠀⠀⠀⠀⠀⠀⠀⠀⠙⢷⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⡴⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀",
            "⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⠈⠙⠳⠶⠦⣤⣤⣤⡤⠶⠞⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"
        };
        for (String line : skullLines) {
            System.out.println(line);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}
}
