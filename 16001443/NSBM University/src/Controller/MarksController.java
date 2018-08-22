/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DTO.CourseWorkDTO;
import DTO.MarksDTO;
import Model.MarksModel;
import java.util.ArrayList;

/**
 *
 * @author Imalka Gunawardana
 */
public class MarksController {

    private static MarksModel marksModel = new MarksModel();

    public static boolean addMarks(MarksDTO marksDTO) throws Exception {
        return marksModel.addMarks(marksDTO);
    }

    public static boolean updateMarks(MarksDTO marksDTO) throws Exception {
        return marksModel.updateMarks(marksDTO);
    }

    public static boolean deleteMarks(int markid) throws Exception {
        return marksModel.deleteMarks(markid);
    }
    
    public static ArrayList<MarksDTO> getAllMarksViaSemRegIdAndCourseId(CourseWorkDTO courseWork) throws Exception {
        return marksModel.getAllMarksViaSemRegIdAndCourseId(courseWork);
    }
}
