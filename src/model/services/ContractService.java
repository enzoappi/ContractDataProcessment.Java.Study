/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.services;

import java.util.Calendar;
import java.util.Date;
import model.entities.Contract;
import model.entities.Installment;

/**
 *
 * @author enzoappi
 */
public class ContractService {
    
    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }
    
    private Date addMonths(Date date, int month) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, month);
        return cal.getTime();
    }
    
    public void contractDataProcess(Contract contract, int month) {
        
        double partValue = contract.getTotalValue() / month;
        //Date a = contract.getDate(); 
               
        for(int i = 1; i <= month; i++) {
            //a.setDate(a.getDate() + 30);
            Date date = addMonths(contract.getDate(), i);
            double pi = partValue + onlinePaymentService.paymentInterest(partValue, i); //calculation of the velue of the part payment plus interest tax per month.
            double pf = pi + onlinePaymentService.paymentFee(pi); //calculation of the part value ajusted plus payment fee.
            
            contract.addInstallment(new Installment(date, pf));
        }
    } 
}
