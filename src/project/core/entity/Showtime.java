package project.core.entity;

public class Showtime {
    
    public Showtime(int movieId, String date, Integer time, Integer room) {
        this.movieId = movieId;
        this.date = date;
        this.time = time;
        this.room = room;
    }
    
    private int movieId;
    private String date;
    private Integer time;
    private Integer room;

    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
   
    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }
    //</editor-fold>
    
}
