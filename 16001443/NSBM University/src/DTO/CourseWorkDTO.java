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
public class CourseWorkDTO {

    private int courseWorkId;
    private int courseWorkTypeId;
    private String semesterRegistrationId;
    private String courseWorkName;
    private String subjectId;
    
    private String courseWorkType;
    private int marks;

    public CourseWorkDTO() {
    }

    public CourseWorkDTO(int courseWorkId, int courseWorkTypeId, String semesterRegistrationId, String subjectId, String courseWorkType, int marks) {
        this.courseWorkId = courseWorkId;
        this.courseWorkTypeId = courseWorkTypeId;
        this.semesterRegistrationId = semesterRegistrationId;
        this.subjectId = subjectId;
        this.courseWorkType = courseWorkType;
        this.marks = marks;
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
     * @return the courseWorkTypeId
     */
    public int getCourseWorkTypeId() {
        return courseWorkTypeId;
    }

    /**
     * @param courseWorkTypeId the courseWorkTypeId to set
     */
    public void setCourseWorkTypeId(int courseWorkTypeId) {
        this.courseWorkTypeId = courseWorkTypeId;
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
     * @return the subjectId
     */
    public String getSubjectId() {
        return subjectId;
    }

    /**
     * @param subjectId the subjectId to set
     */
    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    /**
     * @return the courseWorkType
     */
    public String getCourseWorkType() {
        return courseWorkType;
    }

    /**
     * @param courseWorkType the courseWorkType to set
     */
    public void setCourseWorkType(String courseWorkType) {
        this.courseWorkType = courseWorkType;
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

    
}
