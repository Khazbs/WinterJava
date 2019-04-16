import java.util.HashSet;
import java.util.Set;

public class Showtime {
    private String title;
    private Set<Seat> freeSeats;
    public Showtime(String title, int rows, int seats) {
        this.title = title;
        this.freeSeats = new HashSet<>();
        for (int i = 0; i < rows; ++i)
            for (int j = 0; j < seats; ++j)
                this.freeSeats.add(new Seat(i, j));
    }
    synchronized public Set<Seat> getFreeSeats() {
        return this.freeSeats;
    }
    synchronized public boolean bookSeat(Seat seat) {
        return this.freeSeats.remove(seat);
    }
    public String toString() {
        return this.title;
    }
}
