/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DTO.FacultyDTO;
import DTO.StudentRegistrationDTO;
import DTO.StudentDTO;
import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * 
 */
public class RegistrationModel {

    public StudentDTO getStudentNameViaRegId(String registrationID) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getDBConnection().getConnection();
        StudentDTO studentDTO = new StudentDTO();
        String sql = "select firstName,lastName from Student s,Registration r where s.stid=r.stid && rgid=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, registrationID);
        ResultSet rst = preparedStatement.executeQuery();
        if (rst.next()) {
            studentDTO.setFirstName(rst.getString(1));
            studentDTO.setLastName(rst.getString(2));
        }
        return studentDTO;
    }

    public static FacultyDTO getFacultyNameViaRegId(String registrationID) throws Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        FacultyDTO facultyDTO = new FacultyDTO();
        String sql = "select facultyName from Faculty f,Registration r where f.facid=r.facid && r.rgid=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, registrationID);
        ResultSet rst = preparedStatement.executeQuery();
        if (rst.next()) {
            facultyDTO.setFacultyName(rst.getString(1));
        }
        return facultyDTO;
    }
    
    public static StudentDTO getStudentNameViaSemRegId(String semRegistrationID) throws Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        StudentDTO studentDTO = new StudentDTO();
        String sql = "select firstName,lastName from Student s,Registration r,SemesterRegistration sr,SubjSemRegistration ssr where s.stid=r.stid && r.rgid=sr.rgid && ssr.semrgid=sr.semrgid && sr.semrgid=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, semRegistrationID);
        ResultSet rst = preparedStatement.executeQuery();
        if (rst.next()) {
            studentDTO.setFirstName(rst.getString(1));
            studentDTO.setLastName(rst.getString(2));
        }
        return studentDTO;
    }
}
