package com.daniel.mysuperchat.net;

import com.daniel.mysuperchat.domain.Message;
import com.daniel.mysuperchat.utils.SerialUtil;
import com.daniel.mysuperchat.utils.TextUtil;

import java.io.Serial;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.UUID;

public class Sender implements Runnable {


    private final int port;
    private final String userName;
    private final UUID userId;
    private Thread worker;
    private boolean working = true;

    public Sender(int port, String userName, UUID userId) {
        this.port = port;
        this.userName = userName;
        this.userId = userId;
    }


    @Override
    public void run() {

        try {

            DatagramSocket clientSocket = new DatagramSocket();
            SocketAddress address = new InetSocketAddress("10.10.1.0", port);

            while (working) {

                String input = TextUtil.getUserInput("> ");
                Message message = new Message();
                message.setUserId(userId);
                message.setUserName(userName);
                message.setMessageText(input);
                message.setDate(new Date());

                byte[] buffer = SerialUtil.serialize(message);

                DatagramPacket outputPacket = new DatagramPacket(buffer, buffer.length, address);
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
