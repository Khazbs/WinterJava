public class Main {
    public static void main(String[] args) throws InterruptedException {
        Showtime movie = new Showtime("Bohemian Rhapsody", 20, 40);
        Booker vasily = new Booker("Vasily");
        Booker ivan = new Booker("Ivan");
        Booker maria = new Booker("Maria");
        Booker anna = new Booker("Anna");
        vasily.wouldWatch(movie, new Seat[] {
                new Seat(2, 9),
                new Seat(2, 10),
                new Seat(2, 11),
                new Seat(3, 9),
                new Seat(3, 10),
                new Seat(3, 11),
        });
        ivan.wouldWatch(movie, new Seat[] {
                new Seat(4, 9),
                new Seat(4, 10),
                new Seat(4, 11),
                new Seat(3, 9),
                new Seat(3, 10),
                new Seat(3, 11),
        });
        maria.wouldWatch(movie, new Seat[] {
                new Seat(4, 9),
                new Seat(4, 10),
                new Seat(4, 11),
                new Seat(5, 9),
                new Seat(5, 10),
                new Seat(5, 11),
        });
        anna.wouldWatch(movie, new Seat[] {
                new Seat(7, 9),
                new Seat(7, 10),
                new Seat(7, 11),
                new Seat(8, 9),
                new Seat(8, 10),
                new Seat(8, 11),
        });
        Thread t1 = new Thread(vasily);
        Thread t2 = new Thread(ivan);
        Thread t3 = new Thread(maria);
        Thread t4 = new Thread(anna);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
    }
}