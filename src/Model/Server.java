package Model;

import program.Main;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DecimalFormat;

public class Server {
    private static int Port  = 5200;
    private static DecimalFormat df = new DecimalFormat("0.00");

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

                    String str = "", str2 = "",str3 = "";
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

                        //System.out.println("client send : " + str);
                        String[] arrofstr = str.split(",");

                        //baht
                        if(arrofstr[1].equals("BAHT")){
                            if(arrofstr[2].equals("USD")){
                                double num = Double.parseDouble(arrofstr[0]);
                                num = num*0.0334781;
                                str2 = df.format(num) +" "+arrofstr[2];
                            }
                            else if(arrofstr[2].equals("EUR")){
                                double num = Double.parseDouble(arrofstr[0]);
                                num = num*0.0276075;
                                str2 = df.format(num) +" "+arrofstr[2];
                            }
                            else if(arrofstr[2].equals("JPY")){
                                double num = Double.parseDouble(arrofstr[0]);
                                num = num*3.50883;
                                str2 = df.format(num) +" "+arrofstr[2];
                            }
                            else if(arrofstr[2].equals("CNY")){
                                double num = Double.parseDouble(arrofstr[0]);
                                num = num*0.216253;
                                str2 = df.format(num) +" "+arrofstr[2];
                            }

                        }
                        //USD
                        else if(arrofstr[1].equals("USD")){
                            if(arrofstr[2].equals("BAHT")){
                                double num = Double.parseDouble(arrofstr[0]);
                                num = num*29.8696;
                                str2 = df.format(num) +" "+arrofstr[2];
                            }
                            else if(arrofstr[2].equals("EUR")){
                                double num = Double.parseDouble(arrofstr[0]);
                                num = num*0.824661;
                                str2 = df.format(num) +" "+arrofstr[2];
                            }
                            else if(arrofstr[2].equals("JPY")){
                                double num = Double.parseDouble(arrofstr[0]);
                                num = num*104.791;
                                str2 = df.format(num) +" "+arrofstr[2];
                            }
                            else if(arrofstr[2].equals("CNY")){
                                double num = Double.parseDouble(arrofstr[0]);
                                num = num*6.45845;
                                str2 = df.format(num) +" "+arrofstr[2];
                            }
                        }
                        //EUR
                        else if(arrofstr[1].equals("EUR")){
                            if(arrofstr[2].equals("BAHT")){
                                double num = Double.parseDouble(arrofstr[0]);
                                num = num*36.2341;
                                str2 = df.format(num) +" "+arrofstr[2];
                            }
                            else if(arrofstr[2].equals("USD")){
                                double num = Double.parseDouble(arrofstr[0]);
                                num = num*1.21282;
                                str2 = df.format(num) +" "+arrofstr[2];
                            }
                            else if(arrofstr[2].equals("JPY")){
                                double num = Double.parseDouble(arrofstr[0]);
                                num = num*127.093;
                                str2 = df.format(num) +" "+arrofstr[2];
                            }
                            else if(arrofstr[2].equals("CNY")){
                                double num = Double.parseDouble(arrofstr[0]);
                                num = num*7.83337;
                                str2 = df.format(num) +" "+arrofstr[2];
                            }


                        }
                        //JYP
                        else if(arrofstr[1].equals("JPY")){
                            if(arrofstr[2].equals("BAHT")){
                                double num = Double.parseDouble(arrofstr[0]);
                                num = num*0.285159;
                                str2 = df.format(num) +" "+arrofstr[2];
                            }
                            else if(arrofstr[2].equals("USD")){
                                double num = Double.parseDouble(arrofstr[0]);
                                num = num*0.00954461;
                                str2 = df.format(num) +" "+arrofstr[2];
                            }
                            else if(arrofstr[2].equals("EUR")){
                                double num = Double.parseDouble(arrofstr[0]);
                                num = num*0.00787097;
                                str2 = df.format(num) +" "+arrofstr[2];
                            }
                            else if(arrofstr[2].equals("CNY")){
                                double num = Double.parseDouble(arrofstr[0]);
                                num = num*0.0616512;
                                str2 = df.format(num) +" "+arrofstr[2];
                            }

                        }
                        //CNY
                        else if(arrofstr[1].equals("CNY")){
                            if(arrofstr[2].equals("BAHT")){
                                double num = Double.parseDouble(arrofstr[0]);
                                num = num*4.62614;
                                str2 = df.format(num) +" "+arrofstr[2];
                            }
                            else if(arrofstr[2].equals("USD")){
                                double num = Double.parseDouble(arrofstr[0]);
                                num = num*0.154817;
                                str2 = df.format(num) +" "+arrofstr[2];
                            }
                            else if(arrofstr[2].equals("EUR")){
                                double num = Double.parseDouble(arrofstr[0]);
                                num = num*0.127688;
                                str2 = df.format(num) +" "+arrofstr[2];
                            }
                            else if(arrofstr[2].equals("JPY")){
                                double num = Double.parseDouble(arrofstr[0]);
                                num = num*16.2230;
                                str2 = df.format(num) +" "+arrofstr[2];
                            }




                        }







                        //input.close();

                    } catch (Exception e2) {
                        System.out.println("Error to read data from client");
                    }
                    try{
                        //write utf

                        output.writeUTF(str2);
                        //System.out.println("Server send : "+str2);
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

