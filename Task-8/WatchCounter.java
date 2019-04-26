public class WatchCounter implements Comparable<WatchCounter> {
    private int count;
    private int movieId;
    public WatchCounter(int movieId) {
        this(movieId, 1);
    }
    public WatchCounter(int movieId, int count) {
        this.movieId = movieId;
        this.count = count;
    }
    public int increment() {
        return ++this.count;
    }
    public int getCount() {
        return this.count;
    }
    public int getMovieId() {
        return this.movieId;
    }
    public String toString() {
        return this.movieId + ":" + this.count;
    }
    public int compareTo(WatchCounter other) {
        return this.count - other.count;
    }
}
