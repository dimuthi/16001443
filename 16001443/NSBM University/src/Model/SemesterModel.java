/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DTO.FacultyDTO;
import DTO.LecturerDTO;
import DTO.SemesterDTO;
import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Imalka Gunawardana
 */
public class SemesterModel {

    public ArrayList<SemesterDTO> getAllSemesters() throws Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "select semesterName from Semester";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<SemesterDTO> semesterDTOs = new ArrayList<>();
        while (rst.next()) {
            SemesterDTO semesterDTO = new SemesterDTO();
            semesterDTO.setSemesterName(rst.getString(1));
            semesterDTOs.add(semesterDTO);
        }
        return semesterDTOs;
    }

    public SemesterDTO getSemesterId(String semesterName) throws Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "select semid from Semester where semesterName=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, semesterName);
        ResultSet rst = preparedStatement.executeQuery();
        SemesterDTO semesterDTO = new SemesterDTO();
        if (rst.next()) {
            semesterDTO.setSemesterid(rst.getInt(1));
        }
        return semesterDTO;
    }
}
