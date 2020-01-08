package Other;

public enum Town {
    FLOWER(13, 25),
    GREEN(32, 12),
    KITE(22, 44),
    SUN(6, 12);

    private int xg;
    private int yg;

    Town(int xg, int yg) {
        this.xg = xg;
        this.yg = yg;
    }

    public int getXg() {
        return xg;
    }

    public int getYg() {
        return yg;
    }
}
