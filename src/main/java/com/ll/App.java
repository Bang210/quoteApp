package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class App {
    List<String> quotes = new ArrayList<>();
    List<String> writers = new ArrayList<>();
    void run() {
        //초기 메시지
        System.out.println("==명언 앱==");


        while (true) {
            //명령 입력받기
            System.out.print("명령) ");
            Scanner scanner = new Scanner(System.in);
            String cmd = scanner.next();
            System.out.printf("입력받은 명령어: %s\n", cmd);
            if (cmd.equals("종료") == true) {
                break;
            }
            else if (cmd.equals("등록") == true) {
                System.out.print("명언: ");
                cmd = scanner.next();
                quotes.add(cmd);
                System.out.print("작가: ");
                cmd = scanner.next();
                writers.add(cmd);
                System.out.printf("%s번 명언이 등록되었습니다.\n", quotes.size());
            }
        }
    }
}
