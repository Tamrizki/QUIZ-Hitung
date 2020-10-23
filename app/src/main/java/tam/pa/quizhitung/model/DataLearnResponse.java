package tam.pa.quizhitung.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataLearnResponse {
    @SerializedName("user")
    @Expose
    private List<LearnItem> user = null;

    public List<LearnItem> getUser() {
        return user;
    }
}
