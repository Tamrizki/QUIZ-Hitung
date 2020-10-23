package tam.pa.quizhitung.activity.learnPage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import tam.pa.quizhitung.R;
import tam.pa.quizhitung.activity.learnPage.adapter.LearnPageAdapter;
import tam.pa.quizhitung.model.LearnItem;

public class LearnActivity extends AppCompatActivity implements IViewLearn{
    @BindView(R.id.vpLearn) ViewPager vpLearn;
    @BindView(R.id.tabLayout) TabLayout tabLayout;
    private String[] page = {"Penjumlahan", "Pengurangan", "Perkalian", "Pembagian"};
    private LearnPageAdapter adapter;
    private IViewLearn iViewLearn;
    LearnPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
        ButterKnife.bind(this);
        iViewLearn = this;
        presenter = new LearnPresenter(iViewLearn, this);
        presenter.onGetMateri();

    }
    private void setNameTabLayout() {
        for (int i = 0; i < page.length; i++) {
            tabLayout.getTabAt(i).setText(page[i]);
        }
    }
    @Override
    public void onDataMateri(List<LearnItem> dataMateri) {
        adapter = new LearnPageAdapter(getSupportFragmentManager(), dataMateri);
        vpLearn.setAdapter(adapter);
        tabLayout.setupWithViewPager(vpLearn);
        setNameTabLayout();
    }

    @Override
    public void onError(String msg) {
        Log.d("PresenterError", msg);
    }
}