/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os.gas.station;

/**
 *
 * @author kareem
 */
public class Pumb extends javax.swing.JFrame {

    /**
     * Creates new form Pump
     */
    public Pumb() {
        initComponents();
        carpic.setEnabled(false);
        redlight.setEnabled(false);
        arriveL.setEnabled(false);
        this.PayingL.setEnabled(false);
        this.paypic.setEnabled(false);
        this.leavepic.setEnabled(false);
        this.leaveL.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        carpic = new javax.swing.JLabel();
        pumppic = new javax.swing.JLabel();
        paypic = new javax.swing.JLabel();
        leavepic = new javax.swing.JLabel();
        redlight = new javax.swing.JLabel();
        greenlight = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        waitL = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        carname = new javax.swing.JLabel();
        arriveL = new javax.swing.JLabel();
        servingL = new javax.swing.JLabel();
        PayingL = new javax.swing.JLabel();
        leaveL = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        carpic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/os/gas/station/picssources/rsz_car-icon.png"))); // NOI18N

        pumppic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/os/gas/station/picssources/rsz_pump.jpg"))); // NOI18N

        paypic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/os/gas/station/picssources/rsz_money-png-photos.png"))); // NOI18N

        leavepic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/os/gas/station/picssources/rsz_exit_png28.png"))); // NOI18N

        redlight.setIcon(new javax.swing.ImageIcon(getClass().getResource("/os/gas/station/picssources/rsz_red.png"))); // NOI18N

        greenlight.setIcon(new javax.swing.ImageIcon(getClass().getResource("/os/gas/station/picssources/rsz_greenlight.jpg"))); // NOI18N
        greenlight.setText("jLabel6");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Next In Queue :");

        waitL.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Car name :");

        carname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        arriveL.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        arriveL.setText("Arrive...");

        servingL.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        servingL.setText("Serveing...");

        PayingL.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PayingL.setText("Paying...");

        leaveL.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        leaveL.setText("Leaving...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(carpic)
                .addGap(51, 51, 51)
                .addComponent(pumppic)
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(paypic)
                        .addGap(47, 47, 47)
                        .addComponent(leavepic))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(waitL, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(carname, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(redlight)
                        .addGap(18, 18, 18)
                        .addComponent(greenlight, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(arriveL, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93)
                        .addComponent(servingL, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(91, 91, 91)
                .addComponent(PayingL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(leaveL)
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(waitL))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(carpic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pumppic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(leavepic, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(paypic))
                        .addGap(14, 14, 14)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(redlight))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(carname)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(greenlight, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(arriveL)
                    .addComponent(servingL, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PayingL)
                    .addComponent(leaveL))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pumb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pumb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pumb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pumb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pumb().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel PayingL;
    public javax.swing.JLabel arriveL;
    public javax.swing.JLabel carname;
    public javax.swing.JLabel carpic;
    public javax.swing.JLabel greenlight;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    public javax.swing.JLabel leaveL;
    public javax.swing.JLabel leavepic;
    public javax.swing.JLabel paypic;
    public javax.swing.JLabel pumppic;
    public javax.swing.JLabel redlight;
    public javax.swing.JLabel servingL;
    public javax.swing.JLabel waitL;
    // End of variables declaration//GEN-END:variables
}
