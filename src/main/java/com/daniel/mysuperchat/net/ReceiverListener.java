package com.daniel.mysuperchat.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceiverListener implements Runnable {

    private final int port;
    private Thread worker;
    private boolean working = true;
    private String userName;

    public ReceiverListener(int port, String userName) { this.port = port; this.userName=userName; }

    @Override
    public void run() {

        try {

            DatagramSocket serverSocket = new DatagramSocket(port);

            while (working) {

                byte[] receivingDataBuffer = new byte[1024];
                DatagramPacket inputPacket = new DatagramPacket(receivingDataBuffer, receivingDataBuffer.length);

                serverSocket.receive(inputPacket);
                String str = new String(inputPacket.getData(), 0, inputPacket.getLength());
                if (str.substring(0, userName.length()-1) == userName) {;}else{System.out.println(str);}
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Listener stopped");

    }

    public void start() {
        worker = new Thread(this);
        working = true;
        worker.start();
    }

    public void stop() {
        working = false;

    }


}
