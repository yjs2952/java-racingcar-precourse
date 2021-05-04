package domain;

import java.util.List;

public class Traces {

    private final List<Trace> traces;

    private Traces(List<Trace> traces) {
        this.traces = traces;
    }

    public static Traces of(List<Trace> traces) {
        return new Traces(traces);
    }

    public String draw() {
        StringBuilder sb = new StringBuilder();
        for (Trace trace : traces) {
            sb
                .append(trace.getName())
                .append(":")
                .append(trace.drawPosition())
                .append("\n");
        }
        return sb.toString();
    }

    public String findWinners() {
        Winners winners = new Winners();
        int lastPosition = findLastPosition();

        for (Trace trace : traces) {
            winners.addIfLast(trace, lastPosition);
        }
        return winners.names();
    }

    private int findLastPosition() {
        int maxPosition = 0;
        for (Trace trace : traces) {
            maxPosition = Math.max(maxPosition, trace.getPosition());
        }
        return maxPosition;
    }
}
