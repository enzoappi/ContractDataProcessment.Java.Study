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
public interface OnlinePaymentService {
    
    double paymentInterest(double amount, int month);
    double paymentFee(double amount);
    
}
