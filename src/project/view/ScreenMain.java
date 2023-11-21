package project.view;

public class ScreenMain extends javax.swing.JFrame {

    public ScreenMain() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jLabel1 = new javax.swing.JLabel();
        movieComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        showtimeComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("CineJava");

        movieComboBox.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        movieComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Add Movie", "View Movies", "Remove Movie" }));
        movieComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movieComboBoxActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Manage Movies");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Manage Showtime");

        showtimeComboBox.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        showtimeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "View showtimes", "Add showtime" }));
        showtimeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showtimeComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(showtimeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(movieComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(movieComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showtimeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    ScreenAddMovie addMovie = null;
    ScreenViewMovies viewMovies = null;
    ScreenRemoveMovie removeMovie = null;
    ScreenViewShowtimes viewShowtimes = null;
    ScreenAddShowtime addShowtime = null;
    
    private void movieComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movieComboBoxActionPerformed
        switch (movieComboBox.getSelectedIndex()) {
            case 0:
                if (addMovie == null || !addMovie.isVisible()) {
                    addMovie = new ScreenAddMovie();
                    addMovie.setVisible(true);
                }
                break;
            case 1:
                if (viewMovies == null || !viewMovies.isVisible()) {
                    viewMovies = new ScreenViewMovies();
                    viewMovies.setVisible(true);
                }
                break;
            case 2:
                if (removeMovie == null || !removeMovie.isVisible()) {
                    removeMovie = new ScreenRemoveMovie();
                    removeMovie.setVisible(true);
                }
                break;
            default:
                throw new AssertionError();
        }
    }//GEN-LAST:event_movieComboBoxActionPerformed

    private void showtimeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showtimeComboBoxActionPerformed
        switch (showtimeComboBox.getSelectedIndex()) {
            case 0:
                if (viewShowtimes == null || !viewShowtimes.isVisible()) {
                    viewShowtimes = new ScreenViewShowtimes();
                    viewShowtimes.setVisible(true);
                }
                break;
            case 1:
                if (addShowtime == null || !addShowtime.isVisible()) {
                    addShowtime = new ScreenAddShowtime();
                    addShowtime.setVisible(true);
                }
                break;
            default:
                throw new AssertionError();
        }
    }//GEN-LAST:event_showtimeComboBoxActionPerformed

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
            java.util.logging.Logger.getLogger(ScreenMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScreenMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScreenMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScreenMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ScreenMain().setVisible(true);
            }
        });
    }
    
    // <editor-fold defaultstate="collapsed" desc="Swing Variables">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JComboBox<String> movieComboBox;
    private javax.swing.JComboBox<String> showtimeComboBox;
    // End of variables declaration//GEN-END:variables
    // </editor-fold>
}
