/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DTO.StudentRegistrationDTO;
import DTO.UndergraduateDetailsDTO;
import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Imalka Gunawardana
 */
public class UndergraduateDetailsModel {

    public boolean addUndergraduateDetails(UndergraduateDetailsDTO undergraduateDetailsDTO) throws Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "INSERT INTO UndergraduateDetails (rgid,alResults,school,zscore,year) values (?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, undergraduateDetailsDTO.getRegistrationId());
        preparedStatement.setObject(2, undergraduateDetailsDTO.getAlResults());
        preparedStatement.setObject(3, undergraduateDetailsDTO.getSchool());
        preparedStatement.setObject(4, undergraduateDetailsDTO.getZscore());
        preparedStatement.setObject(5, undergraduateDetailsDTO.getYearAl());
        return preparedStatement.executeUpdate() > 0;
    }

    public boolean updateUndergraduateDetails(UndergraduateDetailsDTO undergraduateDetailsDTO) throws Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "update UndergraduateDetails set alResults=?,school=?,zscore=?,year=? where rgid=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, undergraduateDetailsDTO.getAlResults());
        preparedStatement.setObject(2, undergraduateDetailsDTO.getSchool());
        preparedStatement.setObject(3, undergraduateDetailsDTO.getZscore());
        preparedStatement.setObject(4, undergraduateDetailsDTO.getYearAl());
        preparedStatement.setObject(5, undergraduateDetailsDTO.getRegistrationId());
        return preparedStatement.executeUpdate() > 0;
    }

    public UndergraduateDetailsDTO getUndergraduateDetails(String rgid) throws Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "select alResults,school,zscore,year from UndergraduateDetails where rgid=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, rgid);
        ResultSet rst = preparedStatement.executeQuery();
        UndergraduateDetailsDTO detailsDTO = new UndergraduateDetailsDTO();
        if (rst.next()) {
            detailsDTO.setAlResults(rst.getString(1));
            detailsDTO.setSchool(rst.getString(2));
            detailsDTO.setZscore(rst.getDouble(3));
            detailsDTO.setYearAl(rst.getString(4));
        }
        return detailsDTO;
    }
}
