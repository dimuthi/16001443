/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DTO.InstructorDTO;
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
public class InstructorModel {
    public ArrayList<InstructorDTO> getAllInstructors(InstructorDTO instructorDTO) throws ClassNotFoundException, SQLException{
        Connection connection=DBConnection.getDBConnection().getConnection();
        String sql="select incid,firstName,lastName,instructorAddress,telephone,gender,email from instructor where facid=? && subid=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setObject(1, instructorDTO.getFacultyId());
        preparedStatement.setObject(2, instructorDTO.getSubjectId());
        ResultSet rst=preparedStatement.executeQuery();
        ArrayList<InstructorDTO> instructorDTOs=new ArrayList<>();
        while(rst.next()){
            InstructorDTO ins=new InstructorDTO();
            ins.setInstructorID(rst.getString(1));
            ins.setFirstName(rst.getString(2));
            ins.setLastName(rst.getString(3));
            ins.setAddress(rst.getString(4));
            ins.setTelephone(rst.getString(5));
            ins.setGender(rst.getString(6));
            ins.setEmail(rst.getString(7));
            instructorDTOs.add(ins);
        }
        return instructorDTOs;
        
    }
    
    public boolean addInstructor(InstructorDTO instructorDTO) throws ClassNotFoundException, SQLException{
        Connection connection=DBConnection.getDBConnection().getConnection();
        String sql="INSERT INTO instructor values (?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, instructorDTO.getInstructorID());
        preparedStatement.setObject(2, instructorDTO.getSubjectId());
        preparedStatement.setObject(3, instructorDTO.getFacultyId());
        preparedStatement.setObject(4, instructorDTO.getFirstName());
        preparedStatement.setObject(5, instructorDTO.getLastName());
        preparedStatement.setObject(6, instructorDTO.getAddress());
        preparedStatement.setObject(7, instructorDTO.getTelephone());
        preparedStatement.setObject(8, instructorDTO.getGender());
        preparedStatement.setObject(9, instructorDTO.getEmail());
        
        return preparedStatement.executeUpdate()>0;

    }
    public boolean updateInstructor(InstructorDTO instructorDTO) throws ClassNotFoundException, SQLException{
        Connection connection=DBConnection.getDBConnection().getConnection();
        String sql="update instructor set firstName=?,lastName=?,instructorAddress=?,telephone=?,gender=?,email=?,facid=?,subid=? where incid=? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
       
       
        preparedStatement.setObject(1, instructorDTO.getFirstName());
        preparedStatement.setObject(2, instructorDTO.getLastName());
        preparedStatement.setObject(3, instructorDTO.getAddress());
        preparedStatement.setObject(4, instructorDTO.getTelephone());
        preparedStatement.setObject(5, instructorDTO.getGender());
        preparedStatement.setObject(6, instructorDTO.getEmail());
        preparedStatement.setObject(7, instructorDTO.getFacultyId());
        preparedStatement.setObject(8, instructorDTO.getSubjectId());
        preparedStatement.setObject(9, instructorDTO.getInstructorID());
        return preparedStatement.executeUpdate()>0;
        
    }
    public boolean deleteInstructor(String incid) throws ClassNotFoundException, SQLException{
        Connection connection=DBConnection.getDBConnection().getConnection();
        String sql="delete from instructor where incid=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setObject(1, incid);
        
        return preparedStatement.executeUpdate()>0;
    }
   
    public ArrayList<InstructorDTO> getAllInstructorsViaInstructorID(String incid) throws ClassNotFoundException, SQLException{
       Connection connection=DBConnection.getDBConnection().getConnection();
       String sql="select incid,firstName,lastName,instructorAddress,telephone,gender,email from instructor where incid=? ";
       PreparedStatement preparedStatement=connection.prepareStatement(sql);
       preparedStatement.setObject(1, incid);
       ResultSet rst=preparedStatement.executeQuery();
       ArrayList<InstructorDTO> instructorDTOs=new ArrayList<>();
       while(rst.next()){
            InstructorDTO ins=new InstructorDTO();
            ins.setInstructorID(rst.getString(1));
            ins.setFirstName(rst.getString(2));
            ins.setLastName(rst.getString(3));
            ins.setAddress(rst.getString(4));
            ins.setTelephone(rst.getString(5));
            ins.setGender(rst.getString(6));
            ins.setEmail(rst.getString(7));
            instructorDTOs.add(ins);
           
             
        
       }
       return instructorDTOs;
    }
    
}
