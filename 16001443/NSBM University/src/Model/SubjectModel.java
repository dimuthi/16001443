/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DTO.SubjectDTO;
import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author dimut
 */
public class SubjectModel {

    public boolean addSubject(SubjectDTO subjectDTO) throws Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "INSERT INTO subject values (?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, subjectDTO.getSubjectId());
        preparedStatement.setObject(2, subjectDTO.getLecturerID());
        preparedStatement.setObject(3, subjectDTO.getSemesterid());
        preparedStatement.setObject(4, subjectDTO.getFacultyId());
        preparedStatement.setObject(5, subjectDTO.getDegreeId());
        preparedStatement.setObject(6, subjectDTO.getSubjectName());
        preparedStatement.setObject(7, subjectDTO.getCredits());
        preparedStatement.setObject(8, subjectDTO.getFee());
        return preparedStatement.executeUpdate() > 0;
    }

    public boolean updateSubject(SubjectDTO subjectDTO) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "Update subject set lecid=?,semid=?,facid=?,subjectName=?,credits=?,fee=?,degid=? where subid=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, subjectDTO.getLecturerID());
        preparedStatement.setObject(2, subjectDTO.getSemesterid());
        preparedStatement.setObject(3, subjectDTO.getFacultyId());
        preparedStatement.setObject(4, subjectDTO.getSubjectName());
        preparedStatement.setObject(5, subjectDTO.getCredits());
        preparedStatement.setObject(6, subjectDTO.getFee());
        preparedStatement.setObject(7, subjectDTO.getDegreeId());
        preparedStatement.setObject(8, subjectDTO.getSubjectId());
        return preparedStatement.executeUpdate() > 0;
    }

    public boolean deleteSubject(String subid) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "delete from subject where subid=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, subid);
        return preparedStatement.executeUpdate() > 0;
    }

    public ArrayList<SubjectDTO> getAllSubject(SubjectDTO subjectDTo) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "select subid,subjectName,lecturerName,credits,fee,degreeName from faculty f,semester sem,subject sub,lecturer l,degree d where sub.degid=d.degid && sub.semid=sem.semid && sub.facid=f.facid && sub.lecid=l.lecid && sub.facid=? && sem.semid=? && d.degid=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, subjectDTo.getFacultyId());
        preparedStatement.setObject(2, subjectDTo.getSemesterid());
        preparedStatement.setObject(3, subjectDTo.getDegreeId());
        ResultSet rst = preparedStatement.executeQuery();
        ArrayList<SubjectDTO> sublist = new ArrayList<>();
        while (rst.next()) {
            SubjectDTO subjectDTO = new SubjectDTO();
            subjectDTO.setSubjectId(rst.getString(1));
            subjectDTO.setSubjectName(rst.getString(2));
            subjectDTO.setLecturerName(rst.getString(3));
            subjectDTO.setCredits(rst.getInt(4));
            subjectDTO.setFee(rst.getDouble(5));
            subjectDTO.setDegreeName(rst.getString(6));
            sublist.add(subjectDTO);

        }
        return sublist;
    }

    public ArrayList<SubjectDTO> getAllSubjectsViaLecturer(String lecturerId) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "select subid,subjectName,credits from subject where lecid=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, lecturerId);
        ResultSet rst = preparedStatement.executeQuery();
        ArrayList<SubjectDTO> sublist = new ArrayList<>();
        while (rst.next()) {
            SubjectDTO subjectDTO = new SubjectDTO();
            subjectDTO.setSubjectId(rst.getString(1));
            subjectDTO.setSubjectName(rst.getString(2));
            subjectDTO.setCredits(rst.getInt(3));
            sublist.add(subjectDTO);

        }
        return sublist;
    }

    //return subjects name which are relevant to the faculty and semester.
    public ArrayList<SubjectDTO> getRelaventSubjectCodes(SubjectDTO subjectDTO) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "select subid from subject where semid=? && facid=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, subjectDTO.getSemesterid());
        preparedStatement.setObject(2, subjectDTO.getFacultyId());
        ResultSet rst = preparedStatement.executeQuery();
        ArrayList<SubjectDTO> sublist = new ArrayList<>();
        while (rst.next()) {
            SubjectDTO subdto = new SubjectDTO();
            subdto.setSubjectName(rst.getString(1));
            sublist.add(subdto);
        }
        return sublist;
    }

    public ArrayList<SubjectDTO> getSubjectsCodesViaFacultyId(SubjectDTO subjectDTO) throws ClassNotFoundException, SQLException{
        Connection connection=DBConnection.getDBConnection().getConnection();
        String sql="select subid from subject where facid=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setObject(1, subjectDTO.getFacultyId());
        ResultSet rst=preparedStatement.executeQuery();
        ArrayList<SubjectDTO> subjectDTOs=new ArrayList<>();
        while(rst.next()){
            SubjectDTO subject=new SubjectDTO();
            subject.setSubjectId(rst.getString(1));
            subjectDTOs.add(subject);
        }
        return subjectDTOs;
    }
    public SubjectDTO getSubdetailsViaSubId(String subjectId) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "select subid,subjectname,credits,fee from subject where subid=? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, subjectId);
        ResultSet rst = preparedStatement.executeQuery();
        SubjectDTO subjectDTo = new SubjectDTO();
        if (rst.next()) {
            subjectDTo.setSubjectId(rst.getString(1));
            subjectDTo.setSubjectName(rst.getString(2));
            subjectDTo.setCredits(rst.getInt(3));
            subjectDTo.setFee(rst.getDouble(4));
        }
        return subjectDTo;
    }

    public SubjectDTO getRelaventSubjectNameViaCode(String subjectCode) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "select subjectName from subject where subid=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, subjectCode);
        ResultSet rst = preparedStatement.executeQuery();
        SubjectDTO subjectDTo = new SubjectDTO();
        if (rst.next()) {
            subjectDTo.setSubjectName(rst.getString(1));
        }
        return subjectDTo;
    }

    public ArrayList<SubjectDTO> getAllSubjectsViaSemRegId(String semRegId) throws Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "select sub.subid,subjectName,credits,fee from Subject sub,SubjSemRegistration sr where sub.subid=sr.subid && sr.semrgid=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, semRegId);
        ResultSet rst = preparedStatement.executeQuery();
        ArrayList<SubjectDTO> sublist = new ArrayList<>();
        while (rst.next()) {
            SubjectDTO subdto = new SubjectDTO();
            subdto.setSubjectId(rst.getString(1));
            subdto.setSubjectName(rst.getString(2));
            subdto.setCredits(rst.getInt(3));
            subdto.setFee(rst.getDouble(4));
            sublist.add(subdto);
        }
        return sublist;
    }

    public ArrayList<SubjectDTO> getRelaventSubjectCodesViaDegreeId(SubjectDTO subjectDTO) throws Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "select subid from subject where semid=? && facid=? && degid=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, subjectDTO.getSemesterid());
        preparedStatement.setObject(2, subjectDTO.getFacultyId());
        preparedStatement.setObject(3, subjectDTO.getDegreeId());
        ResultSet rst = preparedStatement.executeQuery();
        ArrayList<SubjectDTO> sublist = new ArrayList<>();
        while (rst.next()) {
            SubjectDTO subdto = new SubjectDTO();
            subdto.setSubjectName(rst.getString(1));
            sublist.add(subdto);
        }
        return sublist;
    }
    public SubjectDTO getSubjectId(String subname) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "select subid from subject where subjectName=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, subname);
         ResultSet rst = preparedStatement.executeQuery();
         SubjectDTO subdto = new SubjectDTO();
         while (rst.next()) {
            
            subdto.setSubjectId(rst.getString(1));
           
        }
         return subdto;
    }
}
