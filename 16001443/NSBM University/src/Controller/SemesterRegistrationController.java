/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DTO.SemesterRegistrationDTO;
import DTO.SubjSemRegistrationDTO;
import Model.SemesterRegistrationModel;
import Model.SubjSemRegistrationModel;
import db.DBConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Imalka Gunawardana
 */
public class SemesterRegistrationController {

    private static Connection connection;
    private static SemesterRegistrationModel semesterRegistrationModel = new SemesterRegistrationModel();
    private static SubjSemRegistrationModel subjSemRegistrationModel = new SubjSemRegistrationModel();

    public static boolean addSemesterRegistration(SemesterRegistrationDTO semesterRegistrationDTO) throws Exception {
        try {
            connection = DBConnection.getDBConnection().getConnection();
            int count = 0;
            connection.setAutoCommit(false);
            ArrayList<String> subjectCodesList = semesterRegistrationDTO.getSubjectCodesList();
            boolean addSemesterRegistration = semesterRegistrationModel.addSemesterRegistration(semesterRegistrationDTO);
            if (addSemesterRegistration) {
                for (String subjectCode : subjectCodesList) {
                    SubjSemRegistrationDTO subjSemRegistrationDTO = new SubjSemRegistrationDTO();
                    subjSemRegistrationDTO.setSemesterRegistrationId(semesterRegistrationDTO.getSemesterRegistrationId());
                    subjSemRegistrationDTO.setSubjectId(subjectCode);
                    boolean addSubjSemRegistration = subjSemRegistrationModel.addSubjSemRegistration(subjSemRegistrationDTO);
                    if (addSubjSemRegistration) {
                        count++;
                    }
                }
            }
            if (count == subjectCodesList.size()) {
                connection.commit();
                return true;
            } else {
                connection.rollback();
            }
            connection.rollback();
            return false;
        } finally {
            connection.setAutoCommit(true);
        }
    }

    public static boolean deleteSemesterRegistration(SemesterRegistrationDTO semesterRegistrationDTO) throws Exception {
        return semesterRegistrationModel.deleteSemesterRegistration(semesterRegistrationDTO);
    }

    public static ArrayList<SemesterRegistrationDTO> getSemesterRegistrations(SemesterRegistrationDTO semesterRegistrationDTO) throws Exception {
        return semesterRegistrationModel.getSemesterRegistrations(semesterRegistrationDTO);
    }
    
    public static ArrayList<SemesterRegistrationDTO> getSemesterRegistrationsViaRegId(SemesterRegistrationDTO semesterRegistrationDTO) throws Exception {
        return semesterRegistrationModel.getSemesterRegistrationsViaRegId(semesterRegistrationDTO);
    }
}
