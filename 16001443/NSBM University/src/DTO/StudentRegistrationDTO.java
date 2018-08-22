/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Imalka Gunawardana
 */
public class StudentRegistrationDTO {

    private String registrationId;
    private String studentID;
    private int degreeid;
    private int facultyId;
    private String graduationType;
    private String firstName;
    private String lastName;
    private String date;
    private String intake;
    private String degreeName;

    public StudentRegistrationDTO() {
    }

    public StudentRegistrationDTO(String registrationId, String studentID, int degreeid, int facultyId) {
        this.registrationId = registrationId;
        this.studentID = studentID;
        this.degreeid = degreeid;
        this.facultyId = facultyId;
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
     * @return the studentID
     */
    public String getStudentID() {
        return studentID;
    }

    /**
     * @param studentID the studentID to set
     */
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    /**
     * @return the degreeid
     */
    public int getDegreeid() {
        return degreeid;
    }

    /**
     * @param degreeid the degreeid to set
     */
    public void setDegreeid(int degreeid) {
        this.degreeid = degreeid;
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
     * @return the graduationType
     */
    public String getGraduationType() {
        return graduationType;
    }

    /**
     * @param graduationType the graduationType to set
     */
    public void setGraduationType(String graduationType) {
        this.graduationType = graduationType;
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

    /**
     * @return the intake
     */
    public String getIntake() {
        return intake;
    }

    /**
     * @param intake the intake to set
     */
    public void setIntake(String intake) {
        this.intake = intake;
    }

    /**
     * @return the degreeName
     */
    public String getDegreeName() {
        return degreeName;
    }

    /**
     * @param degreeName the degreeName to set
     */
    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }

}
