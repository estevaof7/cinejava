package project.core.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import project.core.dao.connection.ConnectionJDBC;
import project.core.entity.Movie;
import java.sql.ResultSet;
import java.time.LocalDate;
import javax.swing.JPanel;
import javax.swing.JTextField;
import project.core.entity.Showtime;

public class MovieDAO {
    
    //<editor-fold defaultstate="collapsed" desc="Movies Methods">
    public void addMovie(Movie movie) {
        String sql = "INSERT INTO MOVIE (TITLE, POSTER, DURATION) VALUES (?,?,?)";

        PreparedStatement ps = null;

        try {
            ps = ConnectionJDBC.getConnection().prepareStatement(sql);
            ps.setString(1, movie.getTitle());
            ps.setString(2, movie.getPoster());
            ps.setInt(3, movie.getDuration());

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "There has been an error with the Database", "SQL Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
            }
        }
    }
    public List<Movie> movieList() {
        String sql = "SELECT ID, TITLE, POSTER, DURATION FROM cinema.movie ORDER BY title ASC";

        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Movie> filmes = new ArrayList<>();

        try {
            ps = ConnectionJDBC.getConnection().prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                Movie movie = new Movie(
                        rs.getString("TITLE"),
                        rs.getString("POSTER"),
                        rs.getInt("DURATION")
                );
                movie.setMovieId(rs.getInt("ID"));
                filmes.add(movie);
            }
            return filmes;

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "There has been an error with the Database", "SQL Error", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            try {
                ps.close();
                rs.close();
            } catch (SQLException ex) {
            }
        }
    }
    public List<char[]> charArrayMovies(List<Movie> movies) {
        List<char[]> charNames = new ArrayList<>();
        for (Movie m : movies) {
            charNames.add(m.getTitle().toCharArray());
        }
        return charNames;
    }
    public List<String> titles(List<Movie> movies) {
        List<String> StringTitles = new ArrayList<>();
        for (Movie m : movies) {
            StringTitles.add(m.getTitle());
        }
        return StringTitles;
    }
    public void removeMovie(Movie movie) {
        String sql = "DELETE FROM cinema.movie WHERE ID = ?";
        
        PreparedStatement ps = null;

        try {
            ps = ConnectionJDBC.getConnection().prepareStatement(sql);
            ps.setInt(1, movie.getMovieId());

            ps.execute();

        } catch (java.sql.SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "Movie found in a showtime. "
                    + "\nPlease, try to remove the showtime before removing the movie.", "SQL Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "There has been an error with the Database", "SQL Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
            }
        }
    }
    public void search(
            JTextField fieldSearch,
            List<String> results,
            List<Movie> movies,
            List<JPanel> panelList,
            List<char[]> charNames
    ) {
        try {
            String busca = fieldSearch.getText();
            results.removeAll(results);

            char[] charBusca = busca.toCharArray();
            charBusca[0] = Character.toUpperCase(charBusca[0]); //If first letter is lowercase

            for (char[] nome : charNames) {
                for (int i = 0; i < charBusca.length; i++) {
                    if (nome[i] == charBusca[i]) {
                        if (i == charBusca.length - 1) {
                            results.add(charArrayToString(nome));
                        }
                    } else {
                        break;
                    }
                }
            }

            if (!results.isEmpty()) {
                for (int i = 0; i < panelList.size(); i++) {
                    for (int j = 0; j < results.size(); j++) {
                        if (movies.get(i).getTitle().equals(results.get(j))) {
                            panelList.get(i).setVisible(true);
                            break;
                        }
                        if (j == results.size() - 1) {
                            panelList.get(i).setVisible(false);
                        }
                    }
                }
            } else {
                for (JPanel panel : panelList) {
                    panel.setVisible(false);
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            for (JPanel panel : panelList) {
                panel.setVisible(true);
            }
        }
    }
    
    public String charArrayToString(char[] charWord) {
        String stringWord = "";
        for (char letter : charWord) {
            stringWord += letter;
        }
        return stringWord;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Showtimes Methods">
    public List<LocalDate> fifteenDaysList() {
        List<LocalDate> days = new ArrayList<>();
        LocalDate today = LocalDate.now();

        for (int i = 0; i < 16; i++) {
            days.add(today.plusDays(i));
        }
        return days;
    }
    public List<Showtime> showtimesList() {
        String sql = "SELECT IDSHOWTIME, MOVIE_ID, DATE, TIME, ROOM FROM cinema.showtime";

        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Showtime> stList = new ArrayList<>();
        
        try {
            ps = ConnectionJDBC.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Showtime st = new Showtime(
                        rs.getInt("MOVIE_ID"),
                        rs.getString("DATE"),
                        rs.getInt("TIME"), 
                        rs.getInt("ROOM"));
                stList.add(st);
            }
            return stList;

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "There has been an error with the Database", "SQL Error", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            try {
                ps.close();
                rs.close();
            } catch (SQLException ex) {
            }
        }
    }
    public void removePastShowtimes() { //It will be invoked everytime the application is opened
        List<Showtime> showtimesList = this.showtimesList();
        Long today = LocalDate.now().toEpochDay();
        
        for (Showtime st : showtimesList) {
            if(LocalDate.parse(st.getDate()).toEpochDay() < today) {
                this.removeShowtime(st);
            }
        }
    }
    
    public void addShowtime(Showtime showtime) {
        String sql = "INSERT INTO cinema.showtime (MOVIE_ID, DATE, TIME, ROOM) VALUES (?,?,?,?)";

        PreparedStatement ps = null;

        try {
            ps = ConnectionJDBC.getConnection().prepareStatement(sql);
            ps.setInt(1, showtime.getMovieId());
            ps.setString(2, showtime.getDate());
            ps.setInt(3, showtime.getTime());
            ps.setInt(4, showtime.getRoom());

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "There has been an error with the Database", "SQL Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
            }
        }
    }
    public void removeShowtime(Showtime showtime) {
        String sql = "DELETE FROM cinema.showtime WHERE IDSHOWTIME = ?";

        PreparedStatement ps = null;

        try {
            ps = ConnectionJDBC.getConnection().prepareStatement(sql);
            ps.setInt(1, this.getShowtimeId(showtime));

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "There has been an error with the Database", "SQL Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
            }
        }
    }
    public Integer getShowtimeId (Showtime showtime) {
        String sql = "SELECT idshowtime FROM cinema.showtime WHERE movie_id = ? AND date = ? AND time = ? AND room = ?";
        int id;
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            ps = ConnectionJDBC.getConnection().prepareStatement(sql);
            ps.setInt(1, showtime.getMovieId());
            ps.setString(2, showtime.getDate());
            ps.setInt(3, showtime.getTime());
            ps.setInt(4, showtime.getRoom());

            rs = ps.executeQuery();

            if (rs.next()) {

                id = rs.getInt("idshowtime");

                return id;
            } else {
                JOptionPane.showMessageDialog(null, "Showtime not found");
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "There has been an error with the Database", "SQL Error", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            try {
                ps.close();
                rs.close();
            } catch (SQLException ex) {
            }

        }
    }
       
    public List<Integer> getDistinctMovieIdsByDate(LocalDate day) {
        String sql = "SELECT movie_id FROM cinema.showtime WHERE date = ? GROUP BY movie_id";
        String date = day.toString();
        List<Integer> movieIdList = new ArrayList<>();
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            ps = ConnectionJDBC.getConnection().prepareStatement(sql);
            ps.setString(1, date);

            rs = ps.executeQuery();

            while (rs.next()) {
                movieIdList.add(rs.getInt("movie_id"));
            } 
            return movieIdList;

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "There has been an error with the Database", "SQL Error", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            try {
                ps.close();
                rs.close();
            } catch (SQLException ex) {
            }

        }
    }
    public Movie getMovieById(int id) {
        for(Movie movie : this.movieList()) {
            if(id == movie.getMovieId()) return movie;
        }
        return null;
    }
    public Integer getMovieIdFromTitle(String title) {
        List<Movie> movies = this.movieList();
        
        for (Movie movie : movies) {
            if(movie.getTitle().equals(title)) {
                return movie.getMovieId();
            }
        }
        return null;
    }
    public List<Integer[]> getTimesAndRoom(LocalDate day, int movieId) {
        String sql = "SELECT time, room FROM cinema.showtime WHERE movie_id = ? AND date = ? ORDER BY time ASC";
        List<Integer[]> timeAndRoomList = new ArrayList<>();
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            ps = ConnectionJDBC.getConnection().prepareStatement(sql);
            ps.setInt(1, movieId);
            ps.setString(2, day.toString());
            
            rs = ps.executeQuery();

            while (rs.next()) {
                Integer[] timeAndRoom = new Integer[2];
                timeAndRoom[0] = rs.getInt("time");
                timeAndRoom[1] = rs.getInt("room");
                
                timeAndRoomList.add(timeAndRoom);
            }
            return timeAndRoomList;

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "There has been an error with the Database", "SQL Error", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            try {
                ps.close();
                rs.close();
            } catch (SQLException ex) {
            }
        }
    }
    public Boolean isTimeAvailable(Integer room, String date, Integer time, Integer duration) {
        String sql = "SELECT time, movie_id FROM cinema.showtime WHERE date = ? AND room = ?";
        Integer endTime = time + duration;
        Boolean finishesAfter12Am = endTime >= 1440;
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        List<int[]> notAvailableIntervals = new ArrayList<>();
        
        try {
            ps = ConnectionJDBC.getConnection().prepareStatement(sql);
            ps.setString(1, date);
            ps.setInt(2, room);
            
            rs = ps.executeQuery();

            while (rs.next()) {
                int[] interval = new int[2];
                interval[0] = rs.getInt("TIME");
                interval[1] = interval[0] + this.getMovieById(rs.getInt("MOVIE_ID")).getDuration();
                notAvailableIntervals.add(interval);
            }
            
            for(int[] interval : notAvailableIntervals) {
                if((time > interval[0] && time < interval[1]) || (endTime > interval[0] && endTime < interval[1])) return false;
            }
            
            if(finishesAfter12Am) {
                LocalDate nextDay = LocalDate.parse(date).plusDays(1);
                this.isTimeAvailable(room, String.valueOf(nextDay), 0, endTime - 1440);               
            }
            
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "There has been an error with the Database", "SQL Error", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            try {
                ps.close();
                rs.close();
            } catch (SQLException ex) {
            }
        }
    }
    
    public Integer timeToInteger(int hours, int minutes, Boolean isAm) {
        Integer time;
        if (isAm) {
            if (hours == 12) {
                time = minutes;
            } else {
                time = (hours * 60) + minutes;
            }
        } else {
            if (hours == 12) {
                time = 720 + minutes;
            } else {
                time = (hours + 12) * 60 + minutes;
            }
        }
        return time;
    }
    public String integerToTime(int timeInMinutes) {
        String hours = "";
        String minutes = "";
        String ampm = "";
        
        if (timeInMinutes < 60) {
            hours = "12";
            minutes = this.addZero(timeInMinutes);
            ampm = "am";
        } else if (timeInMinutes >= 60 && timeInMinutes < 720) {
            hours = this.addZero(timeInMinutes / 60);
            minutes = this.addZero(timeInMinutes % 60);
            ampm = "am";
        } else if (timeInMinutes >= 720 && timeInMinutes < 780) {
            hours = "12";
            minutes = this.addZero(timeInMinutes - 720);
            ampm = "pm";
        } else if (timeInMinutes >= 720 && timeInMinutes < 1440) {
            hours = this.addZero((timeInMinutes - 720) / 60);
            minutes = this.addZero(timeInMinutes % 60);
            ampm = "pm";
        }

        return hours + ":" + minutes + " " + ampm;
    }
    public String addZero(int num) {
        if (num < 10) return String.valueOf("0" + num);
        else return String.valueOf(num);
    }
    //</editor-fold>

    public void temporary() {
        LocalDate today = LocalDate.now();
        Showtime s1 = new Showtime(getMovieIdFromTitle("Inception"), today.toString(), timeToInteger(7, 30, true), 1);
        Showtime s2 = new Showtime(getMovieIdFromTitle("Inception"), today.toString(), timeToInteger(2, 0, false), 2);
        Showtime s3 = new Showtime(getMovieIdFromTitle("Inception"), today.toString(), timeToInteger(4, 30, false), 3);
        Showtime s4 = new Showtime(getMovieIdFromTitle("Inception"), today.toString(), timeToInteger(7, 30, false), 1);
        Showtime s5 = new Showtime(getMovieIdFromTitle("La La Land"), today.toString(), timeToInteger(2, 30, false), 1);
        Showtime s6 = new Showtime(getMovieIdFromTitle("La La Land"), today.toString(), timeToInteger(5, 0, false), 2);
        Showtime s7 = new Showtime(getMovieIdFromTitle("La La Land"), today.toString(), timeToInteger(9, 0, false), 3);
        Showtime s8 = new Showtime(getMovieIdFromTitle("Mid 90s"), today.toString(), timeToInteger(10, 0, true), 1);
        Showtime s9 = new Showtime(getMovieIdFromTitle("Mid 90s"), today.toString(), timeToInteger(12, 0, false), 2);
        Showtime s10 = new Showtime(getMovieIdFromTitle("Mid 90s"), today.toString(), timeToInteger(4, 0, false), 1);
        Showtime s11 = new Showtime(getMovieIdFromTitle("Mid 90s"), today.toString(), timeToInteger(8, 0, false), 2);
        Showtime s12 = new Showtime(getMovieIdFromTitle("Pulp Fiction"), today.plusDays(1).toString(), timeToInteger(2, 30, false), 1);
        Showtime s13 = new Showtime(getMovieIdFromTitle("Pulp Fiction"), today.plusDays(1).toString(), timeToInteger(5, 0, false), 2);
        Showtime s14 = new Showtime(getMovieIdFromTitle("Pulp Fiction"), today.plusDays(1).toString(), timeToInteger(7, 30, false), 3);
        Showtime s15 = new Showtime(getMovieIdFromTitle("The Social Network"), today.plusDays(1).toString(), timeToInteger(10, 0, true), 1);
        Showtime s16 = new Showtime(getMovieIdFromTitle("The Social Network"), today.plusDays(1).toString(), timeToInteger(4, 0, false), 3);
        Showtime s17 = new Showtime(getMovieIdFromTitle("The Social Network"), today.plusDays(1).toString(), timeToInteger(5, 30, false), 1);
        Showtime s18 = new Showtime(getMovieIdFromTitle("The Social Network"), today.plusDays(1).toString(), timeToInteger(9, 0, false), 2);
        
        this.addShowtime(s1);
        this.addShowtime(s2);
        this.addShowtime(s3);
        this.addShowtime(s4);
        this.addShowtime(s5);
        this.addShowtime(s6);
        this.addShowtime(s7);
        this.addShowtime(s8);
        this.addShowtime(s9);
        this.addShowtime(s10);
        this.addShowtime(s11);
        this.addShowtime(s12);
        this.addShowtime(s13);
        this.addShowtime(s14);
        this.addShowtime(s15);
        this.addShowtime(s16);
        this.addShowtime(s17);
        this.addShowtime(s18);
        
    }
}
