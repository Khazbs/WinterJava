import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Booker implements Runnable{
    private static final Object lock = new Object();
    private String bookerName;
    private Showtime showtime;
    private Set<Seat> wouldBookSeats;
    public Booker(String bookerName) {
        this.bookerName = bookerName;
        this.showtime = null;
        this.wouldBookSeats = null;
    }
    public void wouldWatch(Showtime showtime, Seat[] wouldBookSeats) {
        this.showtime = showtime;
        this.wouldBookSeats = new HashSet<>(Arrays.asList(wouldBookSeats));
    }
    public void run() {
        for (Seat seat : wouldBookSeats) {
            synchronized (lock) {
                if (this.showtime.getFreeSeats().contains(seat))
                    if (this.showtime.bookSeat(seat))
                        System.out.println(bookerName + " has booked Seat(" + seat + ") for " + this.showtime);
                    else
                        System.out.println(bookerName + " has failed to book Seat(" + seat + ") for " + this.showtime);
            }
        }
    }
}
