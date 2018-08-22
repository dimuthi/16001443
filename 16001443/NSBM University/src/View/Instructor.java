/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.FacultyController;
import Controller.InstructorController;
import Controller.SubjectController;
import DTO.FacultyDTO;
import DTO.InstructorDTO;
import DTO.SubjectDTO;
import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import utilities.CustomizeTable;
import utilities.CustomizeTableHeader;

/**
 *
 * @author dimut
 */
public class Instructor extends javax.swing.JPanel {
    private int facultyLoadCount;
    private static Instructor instructor;
    private int subjectLoadCount;
    private DefaultTableModel instructorModel;

    /**
     * Creates new form Instructor2
     */
    public Instructor() {
        
        initComponents();
        setSize(2270, 1140);
        loadFaculties();
        AutoCompleteDecorator.decorate(cmbFaculty);
        AutoCompleteDecorator.decorate(cmbsubjects);
        instructorModel=(DefaultTableModel) tblinstructor.getModel();
        customizeTable();
        loadTable();
    }
     public static Instructor getInstance(){
        if(instructor==null){
            instructor=new Instructor();
        }
        return instructor;
    }
     public void setInitialStage() {
        loadFaculties();
        loadSubjectCodes();
        setSubjectName();
        loadTable();
        
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
        jLabel17 = new javax.swing.JLabel();
        cmbgender = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtfname = new javax.swing.JTextField();
        txttelephone = new javax.swing.JTextField();
        txtinsid = new javax.swing.JTextField();
        txtlname = new javax.swing.JTextField();
        txtaddress = new javax.swing.JTextField();
        pneInstructor = new javax.swing.JScrollPane();
        tblinstructor = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        cmbFaculty = new javax.swing.JComboBox();
        btnupdate = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        btnsave = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        lblsubject = new javax.swing.JLabel();
        cmbsubjects = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(2270, 1140));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        jPanel1.setLayout(null);

        jLabel17.setFont(new java.awt.Font("Bookman Old Style", 1, 22)); // NOI18N
        jLabel17.setText("INSTRUCTOR ID");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(60, 140, 209, 41);

        cmbgender.setBackground(new java.awt.Color(240, 240, 240));
        cmbgender.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        cmbgender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MALE", "FEMALE" }));
        cmbgender.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbgenderItemStateChanged(evt);
            }
        });
        cmbgender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbgenderActionPerformed(evt);
            }
        });
        jPanel1.add(cmbgender);
        cmbgender.setBounds(1070, 360, 110, 40);

        jLabel18.setFont(new java.awt.Font("Bookman Old Style", 1, 22)); // NOI18N
        jLabel18.setText("TELEPHONE");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(810, 150, 209, 41);

        jLabel19.setFont(new java.awt.Font("Bookman Old Style", 1, 22)); // NOI18N
        jLabel19.setText("FACULTY");
        jPanel1.add(jLabel19);
        jLabel19.setBounds(60, 50, 209, 41);

        jLabel20.setFont(new java.awt.Font("Bookman Old Style", 1, 22)); // NOI18N
        jLabel20.setText("GENDER");
        jPanel1.add(jLabel20);
        jLabel20.setBounds(810, 360, 209, 41);

        jLabel21.setFont(new java.awt.Font("Bookman Old Style", 1, 22)); // NOI18N
        jLabel21.setText("FIRST NAME");
        jPanel1.add(jLabel21);
        jLabel21.setBounds(60, 240, 209, 41);

        jLabel22.setFont(new java.awt.Font("Bookman Old Style", 1, 22)); // NOI18N
        jLabel22.setText("LAST NAME");
        jPanel1.add(jLabel22);
        jLabel22.setBounds(60, 340, 209, 41);

        jLabel23.setFont(new java.awt.Font("Bookman Old Style", 1, 22)); // NOI18N
        jLabel23.setText("SUBJECT NAME");
        jPanel1.add(jLabel23);
        jLabel23.setBounds(1570, 150, 209, 41);

        txtfname.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        txtfname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfnameActionPerformed(evt);
            }
        });
        jPanel1.add(txtfname);
        txtfname.setBounds(300, 240, 430, 40);

        txttelephone.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        txttelephone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelephoneActionPerformed(evt);
            }
        });
        txttelephone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttelephoneKeyReleased(evt);
            }
        });
        jPanel1.add(txttelephone);
        txttelephone.setBounds(1070, 150, 430, 40);

        txtinsid.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        txtinsid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtinsidActionPerformed(evt);
            }
        });
        txtinsid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtinsidKeyReleased(evt);
            }
        });
        jPanel1.add(txtinsid);
        txtinsid.setBounds(300, 140, 430, 40);

        txtlname.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        txtlname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtlnameActionPerformed(evt);
            }
        });
        jPanel1.add(txtlname);
        txtlname.setBounds(300, 340, 430, 40);

        txtaddress.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        txtaddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtaddressActionPerformed(evt);
            }
        });
        jPanel1.add(txtaddress);
        txtaddress.setBounds(1070, 60, 430, 40);

        tblinstructor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Instructor ID", "First Name", "Last Name", "Address", "Telephone", "Gender", "Email"
            }
        ));
        tblinstructor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblinstructorMouseClicked(evt);
            }
        });
        pneInstructor.setViewportView(tblinstructor);
        if (tblinstructor.getColumnModel().getColumnCount() > 0) {
            tblinstructor.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel1.add(pneInstructor);
        pneInstructor.setBounds(20, 640, 2210, 490);

        jLabel24.setFont(new java.awt.Font("Bookman Old Style", 1, 22)); // NOI18N
        jLabel24.setText("EMAIL");
        jPanel1.add(jLabel24);
        jLabel24.setBounds(810, 260, 209, 41);

        cmbFaculty.setBackground(new java.awt.Color(240, 240, 240));
        cmbFaculty.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        cmbFaculty.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbFacultyItemStateChanged(evt);
            }
        });
        cmbFaculty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFacultyActionPerformed(evt);
            }
        });
        jPanel1.add(cmbFaculty);
        cmbFaculty.setBounds(300, 50, 430, 40);

        btnupdate.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        btnupdate.setText("UPDATE");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnupdate);
        btnupdate.setBounds(1780, 550, 200, 50);

        btndelete.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        btndelete.setText("DELETE");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btndelete);
        btndelete.setBounds(2030, 550, 200, 50);

        btnsave.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        btnsave.setText("SAVE");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnsave);
        btnsave.setBounds(1520, 550, 200, 50);

        jLabel25.setFont(new java.awt.Font("Bookman Old Style", 1, 22)); // NOI18N
        jLabel25.setText("ADDRESS");
        jPanel1.add(jLabel25);
        jLabel25.setBounds(810, 60, 209, 41);

        jLabel26.setFont(new java.awt.Font("Bookman Old Style", 1, 22)); // NOI18N
        jLabel26.setText("SUBJECT CODE");
        jPanel1.add(jLabel26);
        jLabel26.setBounds(1570, 60, 209, 41);

        txtemail.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        txtemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtemailActionPerformed(evt);
            }
        });
        txtemail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtemailKeyReleased(evt);
            }
        });
        jPanel1.add(txtemail);
        txtemail.setBounds(1070, 260, 430, 40);

        lblsubject.setFont(new java.awt.Font("Bookman Old Style", 0, 20)); // NOI18N
        jPanel1.add(lblsubject);
        lblsubject.setBounds(1790, 150, 410, 40);

        cmbsubjects.setBackground(new java.awt.Color(240, 240, 240));
        cmbsubjects.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        cmbsubjects.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbsubjectsItemStateChanged(evt);
            }
        });
        cmbsubjects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbsubjectsActionPerformed(evt);
            }
        });
        jPanel1.add(cmbsubjects);
        cmbsubjects.setBounds(1790, 60, 430, 40);
        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(180, 792, 120, 20);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("(xxx-xxxxxxx)");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(1200, 200, 190, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3190, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 3190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1150, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbgenderItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbgenderItemStateChanged
        // if (facultyLoadCount > 0) {
            // loadTable();
            //}
    }//GEN-LAST:event_cmbgenderItemStateChanged

    private void cmbgenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbgenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbgenderActionPerformed

    private void txtfnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfnameActionPerformed

    private void txttelephoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelephoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelephoneActionPerformed

    private void txtinsidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtinsidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtinsidActionPerformed

    private void txtlnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtlnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtlnameActionPerformed

    private void txtaddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtaddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtaddressActionPerformed

    private void cmbFacultyItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbFacultyItemStateChanged
        if(facultyLoadCount>0){
            loadSubjectCodes();
            loadTable();
        }
    }//GEN-LAST:event_cmbFacultyItemStateChanged

    private void cmbFacultyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFacultyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbFacultyActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed

        if (tblinstructor.getSelectedRow() > -1){
            try {
                InstructorDTO instructorDTO=new InstructorDTO();
                instructorDTO.setInstructorID(txtinsid.getText());
                instructorDTO.setFirstName(txtfname.getText());
                instructorDTO.setLastName(txtlname.getText());
                instructorDTO.setAddress(txtaddress.getText());
                instructorDTO.setEmail(txtemail.getText());
                instructorDTO.setFacultyId(FacultyController.getFacultyId(cmbFaculty.getSelectedItem().toString()).getFacultyId());
                instructorDTO.setGender(cmbgender.getSelectedItem().toString());
                instructorDTO.setSubjectId(cmbsubjects.getSelectedItem().toString());
                instructorDTO.setTelephone(txttelephone.getText());
                boolean updated=InstructorController.updateInstructor(instructorDTO);
                if(updated){
                    loadTable();
                    clearFields();
                }
                else{
                 JOptionPane.showMessageDialog(this, "Error");
            }
                
            } catch (Exception ex) {
                Logger.getLogger(Instructor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
       if(tblinstructor.getSelectedRow()>-1){
           try {
               String id=(String) tblinstructor.getValueAt(tblinstructor.getSelectedRow(), 0);
               boolean deleted=InstructorController.deleteInstructor(id);
               if(deleted){
                   loadTable();
                   clearFields();
               }else{
                   JOptionPane.showMessageDialog(this,"Error");
               }
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(Instructor.class.getName()).log(Level.SEVERE, null, ex);
           } catch (SQLException ex) {
               Logger.getLogger(Instructor.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        if(isNotBlank()){
        try {
            InstructorDTO instructorDTO = new InstructorDTO();
            instructorDTO.setInstructorID(txtinsid.getText());
            instructorDTO.setFirstName(txtfname.getText());
            instructorDTO.setLastName(txtlname.getText());
            instructorDTO.setAddress(txtaddress.getText());
            instructorDTO.setEmail(txtemail.getText());
            instructorDTO.setFacultyId(FacultyController.getFacultyId(cmbFaculty.getSelectedItem().toString()).getFacultyId());
            instructorDTO.setGender(cmbgender.getSelectedItem().toString());
            instructorDTO.setSubjectId(cmbsubjects.getSelectedItem().toString());
            instructorDTO.setTelephone(txttelephone.getText());
            boolean b=InstructorController.addInstructor(instructorDTO);
            //System.out.println("ok");
            if(b){
                loadTable();
                clearFields();
            }else{
                JOptionPane.showMessageDialog(this, "Error");
            }

        } catch (Exception ex) {
            Logger.getLogger(Instructor.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
      
    }//GEN-LAST:event_btnsaveActionPerformed

    private void txtemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtemailActionPerformed

    private void cmbsubjectsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbsubjectsItemStateChanged
      if (subjectLoadCount > 0) {
            setSubjectName();
            loadTable();
      }
    }//GEN-LAST:event_cmbsubjectsItemStateChanged

    private void cmbsubjectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbsubjectsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbsubjectsActionPerformed

    private void txtinsidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtinsidKeyReleased
        txtinsid.setText(txtinsid.getText().toUpperCase());
       /* try {
           instructorModel.setRowCount(0);
            ArrayList<InstructorDTO> instructorDTOs=InstructorController.getAllInstructorsViaInstructorID(txtinsid.getText());
            for(InstructorDTO ins:instructorDTOs){
                Object ob[]={ins.getInstructorID(),ins.getFirstName(),ins.getLastName(),ins.getAddress(),ins.getTelephone(),ins.getGender(),ins.getEmail()};
                instructorModel.addRow(ob);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Instructor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Instructor.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
    }//GEN-LAST:event_txtinsidKeyReleased

    private void tblinstructorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblinstructorMouseClicked
       loadDataToFields();
    }//GEN-LAST:event_tblinstructorMouseClicked

    private void txttelephoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelephoneKeyReleased
        validatePhoneNumber(txttelephone);
    }//GEN-LAST:event_txttelephoneKeyReleased

    private void txtemailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtemailKeyReleased
        emailValidate(txtemail);
    }//GEN-LAST:event_txtemailKeyReleased

    private void loadFaculties(){
        try {
            facultyLoadCount=0;
            cmbFaculty.removeAllItems();
            ArrayList<FacultyDTO> facultyDTOs=FacultyController.getAllFaculties();
            for(FacultyDTO facultyDTO:facultyDTOs){
                cmbFaculty.addItem(facultyDTO.getFacultyName());
            }
            facultyLoadCount++;
        } catch (Exception ex) {
            Logger.getLogger(Instructor1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void loadSubjectCodes(){
        subjectLoadCount=0;
        SubjectDTO subjectDTO=new SubjectDTO();
        
        try {
            subjectDTO.setFacultyId(FacultyController.getFacultyId(cmbFaculty.getSelectedItem().toString()).getFacultyId());
             
            ArrayList<SubjectDTO> subjectDTOs=SubjectController.getSubjectsCodesViaFacultyId(subjectDTO);
            
           cmbsubjects.removeAllItems();
            for(SubjectDTO x:subjectDTOs){
                cmbsubjects.addItem(x.getSubjectId());
                //System.out.println("ok");
               
            }
            subjectLoadCount++;
            setSubjectName();
        } catch (Exception ex) {
            Logger.getLogger(Instructor1.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
     private void setSubjectName(){
        String subname="";
        if(cmbsubjects.getSelectedItem()!=null){
            try {
                subname=SubjectController.getRelaventSubjectNameViaCode(cmbsubjects.getSelectedItem().toString()).getSubjectName();
            } catch (Exception ex) {
                Logger.getLogger(Instructor1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            subname="";
        }
        lblsubject.setText(subname);
    }
      private void customizeTable() {
        tblinstructor.setDefaultRenderer(Object.class, new CustomizeTable());
        tblinstructor.getTableHeader().setDefaultRenderer(new CustomizeTableHeader());
        tblinstructor.setRowHeight(30);
        tblinstructor.setShowGrid(true);
        tblinstructor.setFont(new Font("", 0, 18));
        pneInstructor.getViewport().setBackground(Color.WHITE);
    }
    private void loadTable(){
        try {
            instructorModel.setRowCount(0);
            InstructorDTO instructorDTO=new InstructorDTO();
            instructorDTO.setFacultyId(FacultyController.getFacultyId(cmbFaculty.getSelectedItem().toString()).getFacultyId());
            instructorDTO.setSubjectId(SubjectController.getSubjectId(lblsubject.getText()).getSubjectId());
            ArrayList<InstructorDTO> instructorDTOs=InstructorController.getAllInstructors(instructorDTO);
            for(InstructorDTO ins:instructorDTOs){
               Object ob[]={ins.getInstructorID(),ins.getFirstName(),ins.getLastName(),ins.getAddress(),ins.getTelephone(),ins.getGender(),ins.getEmail()};
               instructorModel.addRow(ob);
            }
        } catch (Exception ex) {
            Logger.getLogger(Instructor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void loadDataToFields(){
        txtaddress.setText(tblinstructor.getValueAt(tblinstructor.getSelectedRow(), 3).toString());
        txtemail.setText(tblinstructor.getValueAt(tblinstructor.getSelectedRow(), 6).toString());
        txtfname.setText(tblinstructor.getValueAt(tblinstructor.getSelectedRow(), 1).toString());
        txtinsid.setText(tblinstructor.getValueAt(tblinstructor.getSelectedRow(), 0).toString());
        txtlname.setText(tblinstructor.getValueAt(tblinstructor.getSelectedRow(), 2).toString());
        txttelephone.setText(tblinstructor.getValueAt(tblinstructor.getSelectedRow(), 4).toString());
    }
    private boolean isNotBlank() {
        return (!txtaddress.getText().equals("") && !txtemail.getText().equals("") && !txtfname.getText().equals("") && !txtinsid.getText().equals("") && !txtlname.getText().equals("") && !txttelephone.getText().equals(""));
    }
    private void clearFields(){
        txtaddress.setText(null);
        txtemail.setText(null);
        txtfname.setText(null);
        txtinsid.setText(null);
        txtlname.setText(null);
        txttelephone.setText(null);

          
    }
     public  void emailValidate(JTextField textField) {
        String text = textField.getText();
        int caretPosition = textField.getCaretPosition();
        if (!text.matches("^[a-z]([a-z0-9]+\\.)*[a-z0-9]+@[a-z0-9]+([a-z0-9]+\\.)*(\\.[a-z0-9]+)+$")) {
            //textField.setText(textField.getText().substring(0, textField.getText ().length() - 1));
            textField.setForeground(Color.red);
        }else{
            textField.setForeground(Color.black);
        }
    }
         public  void validatePhoneNumber(JTextField textField) {
        String text = textField.getText();
        if (!text.matches("\\d{3}\\-\\d{7}")) {
            textField.setForeground(Color.red);
        }else{
            textField.setForeground(Color.black);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton btnupdate;
    private javax.swing.JComboBox cmbFaculty;
    private javax.swing.JComboBox cmbgender;
    private javax.swing.JComboBox cmbsubjects;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblsubject;
    private javax.swing.JScrollPane pneInstructor;
    private javax.swing.JTable tblinstructor;
    private javax.swing.JTextField txtaddress;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtfname;
    private javax.swing.JTextField txtinsid;
    private javax.swing.JTextField txtlname;
    private javax.swing.JTextField txttelephone;
    // End of variables declaration//GEN-END:variables
}