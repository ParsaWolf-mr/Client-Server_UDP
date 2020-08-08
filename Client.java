package com.company;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Client{
    // using UDP Method
    private static final int PORT= 9999;


    public Client(){
        try{
            System.out.println("Starting the Connection!");
            DatagramSocket dsoc = new DatagramSocket();

            // reading from input
            Scanner scanner = new Scanner(System.in);
            System.out.println("> ");
            String str = scanner.nextLine();

            byte[]b1 = str.getBytes();
            InetAddress ia = InetAddress.getLocalHost();
            DatagramPacket dp = new DatagramPacket(b1, b1.length, ia, PORT);
            dsoc.send(dp);

            byte[]b2 = new byte[1024];
            DatagramPacket dp2 = new DatagramPacket(b2, b2.length);
            dsoc.receive(dp2);

            String strTemp = new String(dp2.getData());
            System.out.println(strTemp);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Client();
    }
}
