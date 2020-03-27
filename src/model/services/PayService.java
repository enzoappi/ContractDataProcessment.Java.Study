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
    
    @Override
    public double paymentInterest(double amount, int month) {
        return amount * 0.01 * month;
    }
    
    @Override
    public double paymentFee(double amount) {
        return amount * 0.02;
    }
    
}
