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
public class SemesterDTO {

    private int semesterid;
    private String semesterName;

    public SemesterDTO() {
    }

    public SemesterDTO(int semesterid, String semesterName) {
        this.semesterid = semesterid;
        this.semesterName = semesterName;
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
     * @return the semesterName
     */
    public String getSemesterName() {
        return semesterName;
    }

    /**
     * @param semesterName the semesterName to set
     */
    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

}
