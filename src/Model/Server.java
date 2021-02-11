package Model;

import program.Main;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static int Port  = 5200;

    public ServerSocket startServerSocket(){
        ServerSocket server = null;
        try {
             server = new ServerSocket(Port);
            System.out.println("Start Server "+server);

        }catch (Exception e){
            System.out.println("Error to start server");
            e.printStackTrace();
        }
        return server;
    }


    public void handleRequest(ServerSocket server) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {
                    Socket client = null;
                    DataInputStream input = null;
                    DataOutputStream output = null;

                    String str = "", str2 = "";
                    try {
                        client = server.accept();
                        System.out.println("connection have been made");

                        input = new DataInputStream(client.getInputStream());
                        output = new DataOutputStream(client.getOutputStream());
                        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

                    } catch (Exception e) {
                        System.out.println("Error connecting to client");
                        System.exit(-1);
                    }

                    try {
                        //read utf

                        str = input.readUTF();
                        System.out.println("client Say : " + str);





                        //input.close();

                    } catch (Exception e2) {
                        System.out.println("Error to read data from client");
                    }
                    try{
                        //write utf
                        str2 = "client Say : " + str;
                        output.writeUTF(str2);
                        output.flush();
                        client.close();
                    }catch (Exception e){
                        System.out.println("Error to send data to client");
                    }




                }
            }

        });thread.start();
    }

    }

