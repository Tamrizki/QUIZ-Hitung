package tam.pa.quizhitung.activity.reward;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import tam.pa.quizhitung.R;
import tam.pa.quizhitung.activity.homePage.HomeActivity;
import tam.pa.quizhitung.dialog.DialoGHitungMundur;

public class RewardActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.btnKembali) Button btnKembali;
    @BindView(R.id.bntMainLagi) Button bntMainLagi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reward);
        ButterKnife.bind(this);
        bntMainLagi.setOnClickListener(this);
        btnKembali.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == bntMainLagi){
            DialoGHitungMundur dialog = new DialoGHitungMundur(this);
            dialog.show();
        }
        else if (view == btnKembali){
            startActivity(new Intent(this, HomeActivity.class));
        }
    }
}