/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.ArrayList;

/**
 *
 * @author Imalka Gunawardana
 */
public class SemesterRegistrationDTO {

    private String semesterRegistrationId;
    private int semesterid;
    private int facultyId;
    private String registrationId;
    private ArrayList<String> subjectCodesList;
    private String firstName;
    private String lastName;
    private String date;

    public SemesterRegistrationDTO() {
    }

    public SemesterRegistrationDTO(String semesterRegistrationId, int semesterid, String registrationId) {
        this.semesterRegistrationId = semesterRegistrationId;
        this.semesterid = semesterid;
        this.registrationId = registrationId;
    }

    /**
     * @return the semesterRegistrationId
     */
    public String getSemesterRegistrationId() {
        return semesterRegistrationId;
    }

    /**
     * @param semesterRegistrationId the semesterRegistrationId to set
     */
    public void setSemesterRegistrationId(String semesterRegistrationId) {
        this.semesterRegistrationId = semesterRegistrationId;
    }

    /**
     * @return the semesterid
     */
    public int getSemesterid() {
        return semesterid;
    }

    /**
     * @param semesterid the semesterid to set
     */
    public void setSemesterid(int semesterid) {
        this.semesterid = semesterid;
    }

    /**
     * @return the registrationId
     */
    public String getRegistrationId() {
        return registrationId;
    }

    /**
     * @param registrationId the registrationId to set
     */
    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    /**
     * @return the subjectCodesList
     */
    public ArrayList<String> getSubjectCodesList() {
        return subjectCodesList;
    }

    /**
     * @param subjectCodesList the subjectCodesList to set
     */
    public void setSubjectCodesList(ArrayList<String> subjectCodesList) {
        this.subjectCodesList = subjectCodesList;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the facultyId
     */
    public int getFacultyId() {
        return facultyId;
    }

    /**
     * @param facultyId the facultyId to set
     */
    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

}
