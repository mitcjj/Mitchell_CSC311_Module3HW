package org.example.mitchell_csc311_module3hw;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Calculator Application
 *
 * Calculates monthly and total loan payments based on user values:
 * loan amount, annual interest rate, and number of years on the loan
 *
 * @author Jared Mitchell
 *
 */
public class CalculatorApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        VBox root = new VBox();
        HBox annualInterestRateRow = new HBox();
        HBox numOfYearsRow = new HBox();
        HBox loanAmountRow = new HBox();
        HBox monthlyPaymentRow = new HBox();
        HBox totalPaymentRow = new HBox();

        Label annualInterestRateLabel = new Label("Annual Interest Rate: ");
        TextField annualInterestRateField = new TextField();
        annualInterestRateRow.getChildren().addAll(annualInterestRateLabel, annualInterestRateField);

        Label numOfYearsLabel = new Label("Number of Years: ");
        TextField numOfYearsField = new TextField();
        numOfYearsRow.getChildren().addAll(numOfYearsLabel, numOfYearsField);

        Label loanAmountLabel = new Label("Loan Amount: ");
        TextField loanAmountField = new TextField();
        loanAmountRow.getChildren().addAll(loanAmountLabel, loanAmountField);

        Label monthlyPaymentLabel = new Label("Monthly Payment: ");
        TextField monthlyPaymentField = new TextField();
        monthlyPaymentRow.getChildren().addAll(monthlyPaymentLabel, monthlyPaymentField);

        Label totalPaymentLabel = new Label("Total Payment: ");
        TextField totalPaymentField = new TextField();
        totalPaymentRow.getChildren().addAll(totalPaymentLabel, totalPaymentField);

        Button calculator = new Button("Calculator");
        calculator.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                double annualInterestRate = 1 + (Double.parseDouble(annualInterestRateField.getText()) / 100);
                int numOfYears = Integer.parseInt(numOfYearsField.getText());
                double loanAmount = Double.parseDouble(loanAmountField.getText());
                double monthlyPayment = (loanAmount * annualInterestRate) / 12.0;
                double totalPayment = loanAmount * Math.pow(annualInterestRate, numOfYears);

                monthlyPaymentField.setText(String.valueOf(monthlyPayment));
                totalPaymentField.setText(String.valueOf(totalPayment));
            }
        });

        root.getChildren().addAll(annualInterestRateRow, numOfYearsRow, loanAmountRow, monthlyPaymentRow, totalPaymentRow, calculator);

        Scene scene = new Scene(root, 350, 320);

        ;

        stage.setTitle("LoanCalculator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}