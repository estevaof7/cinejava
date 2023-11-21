package project.view;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import project.core.dao.MovieDAO;
import project.core.entity.Movie;

public class ScreenRemoveMovie extends javax.swing.JFrame {

    public ScreenRemoveMovie() {
        initComponents();
        display();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fieldSearch = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setSize(new java.awt.Dimension(600, 400));

        fieldSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                writtenLetter(evt);
            }
        });

        search.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        search.setText("Search Movie");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        remove.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        remove.setText("Remove");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });

        cancel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Select movies that will be removed");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(remove))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(search)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(remove)
                    .addComponent(cancel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //<editor-fold defaultstate="collapsed" desc="Variables">
    JPanel contentPanel;
    List<JCheckBox> boxList = new ArrayList<>();
    List<JPanel> panelList = new ArrayList<>();
    MovieDAO mdao = new MovieDAO();
    List<Movie> movies = mdao.movieList();
    List<String> results = mdao.titles(movies);
    List<char[]> charNames = mdao.charArrayMovies(movies);
    //</editor-fold>

    private void addEventListener(JCheckBox box, int index) {
        box.addItemListener(new CheckBoxItemListener(index));
    }
    class CheckBoxItemListener implements ItemListener {

        CheckBoxItemListener(int index) {
            this.index = index;
        }

        int index;

        @Override
        public void itemStateChanged(ItemEvent e) {
            JCheckBox box = (JCheckBox) e.getItem();
            if (box.isSelected()) {
                panelList.get(index).setBackground(new Color(255, 150, 150));
            } else {
                panelList.get(index).setBackground(null);
            }
        }

    }
    private void display() {
        contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(contentPanel);

        for (Movie movie : movies) {
            JPanel panel = new JPanel();
            panel.setPreferredSize(new Dimension(jScrollPane1.getWidth() - 40, 30));
            panel.setMaximumSize(new Dimension(jScrollPane1.getWidth(), 30));
            panel.setMinimumSize(new Dimension(jScrollPane1.getWidth(), 30));
            panel.setLayout(new CustomLayoutManager());

            JLabel title = new JLabel(movie.getTitle());
            title.setFont(new Font("Segoe", Font.BOLD, 12));
            JCheckBox box = new JCheckBox();

            panel.add(title);
            panel.add(box);

            panelList.add(panel);
            boxList.add(box);
            addEventListener(box, boxList.indexOf(box));

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
            int parentWidth = parent.getWidth();

            components[0].setBounds(10, 0, parentWidth - 60, parentHeight);

            components[1].setBounds(parentWidth - 50, 0, 50, parentHeight);
        }
    }

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        if (results.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Movie not found", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_searchActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        String moviesToBeRemoved = "";
        List<String> moviesToBeRemovedList = new ArrayList<>();

        for (int i = 0; i < panelList.size(); i++) {
            if (boxList.get(i).isSelected()) {
                moviesToBeRemovedList.add(movies.get(i).getTitle());
                moviesToBeRemoved += movies.get(i).getTitle() + "\n";
            }
        }

        if (moviesToBeRemovedList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No movies selected");
        } else {
            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove\n\n" 
                    + moviesToBeRemoved 
                    + "\nfrom your database?", "Confirmation", JOptionPane.YES_NO_OPTION);

            if (option == 0) {
                for (String movie : moviesToBeRemovedList) {
                    for (Movie m : movies) {
                        if (movie.equals(m.getTitle())) {
                            mdao.removeMovie(m);
                        }
                    }
                }
                dispose();
            }
        }
    }//GEN-LAST:event_removeActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void writtenLetter(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_writtenLetter
        mdao.search(fieldSearch, results, movies, panelList, charNames);
    }//GEN-LAST:event_writtenLetter

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
            java.util.logging.Logger.getLogger(ScreenRemoveMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScreenRemoveMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScreenRemoveMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScreenRemoveMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ScreenRemoveMovie().setVisible(true);
            }
        });

    }
    
    // <editor-fold defaultstate="collapsed" desc="Swing Variables">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JTextField fieldSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton remove;
    private javax.swing.JButton search;
    // End of variables declaration//GEN-END:variables
    // </editor-fold>
}
