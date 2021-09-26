package main;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

public class Main {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        byte[] bytes = getArr(sc.nextLine());
        int cm = getControlSum(bytes);
        if (cm == 0){
            System.out.println("Правильное сообщение: " + Arrays.toString(bytes));
            System.out.println("Ошибки нет");
        } else {
            bytes[cm-1] = (byte)(bytes[cm-1] == 1 ? 0 : 1);
            System.out.println("Правильное сообщение: " + Arrays.toString(bytes));
            System.out.println("Ошибка в бите номер " + cm);
        }
    }

    private static byte[] getArr(String s){
        byte[] b = new byte[s.length()];
        for (int i = 0; i < b.length; i++){
            b[i]  = Byte.parseByte(String.valueOf(s.charAt(i)));
        }
        return b;
    }

    private static int getControlSum(byte[] bytes){
        int ret = 0;
        if ((bytes[0] ^ bytes[2] ^ bytes[4] ^ bytes[6]) == 1) ret += 1;
        if ((bytes[1] ^ bytes[2] ^ bytes[5] ^ bytes[6]) == 1) ret += 2;
        if ((bytes[3] ^ bytes[4] ^ bytes[5] ^ bytes[6]) == 1) ret += 4;
        return ret;
    }

}