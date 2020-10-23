package tam.pa.quizhitung.network;

import io.reactivex.Observable;
import retrofit2.http.GET;
import tam.pa.quizhitung.model.DataLearnResponse;

public interface ApiService {
    @GET("exec")
    Observable<DataLearnResponse> onMateri();
}
