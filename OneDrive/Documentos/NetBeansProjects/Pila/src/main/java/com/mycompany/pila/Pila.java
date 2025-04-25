/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pila;

/**
 *
 * @author Alumno
 */
public class Pila {

    public static boolean isInteger(String str) {
        return str.matches("-?\\d+");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
    /*
     Pilas<Integer> p1 = new Pilas<>();
     int iUno = 1, iDos = 20;
     p1.peek();
     p1.push(iUno);
     p1.push(iDos);
     p1.peek();
     int demo = p1.pop();
     int demo2 = p1.pop();
     System.out.println("El elmento que sacamos es: " + demo);
     int demo3 = p1.pop();
     */
     String operacion = "2 2 / 4 5 + 3 8 * - +";
     Pilas<Integer> p2 = new Pilas<>();
     String[] c = operacion.split(" ");
     
     for (int i = 0; i < c.length; i++){
         if (isInteger(c[i])){
             int j = Integer.parseInt(c[i]);
             p2.push(j);
         } else{
           int num1 = p2.pop();
           int num2 = p2.pop();
           int num3;
           
           switch(c[i]){
                case "+":
                    num3 = num1 + num2;
                    break;
                case "-":
                    num3 = num1 - num2;
                    break;
                case "*":
                    num3 = num1 * num2;
                    break;
                case "/":
                    num3 = num2 / num1;
                    break;
                default:
                    throw new Exception("Usa operacion valida");
           }
           p2.push(num3);
         }
     }
     p2.peek();
     }
  }