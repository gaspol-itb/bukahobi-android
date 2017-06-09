package gaspol.bukahobi.models;

/**
 * Created by USER on 6/9/2017.
 */

public class Comment {
    private int userProfile;
    private String comment;

    public Comment(int userProfile, String comment) {
        this.userProfile = userProfile;
        this.comment = comment;
    }

    public int getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(int userProfile) {
        this.userProfile = userProfile;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
