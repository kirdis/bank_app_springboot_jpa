package com.bank.bank_app.utils;

public class CardNumberMask {
    public static String maskCardNumber(String cardNumber) {
        String mask = "xxxx-xxxx-xxxx-####";

        int index = 0;
        StringBuilder maskedNumber = new StringBuilder();
        for (int i = 0; i < mask.length(); i++) {
            char c = mask.charAt(i);
            if (c == '#') {
                maskedNumber.append(cardNumber.charAt(index));
                index++;
            } else if (c == 'x') {
                maskedNumber.append(c);
                index++;
            } else {
                maskedNumber.append(c);
            }
        }

        return maskedNumber.toString();
    }
}
