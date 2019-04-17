public class Counter {
    private int count;
    public Counter() {
        this(0);
    }
    public Counter(int count) {
        this.count = count;
    }
    public int increment() {
        return ++this.count;
    }
    public int getCount() {
        return this.count;
    }
}
