/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DTO.DegreeDTO;
import Model.DegreeModel;
import java.util.ArrayList;

/**
 *
 * @author Imalka Gunawardana
 */
public class DegreeController {

    private static DegreeModel degreeModel = new DegreeModel();

    public static DegreeDTO getGraduationType(String degreeName) throws Exception {
        return degreeModel.getGraduationType(degreeName);
    }

    public static ArrayList<DegreeDTO> getDegreeNamesViaFaculty(int facultyId) throws Exception {
        return degreeModel.getDegreeNamesViaFaculty(facultyId);
    }

    public static DegreeDTO getDegreeId(String degreeName) throws Exception {
        return degreeModel.getDegreeId(degreeName);
    }
}
