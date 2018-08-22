/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DTO.FacultyDTO;
import DTO.StudentDTO;
import Model.RegistrationModel;

/**
 *
 * @author Imalka Gunawardana
 */
public class RegistrationController {
    private static RegistrationModel registrationModel=new RegistrationModel();
    
    public static StudentDTO getStudentNameViaRegId(String registrationID) throws Exception {
        return registrationModel.getStudentNameViaRegId(registrationID);
    }
    
    public static StudentDTO getStudentNameViaSemRegId(String registrationID) throws Exception {
        return registrationModel.getStudentNameViaSemRegId(registrationID);
    }
    
    public static FacultyDTO getFacultyNameViaRegId(String semRegistrationID) throws Exception {
        return registrationModel.getFacultyNameViaRegId(semRegistrationID);
    }
}
