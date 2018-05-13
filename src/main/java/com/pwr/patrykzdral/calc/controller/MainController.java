package com.pwr.patrykzdral.calc.controller;

import com.pwr.patrykzdral.calc.app.Calc;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    public Label labelHalfResult;
    public TextField textFieldScreen;
    public Button offButton;
    public Button clearButton;
    public Button divideButton;
    public Button sevenButton;
    public Button eightButton;
    public Button nineButton;
    public Button multiplyButton;
    public Button subtractButton;
    public Button addButton;
    public Button dotButton;
    public Button equalButton;
    public Button clearAllButton;
    public Button buttonRemoveCypher;
    public Button buttonSquareRoot;
    public Button buttonPower;
    public Button buttonFraction;
    public VBox vBoxMain;
    private Boolean isActiveOp = true;
    private double resultValue = 0;
    private String activeOperation = "";

    public void offButton_onAction(ActionEvent mouseEvent) {
        Stage stage = (Stage) vBoxMain.getScene().getWindow();
        stage.close();
    }

    public void clearButton_onAction(ActionEvent actionEvent) {
        textFieldScreen.setText("0");
    }


    public void equalButton_onAction(ActionEvent actionEvent) {
        Double var;
        switch (activeOperation) {
            case "+":
                var = resultValue + Double.parseDouble(textFieldScreen.getText());
                textFieldScreen.setText(var.toString());
                isActiveOp = true;
                break;
            case "-":
                var = resultValue - Double.parseDouble(textFieldScreen.getText());
                textFieldScreen.setText(var.toString());
                isActiveOp = true;
                break;
            case "*":
                var = resultValue * Double.parseDouble(textFieldScreen.getText());
                textFieldScreen.setText(var.toString());
                isActiveOp = true;
                break;
            case "/":
                var = resultValue / Double.parseDouble(textFieldScreen.getText());
                textFieldScreen.setText(var.toString());
                isActiveOp = true;
                break;

        }
        try {
            resultValue = Double.parseDouble(textFieldScreen.getText());
        } catch (Exception e) {

        }
        labelHalfResult.setText("");

    }

    public void buttons_onAction(ActionEvent actionEvent) {
        if ((textFieldScreen.getText().equals("0")) || (isActiveOp)) textFieldScreen.clear();
        isActiveOp = false;
        Button button = (Button) actionEvent.getSource();

        if (button.getText().equals(".")) {
            if (!textFieldScreen.getText().equals(".")) textFieldScreen.appendText(button.getText());
        } else {
            textFieldScreen.appendText(button.getText());
        }

    }

    public void buttonsOperator_onAction(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        Double var;
        switch (button.getText()) {
            case "x^2":
                var = Math.pow(Double.parseDouble(textFieldScreen.getText()), 2);
                textFieldScreen.setText(var.toString());
                break;
            case "1/x":
                var = 1 / Double.parseDouble(textFieldScreen.getText());
                textFieldScreen.setText(var.toString());
                break;
            case "√":
                var = Math.sqrt(Double.parseDouble(textFieldScreen.getText()));
                textFieldScreen.setText(var.toString());
                break;
            default:
                if (resultValue != 0) {
                    resultValue = Double.parseDouble(textFieldScreen.getText());
                    textFieldScreen.setText("0");
                    activeOperation = button.getText();
                    labelHalfResult.setText(resultValue + " " + activeOperation);
                    isActiveOp = true;
                } else {
                    resultValue = Double.parseDouble(textFieldScreen.getText());
                    activeOperation = button.getText();
                    labelHalfResult.setText(resultValue + " " + activeOperation);
                    isActiveOp = true;
                }
                break;

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textFieldScreen.setText("0");

    }

    public void clearAllButton_onAction(ActionEvent actionEvent) {
        textFieldScreen.setText("0");
        resultValue = 0;
        labelHalfResult.setText("");

    }

    public void buttonRemoveCypher_onAction(ActionEvent actionEvent) {

        if (!textFieldScreen.getText().equals("0") || textFieldScreen.getText().equals("")) {
            StringBuilder stringBuilder = new StringBuilder(textFieldScreen.getText());
            stringBuilder.deleteCharAt(textFieldScreen.getText().length() - 1);
            if (stringBuilder.toString().equals("")) {
                textFieldScreen.setText("0");
            } else {
                textFieldScreen.setText(stringBuilder.toString());
            }
        }
    }
}
