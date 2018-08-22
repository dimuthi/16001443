/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DTO.LecturerDTO;
import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author dimut
 */
public class LecturerModel {

    public boolean addLecturer(LecturerDTO lecturerDTO) throws Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "INSERT INTO Lecturer values (?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, lecturerDTO.getLecturerID());
        preparedStatement.setObject(2, lecturerDTO.getFacultyId());
        preparedStatement.setObject(3, lecturerDTO.getLecturerName());
        preparedStatement.setObject(4, lecturerDTO.getAddress());
        preparedStatement.setObject(5, lecturerDTO.getGender());
        preparedStatement.setObject(6, lecturerDTO.getTelephone());
        preparedStatement.setObject(7, lecturerDTO.getEmail());

        return preparedStatement.executeUpdate() > 0;
    }
    
    //get all lecturers relavent to the selected faculty with their all details via facultyid
    public ArrayList<LecturerDTO> getAllLecturers(int facid) throws Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "select lecid,lecturerName,lecturerAddress,telephone,gender,facultyName,email from Lecturer l,Faculty f where f.facid=l.facid && f.facid=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, facid);
        ResultSet rst = preparedStatement.executeQuery();
        ArrayList<LecturerDTO> lecturerDTOs = new ArrayList<>();
        while (rst.next()) {
            LecturerDTO lecturerDTO = new LecturerDTO();
            lecturerDTO.setLecturerID(rst.getString(1));
            lecturerDTO.setLecturerName(rst.getString(2));
            lecturerDTO.setAddress(rst.getString(3));
            lecturerDTO.setTelephone(rst.getString(4));
            lecturerDTO.setGender(rst.getString(5));
            lecturerDTO.setFacultyName(rst.getString(6));
            lecturerDTO.setEmail(rst.getString(7));
            lecturerDTOs.add(lecturerDTO);
        }
        return lecturerDTOs;
    }
   
    public boolean deleteLecturer(String lecturerID) throws Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "delete from Lecturer where lecid=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, lecturerID);
        return preparedStatement.executeUpdate() > 0;
    }

    public boolean updateLecturer(LecturerDTO lecturerDTO) throws Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "update Lecturer set facid=?,lecturerName=?,lecturerAddress=?,telephone=?,gender=?,email=? where lecid=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, lecturerDTO.getFacultyId());
        preparedStatement.setObject(2, lecturerDTO.getLecturerName());
        preparedStatement.setObject(3, lecturerDTO.getAddress());
        preparedStatement.setObject(4, lecturerDTO.getTelephone());
        preparedStatement.setObject(5, lecturerDTO.getGender());
        preparedStatement.setObject(6, lecturerDTO.getEmail());
        preparedStatement.setObject(7, lecturerDTO.getLecturerID());

        return preparedStatement.executeUpdate() > 0;
    }

    public LecturerDTO getLecturerId(String lecturerName) throws Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "select lecid from Lecturer where lecturerName=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, lecturerName);
        ResultSet rst = preparedStatement.executeQuery();
        LecturerDTO lecturerDTO = new LecturerDTO();
        if (rst.next()) {
            lecturerDTO.setLecturerID(rst.getString(1));
        }
        return lecturerDTO;
    }
    
    //get all lecturers relavent to the selected faculty with their name via faculty id
    public ArrayList<LecturerDTO> getLecturersViaFaculty(int facultyId) throws Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "select lecturerName from Lecturer where facid=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, facultyId);
        ResultSet rst = preparedStatement.executeQuery();
        ArrayList<LecturerDTO> lecturerDTOs = new ArrayList<>();
        while (rst.next()) {
            LecturerDTO lecturerDTO = new LecturerDTO();
            lecturerDTO.setLecturerName(rst.getString(1));
            lecturerDTOs.add(lecturerDTO);
        }
        return lecturerDTOs;
    }

    public ArrayList<LecturerDTO> getAllLecturersViaLecId(String lecId) throws Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "select lecid,lecturerName,lecturerAddress,telephone,gender,facultyName,email from Lecturer l,Faculty f where f.facid=l.facid && l.lecid=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, lecId);
        ResultSet rst = preparedStatement.executeQuery();
        ArrayList<LecturerDTO> lecturerDTOs = new ArrayList<>();
        while (rst.next()) {
            LecturerDTO lecturerDTO = new LecturerDTO();
            lecturerDTO.setLecturerID(rst.getString(1));
            lecturerDTO.setLecturerName(rst.getString(2));
            lecturerDTO.setAddress(rst.getString(3));
            lecturerDTO.setTelephone(rst.getString(4));
            lecturerDTO.setGender(rst.getString(5));
            lecturerDTO.setFacultyName(rst.getString(6));
            lecturerDTO.setEmail(rst.getString(7));
            lecturerDTOs.add(lecturerDTO);
        }
        return lecturerDTOs;
    }
}
