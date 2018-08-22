/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DTO.PostgraduateDetailsDTO;
import Model.PostgraduateDetailsModel;

/**
 *
 * @author Imalka Gunawardana
 */
public class PostgraduateDetailsController {

    private static PostgraduateDetailsModel postgraduateDetailsModel = new PostgraduateDetailsModel();

    public static PostgraduateDetailsDTO getPostgraduateDetails(String rgid) throws Exception {
        return postgraduateDetailsModel.getPostgraduateDetails(rgid);
    }

    public static boolean updatePostgraduateDetails(PostgraduateDetailsDTO postgraduateDetailsDTO) throws Exception {
        return postgraduateDetailsModel.updatePostgraduateDetails(postgraduateDetailsDTO);
    }
}
