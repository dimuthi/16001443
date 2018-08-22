/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.HomeModel;

/**
 *
 * @author Imalka Gunawardana
 */
public class HomeController {

    private static HomeModel homeModel = new HomeModel();

    public static int getStudentsCount(int facultyId) throws Exception {
        return homeModel.getStudentsCount(facultyId);
    }

    public static int getLecturersCount(int facultyId) throws Exception {
        return homeModel.getLecturersCount(facultyId);
    }

    public static int getSubjectsCount(int facultyId) throws Exception {
        return homeModel.getSubjectsCount(facultyId);
    }
}
