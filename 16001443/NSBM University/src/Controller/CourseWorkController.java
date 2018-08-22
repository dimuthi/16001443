/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DTO.CourseWorkDTO;
import Model.CourseWorkModel;
import java.util.ArrayList;

/**
 *
 * @author Imalka Gunawardana
 */
public class CourseWorkController {

    private static CourseWorkModel courseWorkModel = new CourseWorkModel();

    public static boolean addCourseWork(CourseWorkDTO courseWorkDTO) throws Exception {
        return courseWorkModel.addCourseWork(courseWorkDTO);
    }
    
    public static boolean deleteCourseWork(int courseWorkID) throws Exception {
        return courseWorkModel.deleteCourseWork(courseWorkID);
    }
    
    public static boolean updateCourseWork(CourseWorkDTO courseWorkDTO) throws Exception {
        return courseWorkModel.updateCourseWork(courseWorkDTO);
    }
    
    public static ArrayList<CourseWorkDTO> getAllCourseWorksViaSubject(CourseWorkDTO courseWorkDTO) throws Exception {
        return courseWorkModel.getAllCourseWorksViaSubject(courseWorkDTO);
    }
    
    public static ArrayList<CourseWorkDTO> getAllCourseWorksWithIdViaSubject(CourseWorkDTO courseWork) throws Exception {
        return courseWorkModel.getAllCourseWorksWithIdViaSubject(courseWork);
    }

    public static ArrayList<CourseWorkDTO> getAllCourseWorksTypes() throws Exception {
        return courseWorkModel.getAllCourseWorksTypes();
    }

    public static CourseWorkDTO getCourseWorkTypeId(String name) throws Exception {
        return courseWorkModel.getCourseWorkTypeId(name);
    }
    
    public static CourseWorkDTO getCourseWorkId(String name) throws Exception {
        return courseWorkModel.getCourseWorkId(name);
    }
}
