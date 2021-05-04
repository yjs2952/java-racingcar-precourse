package domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private final List<String> winners;

    public Winners() {
        this.winners = new ArrayList<>();
    }

    public void addIfLast(Trace trace, int lastPosition) {
        if (trace.isSamePosition(lastPosition)) {
            winners.add(trace.getName());
        }
    }

    public String names() {
        return String.join(",", winners);
    }
}
