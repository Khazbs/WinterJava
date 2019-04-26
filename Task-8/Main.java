import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    private static final int MOVIE_ID = 0;
    private static final int MAX_RECOMMENDATIONS = 3;
    public static void main(String[] args) throws IOException {
        String moviesFilePath = "c:/cinema/movies.txt";
        Map<Integer, String> movieTitles = new HashMap<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(moviesFilePath))) {
            String s;
            while ((s = fileReader.readLine()) != null) {
                movieTitles.put(Integer.parseInt(s.split(",")[MOVIE_ID]), s);
            }
        }
        String historyFilePath = "c:/cinema/history.txt";
        Scanner sc = new Scanner(System.in);
        String userWatched = sc.nextLine();
        List<String> userWatchedList = Arrays.asList(userWatched.split(","));
        Map<Integer, WatchCounter> timesWatched = new HashMap<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(historyFilePath))) {
            String s;
            while ((s = fileReader.readLine()) != null) {
                List<String> movies = new ArrayList<>(Arrays.asList(s.split(",")));
                if (!Collections.disjoint(movies, userWatchedList)) {
                    movies.removeAll(userWatchedList);
                    for (String movie : movies) {
                        int movieId = Integer.parseInt(movie);
                        if (timesWatched.containsKey(movieId))
                            timesWatched.get(movieId).increment();
                        else
                            timesWatched.put(movieId, new WatchCounter(movie));
                    }
                }
            }
        }
        List<WatchCounter> recommendations = new ArrayList<>(timesWatched.values());
        recommendations.sort(Collections.reverseOrder());
        for (int i = 0; i < Math.min(recommendations.size(), MAX_RECOMMENDATIONS); ++i) {
            System.out.println(movieTitles.get(recommendations.get(i).getMovieId()));
        }
    }
}
