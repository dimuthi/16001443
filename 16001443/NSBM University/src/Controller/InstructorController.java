/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DTO.InstructorDTO;
import Model.InstructorModel;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author dimut
 */
public class InstructorController {
    private static InstructorModel instructorModel=new InstructorModel();
    
     public  static ArrayList<InstructorDTO> getAllInstructors(InstructorDTO instructorDTO) throws ClassNotFoundException, SQLException{
         return instructorModel.getAllInstructors(instructorDTO);
    }

    public static boolean addInstructor(InstructorDTO instructorDTO) throws ClassNotFoundException, SQLException {
        return instructorModel.addInstructor(instructorDTO);
    }

    public static boolean updateInstructor(InstructorDTO instructorDTO) throws ClassNotFoundException, SQLException {
        return instructorModel.updateInstructor(instructorDTO);
    }

    public static boolean deleteInstructor(String incid) throws ClassNotFoundException, SQLException {
        return instructorModel.deleteInstructor(incid);
    }
    public static ArrayList<InstructorDTO> getAllInstructorsViaInstructorID(String incid) throws ClassNotFoundException, SQLException{
        return getAllInstructorsViaInstructorID(incid);
    }
    }
