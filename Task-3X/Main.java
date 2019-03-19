public class Main {
    public static class IllegalKnightMove extends Exception {
        private String from;
        private String to;
        public IllegalKnightMove(IllegalKnightMove other) {
            this(other.from, other.to);
        }
        public IllegalKnightMove(String from, String to) {
            this.from = from;
            this.to = to;
        }
        public String toString() {
            return "A true knight would never move from " + from + " to " + to + "... You are a disgrace.";
        }
    }
    public static boolean isLegalKnightMove(String from, String to) throws IllegalKnightMove {
        int dx = Math.abs(from.charAt(0) - to.charAt(0));
        int dy = Math.abs(from.charAt(1) - to.charAt(1));
        if (dx == 1 && dy == 2 || dx == 2 && dy == 1) {
            return true;
        }
        else {
            throw new IllegalKnightMove(from, to);
        }
    }
    public static boolean isLegalKnightSequence(String[] moves) {
        boolean result = true;
        for (int i = 0; i < moves.length - 1; ++i) {
            try {
                isLegalKnightMove(moves[i], moves[i + 1]);
            }
            catch (IllegalKnightMove e) {
                System.out.println(e);
                result = false;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String[][] sequences = {
                {"g8", "e7", "e6"},
                {"g8", "e7", "c8"}
        };
        for (String[] sequence : sequences) {
            if (isLegalKnightSequence(sequence)) {
                System.out.println("OK\n");
            }
            else {
                System.out.println("ERROR\n");
            }
        }
    }
}

