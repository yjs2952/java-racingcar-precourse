package view;

import java.util.Scanner;

public class InputView {

    public static final String INPUT_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은쉼표(,) 기준으로 구분)";
    public static final String INPUT_TRY_COUNT = "시도할 회수는 몇회인가요?";
    public static final String INPUT_NUMBER_ERROR_MESSAGE = "문자를 입력할 수 없습니다.";

    private static final Scanner SCANNER = new Scanner(System.in);

    private String names;
    private int tryCount;

    public void inputNames() {
        System.out.println(INPUT_NAMES_MESSAGE);
        names = SCANNER.nextLine();
    }

    public void inputTryCount() {
        System.out.println(INPUT_TRY_COUNT);
        try {
            tryCount = SCANNER.nextInt();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_NUMBER_ERROR_MESSAGE);
        }
    }

    public String getNames() {
        return names;
    }

    public int getTryCount() {
        return tryCount;
    }
}
