package Model;


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    private Socket client ;
    private BufferedReader br;
    private DataInputStream input;
    private DataOutputStream output;
    private String stroutput;
    private static int Port  = 5200;


    public void connectServer(){
        try{
            client = new Socket("localhost",Port);
            input = new DataInputStream(client.getInputStream());
            output = new DataOutputStream(client.getOutputStream());
            br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("client connected");

        }catch (Exception e){
            System.out.println("Error to start server");
        }
    }

    public void disconnect(){
        try{
            client.close();
        }catch (Exception e){
            System.out.println("Can't Disconnect");
        }
    }

//    public void sendData(){
//        connectServer();
//
//        try {
//            String data = br.readLine();
//            output.writeUTF(data);
//            output.flush();
//
//            output.close();
//
//        }catch (Exception e){
//            System.out.println("Can't send message");
//        }
//        disconnect();
//    }

    public String sendData(String str){
        connectServer();

        try{
            output.writeUTF(str);
            output.flush();
            System.out.println("Send Data Complete");

        }catch (Exception e){
            System.out.println("Can't send message");
            e.printStackTrace();
        }

        try {
            stroutput = input.readUTF();
            System.out.println("Receive Data complete");
            System.out.println("-------------------------------------------");

        }catch (Exception e){
            System.out.println("Can't receive message");
        }

        disconnect();
        return stroutput;
    }

}
