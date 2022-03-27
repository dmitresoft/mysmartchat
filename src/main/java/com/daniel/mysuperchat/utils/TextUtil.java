package com.daniel.mysuperchat.utils;

import javax.annotation.Nonnull;
import java.util.Scanner;

public class TextUtil {

    @Nonnull
    public static String getNonEmptyUserInput(@Nonnull String prompt) {
        String result;
        do {
            result = getUserInput(prompt);
        } while (result.isEmpty());
        return result;
    }

    @Nonnull
    public static String getUserInput(@Nonnull String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }


}
