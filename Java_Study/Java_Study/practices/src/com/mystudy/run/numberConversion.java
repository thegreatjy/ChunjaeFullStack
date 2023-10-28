package com.mystudy.run;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class numberConversion {
    public static void main(String[] args) throws Exception {
        System.out.print("10진수를 입력해주세요. : ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int dec = Integer.parseInt(br.readLine());

        // to binary num
        String bin = Integer.toBinaryString(dec);
        // to octal num
        String oct = Integer.toOctalString(dec);
        // to hexadecimal num
        String hex = Integer.toHexString(dec);

        System.out.println("=====변환 결과=====");
        System.out.println("2진수 : 0b" + bin);
        System.out.println("8진수 : 0o" + oct);
        System.out.println("16진수 : 0x" + hex);
    }
}
