/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DTO.PaymentDTO;
import Model.PaymentModel;
import java.util.ArrayList;

/**
 *
 * @author Imalka Gunawardana
 */
public class PaymentController {

    private static PaymentModel paymentModel = new PaymentModel();

    public static boolean addPayment(PaymentDTO paymentDTO) throws Exception {
        return paymentModel.addPayment(paymentDTO);
    }

    public static boolean updatePayment(PaymentDTO paymentDTO) throws Exception {
        return paymentModel.updatePayment(paymentDTO);
    }

    public static boolean deletePayment(String payid) throws Exception {
        return paymentModel.deletePayment(payid);
    }

    public static ArrayList<PaymentDTO> getPaymentsViaSemRegId(String semRegId) throws Exception {
        return paymentModel.getPaymentsViaSemRegId(semRegId);
    }
}
