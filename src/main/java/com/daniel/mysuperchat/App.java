package com.daniel.mysuperchat;

import java.util.Scanner;

public class App {



    public static void main(String[] args){
        getUserName();
    }

    private static String getUserName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("your name: ");
        return scanner.nextLine();

    }

}
