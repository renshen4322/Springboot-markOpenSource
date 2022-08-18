package com.mark.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class UniqueCodeGenerator {
    private static char[] CODES = {'M', 'w', 'W', 'J', 's', 'c', 'B', 'A', 'Q', 'T', 'D', 'r', 'u', 'X', 'n',
            't', 'R', 'p', 'y', 'i', 'd', 'f', 'b', '7', 'g', 'Z', 'N', 'j', '2', 'H', 'a', 'x', 'v', 'e', 'h', '6',
            'E', 'G', 'Y', '5', '3', 'k', 'z', '8', '4', 'm'};
    private static char[] COMPLEMENTS = {'9', 'F', '1', 'S', 'P', 'C', 'U', 'V', 'L', 'K', '0'};

    private static final Map<Character, Integer> decodeMap = new HashMap<>();
    private static final Map<Character, Integer> complementsDecodeMap = new HashMap<>();

    static {
        for (int i = 0; i < CODES.length; i++) {
            decodeMap.put(CODES[i], i);
        }
        for (int i = 0; i < COMPLEMENTS.length; i++) {
            complementsDecodeMap.put(COMPLEMENTS[i], i);
        }
    }

    public static String generateUniqueCode(long d, int length) {
        int l = CODES.length;
        char[] bytes = new char[16];
        int pos = 16;
        while (d >= l) {
            bytes[--pos] = CODES[(int) (d % l)];
            d /= l;
        }
        if (d > 0) {
            bytes[--pos] = (CODES[(int) (d % l)]);
        }
        StringBuilder s = new StringBuilder(new String(bytes, pos, 16 - pos));
        l = length - s.length(); // 需要补足内容
        if (0 < l) {
            for (int i = 0; i < l; i++) {
                s.append(COMPLEMENTS[ThreadLocalRandom.current().nextInt(0, COMPLEMENTS.length)]);
            }
        }
        return s.toString();
    }

    public static long reduction(String s) {
        int pos = s.length() - 1, ignore = 0;
        long result = 0, pow = 0;
        char c;
        while (0 <= pos) {
            c = s.charAt(pos);
            if (complementsDecodeMap.containsKey(c)) {
                pos--;
                ignore++;
                continue;
            }
            if (!decodeMap.containsKey(c)) {
                return -1;
            }
            long n = (long) decodeMap.get(c);
            for (int i = 0; i < (s.length() - pos - ignore - 1); i++) {
                n = n * ((long) CODES.length);
            }
            result += n;
            pos--;
        }
        return result;
    }

    public static void main(String[] args) {
        String code = generateUniqueCode(1951364703846063L-1900000003846063L, 6);
        System.out.println(code);
    }
}
