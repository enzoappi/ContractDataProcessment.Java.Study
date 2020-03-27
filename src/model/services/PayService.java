/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.services;

/**
 *
 * @author enzoappi
 */
public class PayService implements OnlinePaymentService{
    
    private Double paymentInterestTax = 0.01;
    private Double paymentFeeTax = 0.02;
    
    @Override
    public double paymentInterest(double amount, int month) {
        return amount * paymentInterestTax * month;
    }
    
    @Override
    public double paymentFee(double amount) {
        return amount * paymentFeeTax;
    }
    
}
