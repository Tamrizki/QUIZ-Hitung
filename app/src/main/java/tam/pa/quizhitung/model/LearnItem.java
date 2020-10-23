package tam.pa.quizhitung.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LearnItem {
    @SerializedName("Timestamp")
    @Expose
    private String timestamp;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("firstDescription")
    @Expose
    private String firstDescription;
    @SerializedName("imgTheory")
    @Expose
    private String imgTheory;
    @SerializedName("secondDecription")
    @Expose
    private String secondDecription;

    public String getTimestamp() {
        return timestamp;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getFirstDescription() {
        return firstDescription;
    }

    public String getImgTheory() {
        return imgTheory;
    }

    public String getSecondDecription() {
        return secondDecription;
    }
}
