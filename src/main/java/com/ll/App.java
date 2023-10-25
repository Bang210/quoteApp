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

            //종료 명령
            if (cmd.equals("종료") == true) {
                break;
            }

            //등록 명령
            else if (cmd.equals("등록") == true) {
                System.out.print("명언: ");
                cmd = scanner.next();
                quotes.add(cmd);
                System.out.print("작가: ");
                cmd = scanner.next();
                writers.add(cmd);
                System.out.printf("%s번 명언이 등록되었습니다.\n", quotes.size());
            }

            //목록 명령
            else if (cmd.equals("목록") == true) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("-----------------------------");
                for (int i = 0; i < quotes.size(); i++) {
                    System.out.printf("%d / %s / %s\n", i + 1, writers.get(i), quotes.get(i));
                }
            }
        }
    }
}
