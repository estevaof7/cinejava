package project.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import project.core.dao.MovieDAO;
import project.core.entity.Movie;
import project.core.entity.Showtime;

public class ScreenAddShowtime extends javax.swing.JFrame {

    public ScreenAddShowtime() {
        initComponents();
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dateComboBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        fieldMovie = new javax.swing.JTextField();
        scrollPaneMovies = new javax.swing.JScrollPane();
        jLabel4 = new javax.swing.JLabel();
        fieldHour = new javax.swing.JTextField();
        fieldMinutes = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        amPmComboBox = new javax.swing.JComboBox<>();
        addTime = new javax.swing.JButton();
        addShowtimes = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        search = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        roomComboBox = new javax.swing.JComboBox<>();
        addedShowtimes = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Add Showtime");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Select a date: ");

        dateComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Select a movie:");

        fieldMovie.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fieldMovie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                writtenLetter(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Add a time:");

        fieldHour.setDocument(new JTextFieldLimit(2));
        fieldHour.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        fieldMinutes.setDocument(new JTextFieldLimit(2));
        fieldMinutes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText(":");

        amPmComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        amPmComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "am", "pm" }));

        addTime.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        addTime.setText("Add time");
        addTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTimeActionPerformed(evt);
            }
        });

        addShowtimes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        addShowtimes.setText("Add showtimes");
        addShowtimes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addShowtimesActionPerformed(evt);
            }
        });

        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        search.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Select a room:");

        roomComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        roomComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));

        addedShowtimes.setPreferredSize(new java.awt.Dimension(376, 2));

        javax.swing.GroupLayout addedShowtimesLayout = new javax.swing.GroupLayout(addedShowtimes);
        addedShowtimes.setLayout(addedShowtimesLayout);
        addedShowtimesLayout.setHorizontalGroup(
            addedShowtimesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        addedShowtimesLayout.setVerticalGroup(
            addedShowtimesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPaneMovies)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addShowtimes))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fieldMovie)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dateComboBox, 0, 326, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(roomComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(fieldHour, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldMinutes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(amPmComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(addTime))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addedShowtimes, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(dateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(roomComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldMovie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPaneMovies, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fieldHour, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldMinutes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(amPmComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(addTime))
                    .addComponent(addedShowtimes, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addShowtimes)
                    .addComponent(cancel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //<editor-fold defaultstate="collapsed" desc="Variables">
    JPanel contentPanel;
    MovieDAO mdao = new MovieDAO();
    List<LocalDate> dateList = mdao.fifteenDaysList();
    List<Movie> movies = mdao.movieList();
    List<String> results = mdao.titles(movies);
    List<JPanel> panelList = new ArrayList<>();
    List<char[]> charNames = mdao.charArrayMovies(movies);
    List<JPanel> gridItemsQueue = new ArrayList<>();
    List<JLabel> gridLabelsQueue = new ArrayList<>();
    List<Integer> timesToBeAdded = new ArrayList<>();
    //</editor-fold>

    private void init() {

        this.setDateComboBox();
        
        contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        scrollPaneMovies.setViewportView(contentPanel);

        for (Movie movie : movies) {
            JPanel panel = new JPanel();
            JLabel title = new JLabel("<html><div>"
                    + movie.getTitle()
                    + "</div></html>");
            title.setFont(new Font("Segoe", Font.PLAIN, 14));
            panel.setLayout(new BorderLayout());
            panel.setPreferredSize(new Dimension(scrollPaneMovies.getWidth() - 18, 30));
            panel.setMaximumSize(new Dimension(scrollPaneMovies.getWidth(), 30));
            panel.setMinimumSize(new Dimension(scrollPaneMovies.getWidth(), 30));
            panel.add(title);

            panel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    panel.setBackground(new Color(255, 150, 150));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    panel.setBackground(new Color(238, 238, 238));
                }

                @Override
                public void mouseClicked(MouseEvent e) {
                    fieldMovie.setText(movie.getTitle());
                    contentPanel.setVisible(false);
                }
            });

            panelList.add(panel);
            contentPanel.add(panel);
        }

        addedShowtimes.setLayout(new GridLayout(2, 4));
        
        for (int i = 0; i < 8; i++) {
            JPanel gridItem = new JPanel();
            gridItem.setLayout(new FlowLayout());

            JLabel time = new JLabel();
            JLabel removeButton = new JLabel("<html><div "
                    + "style = '"
                    + "border: 1px solid gray;"
                    + "padding: 3px 5px 3px 5px;"
                    + "background-color: rgb(250,250,250);'>"
                    + "x"
                    + "</div></html>");
            removeButton.setVisible(false);

            gridLabelsQueue.add(time);
            gridItem.add(time);
            gridItem.add(removeButton);
            gridItem.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    removeButton.setVisible(true);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    removeButton.setVisible(false);
                }
            });

            gridItem.setVisible(false);
            gridItemsQueue.add(gridItem);

            removeButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    setCursor(Cursor.HAND_CURSOR);
                    removeButton.setVisible(true);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    setCursor(Cursor.DEFAULT_CURSOR);
                }

                @Override
                public void mouseClicked(MouseEvent e) { //Remove an item from Queue
                    for (int j = gridItemsQueue.indexOf(removeButton.getParent()); j < 7; j++) { 
                        gridLabelsQueue.get(j).setText(gridLabelsQueue.get(j+1).getText());
                        if(!gridItemsQueue.get(j+1).isVisible() && gridItemsQueue.get(j).isVisible()) {
                            gridItemsQueue.get(j).setVisible(false);
                        }
                    }
                    gridItemsQueue.get(7).setVisible(false);
                    
                    timesToBeAdded.remove(gridItemsQueue.indexOf(removeButton.getParent()));
                }

            });

            addedShowtimes.add(gridItem);
        }
    }
    
    private void setDateComboBox() {
        for (LocalDate day : dateList) {
            dateComboBox.addItem(day.getDayOfWeek() + ", " + mdao.addZero(day.getMonthValue()) + "/" + mdao.addZero(day.getDayOfMonth()));
        }
    }
    
    public class JTextFieldLimit extends PlainDocument { //use with setDocument

        private final int limit;

        JTextFieldLimit(int limit) {
            super();
            this.limit = limit;
        }

        @Override
        public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
            if (str == null) {
                return;
            }

            if ((getLength() + str.length()) <= limit) {
                super.insertString(offset, str, attr);
            }
        }
    }

    private void writtenLetter(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_writtenLetter
        if (!contentPanel.isVisible()) {
            contentPanel.setVisible(true);
        }
        mdao.search(fieldMovie, results, movies, panelList, charNames);
    }//GEN-LAST:event_writtenLetter

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        if (results.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Movie not found", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_searchActionPerformed

    private void addTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTimeActionPerformed
        try {
            Integer hour = Integer.valueOf(fieldHour.getText());
            Integer minutes = Integer.valueOf(fieldMinutes.getText());

            if (hour > 12 || minutes > 59) {
                throw new NumberFormatException();
            }

            Integer intTime = mdao.timeToInteger(hour, minutes, amPmComboBox.getSelectedIndex() == 0);

            for (int i = 0; i < timesToBeAdded.size(); i++) {
                if (Objects.equals(intTime, timesToBeAdded.get(i))) {
                    throw new IndexOutOfBoundsException();
                }
            }

            gridLabelsQueue.get(timesToBeAdded.size()).setText("<html><div "
                    + "style = '"
                    + "border: 1px solid gray;"
                    + "padding: 3px;"
                    + "background-color: rgb(250,250,250);'>"
                    + mdao.integerToTime(intTime)
                    + "</div></html>");

            gridItemsQueue.get(timesToBeAdded.size()).setVisible(true);

            timesToBeAdded.add(intTime);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid time", "Error", JOptionPane.ERROR_MESSAGE);
            fieldHour.setText("");
            fieldMinutes.setText("");
        } catch (IndexOutOfBoundsException e) {
            fieldHour.setText("");
            fieldMinutes.setText("");
        }

    }//GEN-LAST:event_addTimeActionPerformed
     
    private void addShowtimesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addShowtimesActionPerformed
        
        try {
            
            String movieTitle = fieldMovie.getText();
            Integer movieId = mdao.getMovieIdFromTitle(movieTitle);
            if(movieId == null) throw new MovieNotFound();
            if(timesToBeAdded.isEmpty()) throw new TimesEmpty();
            
            String date = String.valueOf(dateList.get(dateComboBox.getSelectedIndex()));
            Integer room = roomComboBox.getSelectedIndex() + 1;
            
            List<Integer> rejectedTimes = new ArrayList<>();

            for (int i = 0; i < timesToBeAdded.size(); i++) {
                if (mdao.isTimeAvailable(room, date, timesToBeAdded.get(i), mdao.getMovieById(movieId).getDuration())) {
                    Showtime showtime = new Showtime(movieId, date, timesToBeAdded.get(i), room);
                    mdao.addShowtime(showtime);
                } else {
                    rejectedTimes.add(timesToBeAdded.get(i));
                    timesToBeAdded.remove(timesToBeAdded.get(i));
                    i--;
                }
            }

            if (!rejectedTimes.isEmpty()) {
                String errorMsg = "";

                if (rejectedTimes.size() == 1) {
                    errorMsg += mdao.integerToTime(rejectedTimes.get(0)) + "\n\nwasn't";
                } else if (rejectedTimes.size() > 1) {
                    for (Integer time : rejectedTimes) {
                        errorMsg += mdao.integerToTime(time) + "\n";
                    }
                    errorMsg += "\nweren't";
                }
                JOptionPane.showMessageDialog(null,
                        errorMsg + " added due to unavailability in room " + room + ".",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

            if (!timesToBeAdded.isEmpty()) {
                String msg = "";
                if (timesToBeAdded.size() == 1) {
                    msg = " added: " + mdao.integerToTime(timesToBeAdded.get(0));
                } else if (timesToBeAdded.size() > 1) {
                    msg += "s added: ";
                    for (Integer time : timesToBeAdded) {
                        msg += mdao.integerToTime(time);
                        if (Objects.equals(time, timesToBeAdded.get(timesToBeAdded.size() - 1))) {
                            break;
                        }
                        msg += " - ";
                    }
                }
                JOptionPane.showMessageDialog(null,
                        "Movie: " + movieTitle
                        + "\nDate: " + date
                        + "\nRoom: " + room
                        + "\nTime" + msg
                        + "\n\n added!");
            }

            for (int i = 0; i < 8; i++) {
                gridLabelsQueue.get(i).setText("");
                gridItemsQueue.get(i).setVisible(false);
            }
            fieldHour.setText("");
            fieldMinutes.setText("");
        } catch (MovieNotFound e) {
            JOptionPane.showMessageDialog(null, "Movie not found", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (TimesEmpty e) {
            JOptionPane.showMessageDialog(null, "No times added", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_addShowtimesActionPerformed

    public class MovieNotFound extends NullPointerException {}
    public class TimesEmpty extends Exception {}
    
    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ScreenAddShowtime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScreenAddShowtime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScreenAddShowtime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScreenAddShowtime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ScreenAddShowtime().setVisible(true);
            }
        });
    }

    // <editor-fold defaultstate="collapsed" desc="Swing Variables">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addShowtimes;
    private javax.swing.JButton addTime;
    private javax.swing.JPanel addedShowtimes;
    private javax.swing.JComboBox<String> amPmComboBox;
    private javax.swing.JButton cancel;
    private javax.swing.JComboBox<String> dateComboBox;
    private javax.swing.JTextField fieldHour;
    private javax.swing.JTextField fieldMinutes;
    private javax.swing.JTextField fieldMovie;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JComboBox<String> roomComboBox;
    private javax.swing.JScrollPane scrollPaneMovies;
    private javax.swing.JButton search;
    // End of variables declaration//GEN-END:variables
    // </editor-fold>
}
