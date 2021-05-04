package domain;

import java.util.ArrayList;
import java.util.List;

public class Result {
    public static final String APPEND_WIN_MESSAGE = "가 최종 우승했습니다.";
    private final List<Traces> results;

    public Result() {
        results = new ArrayList<>();
    }

    public void add(Traces traces) {
        results.add(traces);
    }

    public String resultMessage() {
        StringBuilder sb = new StringBuilder();
        for (Traces result : results) {
            sb
                .append(result.draw())
                .append("\n");
        }
        sb.append(findWinners());
        return sb.toString();
    }

    private String findWinners() {
        Traces last = results.get(results.size() - 1);
        return last.findWinners() + APPEND_WIN_MESSAGE;
    }
}
