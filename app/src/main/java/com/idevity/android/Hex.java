package com.idevity.android;

import java.nio.ByteBuffer;

public class Hex {

    private Hex() {
    }

    public static String toHex(byte[] bytes) {
        StringBuffer buff = new StringBuffer();
        for (byte b : bytes) {
            buff.append(String.format("%02X", b));
        }

        return buff.toString();
    }

    public static byte[] fromHex(String digits) {
        digits = digits.replace(" ", "");
        final int bytes = digits.length() / 2;
        if (2 * bytes != digits.length()) {
            throw new IllegalArgumentException(
                    "Hex string must have an even number of digits");
        }

        byte[] result = new byte[bytes];
        for (int i = 0; i < digits.length(); i += 2) {
            result[i / 2] = (byte) Integer.parseInt(digits.substring(i, i + 2),
                    16);
        }
        return result;
    }

    public static byte[] toBytes(int i) {
        return ByteBuffer.allocate(4).putInt(i).array();
    }

    public static byte[] toBytes(short s) {
        return ByteBuffer.allocate(2).putShort(s).array();
    }

    public static String toHex(int i) {
        return toHex(toBytes(i));
    }

    public static String toHex(short s) {
        return toHex(toBytes(s));
    }
}
