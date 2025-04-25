/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package avanceproyecto2;

/**
 *
 * @author Leo_1
 */
public class Task {
    private String name;
    private int urgencia; //jerarquía más importante
    private String departamento; //jerarquía subsiguiente
    private String descripcion; // no importa mucho el orden aquí

    
    public Task(String name, int urgencia, String departamento, String descripcion){
        this.name = name;
        this.urgencia = urgencia;
        this.departamento = departamento;
        this.descripcion = descripcion;
        
    }
    
    
    
    @Override
    public String toString(){
        return "\nTarea: " + getName() +
                "\nNivel de urgencia: " + getUrgencia() +
                "\nDepartamento: " + getDepartamento() +
                "\nDescripción: " + getDescripcion() + "\n";
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
     * @return the urgencia
     */
    public int getUrgencia() {
        return urgencia;
    }

    /**
     * @param urgencia the urgencia to set
     */
    public void setUrgencia(int urgencia) {
        this.urgencia = urgencia;
    }

    /**
     * @return the departamento
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * @param departamento the departamento to set
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
