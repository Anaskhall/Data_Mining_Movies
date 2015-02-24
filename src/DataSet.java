import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Anas-kh on 23/02/2015.
 */
public class DataSet {

    public final String DATA_RATING = "data/u.data";
    public final String DATA_USER = "data/u.user";
    public final String DATA_MOVIES = "data/u.item";

    public final int NB_USER = 943;
    public final int NB_MOVIES = 1682;
    public final int NB_RATINGS = 100000;

    public Object[] rating_data_parser(){

        HashMap<Integer, Movie> movies = new HashMap<Integer, Movie>();
        HashMap<Integer, User> users = new HashMap<Integer, User>();

        try {
            BufferedReader data_rating = new BufferedReader(new FileReader(DATA_RATING));
            String data = data_rating.readLine();

            while (data != null) {
                String[] tokens = data.split("\t");

                int user_id = Integer.parseInt(tokens[0]);
                int movie_id = Integer.parseInt(tokens[1]);
                double rating = Float.parseFloat(tokens[2]);

                if (!movies.containsKey(movie_id)){
                    Movie movie = new Movie(movie_id, new HashMap<Integer, Double>());
                    movies.put(movie_id, movie);
                }

                if (!users.containsKey(user_id)){
                    User user = new User(user_id, new HashMap<Integer, Double>());
                    users.put(user_id, user);
                }

                movies.get(movie_id).getRating().put(user_id, rating);
                users.get(user_id).getRatings().put(movie_id, rating);
                data = data_rating.readLine();
            }
            data_rating.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Object[]{movies, users};
    }

    public  HashMap<Integer, Movie> movies_data_parser(  HashMap<Integer, Movie> movies){

        try {
            BufferedReader data_movies = new BufferedReader(new FileReader(DATA_MOVIES));
            String data = data_movies.readLine();

            while (data != null){
                String[] tokens = data.split("\\|");

                int movie_id = Integer.parseInt(tokens[0]);
                String title = tokens[1];

                ArrayList<Integer> genre = new ArrayList<Integer>();

                for (int i=5; i<tokens.length; i++){
                    genre.add(Integer.parseInt(tokens[i]));
                }

                if (!movies.containsKey(movie_id)){
                    Movie movie = new Movie(movie_id, title, genre, new HashMap<Integer, Double>());
                    movies.put(movie_id, movie);
                }
                movies.get(movie_id).setGenre(genre);
                movies.get(movie_id).setTitle(title);
                data = data_movies.readLine();
            }

            data_movies.close();;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return movies;
    }

    public  HashMap<Integer, User> users_data_parser(  HashMap<Integer, User> users){
        try {
            BufferedReader data_user = new BufferedReader(new FileReader(DATA_USER));
            String data = data_user.readLine();

            while (data != null){

                String[] tokens = data.split("\\|");

                int user_id = Integer.parseInt(tokens[0]);
                int age = Integer.parseInt(tokens[1]);
                String gender = tokens[2];
                String occupation = tokens[3];
                int zipcode=0;
                try{
                    zipcode = Integer.parseInt(tokens[4]);
                }
                catch (NumberFormatException e) {
                }

                if (!users.containsKey(user_id)){
                    User user = new User(user_id, age, gender, occupation, zipcode, new HashMap<Integer, Double>());
                    users.put(user_id, user);
                }
                users.get(user_id).setAge(age);
                users.get(user_id).setGender(gender);
                users.get(user_id).setOccupation(occupation);
                users.get(user_id).setZipcode(zipcode);

                data = data_user.readLine();
            }

            data_user.close();;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    public static void main(String[] args){
        DataSet set = new DataSet();
        Object[] data = set.rating_data_parser();

        HashMap<Integer, Movie> movies = (HashMap<Integer, Movie>) data[0];
        HashMap<Integer, User> users = (HashMap<Integer, User>)data[1];

        users = set.users_data_parser(users);
        movies = set.movies_data_parser(movies);

        System.out.println(movies.size());
        System.out.println(users.size());
        System.out.println(movies.get(1).toString());
        System.out.println(users.get(95).average_rating());
        System.out.println(users.get(95).toString());
    }

}
