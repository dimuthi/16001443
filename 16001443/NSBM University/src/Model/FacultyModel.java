/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DTO.FacultyDTO;
import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author dimut
 */
public class FacultyModel {

    public ArrayList<FacultyDTO> getAllFaculties() throws Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "select facultyName from Faculty";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<FacultyDTO> facultyDTOs = new ArrayList<>();
        while (rst.next()) {
            FacultyDTO facultyDTO = new FacultyDTO();
            facultyDTO.setFacultyName(rst.getString(1));
            facultyDTOs.add(facultyDTO);
        }
        return facultyDTOs;
    }
   

    public FacultyDTO getFacultyId(String facultyName) throws Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "select facid from Faculty where facultyName=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, facultyName);
        ResultSet rst = preparedStatement.executeQuery();
        FacultyDTO facultyDTO = new FacultyDTO();
        if (rst.next()) {
            facultyDTO.setFacultyId(rst.getInt(1));
        }
        return facultyDTO;
    }
    
   
}
