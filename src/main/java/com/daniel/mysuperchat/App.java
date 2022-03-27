package com.daniel.mysuperchat;

import com.daniel.mysuperchat.net.ReceiverListener;
import com.daniel.mysuperchat.net.Sender;
import com.daniel.mysuperchat.utils.TextUtil;

import javax.annotation.Nonnull;

public class App {

    private static final int PORT = 50001;

    private final String userName;

    private ReceiverListener serverListener;
    private Sender sender;

    public App(@Nonnull String userName) {
        this.userName = userName;
    }

    private void begin() {

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                serverListener.stop();
                sender.stop();
            }
        }));

        // start ....
        this.serverListener = new ReceiverListener(PORT, userName);
        this.serverListener.start();

        this.sender = new Sender(PORT, userName);
        this.sender.start();

    }

    public static void main(String[] args) {
        String userName = TextUtil.getUserInput("Your Name: ");
        App app = new App(userName);
        app.begin();
    }

}
