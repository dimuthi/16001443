/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.DegreeController;
import Controller.FacultyController;
import Controller.LecturerController;
import Controller.SemesterController;
import Controller.SubjectController;
import DTO.DegreeDTO;
import DTO.FacultyDTO;
import DTO.LecturerDTO;
import DTO.SemesterDTO;
import DTO.SubjectDTO;
import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import utilities.CustomizeTable;
import utilities.CustomizeTableHeader;

/**
 *
 * @author dimut
 */
public class Subjects extends javax.swing.JPanel {

    private static Subjects subjects;
    private DefaultTableModel mdlSubject;
    private int facultyLoadCount;
    private int semesterLoadCount;
    private int lecturerLoadCount;
    private int coursesLoadCount;

    /**
     * Creates new form Subjects
     */
    private Subjects() {
        initComponents();
        this.setSize(2270, 1140);
        mdlSubject = (DefaultTableModel) tblesubjects.getModel();
        AutoCompleteDecorator.decorate(cmbLecName);
        AutoCompleteDecorator.decorate(cmbSemester);
        AutoCompleteDecorator.decorate(cmboCourse);
        customizeSubjectsTable();
    }

    public static Subjects getInstance() {
        if (subjects == null) {
            subjects = new Subjects();
        }
        return subjects;
    }

    public void setInitialStage() {
        loadFaculties();
        loadCourses();
        loadLecturers();
        loadSemesters();
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

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtcredits = new javax.swing.JTextField();
        txtsubcode = new javax.swing.JTextField();
        txtfee = new javax.swing.JTextField();
        txtsubname = new javax.swing.JTextField();
        btnsave = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        pneSubjects = new javax.swing.JScrollPane();
        tblesubjects = new javax.swing.JTable();
        btnupdate = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cmbLecName = new javax.swing.JComboBox<String>();
        jLabel7 = new javax.swing.JLabel();
        cmbFaculty = new javax.swing.JComboBox<String>();
        jLabel8 = new javax.swing.JLabel();
        cmbSemester = new javax.swing.JComboBox<String>();
        jLabel9 = new javax.swing.JLabel();
        cmboCourse = new javax.swing.JComboBox();
        lblLecturerId = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(2206, 1035));
        setLayout(null);

        jLabel2.setFont(new java.awt.Font("Bookman Old Style", 1, 22)); // NOI18N
        jLabel2.setText("DEGREE");
        add(jLabel2);
        jLabel2.setBounds(950, 240, 99, 44);

        jLabel3.setFont(new java.awt.Font("Bookman Old Style", 1, 22)); // NOI18N
        jLabel3.setText("CREDITS");
        add(jLabel3);
        jLabel3.setBounds(20, 340, 185, 44);

        jLabel4.setFont(new java.awt.Font("Bookman Old Style", 1, 22)); // NOI18N
        jLabel4.setText("SUBJECT CODE");
        add(jLabel4);
        jLabel4.setBounds(20, 240, 210, 44);

        jLabel5.setFont(new java.awt.Font("Bookman Old Style", 1, 22)); // NOI18N
        jLabel5.setText("FACULTY");
        add(jLabel5);
        jLabel5.setBounds(20, 60, 230, 44);

        txtcredits.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        add(txtcredits);
        txtcredits.setBounds(260, 340, 160, 40);

        txtsubcode.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        txtsubcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsubcodeActionPerformed(evt);
            }
        });
        txtsubcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsubcodeKeyReleased(evt);
            }
        });
        add(txtsubcode);
        txtsubcode.setBounds(260, 240, 400, 40);

        txtfee.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        add(txtfee);
        txtfee.setBounds(260, 430, 270, 40);

        txtsubname.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        txtsubname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsubnameActionPerformed(evt);
            }
        });
        add(txtsubname);
        txtsubname.setBounds(1290, 330, 520, 40);

        btnsave.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        btnsave.setText("SAVE");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });
        add(btnsave);
        btnsave.setBounds(1460, 550, 222, 49);

        btndelete.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        btndelete.setText("DELETE");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });
        add(btndelete);
        btndelete.setBounds(1720, 550, 222, 49);

        tblesubjects.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblesubjects.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sub Code", "Degree", "Subject Name", "Lecturer", "Credits", "Fee"
            }
        ));
        tblesubjects.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblesubjectsMouseClicked(evt);
            }
        });
        pneSubjects.setViewportView(tblesubjects);
        if (tblesubjects.getColumnModel().getColumnCount() > 0) {
            tblesubjects.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblesubjects.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblesubjects.getColumnModel().getColumn(3).setPreferredWidth(150);
            tblesubjects.getColumnModel().getColumn(4).setPreferredWidth(5);
            tblesubjects.getColumnModel().getColumn(5).setPreferredWidth(5);
        }

        add(pneSubjects);
        pneSubjects.setBounds(20, 630, 2230, 490);

        btnupdate.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        btnupdate.setText("UPDATE");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });
        add(btnupdate);
        btnupdate.setBounds(1980, 550, 222, 49);

        jLabel6.setFont(new java.awt.Font("Bookman Old Style", 1, 22)); // NOI18N
        jLabel6.setText("FEE");
        add(jLabel6);
        jLabel6.setBounds(20, 430, 90, 44);

        cmbLecName.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        cmbLecName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbLecNameActionPerformed(evt);
            }
        });
        add(cmbLecName);
        cmbLecName.setBounds(1290, 160, 560, 40);

        jLabel7.setFont(new java.awt.Font("Bookman Old Style", 1, 22)); // NOI18N
        jLabel7.setText("LECTURER ID");
        add(jLabel7);
        jLabel7.setBounds(950, 80, 210, 44);

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
        add(cmbFaculty);
        cmbFaculty.setBounds(260, 60, 400, 40);

        jLabel8.setFont(new java.awt.Font("Bookman Old Style", 1, 22)); // NOI18N
        jLabel8.setText("SUBJECT NAME");
        add(jLabel8);
        jLabel8.setBounds(950, 330, 186, 44);

        cmbSemester.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        cmbSemester.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbSemesterItemStateChanged(evt);
            }
        });
        add(cmbSemester);
        cmbSemester.setBounds(260, 150, 270, 40);

        jLabel9.setFont(new java.awt.Font("Bookman Old Style", 1, 22)); // NOI18N
        jLabel9.setText("SEMESTER");
        add(jLabel9);
        jLabel9.setBounds(20, 150, 133, 44);

        cmboCourse.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        cmboCourse.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmboCourseItemStateChanged(evt);
            }
        });
        add(cmboCourse);
        cmboCourse.setBounds(1290, 240, 330, 40);

        lblLecturerId.setFont(new java.awt.Font("Bookman Old Style", 0, 20)); // NOI18N
        add(lblLecturerId);
        lblLecturerId.setBounds(1290, 80, 550, 40);

        jLabel10.setFont(new java.awt.Font("Bookman Old Style", 1, 22)); // NOI18N
        jLabel10.setText("LECTURER NAME");
        add(jLabel10);
        jLabel10.setBounds(950, 160, 210, 44);
    }// </editor-fold>//GEN-END:initComponents

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        if (isNotBlank()) {
            try {
                SubjectDTO subjectDTO = new SubjectDTO();
                subjectDTO.setFacultyId(FacultyController.getFacultyId(cmbFaculty.getSelectedItem().toString()).getFacultyId());
                subjectDTO.setSubjectId(txtsubcode.getText());
                subjectDTO.setDegreeId(DegreeController.getDegreeId(cmboCourse.getSelectedItem().toString()).getDegreeid());
                subjectDTO.setSubjectName(txtsubname.getText());
                subjectDTO.setSemesterid(SemesterController.getSemesterId(cmbSemester.getSelectedItem().toString()).getSemesterid());
                subjectDTO.setCredits(Integer.parseInt(txtcredits.getText()));
                subjectDTO.setFee(Double.parseDouble(txtfee.getText()));
                subjectDTO.setLecturerID(lblLecturerId.getText());

                boolean addSubject = SubjectController.addSubject(subjectDTO);
                if (addSubject) {
                   
                    //JOptionPane.showMessageDialog(this, "Success");
                    loadTable();
                } else {
                    JOptionPane.showMessageDialog(this, "Error");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Subjects.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Subjects.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(Subjects.class.getName()).log(Level.SEVERE, null, ex);
            }
            clearFields();
        }
    }//GEN-LAST:event_btnsaveActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        if (isNotBlank()) {
            try {
                boolean deleteSubject = SubjectController.deleteSubject(txtsubcode.getText());
                if (deleteSubject) {
                    loadTable();
                } else {
                    JOptionPane.showMessageDialog(this, "Error");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Subjects.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Subjects.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(Subjects.class.getName()).log(Level.SEVERE, null, ex);
            }
            clearFields();
        }
    }//GEN-LAST:event_btndeleteActionPerformed

    private void tblesubjectsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblesubjectsMouseClicked
        if (mdlSubject.getRowCount() > 0) {
            if (tblesubjects.getSelectedRow() > -1) {
                loadDataToFields();
            }
        }
    }//GEN-LAST:event_tblesubjectsMouseClicked

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        if (isNotBlank()) {
            try {
                SubjectDTO subjectDTO = new SubjectDTO();
                subjectDTO.setFacultyId(FacultyController.getFacultyId(cmbFaculty.getSelectedItem().toString()).getFacultyId());
                subjectDTO.setSubjectId(txtsubcode.getText());
                subjectDTO.setDegreeId(DegreeController.getDegreeId(cmboCourse.getSelectedItem().toString()).getDegreeid());
                subjectDTO.setSubjectName(txtsubname.getText());
                subjectDTO.setSemesterid(SemesterController.getSemesterId(cmbSemester.getSelectedItem().toString()).getSemesterid());
                subjectDTO.setCredits(Integer.parseInt(txtcredits.getText()));
                subjectDTO.setFee(Double.parseDouble(txtfee.getText()));
                subjectDTO.setLecturerID(LecturerController.getLecturerId(cmbLecName.getSelectedItem().toString()).getLecturerID());
                boolean updateSubject = SubjectController.updateSubject(subjectDTO);
                if (updateSubject) {
                    loadTable();
                } else {
                    JOptionPane.showMessageDialog(this, "Error");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Subjects.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Subjects.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(Subjects.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        clearFields();
    }//GEN-LAST:event_btnupdateActionPerformed

    private void cmbSemesterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbSemesterItemStateChanged
        if (semesterLoadCount > 0) {
            loadTable();
        }
    }//GEN-LAST:event_cmbSemesterItemStateChanged

    private void txtsubcodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsubcodeKeyReleased
        txtsubcode.setText(txtsubcode.getText().toUpperCase());
    }//GEN-LAST:event_txtsubcodeKeyReleased

    private void cmboCourseItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmboCourseItemStateChanged
        if (coursesLoadCount > 0) {
            loadTable();
        }
    }//GEN-LAST:event_cmboCourseItemStateChanged

    private void cmbFacultyItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbFacultyItemStateChanged
        loadLecturers();
        if (facultyLoadCount > 0) {
            loadTable();
        }
    }//GEN-LAST:event_cmbFacultyItemStateChanged

    private void txtsubcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsubcodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsubcodeActionPerformed

    private void cmbFacultyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFacultyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbFacultyActionPerformed

    private void cmbLecNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbLecNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbLecNameActionPerformed

    private void txtsubnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsubnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsubnameActionPerformed

    /*Check whether textfields are empty*/
    private boolean isNotBlank() {
        return (!txtcredits.getText().equals("") && !txtfee.getText().equals("") && !txtsubcode.getText().equals("") && !txtsubname.getText().equals(""));
    }

    /*Set save button enable*/
    public void setSaveEnable() {
        btnsave.setEnabled(true);
    }

    /*Set save button disable*/
    public void setSaveDisable() {
        btnsave.setEnabled(false);
    }

    /*Set lecturer on subject via lecturer section*/
    public void setLecturerDetails(ArrayList<String> text) {
        cmbFaculty.setSelectedItem(text.get(0));
        cmbLecName.setSelectedItem(text.get(1));
        lblLecturerId.setText(text.get(2));
    }

    /*Load table using faculty id,semester id,degree id*/
    private void loadTable() {
        try {
            mdlSubject.setRowCount(0);
            SubjectDTO subjectDTo = new SubjectDTO();
            subjectDTo.setFacultyId(FacultyController.getFacultyId(cmbFaculty.getSelectedItem().toString()).getFacultyId());
            subjectDTo.setSemesterid(SemesterController.getSemesterId(cmbSemester.getSelectedItem().toString()).getSemesterid());
            subjectDTo.setDegreeId(DegreeController.getDegreeId(cmboCourse.getSelectedItem().toString()).getDegreeid());
            ArrayList<SubjectDTO> allSubject = SubjectController.getAllSubject(subjectDTo);
            for (SubjectDTO subjectDTO : allSubject) {
                Object[] ob = {subjectDTO.getSubjectId(), subjectDTO.getDegreeName(), subjectDTO.getSubjectName(), subjectDTO.getLecturerName(), subjectDTO.getCredits(), subjectDTO.getFee()};
                mdlSubject.addRow(ob);
            }
        } catch (Exception ex) {
            Logger.getLogger(Subjects.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /*Clear textfields*/
    private void clearFields() {
        txtsubcode.setText(null);
        txtsubname.setText(null);
        txtcredits.setText(null);
        txtfee.setText(null);
    }

    /*Load data to textfields*/
    private void loadDataToFields() {
        try {
            txtsubcode.setText(tblesubjects.getValueAt(tblesubjects.getSelectedRow(), 0).toString());
            cmboCourse.setSelectedItem(tblesubjects.getValueAt(tblesubjects.getSelectedRow(), 1).toString());
            txtsubname.setText(tblesubjects.getValueAt(tblesubjects.getSelectedRow(), 2).toString());
            cmbLecName.setSelectedItem(tblesubjects.getValueAt(tblesubjects.getSelectedRow(), 3).toString());
            lblLecturerId.setText(LecturerController.getLecturerId(tblesubjects.getValueAt(tblesubjects.getSelectedRow(), 3).toString()).getLecturerID());
            txtcredits.setText(tblesubjects.getValueAt(tblesubjects.getSelectedRow(), 4).toString());
            txtfee.setText(tblesubjects.getValueAt(tblesubjects.getSelectedRow(), 5).toString());
        } catch (Exception ex) {
            Logger.getLogger(Subjects.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*Load faculties to combo box*/
    private void loadFaculties() {
        try {
            facultyLoadCount = 0;
            ArrayList<FacultyDTO> allFaculties = FacultyController.getAllFaculties();
            cmbFaculty.removeAllItems();
            for (FacultyDTO faculty : allFaculties) {
                cmbFaculty.addItem(faculty.getFacultyName());
            }
            facultyLoadCount++;
        } catch (Exception ex) {
            Logger.getLogger(Lecturer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*Load semesters to combo box*/
    private void loadSemesters() {
        try {
            semesterLoadCount = 0;
            ArrayList<SemesterDTO> semesterDTOs = SemesterController.getAllSemesters();
            cmbSemester.removeAllItems();
            for (SemesterDTO semesterDTO : semesterDTOs) {
                cmbSemester.addItem(semesterDTO.getSemesterName());
            }
            semesterLoadCount++;
        } catch (Exception ex) {
            Logger.getLogger(Lecturer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*Load lecturers to combo box*/
    private void loadLecturers() {
        try {
            lecturerLoadCount = 0;
            if (cmbFaculty.getSelectedItem() != null) {
                ArrayList<LecturerDTO> lecturersViaFaculty = LecturerController.getLecturersViaFaculty(FacultyController.getFacultyId(cmbFaculty.getSelectedItem().toString()).getFacultyId());
                cmbLecName.removeAllItems();
                for (LecturerDTO lecturerDTO : lecturersViaFaculty) {
                    cmbLecName.addItem(lecturerDTO.getLecturerName());
                }
                lecturerLoadCount++;
            }
        } catch (Exception ex) {
            Logger.getLogger(Subjects.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*Load courses to combo box*/
    private void loadCourses() {
        try {
            coursesLoadCount = 0;
            ArrayList<DegreeDTO> degreeNamesViaFaculty = DegreeController.getDegreeNamesViaFaculty(FacultyController.getFacultyId(cmbFaculty.getSelectedItem().toString()).getFacultyId());
            cmboCourse.removeAllItems();
            for (DegreeDTO degreeDTO : degreeNamesViaFaculty) {
                cmboCourse.addItem(degreeDTO.getDegreeName());
            }
            coursesLoadCount++;
        } catch (Exception ex) {
            Logger.getLogger(StudentRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    /*Customize Table*/
    private void customizeSubjectsTable() {
        tblesubjects.setDefaultRenderer(Object.class, new CustomizeTable());
        tblesubjects.getTableHeader().setDefaultRenderer(new CustomizeTableHeader());
        tblesubjects.setRowHeight(30);
        tblesubjects.setShowGrid(true);
        tblesubjects.setFont(new Font("", 0, 18));
        pneSubjects.getViewport().setBackground(Color.WHITE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton btnupdate;
    private javax.swing.JComboBox<String> cmbFaculty;
    private javax.swing.JComboBox<String> cmbLecName;
    private javax.swing.JComboBox<String> cmbSemester;
    private javax.swing.JComboBox cmboCourse;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblLecturerId;
    private javax.swing.JScrollPane pneSubjects;
    private javax.swing.JTable tblesubjects;
    private javax.swing.JTextField txtcredits;
    private javax.swing.JTextField txtfee;
    private javax.swing.JTextField txtsubcode;
    private javax.swing.JTextField txtsubname;
    // End of variables declaration//GEN-END:variables

}
