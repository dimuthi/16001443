/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DTO.CourseWorkDTO;
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
public class CourseWorkModel {

    public boolean addCourseWork(CourseWorkDTO courseWorkDTO) throws Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "INSERT INTO CourseWork (subid,cwtid,courseWorkName) values (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, courseWorkDTO.getSubjectId());
        preparedStatement.setObject(2, courseWorkDTO.getCourseWorkTypeId());
        preparedStatement.setObject(3, courseWorkDTO.getCourseWorkName());

        return preparedStatement.executeUpdate() > 0;
    }

    public boolean deleteCourseWork(int courseWorkID) throws Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "delete from CourseWork where cwid=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, courseWorkID);
        return preparedStatement.executeUpdate() > 0;
    }

    public boolean updateCourseWork(CourseWorkDTO courseWorkDTO) throws Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "update CourseWork set subid=?,cwtid=?,courseWorkName=? where cwid=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, courseWorkDTO.getSubjectId());
        preparedStatement.setObject(2, courseWorkDTO.getCourseWorkTypeId());
        preparedStatement.setObject(3, courseWorkDTO.getCourseWorkName());
        preparedStatement.setObject(4, courseWorkDTO.getCourseWorkId());
        return preparedStatement.executeUpdate() > 0;
    }

    public ArrayList<CourseWorkDTO> getAllCourseWorksViaSubject(CourseWorkDTO courseWork) throws Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "select courseWorkName from CourseWork where cwtid=? && subid=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, courseWork.getCourseWorkTypeId());
        preparedStatement.setObject(2, courseWork.getSubjectId());
        ResultSet rst = preparedStatement.executeQuery();
        ArrayList<CourseWorkDTO> courseWorkDTOs = new ArrayList<>();
        while (rst.next()) {
            CourseWorkDTO courseWorkDTO = new CourseWorkDTO();
            courseWorkDTO.setCourseWorkName(rst.getString(1));
            courseWorkDTOs.add(courseWorkDTO);
        }
        return courseWorkDTOs;
    }

    public ArrayList<CourseWorkDTO> getAllCourseWorksWithIdViaSubject(CourseWorkDTO courseWork) throws Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "select cwid,courseWorkName from CourseWork where cwtid=? && subid=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, courseWork.getCourseWorkTypeId());
        preparedStatement.setObject(2, courseWork.getSubjectId());
        ResultSet rst = preparedStatement.executeQuery();
        ArrayList<CourseWorkDTO> courseWorkDTOs = new ArrayList<>();
        while (rst.next()) {
            CourseWorkDTO courseWorkDTO = new CourseWorkDTO();
            courseWorkDTO.setCourseWorkId(rst.getInt(1));
            courseWorkDTO.setCourseWorkName(rst.getString(2));
            courseWorkDTOs.add(courseWorkDTO);
        }
        return courseWorkDTOs;
    }

    public CourseWorkDTO getCourseWorkId(String name) throws Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "select cwid from CourseWork where courseWorkName=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, name);
        ResultSet rst = preparedStatement.executeQuery();
        CourseWorkDTO courseWorkDTO = new CourseWorkDTO();
        if (rst.next()) {
            courseWorkDTO.setCourseWorkId(rst.getInt(1));
        }
        return courseWorkDTO;
    }

    /*Course work types*/
    public ArrayList<CourseWorkDTO> getAllCourseWorksTypes() throws Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "select courseWorkTypeName from CourseWorkType";
        Statement createStatement = connection.createStatement();
        ResultSet rst = createStatement.executeQuery(sql);
        ArrayList<CourseWorkDTO> courseWorkDTOs = new ArrayList<>();
        while (rst.next()) {
            CourseWorkDTO courseWorkDTO = new CourseWorkDTO();
            courseWorkDTO.setCourseWorkType(rst.getString(1));
            courseWorkDTOs.add(courseWorkDTO);
        }
        return courseWorkDTOs;
    }

    public CourseWorkDTO getCourseWorkTypeId(String name) throws Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "select cwtid from CourseWorkType where courseWorkTypeName=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, name);
        ResultSet rst = preparedStatement.executeQuery();
        CourseWorkDTO courseWorkDTO = new CourseWorkDTO();
        if (rst.next()) {
            courseWorkDTO.setCourseWorkTypeId(rst.getInt(1));
        }
        return courseWorkDTO;
    }
}
