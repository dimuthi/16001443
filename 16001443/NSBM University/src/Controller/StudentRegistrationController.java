/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DTO.AllRegistrationDTO;
import DTO.SemesterRegistrationDTO;
import DTO.StudentRegistrationDTO;
import Model.PostgraduateDetailsModel;
import Model.StudentRegistrationModel;
import Model.UndergraduateDetailsModel;
import db.DBConnection;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Imalka Gunawardana
 */
public class StudentRegistrationController {

    private static Connection connection;
    private static StudentRegistrationModel studentRegistrationModel = new StudentRegistrationModel();
    private static UndergraduateDetailsModel undergraduateDetailsModel = new UndergraduateDetailsModel();
    private static PostgraduateDetailsModel postgraduateDetailsModel = new PostgraduateDetailsModel();

    public static boolean addStudentRegistration(AllRegistrationDTO allRegistrationDTO) throws Exception {
        try {
            connection = DBConnection.getDBConnection().getConnection();
            connection.setAutoCommit(false);
            boolean addStudentRegistration = studentRegistrationModel.addStudentRegistration(allRegistrationDTO.getRegistrationDTO());
            if (addStudentRegistration) {
                String graduationType = allRegistrationDTO.getRegistrationDTO().getGraduationType();
                if (graduationType.equals("UG")) {
                    boolean addUndergraduateDetails = undergraduateDetailsModel.addUndergraduateDetails(allRegistrationDTO.getUndergraduateDetailsDTO());
                    if (addUndergraduateDetails) {
                        connection.commit();
                        return true;
                    }
                } else {
                    boolean addPostgraduateDetails = postgraduateDetailsModel.addPostgraduateDetails(allRegistrationDTO.getPostgraduateDetailsDTO());
                    if (addPostgraduateDetails) {
                        connection.commit();
                        return true;
                    }
                }
            }
            connection.rollback();
            return false;
        } finally {
            connection.setAutoCommit(true);
        }
    }

    public static boolean deleteStudentRegistration(String registrationId) throws Exception {
        return studentRegistrationModel.deleteStudentRegistration(registrationId);
    }

    public static ArrayList<StudentRegistrationDTO> getStudentRegistration(StudentRegistrationDTO studentRegistrationDTO) throws Exception {
        return studentRegistrationModel.getStudentRegistration(studentRegistrationDTO);
    }

    public static ArrayList<StudentRegistrationDTO> getStudentRegistrationViaRegId(String rgid) throws Exception {
        return studentRegistrationModel.getStudentRegistrationViaRegId(rgid);
    }

    public static StudentRegistrationDTO getIntakeWithDate(String rgid) throws Exception {
        return studentRegistrationModel.getIntakeWithDate(rgid);
    }

    public static StudentRegistrationDTO getStudentIdWithIntake(String rgid) throws Exception {
        return studentRegistrationModel.getStudentIdWithIntake(rgid);
    }
    
    public static StudentRegistrationDTO getDegreeViaStudentRegistration(String rgid) throws Exception {
        return studentRegistrationModel.getDegreeViaStudentRegistration(rgid);
    }
}
