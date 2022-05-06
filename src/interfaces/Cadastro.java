package interfaces;
import classes.Usuario;
import java.awt.Color;
import javax.swing.JOptionPane;
import bd.BDusuario;
/*
 * @author Maria Heloisa Souza
*/
public class Cadastro extends javax.swing.JFrame
{

    public Cadastro() 
    {
        initComponents();
        Color vinho = new Color(66,0,0);
        this.getContentPane().setBackground(vinho);
        this.setLocationRelativeTo(null);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel = new javax.swing.JPanel();
        imgCad = new javax.swing.JLabel();
        jlCad = new javax.swing.JLabel();
        jlNome = new javax.swing.JLabel();
        jtNome = new javax.swing.JTextField();
        jtEmail = new javax.swing.JTextField();
        jlEmail = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jpSenha = new javax.swing.JPasswordField();
        jbCancelar = new javax.swing.JButton();
        jbCadastrar = new javax.swing.JButton();

        setTitle("Cadastro");
        setBackground(new java.awt.Color(66, 0, 0));
        setPreferredSize(new java.awt.Dimension(910, 519));

        painel.setBackground(new java.awt.Color(255, 255, 255));
        painel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(77, 51, 25), 6));

        imgCad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/icons8-usuário-100 (1).png"))); // NOI18N

        jlCad.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jlCad.setForeground(new java.awt.Color(66, 0, 0));
        jlCad.setText("Cadastro");

        jlNome.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlNome.setForeground(new java.awt.Color(66, 0, 0));
        jlNome.setText("Nome completo:");

        jtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtEmailActionPerformed(evt);
            }
        });

        jlEmail.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlEmail.setForeground(new java.awt.Color(66, 0, 0));
        jlEmail.setText("Email:");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(66, 0, 0));
        jLabel1.setText("Senha:");

        jpSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpSenhaActionPerformed(evt);
            }
        });

        jbCancelar.setBackground(new java.awt.Color(153, 102, 51));
        jbCancelar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jbCancelar.setForeground(new java.awt.Color(255, 255, 255));
        jbCancelar.setLabel("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jbCadastrar.setBackground(new java.awt.Color(153, 102, 51));
        jbCadastrar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jbCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        jbCadastrar.setText("Cadastrar");
        jbCadastrar.setToolTipText("");
        jbCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(painelLayout.createSequentialGroup()
                                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtEmail)
                                    .addComponent(jpSenha)))
                            .addGroup(painelLayout.createSequentialGroup()
                                .addComponent(jlNome)
                                .addGap(2, 2, 2)
                                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                                    .addGroup(painelLayout.createSequentialGroup()
                                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jlCad)
                                            .addComponent(imgCad))
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(painelLayout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jbCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(jbCadastrar)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgCad, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlCad, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCancelar)
                    .addComponent(jbCadastrar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(painel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(200, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(103, Short.MAX_VALUE)
                .addComponent(painel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtEmailActionPerformed

    private void jpSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jpSenhaActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrarActionPerformed
        String nome="",email="", senha="";
        nome= jtNome.getText();
        email = jtEmail.getText();
        senha = new String(jpSenha.getPassword());
        Perfil objperfil= new Perfil(nome, email,senha);
        objperfil.setVisible(true);
        dispose();
                                       
    }//GEN-LAST:event_jbCadastrarActionPerformed

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
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cadastro().setVisible(true);
            }
        });
        
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel imgCad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jbCadastrar;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JLabel jlCad;
    private javax.swing.JLabel jlEmail;
    private javax.swing.JLabel jlNome;
    private javax.swing.JPasswordField jpSenha;
    private javax.swing.JTextField jtEmail;
    private javax.swing.JTextField jtNome;
    private javax.swing.JPanel painel;
    // End of variables declaration//GEN-END:variables
}
