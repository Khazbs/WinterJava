import java.util.Objects;

public class Seat {
    private final int row;
    private final int seat;
    public Seat(int row, int seat) {
        this.row = row;
        this.seat = seat;
    }
    public int getRow() {
        return this.row;
    }
    public int getSeat() {
        return this.seat;
    }
    public String toString() {
        return "Row: " + this.row + " Seat: " + this.seat;
    }
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Seat))
            return false;
        Seat other = (Seat) obj;
        return this.row == other.row && this.seat == other.seat;
    }
    public int hashCode() {
        return Objects.hash(this.row, this.seat);
    }
}
