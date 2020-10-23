package tam.pa.quizhitung.activity.learnPage;

import android.app.Service;
import android.content.Context;
import android.util.Log;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import tam.pa.quizhitung.helper.LoadingHelper;
import tam.pa.quizhitung.model.DataLearnResponse;
import tam.pa.quizhitung.network.ApiClient;
import tam.pa.quizhitung.network.ApiService;

public class LearnPresenter {
    IViewLearn iView;
    private Context context;
    private ApiService apiService = ApiClient.getRetrofit().create(ApiService.class);
    private LoadingHelper loadingHelper;
    public LearnPresenter(IViewLearn iView, Context context) {
        this.iView = iView;
        this.context = context;
        loadingHelper = new LoadingHelper(context);
    }

    public void onGetMateri(){
        loadingHelper.startLoading();
        CompositeDisposable disposable = new CompositeDisposable();
        disposable.add(
                apiService.onMateri()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<DataLearnResponse>() {
                    @Override
                    public void onNext(@NonNull DataLearnResponse dataLearnResponse) {
                        iView.onDataMateri(dataLearnResponse.getUser());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d("asda", e.getMessage());
                        loadingHelper.stopLoading();
                    }

                    @Override
                    public void onComplete() {
                        loadingHelper.stopLoading();
                    }
                })
        );
    }
}
