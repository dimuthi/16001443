/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Imalka Gunawardana
 */
public class HomeModel {

    public int getStudentsCount(int facultyId) throws Exception {
        int count = 0;
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "select count(stid) from Registration r where facid=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, facultyId);
        ResultSet rst = preparedStatement.executeQuery();
        if (rst.next()) {
            count = rst.getInt(1);
        }
        return count;
    }

    public int getLecturersCount(int facultyId) throws Exception {
        int count = 0;
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "select count(lecid) from Lecturer l where facid=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, facultyId);
        ResultSet rst = preparedStatement.executeQuery();
        if (rst.next()) {
            count = rst.getInt(1);
        }
        return count;
    }

    public int getSubjectsCount(int facultyId) throws Exception {
        int count = 0;
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "select count(subid) from Subject where facid=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, facultyId);
        ResultSet rst = preparedStatement.executeQuery();
        if (rst.next()) {
            count = rst.getInt(1);
        }
        return count;
    }
}
