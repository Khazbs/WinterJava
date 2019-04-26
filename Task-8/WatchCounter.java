public class WatchCounter implements Comparable<WatchCounter> {
    private int count;
    private String movieId;
    public WatchCounter(String movieId) {
        this(movieId, 1);
    }
    public WatchCounter(String movieId, int count) {
        this.movieId = movieId;
        this.count = count;
    }
    public int increment() {
        return ++this.count;
    }
    public int getCount() {
        return this.count;
    }
    public String getMovieId() {
        return this.movieId;
    }
    public String toString() {
        return this.movieId + ":" + this.count;
    }
    public int compareTo(WatchCounter other) {
        return this.count - other.count;
    }
}
