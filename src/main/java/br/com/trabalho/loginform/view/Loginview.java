package br.com.trabalho.loginform.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import com.autenticator.DefaultAuthenticationService;
import com.autenticator.DefaultSessionManager;
import com.autenticator.PasswordEncryptor;
import com.autenticator.SHA256PasswordEncryptor;
import com.autenticator.SessionManager;
import com.autenticator.AbstractAuthenticationService;
import com.autenticator.Database.DatabaseUserDAO;
import com.autenticator.Database.UserDAO;
import com.autenticator.Users.NewUser;

/**
 *
 * @author Sarah Nogueira
 * @author Ellen Sampaio
 */
public class Loginview extends javax.swing.JFrame {

    private javax.swing.JTextField jTextField1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JButton jButtonEntrar;
    private javax.swing.JButton jButtonCadastro;
    private javax.swing.JLabel jLabel2;
    private AbstractAuthenticationService authenticationService;
    private NewUser newUserHandler;
    /**
     * Creates new form Loginview
     */
    public Loginview() {
        initComponents();
        PasswordEncryptor passwordEncryptor = new SHA256PasswordEncryptor();
        SessionManager sessionManager = new DefaultSessionManager();
        UserDAO userDAO = new DatabaseUserDAO();
        authenticationService = new DefaultAuthenticationService(userDAO, sessionManager, passwordEncryptor);
        newUserHandler = new NewUser(userDAO, authenticationService); // Inicializando newUserHandler
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    //@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jButtonEntrar = new javax.swing.JButton();
        jButtonCadastro = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 350, 370, 50));

        jPasswordField1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 460, 370, 50));

        jButtonEntrar.setContentAreaFilled(false);
        jButtonEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEntrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonEntrarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 530, 240, 70));

        jButtonCadastro.setContentAreaFilled(false);
        jButtonCadastro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCadastro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonCadastroActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 640, 170, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/TelaLogin.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 1185, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCadastroActionPerformed(java.awt.event.ActionEvent evt) {
        String username = jTextField1.getText();
        String password = String.valueOf(jPasswordField1.getPassword());
        String email = ""; // adicione o email aqui
        String phoneNumber = ""; // adicione o número de telefone aqui

        // Verificando se o usuário já existe
        if (authenticationService.getAuthenticatedUser() != null) {
            JOptionPane.showMessageDialog(Loginview.this, "Usuário já existe!");
            return;
        }
        // Chame o método registerUser da classe NewUser para registrar o novo usuário
        newUserHandler.registerUser(username, password, email, phoneNumber, "user");
        JOptionPane.showMessageDialog(this, "Novo usuário registrado com sucesso!");
        
        
    }

    private void jButtonEntrarActionPerformed(java.awt.event.ActionEvent evt) {
        String username = jTextField1.getText();
        String password = String.valueOf(jPasswordField1.getPassword());

        if (authenticationService.authenticate(username, password)) {
            JOptionPane.showMessageDialog(Loginview.this, "Autenticação bem-sucedida!");
            dispose();
        } else {
            JOptionPane.showMessageDialog(Loginview.this, "Falha na autenticação!");
        }
    }

    

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
            java.util.logging.Logger.getLogger(Loginview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Loginview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Loginview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Loginview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Loginview().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}