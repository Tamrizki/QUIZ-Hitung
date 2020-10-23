package tam.pa.quizhitung.activity.gamePlay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import tam.pa.quizhitung.R;
import tam.pa.quizhitung.dialog.DialogGagal;
import tam.pa.quizhitung.dialog.DialogSuccess;

public class GamePlayActivity extends AppCompatActivity implements IViewPlay, View.OnClickListener {
    @BindView(R.id.value1) TextView value1;
    @BindView(R.id.operasi) TextView operasi;
    @BindView(R.id.value2) TextView value2;
    @BindView(R.id.progressbar) ProgressBar progressbar;
    @BindView(R.id.btnHasil1) Button btnHasil1;
    @BindView(R.id.btnHasil2) Button btnHasil2;
    @BindView(R.id.btnHasil3) Button btnHasil3;
    @BindView(R.id.btnHasil4) Button btnHasil4;
    private CountDownTimer countDownTimer;
    private int i = 0;
    private GamePlayPresenter presenter;
    private IViewPlay iViewPlay;
    int duration = 0, level = 1, part = 0, hasil = 0;
    private DialogGagal dialogGagal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_play);
        ButterKnife.bind(this);
        iViewPlay = this;
        presenter = new GamePlayPresenter(this, iViewPlay);
        dialogGagal = new DialogGagal(GamePlayActivity.this);
        this.level = getIntent().getIntExtra("level", 1);
        GetPlay(level);
        btnHasil1.setOnClickListener(this);
        btnHasil2.setOnClickListener(this);
        btnHasil3.setOnClickListener(this);
        btnHasil4.setOnClickListener(this);
    }

    private void GetPlay(int lv) {
        if (part == 10){
            DialogSuccess dialog = new DialogSuccess(GamePlayActivity.this, lv);
            dialog.show();
            dialog.setCanceledOnTouchOutside(false);
        }else {
            this.part++;
            presenter.onOperation(level);
        }
    }

    private void SetProgressBar(int time, int reset) {
        this.i = reset;
        progressbar.setProgress(reset);
        countDownTimer = new CountDownTimer(time, 1000) {
            @Override
            public void onTick(long l) {
                Log.d("asda", "progress = "+ i+" "+ l);
                i++;
                progressbar.setProgress(i*100/(time/1000));
            }
            @Override
            public void onFinish() {
                dialogGagal.show();
                dialogGagal.setCanceledOnTouchOutside(false);
            }
        };countDownTimer.start();
    }

    @Override
    public void onGetHasil(int jawaban, int val1, int val2, int hasil1, int hasil2, int hasil3, int hasil4, String type) {
        value1.setText(String.valueOf(val1));
        value2.setText(String.valueOf(val2));
        btnHasil1.setText(String.valueOf(hasil1));
        btnHasil2.setText(String.valueOf(hasil2));
        btnHasil3.setText(String.valueOf(hasil3));
        btnHasil4.setText(String.valueOf(hasil4));
        operasi.setText(type);
        this.hasil = jawaban;
    }

    @Override
    public void onNextLevel(int level, int duration) {
        this.level = level;
        this.duration = duration;
        Log.d("durasi", ""+String.valueOf(duration));
        SetProgressBar(duration, 0);
    }

    @Override
    public void onJawaban(boolean hasil) {
        if (hasil){
            GetPlay(level);
        }else {
            DialogGagal dialog = new DialogGagal(GamePlayActivity.this);
            dialog.show();
            dialog.setCanceledOnTouchOutside(false);
        }
    }

    @Override
    public void onClick(View view) {
        countDownTimer.cancel();
        if (view == btnHasil1){
            presenter.onKoreksi(hasil, Integer.valueOf(btnHasil1.getText().toString()));
        }
        else if (view == btnHasil2){
            presenter.onKoreksi(hasil, Integer.valueOf(btnHasil2.getText().toString()));
        }
        else if (view == btnHasil3){
            presenter.onKoreksi(hasil, Integer.valueOf(btnHasil3.getText().toString()));
        }
        else if (view == btnHasil4){
            presenter.onKoreksi(hasil, Integer.valueOf(btnHasil4.getText().toString()));
        }
    }

}