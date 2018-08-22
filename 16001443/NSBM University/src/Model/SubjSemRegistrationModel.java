/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DTO.SubjSemRegistrationDTO;
import DTO.SubjectDTO;
import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Imalka Gunawardana
 */
public class SubjSemRegistrationModel {

    public boolean addSubjSemRegistration(SubjSemRegistrationDTO subjSemRegistrationDTO) throws Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "INSERT INTO SubjSemRegistration (semrgid,subid) values (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, subjSemRegistrationDTO.getSemesterRegistrationId());
        preparedStatement.setObject(2, subjSemRegistrationDTO.getSubjectId());
        return preparedStatement.executeUpdate() > 0;
    }

    public ArrayList<SubjectDTO> getSubjectCodesViaSemRegId(String semRegId) throws Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "select sub.subid from SubjSemRegistration ssr,Subject sub where ssr.subid=sub.subid && ssr.semrgid=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, semRegId);
        ResultSet rst = preparedStatement.executeQuery();
        ArrayList<SubjectDTO> sublist = new ArrayList<>();
        while (rst.next()) {
            SubjectDTO subjectDTO = new SubjectDTO();
            subjectDTO.setSubjectId(rst.getString(1));
            sublist.add(subjectDTO);
        }
        return sublist;
    }

    public SubjSemRegistrationDTO getSubjectSemesterRegistrationId(SubjSemRegistrationDTO subjSemRegistrationDTO) throws Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "select subsemregid from SubjSemRegistration where semrgid=? && subid=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, subjSemRegistrationDTO.getSemesterRegistrationId());
        preparedStatement.setObject(2, subjSemRegistrationDTO.getSubjectId());
        ResultSet rst = preparedStatement.executeQuery();
        SubjSemRegistrationDTO registrationDTO = new SubjSemRegistrationDTO();
        if (rst.next()) {
            registrationDTO.setSubjSemRegistrationId(rst.getInt(1));
        }
        return registrationDTO;
    }
}
