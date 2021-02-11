package program;

import Model.Client;
import Model.Server;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import javafx.scene.control.TextField;

import java.net.ServerSocket;


public class Controller {
    @FXML Button submitBtn;
    @FXML TextField textField;
    @FXML Label warningLabel;
    @FXML Label warningLabel2;
    @FXML Label outputLabel;
    @FXML ComboBox comboBox1;
    @FXML ComboBox comboBox2;

    private Server server;
    private Client client;
    private ServerSocket sv;


    public void initialize(){
        outputLabel.setText("------");
        warningLabel.setText("");
        warningLabel2.setText("");
        comboBox1.getItems().removeAll(comboBox1.getItems());
        comboBox2.getItems().removeAll(comboBox2.getItems());
        comboBox1.getItems().addAll("BAHT", "USD", "EUR","JPY","CNY");
        comboBox2.getItems().addAll("BAHT", "USD", "EUR","JPY","CNY");


        try{
            server = new Server();
            client = new Client();
            sv = server.startServerSocket();
            server.handleRequest(sv);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return false;
        } catch(NumberFormatException e){
            return true;
        }
    }


    @FXML
    public void handleSubmitBtn(ActionEvent event){
        String strout = "";
        String str = textField.getText();
        warningLabel.setText("");
        warningLabel2.setText("");
        outputLabel.setText("------");
        boolean x = true;

        if(str.equals("")) {
            warningLabel.setText("Please enter a number");

            //server.handleRequest(sv);
        }
        try {

            if (comboBox1.getSelectionModel().getSelectedItem() == null | comboBox2.getSelectionModel().getSelectedItem() == null) {
                warningLabel2.setText("Please select currency to convert");
                x = false;
            }

            if(comboBox1.getValue().toString().equals(comboBox2.getValue().toString())){
                warningLabel2.setText("Can't convert to same currency");
                x = false;
            }
            if(isNumeric(str)){
                warningLabel.setText("Please enter a number");
                x = false;
            }
            if(x){
                str = str+','+comboBox1.getValue().toString()+','+comboBox2.getValue().toString();
                strout = client.sendData(str);
                outputLabel.setText(strout);
                client.disconnect();
                warningLabel.setText("");
                warningLabel2.setText("");
            }
        }catch (Exception e){
            System.out.println("Please correct the input");
        }




    }

}
