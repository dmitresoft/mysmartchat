package com.daniel.mysuperchat.net;

import com.daniel.mysuperchat.utils.TextUtil;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.charset.StandardCharsets;

public class Sender implements Runnable {


    private final int port;
    private final String userName;
    private Thread worker;
    private boolean working = true;

    public Sender(int port, String userName) {
        this.port = port;
        this.userName = userName;
    }


    @Override
    public void run() {

        try {

            DatagramSocket clientSocket = new DatagramSocket();
            SocketAddress address = new InetSocketAddress("10.10.1.0", port);

            while (working) {

                String input = TextUtil.getUserInput("> ");
                byte[] sendingDataBuffer = (userName + ": " + input).getBytes(StandardCharsets.UTF_8);

                DatagramPacket outputPacket = new DatagramPacket(sendingDataBuffer, sendingDataBuffer.length, address);
                clientSocket.send(outputPacket);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

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
