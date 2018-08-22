/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DTO.SemesterRegistrationDTO;
import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Imalka Gunawardana
 */
public class SemesterRegistrationModel {

    public boolean addSemesterRegistration(SemesterRegistrationDTO semesterRegistrationDTO) throws Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "INSERT INTO SemesterRegistration values (?,?,?,now())";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, semesterRegistrationDTO.getSemesterRegistrationId());
        preparedStatement.setObject(2, semesterRegistrationDTO.getSemesterid());
        preparedStatement.setObject(3, semesterRegistrationDTO.getRegistrationId());
        return preparedStatement.executeUpdate() > 0;
    }

    public boolean deleteSemesterRegistration(SemesterRegistrationDTO semesterRegistrationDTO) throws Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "delete from SemesterRegistration where semrgid=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, semesterRegistrationDTO.getSemesterRegistrationId());
        return preparedStatement.executeUpdate() > 0;
    }

    public ArrayList<SemesterRegistrationDTO> getSemesterRegistrations(SemesterRegistrationDTO semesterRegistrationDTO) throws Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "select semrgid,r.rgid,firstName,lastName,dateofSemRegistration from SemesterRegistration sr,Registration r,Faculty f,Student s where s.stid=r.stid && r.rgid=sr.rgid && r.facid=f.facid && semid=? && f.facid=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, semesterRegistrationDTO.getSemesterid());
        preparedStatement.setObject(2, semesterRegistrationDTO.getFacultyId());
        ResultSet rst = preparedStatement.executeQuery();
        ArrayList<SemesterRegistrationDTO> semesterRegistrationDTOs = new ArrayList<>();
        while (rst.next()) {
            SemesterRegistrationDTO registrationDTO = new SemesterRegistrationDTO();
            registrationDTO.setSemesterRegistrationId(rst.getString(1));
            registrationDTO.setRegistrationId(rst.getString(2));
            registrationDTO.setFirstName(rst.getString(3));
            registrationDTO.setLastName(rst.getString(4));
            registrationDTO.setDate(rst.getString(5));
            semesterRegistrationDTOs.add(registrationDTO);
        }
        return semesterRegistrationDTOs;
    }

    public ArrayList<SemesterRegistrationDTO> getSemesterRegistrationsViaRegId(SemesterRegistrationDTO semesterRegistrationDTO) throws Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "select semrgid,r.rgid,firstName,lastName,dateofSemRegistration from SemesterRegistration sr,Registration r,Faculty f,Student s where s.stid=r.stid && r.rgid=sr.rgid && r.facid=f.facid && semid=? && f.facid=? && r.rgid=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, semesterRegistrationDTO.getSemesterid());
        preparedStatement.setObject(2, semesterRegistrationDTO.getFacultyId());
        preparedStatement.setObject(3, semesterRegistrationDTO.getRegistrationId());
        ResultSet rst = preparedStatement.executeQuery();
        ArrayList<SemesterRegistrationDTO> semesterRegistrationDTOs = new ArrayList<>();
        while (rst.next()) {
            SemesterRegistrationDTO registrationDTO = new SemesterRegistrationDTO();
            registrationDTO.setSemesterRegistrationId(rst.getString(1));
            registrationDTO.setRegistrationId(rst.getString(2));
            registrationDTO.setFirstName(rst.getString(3));
            registrationDTO.setLastName(rst.getString(4));
            registrationDTO.setDate(rst.getString(5));
            semesterRegistrationDTOs.add(registrationDTO);
        }
        return semesterRegistrationDTOs;
    }
}
