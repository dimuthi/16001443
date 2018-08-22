/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DTO.SemesterDTO;
import Model.SemesterModel;
import java.util.ArrayList;

/**
 *
 * @author Imalka Gunawardana
 */
public class SemesterController {

    private static SemesterModel semesterModel = new SemesterModel();

    public static ArrayList<SemesterDTO> getAllSemesters() throws Exception {
        return semesterModel.getAllSemesters();
    }
    
    public static SemesterDTO getSemesterId(String semesterName) throws Exception {
        return semesterModel.getSemesterId(semesterName);
    }
}
