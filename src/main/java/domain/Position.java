package domain;

public class Position {
    private int position;

    private Position(int position) {
        this.position = position;
    }

    public static Position of(int position) {
        return new Position(position);
    }

    public void move() {
        this.position++;
    }

    public boolean isSame(int position) {
        return this.position == position;
    }

    public int getPosition() {
        return position;
    }
}
