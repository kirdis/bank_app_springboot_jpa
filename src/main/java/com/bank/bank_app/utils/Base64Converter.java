package com.bank.bank_app.utils;

import java.util.Base64;

public class Base64Converter {

    public static String decodeFromBase64(String str) {
        Base64.Decoder decoder = Base64.getDecoder();
        return new String(decoder.decode(str));
    }
    public static String encodeToBase64(String str) {
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(str.getBytes());
    }
}
