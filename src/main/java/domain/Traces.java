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

}
