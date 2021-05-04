package view;

public class PrintView {

    public static final String PLAY_RESULT_MESSAGE = "\n실행 결과";

    public void print(String result) {
        System.out.println(PLAY_RESULT_MESSAGE);
        System.out.println(result);
    }
}
