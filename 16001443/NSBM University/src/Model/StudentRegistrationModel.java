/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DTO.SemesterRegistrationDTO;
import DTO.StudentRegistrationDTO;
import DTO.SubjectDTO;
import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author dimut
 */
public class StudentRegistrationModel {

    public boolean addStudentRegistration(StudentRegistrationDTO studentRegistrationDTO) throws Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "INSERT INTO Registration values (?,?,?,?,now(),?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, studentRegistrationDTO.getRegistrationId());
        preparedStatement.setObject(2, studentRegistrationDTO.getStudentID());
        preparedStatement.setObject(3, studentRegistrationDTO.getDegreeid());
        preparedStatement.setObject(4, studentRegistrationDTO.getFacultyId());
        preparedStatement.setObject(5, studentRegistrationDTO.getIntake());
        return preparedStatement.executeUpdate() > 0;
    }

    public boolean deleteStudentRegistration(String registrationId) throws Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "delete from Registration where rgid=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, registrationId);
        return preparedStatement.executeUpdate() > 0;
    }

    public ArrayList<StudentRegistrationDTO> getStudentRegistration(StudentRegistrationDTO studentRegistrationDTO) throws Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "select rgid,firstName,lastName,dateofRegistration,degreeName from Registration reg,Student s,Degree d where s.stid=reg.stid && reg.degid=d.degid && reg.facid=? && reg.degid=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, studentRegistrationDTO.getFacultyId());
        preparedStatement.setObject(2, studentRegistrationDTO.getDegreeid());

        ResultSet rst = preparedStatement.executeQuery();
        ArrayList<StudentRegistrationDTO> registrationDTOs = new ArrayList<>();
        while (rst.next()) {
            StudentRegistrationDTO registrationDTO = new StudentRegistrationDTO();
            registrationDTO.setRegistrationId(rst.getString(1));
            registrationDTO.setFirstName(rst.getString(2));
            registrationDTO.setLastName(rst.getString(3));
            registrationDTO.setDate(rst.getString(4));
            registrationDTO.setDegreeName(rst.getString(5));
            registrationDTOs.add(registrationDTO);
        }
        return registrationDTOs;
    }

    public ArrayList<StudentRegistrationDTO> getStudentRegistrationViaRegId(String rgid) throws Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "select rgid,firstName,lastName,dateofRegistration,degreeName from Registration reg,Student s,Degree d where s.stid=reg.stid && reg.degid=d.degid && reg.rgid=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, rgid);
        ResultSet rst = preparedStatement.executeQuery();
        ArrayList<StudentRegistrationDTO> registrationDTOs = new ArrayList<>();
        while (rst.next()) {
            StudentRegistrationDTO registrationDTO = new StudentRegistrationDTO();
            registrationDTO.setRegistrationId(rst.getString(1));
            registrationDTO.setFirstName(rst.getString(2));
            registrationDTO.setLastName(rst.getString(3));
            registrationDTO.setDate(rst.getString(4));
            registrationDTO.setDegreeName(rst.getString(5));
            registrationDTOs.add(registrationDTO);
        }
        return registrationDTOs;
    }

    public StudentRegistrationDTO getIntakeWithDate(String rgid) throws Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "select year(dateofRegistration),intake from Registration where rgid=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, rgid);
        ResultSet rst = preparedStatement.executeQuery();
        StudentRegistrationDTO registrationDTO = new StudentRegistrationDTO();
        if (rst.next()) {
            registrationDTO.setDate(rst.getString(1));
            registrationDTO.setIntake(rst.getString(2));
        }
        return registrationDTO;
    }

    public StudentRegistrationDTO getStudentIdWithIntake(String rgid) throws Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "select stid,intake from Registration where rgid=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, rgid);
        ResultSet rst = preparedStatement.executeQuery();
        StudentRegistrationDTO registrationDTO = new StudentRegistrationDTO();
        if (rst.next()) {
            registrationDTO.setStudentID(rst.getString(1));
            registrationDTO.setIntake(rst.getString(2));
        }
        return registrationDTO;
    }

    public StudentRegistrationDTO getDegreeViaStudentRegistration(String rgid) throws Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "select degid from Registration where rgid=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, rgid);
        ResultSet rst = preparedStatement.executeQuery();
        StudentRegistrationDTO registrationDTO = new StudentRegistrationDTO();
        if (rst.next()) {
            registrationDTO.setDegreeid(rst.getInt(1));
        }
        return registrationDTO;
    }
}
