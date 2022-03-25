package com.daniel.mysuperchat;

import com.daniel.mysuperchat.net.ServerListener;
import com.daniel.mysuperchat.utils.TextUtil;

import javax.annotation.Nonnull;

public class App {

    private static final int PORT = 50011;

    private final String userName;
    private ServerListener serverListener;

    public App(@Nonnull String userName) {
        this.userName = userName;
    }

    private void begin() {

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                serverListener.stop();
            }
        }));

        // start ....
        this.serverListener = new ServerListener(PORT);
        this.serverListener.start();



    }

    public static void main(String[] args) {
        String userName = TextUtil.getUserInput("Your Name: ");
        App app = new App(userName);
        app.begin();
    }

}
