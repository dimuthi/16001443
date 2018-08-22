/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DTO.StudentDTO;
import Model.StudentModel;
import java.util.ArrayList;

/**
 *
 * @author dimut
 */
public class StudentController {

    private static StudentModel studentModel = new StudentModel();

    public static boolean addStudent(StudentDTO studentDTO) throws Exception {
        return studentModel.addStudent(studentDTO);

    }
    public static ArrayList<StudentDTO> getAllStudents() throws Exception{
        return studentModel.getAllStudents();
    }
    public static boolean deleteStudent (String stuid) throws Exception{
        return studentModel.deleteStudent(stuid);
    }
    public static boolean updateStudent(StudentDTO studentDTO) throws Exception{
        return studentModel.updateStudent(studentDTO);
    }
}
