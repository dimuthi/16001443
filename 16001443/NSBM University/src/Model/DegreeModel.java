/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DTO.DegreeDTO;
import DTO.FacultyDTO;
import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Imalka Gunawardana
 */
public class DegreeModel {

    public DegreeDTO getGraduationType(String degreeName) throws Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "select graduationType from Degree where degreeName=? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, degreeName);
        ResultSet rst = preparedStatement.executeQuery();
        DegreeDTO degreeDTO = new DegreeDTO();
        if (rst.next()) {
            degreeDTO.setGraduationType(rst.getString(1));
        }
        return degreeDTO;
    }

    public ArrayList<DegreeDTO> getDegreeNamesViaFaculty(int facultyId) throws Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "select degreeName from Degree d,Faculty f where f.facid=d.facid && f.facid=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, facultyId);
        ResultSet rst = preparedStatement.executeQuery();
        ArrayList<DegreeDTO> degreeDTOs = new ArrayList<>();
        while (rst.next()) {
            DegreeDTO degreeDTO = new DegreeDTO();
            degreeDTO.setDegreeName(rst.getString(1));
            degreeDTOs.add(degreeDTO);
        }
        return degreeDTOs;
    }

    public DegreeDTO getDegreeId(String degreeName) throws Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "select degid from Degree where degreeName=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, degreeName);
        ResultSet rst = preparedStatement.executeQuery();
        DegreeDTO degreeDTO = new DegreeDTO();
        if (rst.next()) {
            degreeDTO.setDegreeid(rst.getInt(1));
        }
        return degreeDTO;
    }
}
