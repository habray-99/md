package student.entry.gui;

/**
 * Created by erspaudel on 7:10 AM, April 10, 2022
 */
public class FirstYear extends Student {
    private String favoriteSubject;

    public FirstYear(int id, String name) {
        super(id, name);
    }

    public String getFavoriteSubject() {
        return favoriteSubject;
    }

    public void setFavoriteSubject(String favoriteSubject) {
        this.favoriteSubject = favoriteSubject;
    }

    public void display() {
        super.display();
        System.out.println("Favorite Subject: " + this.favoriteSubject);
    }
}
