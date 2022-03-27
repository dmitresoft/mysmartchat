package com.daniel.mysuperchat.utils;

import javax.annotation.Nonnull;
import java.util.Scanner;

public class TextUtil {

    @Nonnull
    public static String getUserInput(@Nonnull String prompt, boolean allowEmpty) {

        String result = getString(prompt);

        if (allowEmpty) {
            return result;
        }

        do {
            result = getString(prompt);
        } while (result.isEmpty());
        
        return result;

    }

    private static String getString(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }


}
