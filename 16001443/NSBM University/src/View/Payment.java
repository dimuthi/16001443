/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.PaymentController;
import DTO.PaymentDTO;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utilities.CustomizeTable;
import utilities.CustomizeTableHeader;

/**
 *
 * @author dimut
 */
public class Payment extends javax.swing.JPanel {

    private static Payment payment;
    private DefaultTableModel mdlPayment;

    /**
     * Creates new form Payment
     */
    public Payment() {
        initComponents();
        setSize(2270, 1140);
        mdlPayment = (DefaultTableModel) tblPayments.getModel();
        customizeSubjectsTable();
    }

    public static Payment getInstance() {
        if (payment == null) {
            payment = new Payment();
        }
        return payment;
    }

    public void setInitialStage() {

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pnePayments = new javax.swing.JScrollPane();
        tblPayments = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lblPaymentId = new javax.swing.JLabel();
        txtPaymentId = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtPayingAmount = new javax.swing.JTextField();
        lblTotalFee = new javax.swing.JLabel();
        lblAmountToPay = new javax.swing.JLabel();
        lblSemRegId = new javax.swing.JLabel();
        lblStudentName = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(2206, 1035));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        jLabel2.setText("STUDENT NAME");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(40, 200, 220, 40);

        jLabel3.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        jLabel3.setText("PAYMENT ID");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(40, 20, 400, 40);

        jLabel6.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        jLabel6.setText("AMOUNT TO PAY");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(40, 380, 280, 40);

        tblPayments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Payment ID", "Total Fee", "Paid", "Date"
            }
        ));
        tblPayments.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPaymentsMouseClicked(evt);
            }
        });
        pnePayments.setViewportView(tblPayments);

        jPanel1.add(pnePayments);
        pnePayments.setBounds(20, 660, 2220, 450);

        jLabel7.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        jLabel7.setText("TOTAL FEE");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(40, 290, 160, 40);

        btnSave.setFont(new java.awt.Font("Bookman Old Style", 1, 22)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnSave);
        btnSave.setBounds(1360, 570, 222, 49);

        btnUpdate.setFont(new java.awt.Font("Bookman Old Style", 1, 22)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpdate);
        btnUpdate.setBounds(1650, 570, 222, 49);

        btnDelete.setFont(new java.awt.Font("Bookman Old Style", 1, 22)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete);
        btnDelete.setBounds(1940, 570, 222, 49);

        jLabel4.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        jLabel4.setText("SEMESTER REGISTRATION ID");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(40, 100, 400, 40);

        lblPaymentId.setFont(new java.awt.Font("Bookman Old Style", 0, 20)); // NOI18N
        jPanel1.add(lblPaymentId);
        lblPaymentId.setBounds(600, 20, 320, 40);

        txtPaymentId.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        jPanel1.add(txtPaymentId);
        txtPaymentId.setBounds(920, 20, 80, 40);

        jLabel8.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        jLabel8.setText("PAYING AMOUNT");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(40, 490, 280, 40);

        txtPayingAmount.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        jPanel1.add(txtPayingAmount);
        txtPayingAmount.setBounds(600, 490, 320, 40);

        lblTotalFee.setFont(new java.awt.Font("Bookman Old Style", 0, 20)); // NOI18N
        jPanel1.add(lblTotalFee);
        lblTotalFee.setBounds(600, 290, 320, 40);

        lblAmountToPay.setFont(new java.awt.Font("Bookman Old Style", 0, 20)); // NOI18N
        jPanel1.add(lblAmountToPay);
        lblAmountToPay.setBounds(600, 380, 320, 40);

        lblSemRegId.setFont(new java.awt.Font("Bookman Old Style", 0, 20)); // NOI18N
        jPanel1.add(lblSemRegId);
        lblSemRegId.setBounds(600, 100, 460, 40);

        lblStudentName.setFont(new java.awt.Font("Bookman Old Style", 0, 20)); // NOI18N
        jPanel1.add(lblStudentName);
        lblStudentName.setBounds(600, 200, 450, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 2270, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1140, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            if (isNotBlank()) {
                PaymentDTO paymentDTO = new PaymentDTO();
                paymentDTO.setPaymentId(lblPaymentId.getText() + txtPaymentId.getText());
                paymentDTO.setSemesterRegistrationId(lblSemRegId.getText());
                paymentDTO.setTotalAmount(Double.parseDouble(lblTotalFee.getText()));
                paymentDTO.setAmountToPay(Double.parseDouble(txtPayingAmount.getText()));
                boolean addPayment = PaymentController.addPayment(paymentDTO);
                if (addPayment) {
                    loadTable();
                    calculateAmount();
                }else{
                    JOptionPane.showMessageDialog(this, "Error");
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            if (tblPayments.getSelectedRow() > -1 && isNotBlank()) {
                boolean deletePayment = PaymentController.deletePayment(tblPayments.getValueAt(tblPayments.getSelectedRow(), 0).toString());
                if (deletePayment) {
                    loadTable();
                    calculateAmount();
                }else{
                    JOptionPane.showMessageDialog(this, "Error");
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            if (tblPayments.getSelectedRow() > -1 && isNotBlank()) {
                PaymentDTO paymentDTO = new PaymentDTO();
                paymentDTO.setPaymentId(tblPayments.getValueAt(tblPayments.getSelectedRow(), 0).toString());
                paymentDTO.setSemesterRegistrationId(lblSemRegId.getText());
                paymentDTO.setTotalAmount(Double.parseDouble(lblTotalFee.getText()));
                paymentDTO.setAmountToPay(Double.parseDouble(txtPayingAmount.getText()));
                boolean addPayment = PaymentController.updatePayment(paymentDTO);
                if (addPayment) {
                    loadTable();
                    calculateAmount();
                }else{
                    JOptionPane.showMessageDialog(this, "Error");
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tblPaymentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPaymentsMouseClicked
        String[] splitId = tblPayments.getValueAt(tblPayments.getSelectedRow(), 0).toString().split("" + lblPaymentId.getText() + "\\.?");
        txtPaymentId.setText(splitId[1]);
        txtPayingAmount.setText(tblPayments.getValueAt(tblPayments.getSelectedRow(), 2).toString());
    }//GEN-LAST:event_tblPaymentsMouseClicked

    /*Check whether the textfields are empty*/
    private boolean isNotBlank() {
        return (!txtPayingAmount.getText().equals("") && !txtPaymentId.getText().equals(""));
    }

    /*Load data to table via semester registration id*/
    private void loadTable() {
        try {
            ArrayList<PaymentDTO> paymentsViaSemRegId = PaymentController.getPaymentsViaSemRegId(lblSemRegId.getText());
            mdlPayment.setRowCount(0);
            for (PaymentDTO paymentDTO : paymentsViaSemRegId) {
                Object[] ob = {paymentDTO.getPaymentId(), paymentDTO.getTotalAmount(), paymentDTO.getAmountToPay(), paymentDTO.getDate()};
                mdlPayment.addRow(ob);
            }
        } catch (Exception ex) {
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*Set save button enable*/
    public void setSaveEnable() {
        btnSave.setEnabled(true);
    }

    /*Set save button disable*/
    public void setSaveDisable() {
        btnSave.setEnabled(false);
    }

    /*Set student on payment via semester registration section*/
    public void setPaymentDetails(ArrayList<String> text) {
        lblSemRegId.setText(text.get(0));
        lblStudentName.setText(text.get(1));
        lblPaymentId.setText("P" + lblSemRegId.getText());
        lblTotalFee.setText(text.get(2));
        loadTable();
        calculateAmount();
    }

    /*Calculate amounts in table and get the amount to pay*/
    private void calculateAmount() {
        double amountToPay = 0;
        for (int i = 0; i < tblPayments.getRowCount(); i++) {
            amountToPay += Double.parseDouble(tblPayments.getValueAt(i, 2).toString());
        }
        amountToPay = Double.parseDouble(lblTotalFee.getText()) - amountToPay;
        lblAmountToPay.setText(amountToPay + "");
    }

    /*Load data to textfields*/
    private void loadDataToFields() {
        lblPaymentId.setText(tblPayments.getValueAt(tblPayments.getSelectedRow(), 0).toString());
        lblSemRegId.setText(tblPayments.getValueAt(tblPayments.getSelectedRow(), 1).toString());
        lblTotalFee.setText(tblPayments.getValueAt(tblPayments.getSelectedRow(), 2).toString());
        lblAmountToPay.setText(tblPayments.getValueAt(tblPayments.getSelectedRow(), 3).toString());
    }

    /*Customize Table*/
    private void customizeSubjectsTable() {
        tblPayments.setDefaultRenderer(Object.class, new CustomizeTable());
        tblPayments.getTableHeader().setDefaultRenderer(new CustomizeTableHeader());
        tblPayments.setRowHeight(30);
        tblPayments.setShowGrid(true);
        tblPayments.setFont(new Font("", 0, 18));
        pnePayments.getViewport().setBackground(Color.WHITE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAmountToPay;
    private javax.swing.JLabel lblPaymentId;
    private javax.swing.JLabel lblSemRegId;
    private javax.swing.JLabel lblStudentName;
    private javax.swing.JLabel lblTotalFee;
    private javax.swing.JScrollPane pnePayments;
    private javax.swing.JTable tblPayments;
    private javax.swing.JTextField txtPayingAmount;
    private javax.swing.JTextField txtPaymentId;
    // End of variables declaration//GEN-END:variables
}
