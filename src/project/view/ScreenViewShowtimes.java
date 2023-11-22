package project.view;

import java.time.LocalDate;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import project.core.dao.MovieDAO;
import project.core.entity.Showtime;

public class ScreenViewShowtimes extends javax.swing.JFrame {

    public ScreenViewShowtimes() {
        initComponents();
        display();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        dateComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        goBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Select Date: ");

        dateComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dateComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateComboBoxActionPerformed(evt);
            }
        });

        goBack.setText("Go back");
        goBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(goBack))
                        .addGap(0, 292, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(dateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(goBack)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    MovieDAO mdao = new MovieDAO();
    List<LocalDate> dateList = mdao.fifteenDaysList();
    List<JPanel> contentPanelList = new ArrayList<>();

    private void display() {

        int scrollWidth = jScrollPane1.getWidth();
        int panelWidth = scrollWidth - 40;

        for (LocalDate day : dateList) {
            dateComboBox.addItem(day.getDayOfWeek() + ", " + mdao.addZero(day.getMonthValue()) + "/" + mdao.addZero(day.getDayOfMonth()));

            JPanel contentPanel = new JPanel();
            List<Integer> movieIdList = mdao.getDistinctMovieIdsByDate(day);

            contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

            for (Integer id : movieIdList) {
                List<Integer[]> timesAndRooms = mdao.getTimesAndRoom(day, id);

                JPanel panel = new JPanel();
                panel.setPreferredSize(new Dimension(panelWidth, 220));
                panel.setMaximumSize(new Dimension(panelWidth, 220));
                panel.setMinimumSize(new Dimension(panelWidth, 220));
                panel.setLayout(new CustomLayoutManager());

                JLabel imgLabel = new JLabel();
                ImageIcon icon = new ImageIcon(mdao.getMovieById(id).getPoster());
                icon.setImage(icon.getImage().getScaledInstance(120, 180, 1));
                imgLabel.setIcon(icon);
                panel.add(imgLabel);

                JPanel containerPanel = new JPanel();
                containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.Y_AXIS));

                JLabel titleLabel = new JLabel("<html><div>" + mdao.getMovieById(id).getTitle() + "</div></html>");
                JLabel marginLabel = new JLabel(" ");
                JPanel showtimes = new JPanel();
                showtimes.setAlignmentX(Component.LEFT_ALIGNMENT);
                showtimes.setLayout(new GridLayout(4, 4));

                for (Integer[] pair : timesAndRooms) {
                    JPanel jTime = new JPanel();
                    jTime.setLayout(new FlowLayout());

                    JLabel timeLabel = new JLabel("<html><div "
                            + "style = '"
                            + "border: 1px solid gray;"
                            + "padding: 3px;"
                            + "background-color: rgb(250,250,250);'>"
                            + mdao.integerToTime(pair[0])
                            + "</div></html>");

                    JLabel remove = new JLabel("<html><div "
                            + "style = '"
                            + "border: 1px solid gray;"
                            + "padding: 3px 5px 3px 5px;"
                            + "background-color: rgb(250,250,250);'>"
                            + "x"
                            + "</div></html>");

                    remove.setVisible(false);
                    jTime.add(timeLabel);
                    jTime.add(remove);

                    remove.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseEntered(MouseEvent e) {
                            setCursor(Cursor.HAND_CURSOR);
                            remove.setVisible(true);
                        }

                        @Override
                        public void mouseExited(MouseEvent e) {
                            setCursor(Cursor.DEFAULT_CURSOR);
                            remove.setVisible(false);
                        }

                        @Override
                        public void mouseClicked(MouseEvent e) {
                            Showtime st = new Showtime(id, day.toString(), pair[0], pair[1]);

                            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove\n\n"
                                    + day
                                    + "\n" + mdao.getMovieById(id).getTitle()
                                    + "\n" + mdao.integerToTime(pair[0])
                                    + "\nRoom: " + pair[1]
                                    + "\n\nfrom your showtime list?", "Confirmation", JOptionPane.YES_NO_OPTION);

                            if (option == 0) {
                                mdao.removeShowtime(st);
                                JOptionPane.showMessageDialog(null, "Removal completed");
                                jTime.setVisible(false);
                                showtimes.remove(jTime);
                                showtimes.add(new JLabel());
                            } else {
                                remove.setVisible(false);
                            }
                            setCursor(Cursor.DEFAULT_CURSOR);
                        }

                    });
                    jTime.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseEntered(MouseEvent e) {
                            remove.setVisible(true);
                        }

                        @Override
                        public void mouseExited(MouseEvent e) {
                            remove.setVisible(false);
                        }
                    });

                    showtimes.add(jTime);
                }
                for (int i = 0; i < 16 - timesAndRooms.size(); i++) { //
                    JLabel space = new JLabel();
                    showtimes.add(space);
                }

                titleLabel.setFont(new Font("Segoe", Font.BOLD, 18));

                containerPanel.add(titleLabel);
                containerPanel.add(marginLabel);
                containerPanel.add(showtimes);

                panel.add(containerPanel);

                contentPanel.add(panel);
                contentPanel.revalidate();
                contentPanel.repaint();

            }
            contentPanelList.add(contentPanel);
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

    private void dateComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateComboBoxActionPerformed
        int selected = dateComboBox.getSelectedIndex();

        for (int i = 0; i < contentPanelList.size(); i++) {
            if (selected == i) {
                jScrollPane1.setViewportView(contentPanelList.get(i));
                break;
            }
        }
    }//GEN-LAST:event_dateComboBoxActionPerformed

    private void goBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackActionPerformed
        this.dispose();
    }//GEN-LAST:event_goBackActionPerformed

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
            java.util.logging.Logger.getLogger(ScreenViewShowtimes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScreenViewShowtimes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScreenViewShowtimes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScreenViewShowtimes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ScreenViewShowtimes().setVisible(true);
            }
        });
    }

    // <editor-fold defaultstate="collapsed" desc="Swing Variables">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> dateComboBox;
    private javax.swing.JButton goBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    // </editor-fold>
}
