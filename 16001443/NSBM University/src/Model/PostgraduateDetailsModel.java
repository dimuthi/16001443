/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DTO.PostgraduateDetailsDTO;
import DTO.UndergraduateDetailsDTO;
import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Imalka Gunawardana
 */
public class PostgraduateDetailsModel {

    public boolean addPostgraduateDetails(PostgraduateDetailsDTO postgraduateDetailsDTO) throws Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "INSERT INTO PostgraduateDetails (rgid,qualificationType,institute,year) values (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, postgraduateDetailsDTO.getRegistrationId());
        preparedStatement.setObject(2, postgraduateDetailsDTO.getQualificationType());
        preparedStatement.setObject(3, postgraduateDetailsDTO.getInstitute());
        preparedStatement.setObject(4, postgraduateDetailsDTO.getYear());
        return preparedStatement.executeUpdate() > 0;
    }

    public boolean updatePostgraduateDetails(PostgraduateDetailsDTO postgraduateDetailsDTO) throws Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "update PostgraduateDetails set qualificationType=?,institute=?,year=? where rgid=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, postgraduateDetailsDTO.getQualificationType());
        preparedStatement.setObject(2, postgraduateDetailsDTO.getInstitute());
        preparedStatement.setObject(3, postgraduateDetailsDTO.getYear());
        preparedStatement.setObject(4, postgraduateDetailsDTO.getRegistrationId());
        return preparedStatement.executeUpdate() > 0;
    }

    public PostgraduateDetailsDTO getPostgraduateDetails(String rgid) throws Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "select qualificationType,institute,year from PostgraduateDetails where rgid=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, rgid);
        ResultSet rst = preparedStatement.executeQuery();
        PostgraduateDetailsDTO detailsDTO = new PostgraduateDetailsDTO();
        if (rst.next()) {
            detailsDTO.setQualificationType(rst.getString(1));
            detailsDTO.setInstitute(rst.getString(2));
            detailsDTO.setYear(rst.getString(3));
        }
        return detailsDTO;
    }
}
