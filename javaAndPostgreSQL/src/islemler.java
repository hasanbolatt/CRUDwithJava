
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class islemler extends javax.swing.JFrame {

    DefaultTableModel model;
    public islemler() {
        initComponents();
        populateTable();
        
    }
    
    public void populateTable()
    {
        model = (DefaultTableModel)tblProducts.getModel();
        model.setRowCount(0);
        try {
            ArrayList<Market> urunler = getProducts();
            for(Market market : urunler)
            {
                Object[] rows = {market.getId(),
                    market.getUrun_adi(),
                    market.getUretici(),
                    market.getFiyat()};
                
                model.addRow(rows);
            }
        } catch (SQLException ex) {
            Logger.getLogger(islemler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Market> getProducts()throws SQLException
    {
        Connection connection = null;
        DbHelper helper = new DbHelper();
        Statement statement = null;
        ResultSet resultSet;
        ArrayList<Market> urunler = null;
        
        try {
            connection = helper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from urunler order by urun_id");
            urunler = new ArrayList<Market>();
            
            while(resultSet.next())
            {
                urunler.add(new Market(resultSet.getInt("urun_id"),
                resultSet.getString("urun_adi"),
                resultSet.getString("uretici"),
                resultSet.getDouble("fiyat")
                ));
            }
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        }finally{
            statement.close();
            connection.close();
        }
        
        return urunler;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblProducts = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        lblSearch = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblName1 = new javax.swing.JLabel();
        txtProducer = new javax.swing.JTextField();
        lblPrice = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        lblMessage = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();
        btnRemoveSelected = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblProducts.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ÜRÜN İD", "ÜRÜN ADI", "ÜRETİCİ", "FİYAT"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProducts);
        if (tblProducts.getColumnModel().getColumnCount() > 0) {
            tblProducts.getColumnModel().getColumn(0).setResizable(false);
            tblProducts.getColumnModel().getColumn(1).setResizable(false);
            tblProducts.getColumnModel().getColumn(2).setResizable(false);
            tblProducts.getColumnModel().getColumn(3).setResizable(false);
        }

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        lblSearch.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        lblSearch.setText("ARANACAK İFADE:");

        lblName.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        lblName.setText("ÜRÜN ADI:");

        txtName.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N

        lblName1.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        lblName1.setText("ÜRETİCİI:");

        txtProducer.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N

        lblPrice.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        lblPrice.setText("FİYATI:");

        btnAdd.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        btnAdd.setText("ÜRÜNÜ EKLE");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        lblMessage.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N

        txtPrice.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N

        lblId.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        lblId.setText("ÜRÜN İD");

        txtId.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N

        btnDelete.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        btnDelete.setText("ÜRÜNÜ SİL(İD GİREREK)");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnRemoveSelected.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        btnRemoveSelected.setText("SEÇEREK SİL");
        btnRemoveSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveSelectedActionPerformed(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        btnReset.setText("TEMİZLE");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        btnUpdate.setText("GÜNCELLE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblName1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtName)
                            .addComponent(txtProducer)
                            .addComponent(txtPrice)
                            .addComponent(txtId)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMessage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRemoveSelected, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnReset, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName1)
                    .addComponent(txtProducer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrice)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReset)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRemoveSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        String aranacak = txtSearch.getText();
        TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<DefaultTableModel>(model);
        tblProducts.setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter(aranacak));
        
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
       Connection connection = null;
       DbHelper helper = new DbHelper();
       PreparedStatement statement = null;
       
       
        try {
                connection = helper.getConnection();
                String sql = "insert into urunler values (?,?,?,?)";
                statement = connection.prepareStatement(sql);
                
                statement.setInt(1,Integer.valueOf(txtId.getText()));
                statement.setString(2,txtName.getText());
                statement.setString(3,txtProducer.getText());
                statement.setDouble(4,Double.parseDouble(txtPrice.getText()));
                int result = statement.executeUpdate();
                lblMessage.setText("Ürün başarıyla eklendi..");
                populateTable();
        } catch (SQLException exception) {
              helper.showErrorMessage(exception);
        }finally{
           try {
               statement.close();
               connection.close();
           } catch (SQLException ex) {
               System.out.println("statement ve connection kapatılamadı..");    
           }
        }   
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        Connection connection = null;
        DbHelper helper = new DbHelper();
        PreparedStatement statement = null;
        
         try {
            connection = helper.getConnection();
            String sql = "delete from urunler where urun_id =?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,Integer.parseInt(txtId.getText()));
            statement.executeUpdate();
            lblMessage.setText("Kayıt silindi..");
            populateTable();

        }catch (SQLException exception)
        {
            helper.showErrorMessage(exception);
        }finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                System.out.println("Connection ve statement kapatılamadı..");
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnRemoveSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveSelectedActionPerformed
       DefaultTableModel model =(DefaultTableModel)tblProducts.getModel();
       Connection connection = null;
       PreparedStatement statement  = null;
       DbHelper helper = new DbHelper();
       int selectedRows = tblProducts.getSelectedRow();
       
        try {
            int id = Integer.parseInt(model.getValueAt(selectedRows, 0).toString());
            connection = helper.getConnection();
            statement = connection.prepareStatement("delete from urunler where urun_id=?");
            
            statement.setInt(1, id);
            statement.executeUpdate();
            lblMessage.setText("Seçilen kayıt başarıyla silindi..");
            populateTable();
            
        } catch (SQLException exception)
        {
            helper.showErrorMessage(exception);
        }finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                System.out.println("Connection ve statement kapatılamadı..");
            }
        }
    }//GEN-LAST:event_btnRemoveSelectedActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtId.setText("");
        txtName.setText("");
        txtProducer.setText("");
        txtPrice.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
      DefaultTableModel model =(DefaultTableModel)tblProducts.getModel();
      int selectedRows = tblProducts.getSelectedRow();
      Connection connection = null;
      DbHelper helper = new DbHelper();
      PreparedStatement statement = null;
         
        try {
                int id = Integer.parseInt(model.getValueAt(selectedRows,0).toString());
                connection = helper.getConnection();
                String sql = "update urunler set urun_adi=?,uretici=?,fiyat=? where urun_id=?";
                statement = connection.prepareStatement(sql);
                
                statement.setString(1,txtName.getText());
                statement.setString(2,txtProducer.getText());
                statement.setDouble(3,Double.parseDouble(txtPrice.getText()));
                statement.setInt(4,id);
                int result = statement.executeUpdate();
                lblMessage.setText("Ürün başarıyla güncellendi..");
                populateTable();
        } catch (SQLException exception) {
              helper.showErrorMessage(exception);
        }finally{
           try {
               statement.close();
               connection.close();
           } catch (SQLException ex) {
               System.out.println("statement ve connection kapatılamadı..");    
           }
        }  
      
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tblProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductsMouseClicked
      DefaultTableModel model =(DefaultTableModel)tblProducts.getModel();
      int selectedRows = tblProducts.getSelectedRow();
      
      txtId.setText(model.getValueAt(selectedRows, 0).toString());
      txtName.setText(model.getValueAt(selectedRows, 1).toString());
      txtProducer.setText(model.getValueAt(selectedRows, 2).toString());
      txtPrice.setText(model.getValueAt(selectedRows, 3).toString());

    }//GEN-LAST:event_tblProductsMouseClicked
        
    
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new islemler().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRemoveSelected;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblName1;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JTable tblProducts;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtProducer;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
