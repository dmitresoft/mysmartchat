package com.daniel.mysuperchat.utils;

import javax.annotation.Nonnull;
import java.util.Scanner;

public class TextUtil {

    @Nonnull
    public static String getUserInput(@Nonnull String prompt) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print(prompt);
            return scanner.nextLine();
        }
    }

}
