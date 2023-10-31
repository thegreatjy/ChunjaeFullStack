package thisisjava;

import account.Account;
import user.User;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        DBUtil db = new DBUtil();
        // DB 연결 초기화
        db.init();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

    }
}