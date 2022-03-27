package com.daniel.mysuperchat.net;

import com.daniel.mysuperchat.domain.Message;
import com.daniel.mysuperchat.utils.SerialUtil;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.UUID;

public class ReceiverListener implements Runnable {

    private final int port;
    private final UUID userId;
    private Thread worker;
    private boolean working = true;
    private String userName;

    public ReceiverListener(int port, String userName, UUID userId) {
        this.port = port;
        this.userName = userName;
        this.userId = userId;
    }

    @Override
    public void run() {

        try {

            DatagramSocket serverSocket = new DatagramSocket(port);

            while (working) {

                byte[] receivingDataBuffer = new byte[1024];
                DatagramPacket inputPacket = new DatagramPacket(receivingDataBuffer, receivingDataBuffer.length);

                serverSocket.receive(inputPacket);

                Message message = SerialUtil.deserialize(inputPacket.getData());

                if (message.getUserId().equals(userId)) {
                    System.out.println(message.getFormattedText());
                }


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
