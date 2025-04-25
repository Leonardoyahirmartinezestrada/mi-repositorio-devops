/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eddproject;

/**
 *
 * @author jairmsmz
 */

//La descripción del videojuego en general
public class VideoGame {
    private String name; 
    private int rating; 
    private String genre;
    private int timePlayed; 
    private int days;
    
    
    public VideoGame(String name, int rating, String genre, int timePlayed){
        this.name = name;
        this.rating = rating;
        this.genre = genre;
        this.timePlayed = timePlayed;
    }
    
    
    public VideoGame(String name, int days, String genre){
        this.name = name;
        this.days = days;
        this.genre = genre;
    }
    
    public VideoGame(String name, String genre){
        this.name = name;
        this.genre = genre;
    }
    
    
    
    public String toStringGameLibrary(){
        return "\nJuego: " + getName() +
                "\nGénero: " + getGenre() +
                "\nTiempo jugado en minutos: " + getTimePlayed() +
                "\nPuntuación: " + getRating();
    }
    
    
    
    public String toStringGameSoon(){
        return "\nJuego: " + getName() +
                "\nGénero: " + getGenre() +
                "\nDías que faltan: " + getDays();
    }
    
    public String toStringPending(){
        return "\nJuego: " + getName() +
                "\nGénero: " + getGenre();
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
     * @return the rating
     */
    public int getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * @param genre the genre to set
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * @return the timePlayed
     */
    public int getTimePlayed() {
        return timePlayed;
    }

    /**
     * @param timePlayed the timePlayed to set
     */
    public void setTimePlayed(int timePlayed) {
        this.timePlayed = timePlayed;
    }

    /**
     * @return the days
     */
    public int getDays() {
        return days;
    }

    /**
     * @param days the days to set
     */
    public void setDays(int days) {
        this.days = days;
    }
    
    @Override
    public String toString(){
        return name;
    }
}