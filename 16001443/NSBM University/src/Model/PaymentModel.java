/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DTO.PaymentDTO;
import DTO.SubjectDTO;
import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author dimut
 */
public class PaymentModel {

    public boolean addPayment(PaymentDTO paymentDTO) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "INSERT INTO Payment values (?,?,?,?,now())";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, paymentDTO.getPaymentId());
        preparedStatement.setObject(2, paymentDTO.getSemesterRegistrationId());
        preparedStatement.setObject(3, paymentDTO.getTotalAmount());
        preparedStatement.setObject(4, paymentDTO.getAmountToPay());
        return preparedStatement.executeUpdate() > 0;
    }

    public boolean updatePayment(PaymentDTO paymentDTO) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "Update Payment set semrgid=?,totalAmount=?,amountToPay=? where payid=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, paymentDTO.getSemesterRegistrationId());
        preparedStatement.setObject(2, paymentDTO.getTotalAmount());
        preparedStatement.setObject(3, paymentDTO.getAmountToPay());
        preparedStatement.setObject(4, paymentDTO.getPaymentId());
        return preparedStatement.executeUpdate() > 0;
    }

    public boolean deletePayment(String payid) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "delete from Payment where payid=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, payid);
        return preparedStatement.executeUpdate() > 0;
    }

    public ArrayList<PaymentDTO> getPaymentsViaSemRegId(String semRegId) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "select payid,totalAmount,amountToPay,dateOfPay,firstName,lastName from Payment p,SemesterRegistration srg,Registration r,Student s where srg.semrgid=p.semrgid && r.rgid=srg.rgid && s.stid=r.stid && srg.semrgid=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, semRegId);
        ResultSet rst = preparedStatement.executeQuery();
        ArrayList<PaymentDTO> paymentDTOs = new ArrayList<>();
        while (rst.next()) {
            PaymentDTO paymentDTO = new PaymentDTO();
            paymentDTO.setPaymentId(rst.getString(1));
            paymentDTO.setTotalAmount(rst.getDouble(2));
            paymentDTO.setAmountToPay(rst.getDouble(3));
            paymentDTO.setDate(rst.getString(4));
            paymentDTO.setStudentName(rst.getString(5) + " " + rst.getString(6));
            paymentDTOs.add(paymentDTO);
        }
        return paymentDTOs;
    }
}
