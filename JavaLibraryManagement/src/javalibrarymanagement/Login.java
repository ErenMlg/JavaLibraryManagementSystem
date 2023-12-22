/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javalibrarymanagement;
import javalibrarymanagement.data.SingletonDataWorks;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javalibrarymanagement.data.model.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    static Login login = new Login();
    Statement state;
    ResultSet result;
    
    public Login() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(102, 102, 102));
        state = SingletonDataWorks.getStatement();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        Right = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        etUsername = new javax.swing.JTextField();
        etPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        slctUserType = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));
        setMinimumSize(new java.awt.Dimension(800, 500));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(800, 500));
        jPanel2.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel2.setLayout(null);

        Right.setBackground(new java.awt.Color(0, 102, 102));
        Right.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\erenm\\Desktop\\Desktop\\Dersler\\YM\\Odev\\LibraryManagementSystem\\JavaLibraryManagementSystem\\JavaLibraryManagement\\library.png")); // NOI18N
        jLabel5.setText("jLabel5");

        jLabel6.setFont(new java.awt.Font("Poppins", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Library Management System");

        javax.swing.GroupLayout RightLayout = new javax.swing.GroupLayout(Right);
        Right.setLayout(RightLayout);
        RightLayout.setHorizontalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RightLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RightLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel6)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        RightLayout.setVerticalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addContainerGap(163, Short.MAX_VALUE))
        );

        jPanel2.add(Right);
        Right.setBounds(0, 0, 400, 500);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(400, 500));

        jLabel1.setFont(new java.awt.Font("Poppins", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Login");

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel2.setText("Username");

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel3.setText("Password");

        etUsername.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N

        etPassword.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        etPassword.setHighlighter(null);

        btnLogin.setBackground(new java.awt.Color(0, 102, 102));
        btnLogin.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel4.setText("User Type");

        slctUserType.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        slctUserType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Student", "Academician", "Library" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(etPassword)
                        .addComponent(etUsername)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(slctUserType, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jLabel1)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(etUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(etPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(slctUserType, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );

        jPanel2.add(jPanel1);
        jPanel1.setBounds(400, 0, 400, 506);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        String userName = etUsername.getText();
        String password = etPassword.getText();
        String userType = slctUserType.getSelectedItem().toString();
        String memberType;
        Member enteredMember;
        try{
            if(userType == "Academician"){
                result = state.executeQuery("SELECT m.memberID, m.memberName, m.memberSurname, m.memberPhone, m.memberAdress, m.memberMail, m.memberUserName, m.memberPassword, d.departmantName, b.bookLimit, a.title FROM library_management_system.member m JOIN library_management_system.academician a ON m.memberID = a.memberID LEFT JOIN library_management_system.departmant d ON m.departmantID = d.departmantID LEFT JOIN library_management_system.book_limit b ON m.bookLimitID = b.bookLimitID WHERE m.memberUserName = '"+userName+"'  AND m.memberPassword = '"+password+"';");
                if(result.next()){
                enteredMember = new Academician(
                            result.getString("memberID"),
                            result.getString("memberName"),
                            result.getString("memberSurname"),
                            result.getString("memberPhone"),
                            result.getString("memberAdress"),
                            result.getString("memberMail"),
                            result.getString("memberUsername"),
                            result.getString("departmantName"),
                            result.getInt("bookLimit"),  
                            result.getString("title")                        
                    );
                System.out.println("Kullanıcı bulundu akademisyen");
                new MemberIntro(enteredMember).setVisible(true);
                login.setVisible(false);
                login.dispose();
                }else{
                JOptionPane.showMessageDialog(new JFrame(), "Invalid username or password", "Login Error",JOptionPane.ERROR_MESSAGE);
                etUsername.setText("");
                etPassword.setText("");
            }  
            }else if(userType == "Student"){
                result = state.executeQuery("SELECT m.memberID, m.memberName, m.memberSurname, m.memberPhone, m.memberAdress, m.memberMail, m.memberUserName, m.memberPassword, d.departmantName, b.bookLimit, s.grade, s.studentNumber FROM library_management_system.member m JOIN library_management_system.student s ON m.memberID = s.memberID LEFT JOIN library_management_system.departmant d ON m.departmantID = d.departmantID LEFT JOIN library_management_system.book_limit b ON m.bookLimitID = b.bookLimitID WHERE m.memberUserName = '"+userName+"'  AND m.memberPassword = '"+password+"';");
                if(result.next()){
                    enteredMember = new Student(
                        result.getString("memberID"),
                        result.getString("memberName"),
                        result.getString("memberSurname"),
                        result.getString("memberPhone"),
                        result.getString("memberAdress"),
                        result.getString("memberMail"),
                        result.getString("memberUsername"),
                        result.getString("departmantName"),
                        result.getInt("bookLimit"),  
                        result.getInt("grade"),
                        result.getString("studentNumber")
                    );
                    System.out.println("Kullanıcı bulundu öğrenci");
                    new MemberIntro(enteredMember).setVisible(true);    
                    login.setVisible(false);
                    login.dispose();
                }else{
                JOptionPane.showMessageDialog(new JFrame(), "Invalid username or password", "Login Error",JOptionPane.ERROR_MESSAGE);
                etUsername.setText("");
                etPassword.setText("");
                }           
            }    
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnLoginActionPerformed


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                login.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Right;
    private javax.swing.JButton btnLogin;
    private javax.swing.JPasswordField etPassword;
    private javax.swing.JTextField etUsername;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JComboBox<String> slctUserType;
    // End of variables declaration//GEN-END:variables
}
