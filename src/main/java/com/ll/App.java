package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class App {
    //선언
    static List<String> quotes;
    static List<String> writers;
    static Scanner scanner;
    static String cmd;

    //생성자
    App() {
        quotes = new ArrayList<>();
        writers = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    void run() {

        //초기 메시지
        System.out.println("==명언 앱==");

        while (true) {
            //명령 입력받기
            System.out.print("명령) ");
            cmd = scanner.next();
            System.out.printf("입력받은 명령어: %s\n", cmd);

            //종료 명령
            if (cmd.equals("종료")) {
                break;
            }

            //등록 명령
            else if (cmd.equals("등록")) {
                register();
            }

            //목록 명령
            else if (cmd.equals("목록")) {
                listup();
            }

            //삭제 명령
            else if (cmd.startsWith("삭제?id=")) {
                delete(cmd);
            }

            //수정 명령
            else if (cmd.startsWith("수정?id=")) {
                correct();
            }

            //존재하지 않는 명령에 대한 예외처리
            else {
                System.out.println("유효하지 않은 명령입니다.");
            }
        }
    }

    void register() {
        //등록 명령 수행
        System.out.print("명언: ");
        cmd = scanner.next();
        quotes.add(cmd);
        System.out.print("작가: ");
        cmd = scanner.next();
        writers.add(cmd);
        System.out.printf("%s번 명언이 등록되었습니다.\n", quotes.size());
    }

    void listup() {
        //목록 명령 수행
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-----------------------------");
        for (int i = 0; i < quotes.size(); i++) {
            System.out.printf("%d / %s / %s\n", i + 1, writers.get(i), quotes.get(i));
        }
    }

    void delete(String cmd) {
        //삭제 명령 수행
        int id = parsing(cmd, "삭제", 0);
        if (id > 0 && id <= quotes.size()) {
            quotes.remove(id - 1);
            writers.remove(id - 1);
            System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
        } else {
            System.out.println("해당 번호의 명언은 존재하지 않습니다.");
        }
    }

    void correct() {
        //수정 명령 수행
        int id = parsing(cmd, "수정", 0);
        if (id > 0 && id <= quotes.size()) {
            System.out.printf("명언(기존): %s\n명언: ", quotes.get(id - 1));
            cmd = scanner.next();
            quotes.set(id - 1, cmd);
            System.out.printf("작가(기존): %s\n작가: ", writers.get(id - 1));
            cmd = scanner.next();
            writers.set(id - 1, cmd);
            System.out.printf("%d번 명언이 수정되었습니다.\n", id);
        } else {
            System.out.println("해당 번호의 명언은 존재하지 않습니다.");
        }

    }

    int parsing(String query, String paramName, int defaultValue) {
        String[] split0 = query.split("\\?", 2);
        String action = split0[0];
        String queryString = split0[1];
        String _paramName;
        int paramId;
        String[] split1 = queryString.split("=", 2);
        _paramName = split1[0];
        paramId = Integer.parseInt(split1[1]);
        if (paramName.equals(action)) {
            try {
                return paramId;
            } catch (NumberFormatException e) {
                return defaultValue;
            }
        }
        else {
            return defaultValue;
        }
    }
}