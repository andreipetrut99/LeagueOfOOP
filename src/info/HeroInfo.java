package info;

public class HeroInfo {
    private int row;
    private int column;
    private String type;

    public HeroInfo() {
        row = -1;
        column = -1;
        type = null;
    }

    public HeroInfo(final String t, final int r, final int c) {
        row = r;
        column = c;
        type = t;
    }

    /**
     * toString method.
     * @return a string.
     */
    @Override
    public String toString() {
        return type + " " + row + " " + column;
    }

    /**
     * Getter for hero type.
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * Getter for yPosition.
     * @return int column
     */
    public int getColumn() {
        return column;
    }

    /**
     * Getter for xPosition.
     * @return int row
     */
    public int getRow() {
        return row;
    }
}
