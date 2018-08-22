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
public class PostgraduateDetailsDTO {

    private int PostgraduateDetailId;
    private String registrationId;
    private String qualificationType;
    private String institute;
    private String year;

    public PostgraduateDetailsDTO() {
    }

    public PostgraduateDetailsDTO(int PostgraduateDetailId, String registrationId, String qualificationType, String institute, String year) {
        this.PostgraduateDetailId = PostgraduateDetailId;
        this.registrationId = registrationId;
        this.qualificationType = qualificationType;
        this.institute = institute;
        this.year = year;
    }

    /**
     * @return the PostgraduateDetailId
     */
    public int getPostgraduateDetailId() {
        return PostgraduateDetailId;
    }

    /**
     * @param PostgraduateDetailId the PostgraduateDetailId to set
     */
    public void setPostgraduateDetailId(int PostgraduateDetailId) {
        this.PostgraduateDetailId = PostgraduateDetailId;
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
     * @return the qualificationType
     */
    public String getQualificationType() {
        return qualificationType;
    }

    /**
     * @param qualificationType the qualificationType to set
     */
    public void setQualificationType(String qualificationType) {
        this.qualificationType = qualificationType;
    }

    /**
     * @return the institute
     */
    public String getInstitute() {
        return institute;
    }

    /**
     * @param institute the institute to set
     */
    public void setInstitute(String institute) {
        this.institute = institute;
    }

    /**
     * @return the year
     */
    public String getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(String year) {
        this.year = year;
    }

    
}
