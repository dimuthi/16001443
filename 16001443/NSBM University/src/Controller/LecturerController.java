/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DTO.LecturerDTO;
import Model.LecturerModel;
import java.util.ArrayList;

/**
 *
 * @author Imalka Gunawardana
 */
public class LecturerController {

    private static LecturerModel lecturerModel = new LecturerModel();

    public static boolean addLecturer(LecturerDTO lecturerDTO) throws Exception {
        return lecturerModel.addLecturer(lecturerDTO);

    }

    public static ArrayList<LecturerDTO> getAllLecturers(int facid) throws Exception {
        return lecturerModel.getAllLecturers(facid);
    }

    public static boolean deleteLecturer(String lecturerID) throws Exception {
        return lecturerModel.deleteLecturer(lecturerID);

    }

    public static boolean updateLecturer(LecturerDTO lecturerDTO) throws Exception {
        return lecturerModel.updateLecturer(lecturerDTO);
    }

    public static LecturerDTO getLecturerId(String lecturerName) throws Exception {
        return lecturerModel.getLecturerId(lecturerName);
    }

    public static ArrayList<LecturerDTO> getLecturersViaFaculty(int facultyId) throws Exception {
        return lecturerModel.getLecturersViaFaculty(facultyId);
    }

    public static ArrayList<LecturerDTO> getAllLecturersViaLecId(String lecId) throws Exception {
        return lecturerModel.getAllLecturersViaLecId(lecId);
    }
}
