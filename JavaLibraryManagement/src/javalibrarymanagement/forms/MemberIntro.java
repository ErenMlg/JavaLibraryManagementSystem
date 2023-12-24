
package javalibrarymanagement.forms;

import java.sql.Statement;
import java.sql.ResultSet;
import javalibrarymanagement.data.SingletonDataWorks;
import javalibrarymanagement.data.model.*;
import javax.swing.table.DefaultTableModel;

public class MemberIntro extends javax.swing.JFrame {
    
    private Member currentMember;
    private Statement statement;
    private ResultSet results;
    private DefaultTableModel model;

    public MemberIntro(Member member) {
        initComponents();
        currentMember = member;
        txtRights.setText("Current Books & Avaible Right : "+member.getMemberCurrentRight());
        txtWelcome.setText(currentMember.getUserName());
        statement = SingletonDataWorks.getStatement();
        model = (DefaultTableModel)tblCurrentBooks.getModel();
        try{
            results = statement.executeQuery("SELECT bi.bookISBN, b.bookName, bi.issueStatus, bi.issueDate, bi.returnDate, CONCAT(l.librarianName, ' ', l.librarianSurname) AS librarianName, CONCAT(a.authorName, ' ', a.authorLastName) AS authorName FROM library_management_system.book_issue bi JOIN library_management_system.book b ON bi.bookISBN = b.bookISBN JOIN library_management_system.member m ON bi.memberID = m.memberID JOIN library_management_system.librarian l ON bi.librarianID = l.librarianID JOIN library_management_system.book_author ba ON ba.bookISBN = bi.bookISBN JOIN library_management_system.author a ON ba.authorID = a.authorID WHERE bi.memberID='"+member.getUserID()+"'");
            while(results.next()){
                Object[] row = {
                    results.getString("bookISBN"),
                    results.getString("bookName"),
                    results.getString("authorName"),
                    results.getString("librarianName"),
                    results.getString("issueStatus"),
                    results.getString("issueDate"),
                    results.getString("returnDate")
                };
                model.addRow(row);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        Right = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtWelcome = new javax.swing.JLabel();
        btnShowBooks = new javax.swing.JButton();
        btnShowProfile = new javax.swing.JButton();
        btnEventCalendar = new javax.swing.JButton();
        btnShowAnnouncements = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCurrentBooks = new javax.swing.JTable();
        btnExit = new javax.swing.JLabel();
        txtRights = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(800, 500));
        jPanel2.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel2.setLayout(null);

        Right.setBackground(new java.awt.Color(0, 102, 102));
        Right.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javalibrarymanagement/library.png"))); // NOI18N
        jLabel5.setText("jLabel5");

        jLabel6.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Library Management System");

        javax.swing.GroupLayout RightLayout = new javax.swing.GroupLayout(Right);
        Right.setLayout(RightLayout);
        RightLayout.setHorizontalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        RightLayout.setVerticalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        jPanel2.add(Right);
        Right.setBounds(0, 0, 230, 500);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(400, 500));

        txtWelcome.setFont(new java.awt.Font("Poppins", 0, 36)); // NOI18N
        txtWelcome.setForeground(new java.awt.Color(0, 102, 102));
        txtWelcome.setText("Login");

        btnShowBooks.setBackground(new java.awt.Color(0, 102, 102));
        btnShowBooks.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        btnShowBooks.setForeground(new java.awt.Color(255, 255, 255));
        btnShowBooks.setText("Show Books");
        btnShowBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowBooksActionPerformed(evt);
            }
        });

        btnShowProfile.setBackground(new java.awt.Color(0, 102, 102));
        btnShowProfile.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        btnShowProfile.setForeground(new java.awt.Color(255, 255, 255));
        btnShowProfile.setText("Book Request");

        btnEventCalendar.setBackground(new java.awt.Color(0, 102, 102));
        btnEventCalendar.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        btnEventCalendar.setForeground(new java.awt.Color(255, 255, 255));
        btnEventCalendar.setText("Event Calendar");

        btnShowAnnouncements.setBackground(new java.awt.Color(0, 102, 102));
        btnShowAnnouncements.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        btnShowAnnouncements.setForeground(new java.awt.Color(255, 255, 255));
        btnShowAnnouncements.setText("Announcements");

        tblCurrentBooks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ISBN", "Name", "Author", "Librarian", "Status", "Borrowing Date", "Return Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCurrentBooks);
        if (tblCurrentBooks.getColumnModel().getColumnCount() > 0) {
            tblCurrentBooks.getColumnModel().getColumn(0).setResizable(false);
            tblCurrentBooks.getColumnModel().getColumn(1).setResizable(false);
            tblCurrentBooks.getColumnModel().getColumn(2).setResizable(false);
            tblCurrentBooks.getColumnModel().getColumn(3).setResizable(false);
            tblCurrentBooks.getColumnModel().getColumn(4).setResizable(false);
            tblCurrentBooks.getColumnModel().getColumn(5).setResizable(false);
            tblCurrentBooks.getColumnModel().getColumn(6).setResizable(false);
        }

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javalibrarymanagement/exit.png"))); // NOI18N

        txtRights.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txtRights.setText("Current Books & Avaible Right : ?");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(txtWelcome)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btnShowProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnEventCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(btnShowBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnShowAnnouncements, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtRights))
                .addGap(36, 36, 36))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtWelcome)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txtRights)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnShowBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnShowAnnouncements, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnShowProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEventCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        jPanel2.add(jPanel1);
        jPanel1.setBounds(231, 0, 570, 506);

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

    private void btnShowBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowBooksActionPerformed
             new ShowBooksForMember(currentMember).setVisible(true);
             this.setVisible(false);
             this.dispose();
    }//GEN-LAST:event_btnShowBooksActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Right;
    private javax.swing.JButton btnEventCalendar;
    private javax.swing.JLabel btnExit;
    private javax.swing.JButton btnShowAnnouncements;
    private javax.swing.JButton btnShowBooks;
    private javax.swing.JButton btnShowProfile;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCurrentBooks;
    private javax.swing.JLabel txtRights;
    private javax.swing.JLabel txtWelcome;
    // End of variables declaration//GEN-END:variables
}
