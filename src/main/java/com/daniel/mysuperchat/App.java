package com.daniel.mysuperchat;

import com.daniel.mysuperchat.net.ReceiverListener;
import com.daniel.mysuperchat.net.Sender;
import com.daniel.mysuperchat.utils.TextUtil;

import javax.annotation.Nonnull;
import java.util.UUID;

public class App {

    private static final int PORT = 50001;

    private final String userName;
    private final UUID userId;

    private ReceiverListener serverListener;
    private Sender sender;

    public App(@Nonnull String userName, UUID userId) {
        this.userName = userName;
        this.userId = userId;
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
        this.serverListener = new ReceiverListener(PORT, userName, userId);
        this.serverListener.start();

        this.sender = new Sender(PORT, userName, userId);
        this.sender.start();

    }

    public static void main(String[] args) {
        String userName = TextUtil.getUserInput("Your Name: ", false);
        App app = new App(userName, UUID.randomUUID());
        app.begin();
    }

}
