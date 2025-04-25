/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package act2;
import java.util.Scanner;
import java.time.LocalDate;

/**
 *
 * @author Leo_1
 */
public class Act2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner jair = new Scanner(System.in);
        
        Stack <Task> Historial = new Stack<>();
        Queue <Task> Tareas = new Queue <>();
        int n = 0;
        
        println("Iniciando programa.");
        waitasec();
        println("Por favor, espere.");
        waitasec();
        println("Ya casi.");
        waitasec();
        println("Le damos la bienvenida a nuestro gestor de tareas.");
        
        while(true){
            println("""
                    \nPor favor ingrese el número de lo que desea realizar: 
                    1. Añadir tarea.
                    2. Ejecutar tarea.
                    3. Ver última tarea del historial.
                    4. Borrar última tarea del historial.
                    5. Salir.""");
            
            int choice = jair.nextInt();
            jair.nextLine();
            
            switch(choice){
                case 1:
                    //añadir tarea
                    println("\nEscribe la tarea que deseas añadir: ");
                    String tarea = jair.nextLine();
                    LocalDate fecha = LocalDate.now();
                    n++;
                    Task taask = new Task(n, tarea, fecha);
                    Tareas.pushQ(taask);
                    break;
                case 2:
                    //ejecutar tarea
                    //borrar de Queue; añadir a Stack
                    println("\nObteniendo tarea a ejecutar");
                    loading();
                    Task test = Tareas.popQ();
                    if (test == null){
                        break;
                    } else{
                    Historial.pushStack(test);
                    }
                    break;
                case 3:
                    //ver últ historial
                    println("\nObteniendo la tarea más reciente");
                    loading();
                    Historial.peekStack();
                    break;
                case 4:
                    //borrar últ historial
                    println("\nBorrando tarea más reciente del historial");
                    loading();
                    Historial.popStack();
                    break;
                case 5:
                    //salir del programa
                    println("\nSaliendo del programa");
                    loading();
                    println("Eso ha sido todo. Gracias por usar el programa.");
                    return;
            }
            
        }
        
    }
    
    public static void waitasec(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public static void print(String pr){
        System.out.print(pr);
    }
    
    public static void println(String pr){
        System.out.println(pr);
    }
    
    public static void loading(){
        for(int i = 0; i < 3; i++){
            print(".");
            waitasec();
        }
        println("");
            
    }
    
}