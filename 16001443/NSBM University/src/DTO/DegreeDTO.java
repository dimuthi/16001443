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
public class DegreeDTO {

    private int degreeid;
    private String degreeName;
    private String graduationType;

    public DegreeDTO() {
    }

    public DegreeDTO(int degreeid, String degreeName) {
        this.degreeid = degreeid;
        this.degreeName = degreeName;
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

    
}
