package com.company;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server{
    private static final int PORT= 9999;

    public Server() {
        try{
            System.out.println("Waiting for a Client ..");
            DatagramSocket dsoc = new DatagramSocket(PORT);

            byte[]b1= new byte[1024];
            DatagramPacket dp1 = new DatagramPacket(b1, b1.length);
            dsoc.receive(dp1);
            String str = new String(dp1.getData());

            byte[] b2 = str.getBytes();
            InetAddress ia = InetAddress.getLocalHost();
            DatagramPacket dp2 = new DatagramPacket(b2, b2.length, ia, dp1.getPort());
            dsoc.send(dp2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Server();

    }
}