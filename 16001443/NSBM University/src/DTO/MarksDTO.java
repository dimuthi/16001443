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
public class MarksDTO {

    private int markid;
    private int courseWorkId;
    private int subjSemRegistrationId;
    private String subjectCode;
    private String subjectName;
    private String courseWorkName;
    private int marks;

    public MarksDTO() {
    }

    public MarksDTO(int markid, int courseWorkId, int subjSemRegistrationId, int marks) {
        this.markid = markid;
        this.courseWorkId = courseWorkId;
        this.subjSemRegistrationId = subjSemRegistrationId;
        this.marks = marks;
    }

    /**
     * @return the markid
     */
    public int getMarkid() {
        return markid;
    }

    /**
     * @param markid the markid to set
     */
    public void setMarkid(int markid) {
        this.markid = markid;
    }

    /**
     * @return the courseWorkId
     */
    public int getCourseWorkId() {
        return courseWorkId;
    }

    /**
     * @param courseWorkId the courseWorkId to set
     */
    public void setCourseWorkId(int courseWorkId) {
        this.courseWorkId = courseWorkId;
    }

    /**
     * @return the subjSemRegistrationId
     */
    public int getSubjSemRegistrationId() {
        return subjSemRegistrationId;
    }

    /**
     * @param subjSemRegistrationId the subjSemRegistrationId to set
     */
    public void setSubjSemRegistrationId(int subjSemRegistrationId) {
        this.subjSemRegistrationId = subjSemRegistrationId;
    }

    /**
     * @return the marks
     */
    public int getMarks() {
        return marks;
    }

    /**
     * @param marks the marks to set
     */
    public void setMarks(int marks) {
        this.marks = marks;
    }

    /**
     * @return the subjectName
     */
    public String getSubjectName() {
        return subjectName;
    }

    /**
     * @param subjectName the subjectName to set
     */
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    /**
     * @return the courseWorkName
     */
    public String getCourseWorkName() {
        return courseWorkName;
    }

    /**
     * @param courseWorkName the courseWorkName to set
     */
    public void setCourseWorkName(String courseWorkName) {
        this.courseWorkName = courseWorkName;
    }

    /**
     * @return the subjectCode
     */
    public String getSubjectCode() {
        return subjectCode;
    }

    /**
     * @param subjectCode the subjectCode to set
     */
    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

}
