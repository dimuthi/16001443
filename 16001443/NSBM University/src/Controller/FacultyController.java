/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DTO.FacultyDTO;
import Model.FacultyModel;
import java.util.ArrayList;

/**
 *
 * @author Imalka Gunawardana
 */
public class FacultyController {

    private static FacultyModel facultyModel = new FacultyModel();

    public static ArrayList<FacultyDTO> getAllFaculties() throws Exception {
        return facultyModel.getAllFaculties();
    }

    public static FacultyDTO getFacultyId(String facultyName) throws Exception {
        return facultyModel.getFacultyId(facultyName);
    }
}
