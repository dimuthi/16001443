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
public class UndergraduateDetailsDTO {

    private int UndergraduateDetailId;
    private String registrationId;
    private String alResults;
    private String yearAl;
    private double zscore;
    private String school;

    public UndergraduateDetailsDTO() {
    }

    public UndergraduateDetailsDTO(int UndergraduateDetailId, String registrationId, String alResults, String yearAl, double zscore, String school) {
        this.UndergraduateDetailId = UndergraduateDetailId;
        this.registrationId = registrationId;
        this.alResults = alResults;
        this.yearAl = yearAl;
        this.zscore = zscore;
        this.school = school;
    }

    /**
     * @return the UndergraduateDetailId
     */
    public int getUndergraduateDetailId() {
        return UndergraduateDetailId;
    }

    /**
     * @param UndergraduateDetailId the UndergraduateDetailId to set
     */
    public void setUndergraduateDetailId(int UndergraduateDetailId) {
        this.UndergraduateDetailId = UndergraduateDetailId;
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
     * @return the alResults
     */
    public String getAlResults() {
        return alResults;
    }

    /**
     * @param alResults the alResults to set
     */
    public void setAlResults(String alResults) {
        this.alResults = alResults;
    }

    /**
     * @return the yearAl
     */
    public String getYearAl() {
        return yearAl;
    }

    /**
     * @param yearAl the yearAl to set
     */
    public void setYearAl(String yearAl) {
        this.yearAl = yearAl;
    }

    /**
     * @return the zscore
     */
    public double getZscore() {
        return zscore;
    }

    /**
     * @param zscore the zscore to set
     */
    public void setZscore(double zscore) {
        this.zscore = zscore;
    }

    /**
     * @return the school
     */
    public String getSchool() {
        return school;
    }

    /**
     * @param school the school to set
     */
    public void setSchool(String school) {
        this.school = school;
    }

    
}
