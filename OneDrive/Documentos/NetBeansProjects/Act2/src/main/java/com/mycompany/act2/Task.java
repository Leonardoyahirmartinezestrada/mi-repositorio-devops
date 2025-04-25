/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act2;
import java.time.LocalDate; //ya que en el Canvas pide la fecha

/**
 *
 * @author Leo_1
 */
public class Task {
    private int n;
    private String name;
    private LocalDate fecha;
    
    public Task(int n, String name, LocalDate fecha){
        this.n = n;
        this.name = name;
        this.fecha = fecha;
    }

    /**
     * @return the n
     */
    public int getN() {
        return n;
    }

    /**
     * @param n the n to set
     */
    public void setN(int n) {
        this.n = n;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * @return the fecha
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    @Override
    public String toString(){
        return "->T" + n +
               ": " + name + 
               " {" + fecha + "}<- ";
    }
}
