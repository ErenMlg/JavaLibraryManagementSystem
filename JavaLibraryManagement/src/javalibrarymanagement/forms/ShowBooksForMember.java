/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javalibrarymanagement.forms;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import javalibrarymanagement.data.SingletonDataWorks;
import javalibrarymanagement.data.model.*;
import javalibrarymanagement.repository.getRepo.allGets;
import javalibrarymanagement.repository.searchRepo.AuthorSearch;
import javalibrarymanagement.repository.searchRepo.CategorySearch;
import javalibrarymanagement.repository.searchRepo.ISBNSearch;
import javalibrarymanagement.repository.searchRepo.NameSearch;
import javalibrarymanagement.repository.searchRepo.PublisherSearch;
import javalibrarymanagement.repository.searchRepo.SearchStrategy;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ShowBooksForMember extends javax.swing.JFrame {

    private final Member currentMember;
    private final allGets getsRepo = new allGets();
    private final DefaultTableModel model;
    private final DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    private ArrayList<Book> bookList = getsRepo.getAllBooks();
    private final ArrayList<Categories> allCategories = getsRepo.getAllCategories();
    private final AuthorSearch authorSearch = new AuthorSearch();
    private final CategorySearch categorySearch = new CategorySearch();
    private final ISBNSearch isbnSearch = new ISBNSearch();
    private final NameSearch nameSearch = new NameSearch();
    private final PublisherSearch publisherSearch = new PublisherSearch();
   
    public ShowBooksForMember(Member member) {
        initComponents();
        currentMember = member;
        txtWelcome.setText(currentMember.getUserName());
        model = (DefaultTableModel)tblBooks.getModel();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        tblBooks.setDefaultRenderer(String.class, centerRenderer);
        tblBooks.setDefaultRenderer(int.class, centerRenderer);
        addBooksToTable(bookList);
        for(Categories categories : allCategories){
            etCategory.addItem(categories.getCategoryName());
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBooks = new javax.swing.JTable();
        btnExit = new javax.swing.JLabel();
        txtRights = new javax.swing.JLabel();
        etISBN = new javax.swing.JTextField();
        etCategory = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        etName = new javax.swing.JTextField();
        etAuthor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        etPublisher = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1500, 600));

        jPanel2.setBackground(new java.awt.Color(102, 102, 0));
        jPanel2.setMaximumSize(new java.awt.Dimension(800, 500));
        jPanel2.setPreferredSize(new java.awt.Dimension(1500, 600));
        jPanel2.setLayout(null);

        Right.setBackground(new java.awt.Color(0, 102, 102));
        Right.setPreferredSize(new java.awt.Dimension(230, 500));

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
                .addGap(128, 128, 128)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(144, Short.MAX_VALUE))
        );

        jPanel2.add(Right);
        Right.setBounds(0, 0, 230, 600);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1270, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(1270, 600));

        txtWelcome.setFont(new java.awt.Font("Poppins", 0, 36)); // NOI18N
        txtWelcome.setForeground(new java.awt.Color(0, 102, 102));
        txtWelcome.setText("Login");

        tblBooks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ISBN", "Name", "Author", "Year", "Category", "Publisher", "Language", "Edition", "Status", "Location"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBooks.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblBooks.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblBooks);
        if (tblBooks.getColumnModel().getColumnCount() > 0) {
            tblBooks.getColumnModel().getColumn(0).setResizable(false);
            tblBooks.getColumnModel().getColumn(1).setResizable(false);
            tblBooks.getColumnModel().getColumn(2).setResizable(false);
            tblBooks.getColumnModel().getColumn(3).setResizable(false);
            tblBooks.getColumnModel().getColumn(3).setPreferredWidth(25);
            tblBooks.getColumnModel().getColumn(4).setResizable(false);
            tblBooks.getColumnModel().getColumn(4).setPreferredWidth(40);
            tblBooks.getColumnModel().getColumn(5).setResizable(false);
            tblBooks.getColumnModel().getColumn(6).setResizable(false);
            tblBooks.getColumnModel().getColumn(6).setPreferredWidth(40);
            tblBooks.getColumnModel().getColumn(7).setResizable(false);
            tblBooks.getColumnModel().getColumn(7).setPreferredWidth(25);
            tblBooks.getColumnModel().getColumn(8).setResizable(false);
            tblBooks.getColumnModel().getColumn(9).setResizable(false);
        }

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javalibrarymanagement/exit.png"))); // NOI18N

        txtRights.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txtRights.setText("Current Books");

        etISBN.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        etISBN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etISBNActionPerformed(evt);
            }
        });
        etISBN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                etISBNKeyReleased(evt);
            }
        });

        etCategory.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        etCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select For Search" }));
        etCategory.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                etCategoryİtemStateChanged(evt);
            }
        });
        etCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etCategoryActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel1.setText("ISBN");

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel3.setText("Category");

        etName.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        etName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                etNameKeyReleased(evt);
            }
        });

        etAuthor.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        etAuthor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                etAuthorKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel4.setText("Author");

        etPublisher.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        etPublisher.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                etPublisherKeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel7.setText("Publisher");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javalibrarymanagement/back.png"))); // NOI18N

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javalibrarymanagement/borrow.png"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 969, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(157, 157, 157))
                            .addComponent(etISBN)
                            .addComponent(etName)
                            .addComponent(etCategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(etAuthor)
                            .addComponent(etPublisher)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtRights)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtWelcome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)))
                        .addComponent(btnExit)))
                .addGap(38, 38, 38))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(txtWelcome))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel8)))
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addComponent(txtRights)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(etISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(etName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(etCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(etAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(etPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel1);
        jPanel1.setBounds(230, 0, 1270, 600);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void etCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_etCategoryActionPerformed

    private void etISBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etISBNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_etISBNActionPerformed

    private void etISBNKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_etISBNKeyReleased
        etAuthor.setText("");
        etPublisher.setText("");
        etCategory.setSelectedIndex(0);
        etName.setText("");
        bookList = isbnSearch.search(etISBN.getText());
        model.setRowCount(0);
        addBooksToTable(bookList);
    }//GEN-LAST:event_etISBNKeyReleased

    private void etAuthorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_etAuthorKeyReleased
        etPublisher.setText("");
        etISBN.setText("");
        etCategory.setSelectedIndex(0);
        etName.setText("");
        bookList = authorSearch.search(etAuthor.getText());
        model.setRowCount(0);
        addBooksToTable(bookList);
    }//GEN-LAST:event_etAuthorKeyReleased

    private void etPublisherKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_etPublisherKeyReleased
        etAuthor.setText("");
        etISBN.setText("");
        etCategory.setSelectedIndex(0);
        etName.setText("");
        bookList = publisherSearch.search(etPublisher.getText());
        model.setRowCount(0);
        addBooksToTable(bookList);
    }//GEN-LAST:event_etPublisherKeyReleased

    private void etNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_etNameKeyReleased
        etAuthor.setText("");
        etISBN.setText("");
        etCategory.setSelectedIndex(0);
        etPublisher.setText("");
        bookList = nameSearch.search(etName.getText());
        model.setRowCount(0);
        addBooksToTable(bookList);
    }//GEN-LAST:event_etNameKeyReleased

    private void etCategoryİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_etCategoryİtemStateChanged
        if(etCategory.getSelectedItem() == "Select For Search"){          
            bookList = categorySearch.search("");
        }else{
            etAuthor.setText("");
            etISBN.setText("");
            etName.setText("");
            etPublisher.setText("");
            bookList = categorySearch.search(evt.getItem().toString());
        }
        model.setRowCount(0);
        addBooksToTable(bookList);
    }//GEN-LAST:event_etCategoryİtemStateChanged

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
      int selectedRow = tblBooks.getSelectedRow();
        System.out.println();
      Book newBook = new Book(
        (String)tblBooks.getValueAt(selectedRow, 0),
        (String)tblBooks.getValueAt(selectedRow, 1),
        (String)tblBooks.getValueAt(selectedRow, 2),
        (String)tblBooks.getValueAt(selectedRow, 3),
        (String)tblBooks.getValueAt(selectedRow, 4),
        (String)tblBooks.getValueAt(selectedRow, 5),
        (String)tblBooks.getValueAt(selectedRow, 6),
        (int)tblBooks.getValueAt(selectedRow, 7),
        (String)tblBooks.getValueAt(selectedRow, 8),
        (String)tblBooks.getValueAt(selectedRow, 9)
      );
      new BorrowBook(newBook, currentMember).setVisible(true);
      this.setVisible(false);
      this.dispose();
    }//GEN-LAST:event_jLabel9MouseClicked

    private Object[] mapSearchedBooks(Book searchedElement){
         Object[] row = {
                searchedElement.getBookISBN(),
                searchedElement.getBookName(),
                searchedElement.getAuthor(),
                searchedElement.getPublicationYear(),
                searchedElement.getCategoryName(),
                searchedElement.getPublisherName(),
                searchedElement.getPublicationLanguage(),
                searchedElement.getBookEdition(),
                searchedElement.getStatus(),
                searchedElement.getLocation()
            };
         return row;
    }
    
    private void addBooksToTable(ArrayList<Book> bookList){
        for(Book book:bookList){
            Object[] row = mapSearchedBooks(book);
            model.addRow(row);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Right;
    private javax.swing.JLabel btnExit;
    private javax.swing.JTextField etAuthor;
    private javax.swing.JComboBox<String> etCategory;
    private javax.swing.JTextField etISBN;
    private javax.swing.JTextField etName;
    private javax.swing.JTextField etPublisher;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBooks;
    private javax.swing.JLabel txtRights;
    private javax.swing.JLabel txtWelcome;
    // End of variables declaration//GEN-END:variables
}
