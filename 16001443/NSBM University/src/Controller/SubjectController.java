/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DTO.SubjectDTO;
import Model.SubjectModel;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author dimut
 */
public class SubjectController {

    private static SubjectModel subjecttModel = new SubjectModel();

    public static boolean addSubject(SubjectDTO subjectDTO) throws Exception {
        return subjecttModel.addSubject(subjectDTO);
    }

    public static ArrayList<SubjectDTO> getAllSubject(SubjectDTO subjectDTO) throws Exception {
        return subjecttModel.getAllSubject(subjectDTO);
    }

    public static boolean deleteSubject(String subjectCode) throws Exception {
        return subjecttModel.deleteSubject(subjectCode);
    }

    public static boolean updateSubject(SubjectDTO subjecttDTO) throws Exception {
        return subjecttModel.updateSubject(subjecttDTO);
    }

    public static ArrayList<SubjectDTO> getAllSubjectsViaLecturer(String lecturerId) throws Exception {
        return subjecttModel.getAllSubjectsViaLecturer(lecturerId);
    }

    public static ArrayList<SubjectDTO> getRelaventSubjectCodes(SubjectDTO subjectDTO) throws Exception {
        return subjecttModel.getRelaventSubjectCodes(subjectDTO);
    }

    public static SubjectDTO getSubdetailsViaSubId(String subjectId) throws Exception {
        return subjecttModel.getSubdetailsViaSubId(subjectId);
    }

    public static SubjectDTO getRelaventSubjectNameViaCode(String subjectCode) throws Exception {
        return subjecttModel.getRelaventSubjectNameViaCode(subjectCode);
    }

    public static ArrayList<SubjectDTO> getAllSubjectsViaSemRegId(String semRegId) throws Exception {
        return subjecttModel.getAllSubjectsViaSemRegId(semRegId);
    }
    
    public static ArrayList<SubjectDTO> getRelaventSubjectCodesViaDegreeId(SubjectDTO subjectDTO) throws Exception {
        return subjecttModel.getRelaventSubjectCodesViaDegreeId(subjectDTO);
    }
    public static ArrayList<SubjectDTO> getSubjectsCodesViaFacultyId(SubjectDTO subjectDTO) throws ClassNotFoundException, SQLException{
        return subjecttModel.getSubjectsCodesViaFacultyId(subjectDTO);
    }
    public static  SubjectDTO getSubjectId(String subname) throws ClassNotFoundException, SQLException{
        return subjecttModel.getSubjectId(subname);
    }
}
