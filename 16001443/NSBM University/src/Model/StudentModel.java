/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DTO.StudentDTO;
import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

;

/**
 *
 * @author dimut
 */
public class StudentModel {

    public boolean addStudent(StudentDTO studentDTO) throws Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "INSERT INTO student values (?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, studentDTO.getStudentID());
        preparedStatement.setObject(2, studentDTO.getFirstName());
        preparedStatement.setObject(3, studentDTO.getLastName());
        preparedStatement.setObject(4, studentDTO.getAddress());
        preparedStatement.setObject(5, studentDTO.getGender());
        preparedStatement.setObject(6, studentDTO.getbOD());
        preparedStatement.setObject(7, studentDTO.getTelephone());
        preparedStatement.setObject(8, studentDTO.getEmail());

        return preparedStatement.executeUpdate() > 0;
    }

    public boolean deleteStudent(String stid) throws Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "delete from student where stid=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, stid);
        return preparedStatement.executeUpdate() > 0;
    }

    public boolean updateStudent(StudentDTO studentDTO) throws Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "update student set firstName=?,lastName=?,studentAddress=?,gender=?,dob=?,telephone=?,email=? where stid=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, studentDTO.getFirstName());
        preparedStatement.setObject(2, studentDTO.getLastName());
        preparedStatement.setObject(3, studentDTO.getAddress());
        preparedStatement.setObject(4, studentDTO.getGender());
        preparedStatement.setObject(5, studentDTO.getbOD());
        preparedStatement.setObject(6, studentDTO.getTelephone());
        preparedStatement.setObject(7, studentDTO.getEmail());
        preparedStatement.setObject(8, studentDTO.getStudentID());
        return preparedStatement.executeUpdate() > 0;
    }

    public ArrayList<StudentDTO> getAllStudents() throws Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "select * from student";
        Statement createStatement = connection.createStatement();
        ResultSet rst = createStatement.executeQuery(sql);
        ArrayList<StudentDTO> studentDTOs = new ArrayList<>();
        while (rst.next()) {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setStudentID(rst.getString(1));
            studentDTO.setFirstName(rst.getString(2));
            studentDTO.setLastName(rst.getString(3));
            studentDTO.setAddress(rst.getString(4));
            studentDTO.setGender(rst.getString(5));
            studentDTO.setbOD(rst.getString(6));
            studentDTO.setTelephone(rst.getString(7));
            studentDTO.setEmail(rst.getString(8));
            studentDTOs.add(studentDTO);

        }
        return studentDTOs;
    }
}
