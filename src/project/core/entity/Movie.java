package project.core.entity;

public class Movie {
    
    public Movie(String title, String poster, Integer duration) {
        this.title = title;
        this.poster = poster;
        this.duration = duration;
    }

    private Integer movieId;
    private String title;
    private String poster;
    private Integer duration;

    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
    //</editor-fold>
    
}
