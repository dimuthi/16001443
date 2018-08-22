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
public class SubjSemRegistrationDTO {

    private int subjSemRegistrationId;
    private String semesterRegistrationId;
    private String subjectId;

    public SubjSemRegistrationDTO() {
    }

    public SubjSemRegistrationDTO(int subjSemRegistrationId, String semesterRegistrationId, String subjectId) {
        this.subjSemRegistrationId = subjSemRegistrationId;
        this.semesterRegistrationId = semesterRegistrationId;
        this.subjectId = subjectId;
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

}
