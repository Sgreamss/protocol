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
    @FXML
    Button submitBtn;
    @FXML
    TextField textField;
    @FXML
    Label outputLabel;
    @FXML
    ComboBox comboBox1;

    private Server server;
    private Client client;
    private ServerSocket sv;


    public void initialize(){
        outputLabel.setText("------");
        comboBox1.getItems().removeAll(comboBox1.getItems());
        comboBox1.getItems().addAll("BAHT", "USD", "EUR");


        try{
            server = new Server();
            client = new Client();
            sv = server.startServerSocket();
            server.handleRequest(sv);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @FXML
    public void handleSubmitBtn(ActionEvent event){
        String strout = "";
        String str = textField.getText();


        strout = client.sendData(str);
        //server.handleRequest(sv);



        outputLabel.setText(strout);
        client.disconnect();

    }

}
