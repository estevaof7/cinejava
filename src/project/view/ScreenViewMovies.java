package project.view;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import java.util.List;
import project.core.dao.MovieDAO;
import project.core.entity.Movie;

public class ScreenViewMovies extends javax.swing.JFrame {

    public ScreenViewMovies() {
        initComponents();
        display();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        goBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        fieldSearch = new javax.swing.JTextField();
        search = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        goBack.setText("Go Back");
        goBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBackActionPerformed(evt);
            }
        });

        fieldSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                letraEscrita(evt);
            }
        });

        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(goBack)
                            .addComponent(fieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fieldSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(goBack)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //<editor-fold defaultstate="collapsed" desc="Variables">
    JPanel contentPanel;
    MovieDAO mdao = new MovieDAO();
    List<Movie> movies = mdao.movieList();
    List<JPanel> panelList = new ArrayList<>();
    List<String> results = mdao.titles(movies);
    List<char[]> charNames = mdao.charArrayMovies(movies);
    //</editor-fold>

    private void display() {
        contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(contentPanel);

        for (Movie movie : movies) {            
            JPanel panel = new JPanel();
            panel.setPreferredSize(new Dimension(jScrollPane1.getWidth() - 40, 220));
            panel.setMaximumSize(new Dimension(jScrollPane1.getWidth(), 220));
            panel.setMinimumSize(new Dimension(jScrollPane1.getWidth(), 220));
            panel.setLayout(new CustomLayoutManager());
            panelList.add(panel);

            JLabel imgLabel = new JLabel();
            ImageIcon icon = new ImageIcon(movie.getPoster());
            icon.setImage(icon.getImage().getScaledInstance(120, 180, 1));
            imgLabel.setIcon(icon);
            panel.add(imgLabel);

            JPanel containerPanel = new JPanel();
            containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.Y_AXIS));

            JLabel titleLabel = new JLabel("<html><div>" + movie.getTitle() + "</div></html>");
            JLabel marginLabel = new JLabel(" ");
            JLabel durationLabel = new JLabel("Duration: " + movie.getDuration() + " minutes");

            titleLabel.setFont(new Font("Segoe", Font.BOLD, 18));
            durationLabel.setFont(new Font("Segoe", Font.PLAIN, 12));

            containerPanel.add(titleLabel);
            containerPanel.add(marginLabel);
            containerPanel.add(durationLabel);

            panel.add(containerPanel);

            contentPanel.add(panel);
            contentPanel.revalidate();
            contentPanel.repaint();
        }
    }
    class CustomLayoutManager implements LayoutManager {

        @Override
        public void addLayoutComponent(String name, Component comp) {
        }
        @Override
        public void removeLayoutComponent(Component comp) {
        }
        @Override
        public Dimension preferredLayoutSize(Container parent) {
            return new Dimension(0, 0);
        }
        @Override
        public Dimension minimumLayoutSize(Container parent) {
            return new Dimension(0, 0);
        }
        @Override
        public void layoutContainer(Container parent) {
            Component[] components = parent.getComponents();

            if (components.length != 2) {
                return;
            }

            int parentHeight = parent.getHeight();
            
            int y = Math.max(0, (parentHeight - 180) / 2); //To centralize leftLabel vertically

            components[0].setBounds(20, y, 120, 180); //leftLabel will be vertically centralized

            int width = parent.getWidth() - 200;
            components[1].setBounds(120 + 40, y, width, 180); //rightLabel will get the rest of the width
        }
    }

    private void goBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackActionPerformed
        this.dispose();
    }//GEN-LAST:event_goBackActionPerformed

    private void letraEscrita(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_letraEscrita
        mdao.search(fieldSearch, results, movies, panelList, charNames);
    }//GEN-LAST:event_letraEscrita

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        if (results.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Movie not found", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_searchActionPerformed

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
            java.util.logging.Logger.getLogger(ScreenViewMovies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScreenViewMovies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScreenViewMovies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScreenViewMovies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ScreenViewMovies().setVisible(true);
            }
        });
    }
    
    // <editor-fold defaultstate="collapsed" desc="Swing Variables">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fieldSearch;
    private javax.swing.JButton goBack;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton search;
    // End of variables declaration//GEN-END:variables
    // </editor-fold>
}
