package tam.pa.quizhitung.activity.homePage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import tam.pa.quizhitung.R;
import tam.pa.quizhitung.activity.guidePage.GuideActivity;
import tam.pa.quizhitung.activity.learnPage.LearnActivity;
import tam.pa.quizhitung.dialog.DialoGHitungMundur;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.btnPlay) Button btnPlay;
    @BindView(R.id.btnLearn) Button btnLearn;
    @BindView(R.id.btnPanduan) Button btnPanduan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        btnPlay.setOnClickListener(this);
        btnLearn.setOnClickListener(this);
        btnPanduan.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btnPlay){
            DialoGHitungMundur dialog = new DialoGHitungMundur(this);
            dialog.show();
            dialog.setCanceledOnTouchOutside(false);
        }
        else if (view == btnLearn){
            startActivity(new Intent(this, LearnActivity.class));
        }
        else if (view == btnPanduan){
            startActivity(new Intent(this, GuideActivity.class));
        }
    }
}