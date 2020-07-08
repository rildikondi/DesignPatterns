package monostate;

public class Monostate {
    private static int x;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        Monostate.x = x;
    }
}
