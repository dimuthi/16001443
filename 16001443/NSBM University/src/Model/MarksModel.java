/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DTO.CourseWorkDTO;
import DTO.MarksDTO;
import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Imalka Gunawardana
 */
public class MarksModel {

    public boolean addMarks(MarksDTO marksDTO) throws Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "INSERT INTO Marks (cwid,subsemregid,marks) values (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, marksDTO.getCourseWorkId());
        preparedStatement.setObject(2, marksDTO.getSubjSemRegistrationId());
        preparedStatement.setObject(3, marksDTO.getMarks());
        return preparedStatement.executeUpdate() > 0;
    }

    public boolean updateMarks(MarksDTO marksDTO) throws Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "Update Marks set cwid=?,subsemregid=?,marks=? where markid=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, marksDTO.getCourseWorkId());
        preparedStatement.setObject(2, marksDTO.getSubjSemRegistrationId());
        preparedStatement.setObject(3, marksDTO.getMarks());
        preparedStatement.setObject(4, marksDTO.getMarkid());
        return preparedStatement.executeUpdate() > 0;
    }

    public boolean deleteMarks(int markid) throws Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "delete from Marks where markid=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, markid);
        return preparedStatement.executeUpdate() > 0;
    }
    
    public ArrayList<MarksDTO> getAllMarksViaSemRegIdAndCourseId(CourseWorkDTO courseWork) throws Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "select sub.subid,subjectName,courseWorkName,marks,markid from CourseWorkType cwt,CourseWork cw,SubjSemRegistration ssr,Subject sub,Marks m where ssr.subsemregid=m.subsemregid && m.cwid=cw.cwid && sub.subid=cw.subid && cw.cwtid=cwt.cwtid && ssr.semrgid=? && cwt.cwtid=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, courseWork.getSemesterRegistrationId());
        preparedStatement.setObject(2, courseWork.getCourseWorkTypeId());
        ResultSet rst = preparedStatement.executeQuery();
        ArrayList<MarksDTO> marksDTOs = new ArrayList<>();
        while (rst.next()) {
            MarksDTO marksDTO = new MarksDTO();
            marksDTO.setSubjectCode(rst.getString(1));
            marksDTO.setSubjectName(rst.getString(2));
            marksDTO.setCourseWorkName(rst.getString(3));
            marksDTO.setMarks(rst.getInt(4));
            marksDTO.setMarkid(rst.getInt(5));
            marksDTOs.add(marksDTO);
        }
        return marksDTOs;
    }
}
