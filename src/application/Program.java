/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PayService;

/**
 *
 * @author enzoappi
 */
public class Program {
    
    public static void main(String[] args) throws ParseException {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.println("Enter Contract Data:");
        System.out.print("Number: ");
        int number = sc.nextInt();
        System.out.print("Date (dd/MM/yyyy): ");
        Date date = sdf.parse(sc.next());
        System.out.print("Contract value: Us$");
        double totalValue = sc.nextDouble();
        System.out.print("Number of months installments: ");
        int month = sc.nextInt();
        
        Contract contract = new Contract(number, date, totalValue);
        
        ContractService contractService = new ContractService(new PayService());
        
        contractService.contractDataProcess(contract, month);
        
        System.out.println("Installments:");
              
        for (Installment inst : contract.getInstallments()) {
            System.out.println(inst);
        }
        
        sc.close();
    }
}
