package com.example.bolek.ascii_helper;

public class Tools {

    public static String toBin(int i) {
        if (i > 127) {
            StringBuilder str = new StringBuilder();
            str.append(Integer.toBinaryString(i));
            for (int i2 = str.length() - 4; i2 >= 0; i2 -= 4) {
                str.insert(i2, " ");
            }
            return str.toString();
        }
        StringBuilder s = new StringBuilder();
        String string = Integer.toBinaryString(i);
        int n = string.length();
        while (n < 8) {
            n++;
            s.append("0");
        }
        s.append(string);
        s.insert(4, " ");
        return s.toString();
    }
}
