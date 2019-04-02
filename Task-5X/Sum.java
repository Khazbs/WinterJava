public class Sum {
    private int sum;
    public Sum() {
        this(0);
    }
    public Sum(int sum) {
        this.sum = sum;
    }
    public void add(int sum) {
        this.sum += sum;
    }
    public int getSum() {
        return this.sum;
    }
}
