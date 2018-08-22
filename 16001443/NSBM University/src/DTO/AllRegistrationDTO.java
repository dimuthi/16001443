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
public class AllRegistrationDTO {

    private StudentRegistrationDTO registrationDTO;
    private PostgraduateDetailsDTO postgraduateDetailsDTO;
    private UndergraduateDetailsDTO undergraduateDetailsDTO;

    public AllRegistrationDTO() {
    }

    public AllRegistrationDTO(StudentRegistrationDTO registrationDTO, PostgraduateDetailsDTO postgraduateDetailsDTO, UndergraduateDetailsDTO undergraduateDetailsDTO) {
        this.registrationDTO = registrationDTO;
        this.postgraduateDetailsDTO = postgraduateDetailsDTO;
        this.undergraduateDetailsDTO = undergraduateDetailsDTO;
    }

    /**
     * @return the registrationDTO
     */
    public StudentRegistrationDTO getRegistrationDTO() {
        return registrationDTO;
    }

    /**
     * @param registrationDTO the registrationDTO to set
     */
    public void setRegistrationDTO(StudentRegistrationDTO registrationDTO) {
        this.registrationDTO = registrationDTO;
    }

    /**
     * @return the postgraduateDetailsDTO
     */
    public PostgraduateDetailsDTO getPostgraduateDetailsDTO() {
        return postgraduateDetailsDTO;
    }

    /**
     * @param postgraduateDetailsDTO the postgraduateDetailsDTO to set
     */
    public void setPostgraduateDetailsDTO(PostgraduateDetailsDTO postgraduateDetailsDTO) {
        this.postgraduateDetailsDTO = postgraduateDetailsDTO;
    }

    /**
     * @return the undergraduateDetailsDTO
     */
    public UndergraduateDetailsDTO getUndergraduateDetailsDTO() {
        return undergraduateDetailsDTO;
    }

    /**
     * @param undergraduateDetailsDTO the undergraduateDetailsDTO to set
     */
    public void setUndergraduateDetailsDTO(UndergraduateDetailsDTO undergraduateDetailsDTO) {
        this.undergraduateDetailsDTO = undergraduateDetailsDTO;
    }

}
