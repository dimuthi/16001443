/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author dimut
 */
public class PaymentDTO {

    private String paymentId;
    private String semesterRegistrationId;
    private double totalAmount;
    private double amountToPay;
    private String date;
    private String studentName;

    public PaymentDTO() {
    }

    public PaymentDTO(String paymentId, String semesterRegistrationId, double totalAmount, double amountToPay, String date) {
        this.paymentId = paymentId;
        this.semesterRegistrationId = semesterRegistrationId;
        this.totalAmount = totalAmount;
        this.amountToPay = amountToPay;
        this.date = date;
    }

    /**
     * @return the paymentId
     */
    public String getPaymentId() {
        return paymentId;
    }

    /**
     * @param paymentId the paymentId to set
     */
    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
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
     * @return the totalAmount
     */
    public double getTotalAmount() {
        return totalAmount;
    }

    /**
     * @param totalAmount the totalAmount to set
     */
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * @return the amountToPay
     */
    public double getAmountToPay() {
        return amountToPay;
    }

    /**
     * @param amountToPay the amountToPay to set
     */
    public void setAmountToPay(double amountToPay) {
        this.amountToPay = amountToPay;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the studentName
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * @param studentName the studentName to set
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    
}
