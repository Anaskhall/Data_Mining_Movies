import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Anas-kh on 23/02/2015.
 */
public class Movie {

    private int movie_id;
    private String title;
    private ArrayList<Integer> genre;
    private HashMap<Integer, Double> rating;

    public Movie(int movie_id, HashMap<Integer, Double> rating) {
        this.movie_id = movie_id;
        this.rating = rating;
    }

    public Movie(int movie_id, String title, ArrayList<Integer> genre, HashMap<Integer, Double> rating) {
        this.movie_id = movie_id;
        this.title = title;
        this.genre = genre;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movie_id=" + movie_id +
                ", title='" + title + '\'' +
                ", genre=" + genre +
                ", rating=" + rating +
                '}';
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Integer> getGenre() {
        return genre;
    }

    public void setGenre(ArrayList<Integer> genre) {
        this.genre = genre;
    }

    public HashMap<Integer, Double> getRating() {
        return rating;
    }

    public void setRating(HashMap<Integer, Double> rating) {
        this.rating = rating;
    }
}
