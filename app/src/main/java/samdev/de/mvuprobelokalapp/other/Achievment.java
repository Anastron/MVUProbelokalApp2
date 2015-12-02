package samdev.de.mvuprobelokalapp.other;

import android.media.Image;

/**
 * Created by cYa on 01.12.2015.
 */
public class Achievment {

    private String title;
    private String comment;
    private int thumbnail;

    public Achievment(){

    }

    public Achievment(String title,
                 String comment,
                 int thumbnail
                 ){
        this.title = title;
        this.comment = comment;
        this.thumbnail = thumbnail;


    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }


}
