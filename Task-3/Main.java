public class Main {
    public static class ChessCell {
        private static final int minX = 0, maxX = 8;
        private static final int minY = 0, maxY = 8;
        private int x;
        private int y;
        public ChessCell() {
            this(minX, minY);
        }
        public ChessCell(ChessCell other) {
            this(other.x, other.y);
        }
        public ChessCell(int x, int y) {
            this.setX(x);
            this.setY(y);
        }
        public ChessCell(String cell) {
            this( cell.charAt(0) - 'a', cell.charAt(1) - '1');
        }
        public int getX() {
            return this.x;
        }
        public int getY() {
            return this.y;
        }
        public void setX(int x) {
            if (minX <= x && x <= maxX)
                this.x = x;
            else
                throw new IllegalArgumentException("x must be between " + minX + " and " + maxX);
        }
        public void setY(int y) {
            if (minY <= y && y <= maxY)
                this.y = y;
            else
                throw new IllegalArgumentException("y must be between " + minY + " and " + maxY);
        }
        public String toString() {
            return "" + (char) (x + 'a') + (y + 1);
        }
        public boolean equals(ChessCell other) {
            return this.x == other.x && this.y == other.y;
        }
    }
    public static void main(String[] args) {
        ChessCell cell1 = new ChessCell(1, 1);
        System.out.println(cell1);
        ChessCell cell2 = new ChessCell("b2");
        System.out.println(cell1.equals(cell2));
    }
}

