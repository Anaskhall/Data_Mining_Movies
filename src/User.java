import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Anas-kh on 23/02/2015.
 */
public class User {

    private int user_id;
    private int age;
    private String gender;
    private String occupation;
    private int zipcode;
    private HashMap<Integer, Double> ratings;

    public User(int user_id, int age, String gender, String occupation, int zipcode, HashMap<Integer, Double> ratings) {
        this.user_id = user_id;
        this.age = age;
        this.gender = gender;
        this.occupation = occupation;
        this.zipcode = zipcode;
        this.ratings = ratings;
    }

    public User(int user_id, HashMap<Integer, Double> ratings) {
        this.user_id = user_id;
        this.ratings = ratings;
    }

    public Double average_rating(){
        Double rating =0d;
        for (Double i : ratings.values()){
            rating += i;
        }
         if (ratings.size() > 0){
             return rating/ratings.size();
         }
        return 0d;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", occupation='" + occupation + '\'' +
                ", zipcode=" + zipcode +
                ", ratings=" + ratings +
                '}';
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public HashMap<Integer, Double> getRatings() {
        return ratings;
    }

    public void setRatings(HashMap<Integer, Double> ratings) {
        this.ratings = ratings;
    }
}
