/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DTO.UndergraduateDetailsDTO;
import Model.UndergraduateDetailsModel;

/**
 *
 * @author Imalka Gunawardana
 */
public class UndergraduateDetailsController {

    private static UndergraduateDetailsModel undergraduateDetailsModel = new UndergraduateDetailsModel();

    public static UndergraduateDetailsDTO getUndergraduateDetails(String rgid) throws Exception {
        return undergraduateDetailsModel.getUndergraduateDetails(rgid);
    }

    public static boolean updateUndergraduateDetails(UndergraduateDetailsDTO undergraduateDetailsDTO) throws Exception {
        return undergraduateDetailsModel.updateUndergraduateDetails(undergraduateDetailsDTO);
    }
}
