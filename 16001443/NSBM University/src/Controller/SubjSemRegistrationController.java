/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DTO.SubjSemRegistrationDTO;
import DTO.SubjectDTO;
import Model.SubjSemRegistrationModel;
import java.util.ArrayList;

/**
 *
 * @author Imalka Gunawardana
 */
public class SubjSemRegistrationController {

    private static SubjSemRegistrationModel subjSemRegistrationModel = new SubjSemRegistrationModel();

    public static ArrayList<SubjectDTO> getSubjectCodesViaSemRegId(String semRegId) throws Exception {
        return subjSemRegistrationModel.getSubjectCodesViaSemRegId(semRegId);
    }
    
    public static SubjSemRegistrationDTO getSubjectSemesterRegistrationId(SubjSemRegistrationDTO subjSemRegistrationDTO) throws Exception {
        return subjSemRegistrationModel.getSubjectSemesterRegistrationId(subjSemRegistrationDTO);
    }
    public  static boolean addSubjSemRegistration (SubjSemRegistrationDTO subjSemRegistrationDTO) throws Exception{
        return subjSemRegistrationModel.addSubjSemRegistration(subjSemRegistrationDTO);
    }
}
