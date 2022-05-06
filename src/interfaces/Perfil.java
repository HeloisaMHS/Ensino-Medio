package interfaces;
import bd.BDusuario;
import classes.Usuario;
import java.awt.Color;
import javax.swing.JOptionPane;
/*
 * @author Maria Heloisa Souza
*/
public class Perfil extends javax.swing.JFrame 
{
    String nome="",email="", senha="";
    public Perfil(String nome,String email,String senha)
    {  
        this.nome=nome;
        this.email=email;
        this.senha=senha;
        initComponents();
        Color vinho = new Color(66,0,0);
        this.getContentPane().setBackground(vinho);
        this.setLocationRelativeTo(null);
    }
    private Perfil() 
    {
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel = new javax.swing.JPanel();
        imgPer = new javax.swing.JLabel();
        jlPer = new javax.swing.JLabel();
        jlSexo = new javax.swing.JLabel();
        jlDatanas = new javax.swing.JLabel();
        jbCancelar = new javax.swing.JButton();
        jbCadastrar = new javax.swing.JButton();
        cbSexo = new javax.swing.JComboBox<>();
        cbDia = new javax.swing.JComboBox<>();
        cbAno = new javax.swing.JComboBox<>();
        jlDia = new javax.swing.JLabel();
        jlMes = new javax.swing.JLabel();
        jlAno = new javax.swing.JLabel();
        cbMes1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Perfil");
        setBackground(new java.awt.Color(66, 0, 0));
        setPreferredSize(new java.awt.Dimension(910, 519));

        painel.setBackground(new java.awt.Color(255, 255, 255));
        painel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(77, 51, 25), 6));

        imgPer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/icons8-usuário-100 (3).png"))); // NOI18N

        jlPer.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jlPer.setForeground(new java.awt.Color(66, 0, 0));
        jlPer.setText("Perfil");

        jlSexo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlSexo.setForeground(new java.awt.Color(66, 0, 0));
        jlSexo.setText("Sexo:");

        jlDatanas.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlDatanas.setForeground(new java.awt.Color(66, 0, 0));
        jlDatanas.setText("Data de nascimento:");

        jbCancelar.setBackground(new java.awt.Color(153, 102, 51));
        jbCancelar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jbCancelar.setForeground(new java.awt.Color(255, 255, 255));
        jbCancelar.setLabel("Cancelar");
        jbCancelar.setMaximumSize(new java.awt.Dimension(97, 25));
        jbCancelar.setMinimumSize(new java.awt.Dimension(97, 25));
        jbCancelar.setPreferredSize(new java.awt.Dimension(97, 25));
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jbCadastrar.setBackground(new java.awt.Color(153, 102, 51));
        jbCadastrar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jbCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        jbCadastrar.setText("Confirmar");
        jbCadastrar.setToolTipText("");
        jbCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrarActionPerformed(evt);
            }
        });

        cbSexo.setBackground(new java.awt.Color(153, 102, 51));
        cbSexo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cbSexo.setForeground(new java.awt.Color(66, 0, 0));
        cbSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Feminino", "Masculino", "Não Informar" }));

        cbDia.setBackground(new java.awt.Color(153, 102, 51));
        cbDia.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cbDia.setForeground(new java.awt.Color(66, 0, 0));
        cbDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        cbAno.setBackground(new java.awt.Color(153, 102, 51));
        cbAno.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cbAno.setForeground(new java.awt.Color(66, 0, 0));
        cbAno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019" }));

        jlDia.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlDia.setForeground(new java.awt.Color(66, 0, 0));
        jlDia.setText("Dia");

        jlMes.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlMes.setForeground(new java.awt.Color(66, 0, 0));
        jlMes.setText("Mês");

        jlAno.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlAno.setForeground(new java.awt.Color(66, 0, 0));
        jlAno.setText("Ano");

        cbMes1.setBackground(new java.awt.Color(153, 102, 51));
        cbMes1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cbMes1.setForeground(new java.awt.Color(66, 0, 0));
        cbMes1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelLayout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(jlPer))
                    .addGroup(painelLayout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jlSexo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jlDatanas))
                            .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(painelLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jlDia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbCadastrar))
                            .addGroup(painelLayout.createSequentialGroup()
                                .addComponent(cbDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(jlMes)
                                .addGap(12, 12, 12)
                                .addComponent(cbMes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jlAno)
                                .addGap(6, 6, 6)
                                .addComponent(cbAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(78, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(imgPer)
                .addGap(141, 141, 141))
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(imgPer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlPer, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlSexo)
                    .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlDatanas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlDia)
                    .addComponent(jlMes)
                    .addComponent(jlAno)
                    .addComponent(cbMes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(jbCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(245, 245, 245)
                .addComponent(painel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(261, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(painel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        PainelPrincipal p = new PainelPrincipal();
        p.setVisible(true);
        dispose();
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrarActionPerformed
        String sexo="";
        String dia="",mes="",ano="";
        
        sexo=cbSexo.getSelectedItem().toString();
         dia = cbDia.getSelectedItem().toString();
         mes = cbMes1.getSelectedItem().toString();
         ano = cbAno.getSelectedItem().toString();
         if (dia!="" || mes!="" || ano!="" )
         {
             Usuario objUsuario = new Usuario(nome,email,senha,sexo,dia, mes,ano);
             BDusuario objBD = new BDusuario();

            if ( objBD.insereUsuarios(objUsuario) )
            {
                 JOptionPane.showMessageDialog(rootPane, "Dados gravados com sucesso",
                    "Confirmação de cadastro", JOptionPane.INFORMATION_MESSAGE);
                 dispose(); // Fecho o Frame atual
            } 
            else 
            {
                 JOptionPane.showMessageDialog(rootPane, "Usuário já existente.",
                    "Alerta de erro", JOptionPane.ERROR_MESSAGE);
            }
            PainelPrincipal p = new PainelPrincipal();
            p.setVisible(true);
            p.setLocationRelativeTo(null);
            dispose();
         }
         else
             JOptionPane.showMessageDialog(rootPane,"Algum campo vazio!");
         
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
            java.util.logging.Logger.getLogger(Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Perfil().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbAno;
    private javax.swing.JComboBox<String> cbDia;
    private javax.swing.JComboBox<String> cbMes1;
    private javax.swing.JComboBox<String> cbSexo;
    private javax.swing.JLabel imgPer;
    private javax.swing.JButton jbCadastrar;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JLabel jlAno;
    private javax.swing.JLabel jlDatanas;
    private javax.swing.JLabel jlDia;
    private javax.swing.JLabel jlMes;
    private javax.swing.JLabel jlPer;
    private javax.swing.JLabel jlSexo;
    private javax.swing.JPanel painel;
    // End of variables declaration//GEN-END:variables
}
