package org.example.mitchell_csc311_module3hw;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Controller class
 * Takes in user information, then calculates the monthly and total payments on the loan
 */
public class CalculatorController {
    @FXML
    private TextField annualInterestRateField;
    @FXML
    private TextField numOfYearsField;
    @FXML
    private TextField loanAmountField;
    @FXML
    private TextField monthlyPaymentField;
    @FXML
    private TextField totalPaymentField;
    @FXML
    private Button calculator;

    /**
     * Calculation method
     *
     * Converts the text into doubles for the interest rate and loan amounts
     * and converts the number of years to an integer
     *
     * The annual interest rate is divided by 100, then the remaining value gets 1 added
     * for a 1.xx value used in the calculations
     *
     * The monthly payment is calculated by multiplying the loan amount by the annual interest rate,
     * then dividing the product by 12
     *
     * The total payment is calculated by taking the interest rate to the power of the years on the loan,
     * then multiplying the value by the existing loan
     *
     * The monthly and total payment loans are then posted in the labeled fields
     */
    @FXML
    protected void calculatePayments(){
        double annualInterestRate = 1 + (Double.parseDouble(annualInterestRateField.getText()) / 100);
        int numOfYears = Integer.parseInt(numOfYearsField.getText());
        double loanAmount = Double.parseDouble(loanAmountField.getText());
        double monthlyPayment = (loanAmount * annualInterestRate) / 12.0;
        double totalPayment = loanAmount * Math.pow(annualInterestRate, numOfYears);

        monthlyPaymentField.setText(String.valueOf(monthlyPayment));
        totalPaymentField.setText(String.valueOf(totalPayment));
    }
}